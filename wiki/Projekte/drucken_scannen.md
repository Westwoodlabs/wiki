# Drucken und Scannen im Space

Im Space steht im Nebenraum ein Samsung MFP zum monochromen duplex-Drucken und duplex-Scannen zur Verfügung.

## Drucken

Der Drucker ist erreichbar unter dem Hostname lasermfp.wwlabs.space

### Treiber:
- Linux/CUPS: [ToDo!]
- Windows: [Treiber-Download](https://ftp.hp.com/pub/softlib/software13/printers/SS/SL-M3370FD/SamsungUniversalPrintDriver3.exe) (Ja, Samsung-Treiber von HP, die haben die Druckersparte von Samsung gekauft)
 

## Scannen

Zum Scannen steht eine Infrastruktur mit Webdienst zum PDF-Download bereit.
Um diese zu verwenden:
- Zu scannende Dokumente in den Einzug oben einlegen oder auf das Vorlagenglas legen
- Drucker durch tippen auf das Display aufwecken.
- auf der Startseite "Scannen" auswählen
- "SMB Scan" auswählen
- oben rechts auf "Next" tippen
- Scan2Folder auswählen
- OPTIONAL: in dem Zahnrad-Menü unten rechts können weitere Optionen wie bspw. Farbe, DPI, Duplex-Scan, Format, etc... ausgewählt werden.
- Hardware Start-Knopf drücken oder "Start" auf dem Display antippen

Das Dokument kann jetzt in Webinterface unter [scan.wwlabs.space](https://scan.wwlabs.space) gefunden werden.
Dort wird es nach 15 min automatisch gelöscht. Bei Bedarf kann das Dokument direkt nach dem Download auch durch den User gelöscht werden.

Scan2Mail steht ebenfalls zur Verfügung. (Sollte allerdings aktuell nicht für sensible Dokumente verwendet werden, da die Mail -noch- von einem externen Server verarbeitet wird. [ToDo!])
