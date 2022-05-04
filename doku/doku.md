# Dokumentation

Hier entsteht die Dokumentation für den OCA-Kurs.

## Zufallszahlen generieren:

Um Zufallszahlen zu generieren, gibt es folgende Möglichkeiten:
> ints r = ( int ) ( 2 + Math.round( Math.random() * ( 15 - 2 ) ) );

Der o.g. Code-Block erzeugt eine Zufallszahl im Bereich von:
> [2 ... 15 ]

Folgender Code erzeugt ebenfalls eine Zufallszahl (diesmal direkt als int)
> int r2 = new Random().nextInt(15);

Erzeugt eine Zufallszahl im Bereich von:
> [0 ... 15 ) // 15 exclusive!
