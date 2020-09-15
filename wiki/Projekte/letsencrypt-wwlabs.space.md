# LetsEncrypt wwlabs.sapce

Um Space-interne Dienste mit TLS anbieten zu können - nicht weil es wirklich sicher wäre, aber wegen HTTPS per Default und so - 
gibt es ein wildcard LetsEncrypt Zertifikat für `*.wwlabs.space`. 
Der Private-Key ist nicht wirklich private, sondern nur Space-private: Für Space-interne Projekt kann man ihn bekommen.

## Wie komme ich an das aktuelle Zertifikat
Einfach: `curl https://cert.wwlabs.space/letsencrypt/fullchain.pem`

Originell: `openssl s_client -showcerts wwlabs.space:443 </dev/null 2>/dev/null | sed -n '/^-----BEGIN CERT/,/^-----END CERT/p'`

## Setup des Certbots
Wir nehmen dafür die Hetzner DNS API, da `wwlabs.space` sowieso im Hetzner-DNS liegt.
Die Scripte sind zu 'nem guten Teil aus dem [Hetzner Tutorial](https://community.hetzner.com/tutorials/letsencrypt-dns) geklaut, aber ein bisschen angepasst:

`/usr/local/bin/certbot-hetzner-auth.sh`
```sh
#/bin/bash

token=$(cat /etc/hetzner-dns-token)

zone_id=$(curl \
 -s \
 -H "Auth-API-Token: ${token}" \
 "https://dns.hetzner.com/api/v1/zones?search_name=${CERTBOT_DOMAIN}" | \
 jq ".\"zones\"[] | select(.name == \"${CERTBOT_DOMAIN}\") | .id" 2>/dev/null | tr -d '"')

curl -X "POST" "https://dns.hetzner.com/api/v1/records" \
     -s \
     -H 'Content-Type: application/json' \
     -H "Auth-API-Token: ${token}" \
     -d "{ \"value\": \"${CERTBOT_VALIDATION}\", \"ttl\": 600, \"type\": \"TXT\", \"name\": \"_acme-challenge\", \"zone_id\": \"${zone_id}\" }" > /dev/null 2>/dev/null

# await the entry being present
timeout=60
while [ $timeout -gt 0 ]; do
    echo awaiting TXT record...
    if dig TXT _acme-challenge.${CERTBOT_DOMAIN} @oxygen.ns.hetzner.com | grep "${CERTBOT_VALIDATION}"; then
       echo matching TXT record found
       exit 0
    else 
       timeout=$(($timeout -1))
       sleep 1
    fi
done
echo TXT record not found after 60 seconds.
exit 1
```

`/usr/local/bin/certbot-hetzner-cleanup.sh`
```sh
#/bin/bash

token=$(cat /etc/hetzner-dns-token)

zone_id=$(curl -s \
 -H "Auth-API-Token: ${token}" \
 "https://dns.hetzner.com/api/v1/zones?search_name=${CERTBOT_DOMAIN}" | \
 jq ".\"zones\"[] | select(.name == \"${CERTBOT_DOMAIN}\") | .id" 2>/dev/null | tr -d '"')

record_ids=$(curl -s \
 -H "Auth-API-Token: $token" \
 "https://dns.hetzner.com/api/v1/records?zone_id=$zone_id" | \
 jq ".\"records\"[] | select(.name == \"_acme-challenge\") | .id" 2>/dev/null | tr -d '"')

for record_id in $record_ids
do
 curl -H "Auth-API-Token: $token" \
  -X "DELETE" "https://dns.hetzner.com/api/v1/records/${record_id}" > /dev/null 2> /dev/null
done
```

`/usr/local/bin/certbot-wwlabs.space-deploy.sh`
```
#!/bin/bash
if [ "$RENEWED_LINEAGE" = "/etc/letsencrypt/live/wwlabs.space" ]; then
        cp /etc/letsencrypt/live/wwlabs.space/fullchain.pem /var/www/wwlabs.space/letsencrypt/
        chmod 644 /var/www/wwlabs.space/letsencrypt/fullchain.pem
fi
```

Und zu guter Letzt:
`certbot certonly --manual --preferred-challenges=dns --manual-auth-hook /usr/local/bin/certbot-hetzner-auth.sh --manual-cleanup-hook /usr/local/bin/certbot-hetzner-cleanup.sh -d wwlabs.space -d *.wwlabs.space`

Damit man den Private-Key nicht andauernd neu verteilen muss, wird in der `/etc/letsencrypt/renewal/wwlabs.space.conf` noch in den `renewalparams` `reuse-key = true` gesetzt.
Außerdem wird das deploy Script mit `deploy-hook = /usr/local/bin/certbot-wwlabs.space-deploy.sh` gesetzt.
