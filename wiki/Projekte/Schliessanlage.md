Schließanlage
==============

Im Space haben wir ein automatisches Schließsystem. Ziel war und ist es Mitgliedern jederzeit den Zutritt zu unseren Räumen zu ermögichen. 
Einige Hackerspaces haben bereits ähnliche Systeme im Einsatz, die meisten davon sind aber aus dem ein oder anderen Grund für uns ungeeignet.
So beschäftigten wir uns mit dem Selbstbau.

## Anforderungen

* Keine undokumentierten/unsicheren Funkschnittstellen
* Keine Sonderapps zur Kommunikation mit dem Schloss erforderlich
* Keine/Wenig Fremdsoftware auf dem Gerät
* Keine Modifizierung an der Tür erforderlich
* Schließende Verriegelung (nicht nur zuziehen)
* Betreibbar ohne Cloud
* Status abrufbar
* Keine hart limitierte Nutzerzahl
* Weitere Schließarten einbindbar


## Überlegungen

* Eigenbau 3D Druck mit Motor und eigener Elektronik
* Umbau Homematic Key..
* Umbau Equiva Key 

Auf Grund des Preises und dem Vorzug einer schon fast fertigen Lösung haben wir uns für einen Umbau eines Equiva Schlosses entschieden.

## Umbau

Wie immer sind alle Angaben hier ohne Gewähr und nur auf eigene Verantwwortung durchzuführen. 

### Deaktivierung Bluetooth

Auf der Platine sitzen 2 Chips, einmal ein XXX und einmal ein XXX. (Bilder und genaue Chiptypen fügt @justelex demnächst ein)  Letzter wird als reiner Funkchip verwendet. Nach unserem Reverseengineering kommunizieren die beiden Chips per SPI. Um eine ungewollte Kommunikation per Bluetooth zu verhindern, wollen wir diesen Chip deaktivieren. Dazu kann einfach das Versorgungstrace des Broadcom/XXX Chips durchtrennt werden. Wir haben das einfach mit einem Schraubenzieher durchgekratzt. Eine Überwachung oder Kommunikation mit dem anderen Chip findet also, wohl auch um Energie zu sparen nicht statt. Idealerweise sollte man die Traces so durchtrennen, das man sie mit einem Lötpunkt wiederherstellen kann. Bei Bedarf kann jetzt auch eine Funktionsprüfung mit den beiden Knöpfen auf der Vorderseite erfolgen.

### Spannungsversorgung + USV

Die Spannungsversorgung ist ab Werk über Batterien gelöst. Für unsere Zwecke ist das schlicht nicht realisierbar, da die Batteriekapazität nur für kurze Zeit ausreichen würde. Um dies zu umgehen haben wir an der Platine ein USB Kabel angelötet. Die Verorgung erfolgt über ein 2A USB Ladegerät oder eine Powerbank. Die Powerbank kann gleichzeitig als USV dienen und das Gerät am Laufen halten.

### Wifi Upgrade

Die Ansteuerung des Türschlosses ist über eine Wemos D1 realisiert, der im nichtmehr benötigten Batteriefach Platz findet. Die zwei GPIOS steuern über 2 Widerstände auf den die Schalter des Bluetooth Türschlosses. Achtung! Ohne ausreichende Widerstände (wir verwenden XXX kOhm) brennt der Wemos durch, wenn jemand die Knöpfe am Türschloss drückt. 

## Softwareseite

Der Controllserver ist ein im internen Netzwerk eingebundener Raspberry Pi. Auf ihm läufen ein Hostapd, ein Mosquitto MQTT server und ein SSH server. Aus dem internen Space Netz ist nur der SSH port erreichbar. Der Mosquitto Server hört nur auf das Interface des Hostapd, das ein eigenes WPA2-PSK geschütztes Netz eröffnet. In diesem Netz sind nur der PI und das Türschloss.

Auf der Türschlosseite läuft auf dem Wemos eine Tasmota Firmware. Die darin konfigurierten MQTT Commands Triggern über das GPIO Interface die Button-Eingänge des Türschlosses. Das Signal bleibt ca 1 Sekunde anstehen. 

Auf dem Controllserver sind die berechtigten Personen mit ihrem SSH key hinterlegt. Sie können sich dann mit den Benutzern auf@space und zu@space einloggen, was ein entsprechendes MQTT Command an das Türschloss triggert. 


