# Spaceautomatisierung

Für die interne Steuerung im Space wird Nodered und Homeassistant eingesetzt

## Nodered

Das Nodered bildet die Automatiersung für alle Geräte ab und stellt zudem ein Webinterface unter gandalf.wwlabs.space da.
Mit den Heizungkemostate wird vom Nodered über den Max!Cube kommuniziert und die gewünschte Temperatur eingestellt.
Für Licht und steckdosen wird vom Nodered über den Homeassistant die Zigbee Steckdosen angesprochen.

## Homeassistant

Das Homeassistant bildet die Schnittstelle zwischen dem Nodered und den Zigbeegeräte sowie den Google Chromecast an den Beamern. Bei zigbee kommuniziert das Homeassistant mit einem soket von einem Zigbeegateway
Auf dem Homeassistant sind im docker container statische dns Einträge gesetzt, da die Auflösung vom DNS nicht zuverlässig im Docker funktioniert.

 