package main.java;

import java.util.*;
import java.util.InputMismatchException;

public class TicTacToe {

    // globale Klassenvariablen
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);  // Einmalige Initialisierung
        Random rand = new Random();

        while (true) {

            // Spielerzug
            System.out.println("Um einen Zug zu machen, bitte eine Nummer (1 - 9) eintragen und mit Enter bestätigen:");
            int playerPos = -1;
            while (true) {
                try {
                    playerPos = scan.nextInt();
                    if (playerPos > 0 && playerPos <= 9 && !playerPositions.contains(playerPos) && !cpuPositions.contains(playerPos)) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    scan.next();  // Clear the invalid input
                }
                System.out.println("Ungültige Eingabe, bitte erneut versuchen:");
            }

            placePiece(gameBoard, playerPos, "player");
            if (isGameFinished()) {
                printGameBoard(gameBoard);
                break;
            }

            // Computerzug
            int cpuPos;
            while (true) {
                cpuPos = rand.nextInt(9) + 1;
                if (!playerPositions.contains(cpuPos) && !cpuPositions.contains(cpuPos)) {
                    break;
                }
            }

            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);

            if (isGameFinished()) {
                break;
            }
        }
        scan.close();
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = (user.equals("player")) ? 'X' : 'O';
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        if (user.equals("player")) {
            playerPositions.add(pos);
        } else {
            cpuPositions.add(pos);
        }
    }

    public static boolean isGameFinished() {
        if (checkWinner().length() > 0) {
            System.out.println(checkWinner());
            return true;
        }
        return false;
    }

    public static String checkWinner() {
        List<List<Integer>> winningConditions = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(1, 4, 7),
                Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9),
                Arrays.asList(1, 5, 9),
                Arrays.asList(7, 5, 3)
        );

        for (List<Integer> condition : winningConditions) {
            if (playerPositions.containsAll(condition)) {
                return "Herzlichen Glückwunsch, du hast gewonnen!";
            } else if (cpuPositions.containsAll(condition)) {
                return "Die CPU hat gewonnen!";
            }
        }

        if (playerPositions.size() + cpuPositions.size() == 9) {
            return "Unentschieden!";
        }
        return "";
    }
}
