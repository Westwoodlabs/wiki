Netzwerk
==============

## VLAN
|id|Name|   |Wlan|
|---|---|---|---|
|20 | WWL  | für alles  |Westwoodlabs| 
|30 | IoT  | nur IoT Geräte  | Westwoodlabs-IoT|
|50 | Server  |alle Server   | -|
|100| extern  |Netz zur Fritzbox|-|
|101| FF|Freifunk|freifunk-ww.de|
## Firewall
|In|Out|Protocol|Port|Action|
|---|---|---|---|---|
|ALL|ALL|all|all|accept established,related|
|ALL|ALL|ICMP|all|ACCEPT|
|WWL|extern|all|all|ACCEPT|
|WWL|Server|tcp|22|ACCEPT|
|WWL|Server|tcp|80|ACCEPT|
|WWL|Server|tcp|443|ACCEPT|
|Server|IOT|all|all|ACCEPT|
|IOT|Server|tcp|1883|ACCEPT|
|ALL|ALL|all|all|drop|
## Interne DNS Namen
- strichliste.wwlabs.space
- backend.wwlabs.space
- dymo.wwlabs.space
- nuc.wwlabs.space
- silex.wwlabs.space
- tuer.wwlabs.space
