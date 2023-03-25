# How To 3D Drucker

## Anycubic Mega X

Im Space haben wir einen 3D-Drucker (Anycubic Mega X).

Dieser Drucker darf nur nach einer **Einweisung** verwendet werden!

### Anforderungen

- Verwendung nur nach Einweisung
- Kein Aceton
- Nur mit Mesh-Leveling (Gehört in den Start-G-Code):
  ```
  M501      ; Mesh Bed Leveling (Load all saved settings from EEPROM)
  M420 S1   ; Enable leveling
  M420 Z2.0 ; Set leveling fading height to 2 mm
  ```
- Nicht an den Verstellschrauben für das Heatbed drehen
- Kein Aceton
- Spachtel vermeiden! Nach dem Abkühlen der Druckplatte, lässt sich im Normalfall das Objekt sehr leicht lösen.
- Kein Aceton
- Kein. Aceton. Niemals. Wirklich? Nein.

### OctoPrint

Unter [octopi.wwlabs.space](http://octopi.wwlabs.space) ist der OctoPi mit Octoprint zu finden. Logindaten sind `octopi` / `octopi`.

### Prusa Slicer Profil

[PrusaSlicer_config_MegaX.ini](https://github.com/Westwoodlabs/wiki/raw/master/wiki/Projekte/3D_Drucker/PrusaSlicer_config_MegaX.ini)



