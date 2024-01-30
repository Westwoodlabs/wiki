# Gebrauchsanweisung Harry Plotter

## Hinweis
- Unser Schneidplotter heißt Harry Plotter
- Das Gerät bitte nur verwenden, wenn ihr eine kurze Einweisung bekommt habt.
- Bei Fragen gerne foorschtbar oder mirconnect ansprechen.

## Hardware
Der Plotter im Space ist ein generischer China-Plotter mit `RS232` (1x DB9 & 1x USB)
### Einlegen der Folie
Die Folienrolle wird auf den Halter geschoben, der hinten an dem Gestell des Plotters hängt. Dann wird der Halter mitsamt Folie in das Gestell gehängt und der Folienanfang von hinten in den Plotter geführt. Dafür müssen die drei Führungsrollen jeweils mit ihrem Hebel nach oben geklappt werden. Dann die Folie soweit reinschieben, dass sie ca 1cm übers Messer heraussteht und die Führungsrollen wieder herunterklappen.
### Setzen des Nullpunktes
Den Plotter einschalten, falls noch nicht geschehen.
Den Button `Offline/Pause` drücken. Jetzt kann der Kopf, sowie die Folie mit den Pfeiltasten frei gefahren werden. Nun den gewünschten Nullpunkt anfahren (mehr dazu, wo der Nullpunkt sich in der Datei befindet weiter unten unter **Software**). Bestätigen der Position mit dem Button `Origin`.
### Einstellen der Schnitttiefe
Das ist ein sehr wichtiger Schritt! Unterschiedliche Folien haben unterschiedliche Stärken. Daher bei jedem Folienwechsel die Messertiefe kontrollieren! 

![Plottermesser](Plotter_Messer.png)

Den Nullpunkt in einer Ecke der Folie setzen und dann den Button `Test` betätigen. Damit wird ein Quadrat in einem Quadrat geplottet, an dem man wunderbar die Schnitttiefe kontrollieren kann. Das Messer sollte **NICHT** in die Trägerfolie schneiden. Allerdings sollte es die eigentliche Folie komplett durchtrennen. Das ganze ist ein sehr schmaler Grat. Um das Messer zu verstellen muss am Kopf die bronzefarbene Mutter gelöst werden und dann mit dem Silbernen Rändel das Messer raus- oder reingedreht werden. (Fotos folgen) Dann wieder ein Test-Quadrat plotten.
Wenn sich das Quadrat gut ablösen lässt, und in der Trägerfolie quasi keine Spuren vom Messer zu sehen sind, die bronzefarbene Mutter wieder festdrehen und schon kanns losgehen.

### tl;dr:
- Weniger ist mehr -> Dann ranntasten.
- Zu tiefe Schnitt ins Trägermaterial lassen das Messer schnell stupf werden und zu wenig tiefe Schnitte lassen sich nicht vernünftig raustrennen.
- Testmuster verwenden via Button `Test`

### Einstellungen am Plotter
Hier haben wir mit folgender Einstellung immer gute Erfahrungen gemacht:  
- `Speed 140mm/s`  
- `Pressure 140g`  

## Software
Als Software hat sich [Inkscape](https://inkscape.org/) bewährt, damit lassen sich zB. schnell Schriftzüge erstellen und plotten oder aber auch komplexe svg-Dateien zu Folie bringen.  

Hier vereinfacht die nötigen Schritte:
- Das gewünschte Motiv in Inkscape laden
- Alles Markieren und in Pfade umwandeln (Pfad->Objekt in Pfad umwandeln)
- Die Pfade zur Kontrolle anzeigen lassen (Ansicht->Anzeigemodus->Umriss)
- Das *Mauszeigertool* auswählen
- Oben in der Leiste bei den Maßen auf das Schloss klicken (muss zu sein)
- Die gewünschte Breite oder Höhe in mm angeben (Der jeweils andere Wert skaliert automatisch mit)
- Seitengröße anpassen (Bearbeiten->Seitengröße auf Auswahlgröße)
- Das Menü zum Plotten aufrufen (Erweiterungen->Exportieren->Plotten)
- Nun die serielle Schnittstelle auswählen (zB. `COM1` oder `/dev/ttyUSB0`)
- Die Standardeinstellungen sollten passen (`9600baud, 8Bit, 1StoppBit, keine Parität, Flusssteuerung XON/XOFF, Befehlssprache HPGL`)
- oben im Tab Plottereinstellungen noch die *Drehung auf 90° setzen* (sonst wird zB. bei Schriften extrem viel Folie verschwendet!)
- Dann auf Anwenden klicken und dem Plotter zuschauen (Wenn das Gerät groben Unfug macht, sofort den Button *Reset* am Plotter drücken, damit bootet der Plotter durch und unterbricht den laufenden Auftrag)

### Die Sache mit dem Nullpunkt
Generell ist der absolute Nullpunkt bei -273,15°C bzw. 0°K. Der Plotter hat seinen Nullpunkt immer unten rechts. In Inkscape, sowie auf der Folie am Plotter (Origin). Allerdings befindet sich der Nullpunkt in Inscape **NICHT** unten rechts in der Arbeitsfläche, sondern am ersten Berührungspunkt vom Objekt unten rechts. Wenn man ein unförmiges Objekt plotten möchte, empfiehlt es sich nach dem Zuschneiden der Seitengröße einen klitzekleinen Kreis ganz unten rechts in der Ecke der "Seite" zu zeichnen. Dann stimmt das gesetzte Origin am Plotter in etwa mit dem kleinen Kreis überein, das macht das Platzieren des Motivs auf der Folie wesentlich einfacher.

## Folie
### Aufbringen der Folie
Wenn der Plotter mit seinem Durchgang fertig ist, kann man sich mit dem Button `Offline/Pause` und dem Pfeil nach unten die Folie rausschieben lassen. Dann einfach mit einem Cuttermesser die Folie in einer der Rillen abschneiden. Bitte dabei drauf achten, dass möglichst wenig Folie verschwendet wird. (Man kann zb mehrere Logos nebeneinander plotten: einfach immer den Origin ein Stück weiter nach links vor das letzte Logo setzen und in Inkscape nochmal auf `Anwenden` klicken)  
Dann alles was sich an überflüssiger Folie um das eigentliche Motiv befindet vorsichtig abziehen. Wenn das sehr fummelig ist, war das Messer nicht korrekt eingestellt. Dann ein passendes Stück Transferfolie abschneiden. Dieses nun auf das Motiv kleben, das aufgedruckte Gitter hilft später enorm bei der Ausrichtung, also: gerade Aufkleben. (zB. können bei langen Schriftzügen auch mehrere Stücke Transferfolien nebeneinander geklebt werden.) Das Motiv mit aufgeklebter Transferfolie nun auf einem ebenen Untergrund feste mit der Rakel an die Transferfolie drücken. Dann vorsichtig das Trägermaterial der Folie abziehen. Jetzt das Motiv an die gewünschte Stelle kleben und gut mit der Rakel andrücken, dann nur noch die Transferfolie abziehen und mit der Filzseite der Rakel final über das Motiv streichen. Fertig!

### Folienbestand
Unser aktueller Folienbestand besteht hauptsächlich aus Oracal-Folien, die es vom Vorbesitzer zum Plotter dazugab. (Danke!) In naher Zukunft werden wir wahrscheinlich einen Preis für geplottete Dinge einführen, damit wir auch wieder Folie nachkaufen können. **Die Folie ist nämlich seeehr teuer! Bitte sparsam damit umgehen!**

## Quellen & weitere Infos

Weitere Informationen bei Bedarf unter:
- [Chaospott-Wiki](https://dokuwiki.chaospott.de/geraete:schneidplotter:start)
- [Starship-Factory-Wiki](https://wiki.starship-factory.ch/Howtos/Schneideplotter_mit_Inkscape_ansteuern/)
