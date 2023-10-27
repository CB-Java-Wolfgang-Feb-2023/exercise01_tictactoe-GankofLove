# TicTacToe Spiel Dokumentation

## Überblick
Das `TicTacToe`-Programm ermöglicht es einem Spieler, gegen den Computer in einem klassischen TicTacToe-Spiel anzutreten. Das Spielbrett besteht aus 3x3 Feldern, die über die Zahlen 1-9 zugeordnet werden. Der Spieler ist "X" und der Computer ist "O".

## Struktur

### Klassenvariablen
- **playerPositions**: Speichert die Positionen des Spielers auf dem Spielbrett.
- **cpuPositions**: Speichert die Positionen des Computers auf dem Spielbrett.

### Hauptfunktion (`main`)
- Initialisiert das Spielbrett und gibt den Anfangszustand aus.
- Die Spiellogik wird in einer ständigen Schleife ausgeführt, bis ein Sieger feststeht oder ein Unentschieden erreicht ist. In jedem Schritt der Schleife hat zuerst der Spieler und dann der Computer einen Zug.

### Methoden
- **`printGameBoard(char[][] gameBoard)`**: Gibt den aktuellen Zustand des Spielbretts aus.

- **`placePiece(char[][] gameBoard, int pos, String user)`**: Platziert das Symbol (X oder O) des angegebenen Benutzers an der gewünschten Position auf dem Spielbrett.

- **`isGameFinished()`**: Überprüft, ob das Spiel beendet ist (ein Sieger feststeht oder ein Unentschieden erreicht ist).

- **`checkWinner()`**: Überprüft, ob ein Sieger feststeht, und gibt eine entsprechende Nachricht zurück.

## Spielverlauf
1. Das leere Spielbrett wird ausgegeben.
2. Der Spieler wird aufgefordert, eine Zahl zwischen 1 und 9 einzugeben, um seinen Zug zu machen.
3. Der Spielerzug wird auf dem Spielbrett platziert und das aktualisierte Spielbrett wird ausgegeben.
4. Der Computer zieht zufällig (unter Berücksichtigung der bereits belegten Felder).
5. Das aktualisierte Spielbrett mit dem Computerzug wird ausgegeben.
6. Schritte 2-5 werden wiederholt, bis das Spiel endet.

Das Spiel endet, wenn ein Spieler drei seiner Symbole in einer Reihe, Spalte oder Diagonale hat oder wenn alle Felder belegt sind und kein Spieler gewonnen hat.
