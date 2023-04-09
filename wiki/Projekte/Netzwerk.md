# Netzwerk

Hier dokumentieren wir ein paar Dinge zu unserer Space internen Netzwerk Infrastruktur. 

![Screenshot](netzwerk.jpg)

## DNS

| FQDN | Beschreibung | 
| ----------- | ----------- | 
| [strichliste.wwlabs.space](https://strichliste.wwlabs.space) | Strichliste, siehe [Projekt/Strichliste](Strichliste.md) | 
| [backend.wwlabs.space](https://backend.wwlabs.space) | Node-RED | 
| [gandalf.wwlabs.space](https://gandalf.wwlabs.space) | Space Automation Frontend (Zum Steuern von Licht, Steckdosen, Beamer, Lautsprechern etc.) | 
| [dymo.wwlabs.space](https://dymo.wwlabs.space) | Dymo Webinterface, siehe [Projekt/Dymo](Dymo.md) | 
| [nuc.wwlabs.space](https://nuc.wwlabs.space) | Docker Host | 
| [silex.wwlabs.space](http://silex.wwlabs.space) | Printer/USB-Device-Server | 
| tuer.wwlabs.space | Tür-Pi für Schließanlage, siehe [Projekt/Schliessanlage](Schliessanlage.md) | 
| [scan.wwlabs.space](https://scan.wwlabs.space) | Scan2Folder SMB, siehe [Projekt/drucken_scannen](drucken_scannen.md) |
| [dragino-1ee980.wwlabs.space:8000](http://dragino-1ee980.wwlabs.space:8000) | LoRaWAN Gateway |


## VLANs

| id | Name |   | Wlan | 
| --- | --- | --- | --- | 
| 20 | WWL | für alles  | Westwoodlabs | 
| 30 | IoT | nur IoT Geräte  | Westwoodlabs-IoT | 
| 50 | Server | alle Server  | - | 
| 100 | extern | Netz zur Fritzbox | - | 
| 101 | FF | Freifunk | freifunk-ww.de | 


## Firewall

| In | Out | Protocol | Port | Action | 
| --- | --- | --- | --- | --- | 
| ALL | ALL | all | all | accept established,related | 
| ALL | ALL | ICMP | all | ACCEPT | 
| WWL | extern | all | all | ACCEPT | 
| WWL | Server | tcp | 22 | ACCEPT | 
| WWL | Server | tcp | 80 | ACCEPT | 
| WWL | Server | tcp | 443 | ACCEPT | 
| Server | IOT | all | all | ACCEPT | 
| IOT | Server | tcp | 1883 | ACCEPT | 
| ALL | ALL | all | all | drop | 


## Netzwerkplan

| Patchpanel | Nummer | Location                                         |
|------------|--------|--------------------------------------------------|
| A          | 1      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 2      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 3      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 4      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 5      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 6      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 7      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 8      | Hauptraum „alter“ Teil Brüstungskanal            |
| A          | 9      | Lounge hinter Couch                              |
| A          | 10     | Lounge hinter Couch                              |
| A          | 11     | Lounge hinter Couch                              |
| A          | 12     | Lounge hinter Couch                              |
| A          | 13     | Lounge Brüstungskanal                            |
| A          | 14     | Lounge Brüstungskanal                            |
| A          | 15     | Lounge Brüstungskanal                            |
| A          | 16     | Lounge Brüstungskanal                            |
| A          | 17     | Lounge unter Tisch                               |
| A          | 18     | Lounge unter Tisch                               |
| A          | 19     | Lounge unter Tisch                               |
| A          | 20     | Lounge unter Tisch                               |
| A          | 21     | Hauptraum „alter“ Teil Zwischendecke Accesspoint |
| A          | 22     | Hauptraum Dymo-Regal hinter Tür                  |
| A          | 23     | DSL Westwoodlabs                                 |
| A          | 24     | DSL „fremd“                                      |
| B          | 1      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 2      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 3      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 4      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 5      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 6      | Hauptraum „neuer“ Teil Brüstungskanal |
| B          | 7      | Werkstatt Brüstungskanal              |
| B          | 8      | Werkstatt Brüstungskanal              |
| B          | 9      | Werkstatt Brüstungskanal              |
| B          | 10     | Werkstatt Brüstungskanal              |
| B          | 11     | Werkstatt Brüstungskanal              |
| B          | 12     | Werkstatt Brüstungskanal              |
| B          | 13     | Hauptraum „alter“ Teil auf Tisch      |
| B          | 14     | Hauptraum „alter“ Teil auf Tisch      |
| B          | 15     | Hauptraum „alter“ Teil auf Tisch      |
| B          | 16     | Hauptraum „alter“ Teil auf Tisch      |
| B          | 17     | Hauptraum „neuer“ Teil auf Tisch      |
| B          | 18     | Hauptraum „neuer“ Teil auf Tisch      |
