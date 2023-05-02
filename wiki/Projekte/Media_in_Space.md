In dieser Übersicht dargestellt, wie du Medien im Space konsumieren kannst. 😋

# Grundsätzliches 
- Wir nutzen für die drahtlose Übertragung von Medien an die Beamer verschiedene Chromecasts. Diese *sollte* jedes Gerät in dem Westwoodlabs-WLAN eigenständig finden können. 
- Die Beamer, die Leinwand im Nebenraum sowie die jeweiligen Lautsprecher kannst du, wenn du bei uns im Westwoodlabs-WLAN bist, über [Gandalf](https://gandalf.wwlabs.space/) einschalten/ausschalten/steuern. 
- Denke bitte auch an deine Mitmenschen. Konsumiere also bitte keine Medien, wenn andere sich davon vielleicht belästigt fühlen könnten. Videos wie man ein Windows Vista installiert solltest du also bitte zu Hause konsumieren.
- Die Lautstärke kannst du über [Gandalf](https://gandalf.wwlabs.space/)  oder dein Gerät selbst steuern. Achte bitte auch hier auf eine angemessene (!) Lautstärke.

# Hauptraum

## Übersicht der Geräte:
- Beamer mit 1080p-Auflösung
- Chromecast Version: Gen 3
- Lautsprecher 
- 2x HDMI-Adapter 
- HDMI-Matrix-Switch (unter der Decke)

Im Hauptraum haben wir an den beiden Tischen HDMI-Adapter, welche dann über ein Patch-Kabel das Signal an einen HDMI-Switch weitergeben. Der HDMI-Switch hat eine Fernbedienung, damit man ihm sagen kann, welchen Eingang er nun nutzen soll. Die Belegung ist wie folgt:

1. Chromecast „Hauptraum“
2. Tisch am Whiteboard
3. Tisch an der Wand, aka. Beamerfläche


Da die HDMI-Adapter auch Strom brauchen, *sollte* stets auch ein USB-A auf Micro-USB-Kabel an ihnen sein und direkt an dein jeweiliges Endgerät gesteckt werden können, um sie mit Strom versorgen zu können. 

Die HDMI-Adapter befinden sich an den Raumecken auf der Fensterseite. Das Kabel ist lang genug, damit man aber auch von der anderen Tischseite aus ihn nutzen kann. Du musst also nicht deinen Platz wechseln, nur weil du ihn nutzen willst.

Bitte rolle nach Nutzung das Kabel gemeinsam mit HDMI-Adapter ein und nutze den Kabelbinder, um halbwegs eine Ordnung zu halten. 

Der Chromecast im Hauptraum findest du mit dem Namen „Hauptraum“ im Westwoodlabs-WLAN. So ziemlich jedes Gerät findet den relativ zügig im Netzwerk. Der Chromecast im Hauptraum ist dauerhaft an. Daher kannst du auch deinen Medienkonsum an ihn schon starten zu schicken, obwohl der Beamer nicht eingeschaltet ist.

### Matrix Switch
Hat vier Eingänge und acht Ausgänge. Kann über einen ESP mit der [IRBridge Firmware](https://github.com/foorschtbar/IRBridge) ferngesteuert wird. Die Bridge wird über das Node-Red ferngesteuert. Die Bridge selber hat ein [Webinterface](http://irbridge1.wwlabs.space) zum testen.
```
Output A:
1: 80 01
2: 80 03
3: 80 04
4: 80 06

Output B:
1: 80 07
2: 80 09
3: 80 0A
4: 80 1F
```

# Nebenraum 

## Übersicht der Geräte:
- Beamer mit Auflösung „720p“
- Chromecast Version: Gen 2
- Lautsprecher mit Subwoofer
- elektronische Leinwand 

Der Nebenraum hat für den Medienkonsum keinen HDMI-Adapter, sondern „nur“ einen Chromecast direkt am Beamer mit dem Namen „Nebenraum“. Dieser wird über den Beamer mit Strom versorgt. Daher kannst du ihn nur dann finden, wenn der Beamer im Nebenraum auch eingeschaltet ist. Den Beamer kannst du über [Gandalf](https://gandalf.wwlabs.space/) starten. 

Im Nebenraum gibt es eine elektronische Leinwand, welche über das [Gandalf](https://gandalf.wwlabs.space/)  aus- und wieder eingefahren werden kann. Achte bitte darauf, dass beim Ausfahren oder Einfahren im Schrank nichts rausragt! Beim Hochfahren oder Runterfahren *kann* die Leinwand sonst Dinge aus dem Regal herunterfallen lassen und dann kaputt machen! 


# Abschlussbemerkungen

Solltest du fertig mit deinem Medienkonsum sein, schalte bitte unnötig laufende Beamer und/oder Lautsprecher aus. Fahre auch bitte die Leinwand im Nebenraum wieder ein, wenn du fertig bist. Somit haben wir alle lange was von den Geräten. Und Spaß am Gerät wollen wir alle ja haben. 😃 
