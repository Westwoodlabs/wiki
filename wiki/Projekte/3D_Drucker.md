How To 3D Drucker
==============

Im Space haben wir einen 3D-Drucker (Anycubic Mega X).

Dieser Drucker darf nur nach einer **Einweisung** verwendet werden!

## Anforderungen

* Verwendung nur nach Einweisung
* Kein Aceton
* Nur mit Mesh-Leveling[^bignote]
* Nicht an den Verstellschrauben drehen
* Kein Aceton
* Spachtel vermeiden[^1]
* Kein Aceton[^2]

[^bignote]: Mesh-Leveling aktivieren .gcode
    ```
    M420 S1                                    ; Enable leveling 
    M420 Z2.0                                  ; Set leveling fading height to 2 mm
    ```
[^1]: Nach dem Abkühlen der Druckplatte, lässt sich im Normalfall das Objekt sehr leicht lösen.
[^2]: Kein Aceton