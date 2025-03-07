package ludoUpdate;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Dice dice = new Dice();
        String[][] ludo = new String[15][15];

        for (int i = 0; i < 15; i++) {
            Arrays.fill(ludo[i], "|_|");
        }



        Player player1 = new Player("red","divine", board);
        Player player3 = new Player("green","oghene", board);
        Player player2 = new Player("blue", "esther", board);
        Player player4 = new Player("yellow", "leke", board);

        Player[] players = new Player[]{player1, player2, player3, player4};
        displayBoard(ludo, players);
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            for (Player player : players) {
                System.out.println("player " + player.getName() + " turn to play ");
                System.out.println("press enter to play");
                scanner.nextLine();

                int rolledDice = dice.roll();
                System.out.println("rolled " + rolledDice);
                Piece pieceToMove = null;

                for (Piece piece : player.getPieces()) {
                    if (piece.getStatus() == Status.AT_HOME && rolledDice == 6) {
                        pieceToMove = piece;
                        break;
                    } else if (piece.getStatus() == Status.ON_BOARD) {
                        pieceToMove = piece;
                        break;
                    }
                }

                if (pieceToMove != null) {
                    player.movePiece(pieceToMove, rolledDice);
                    int row = pieceToMove.getCurrentSquare().getPosition().getRow();
                    int col = pieceToMove.getCurrentSquare().getPosition().getCol();
                    ludo[row][col] = "|" + player.getColor().charAt(0) + "|";
                    displayBoard(ludo, players);

                    if (player.hasWon()) {
                        System.out.println("Player " + player.getName() + " has won the game!");
                        gameIsRunning = false;
                        break;
                    }
                } else {
                    System.out.println("No piece could move. Try again next turn.");
                }
            }
        }
        scanner.close();
    }

    public static void displayBoard(String[][] aboard, Player[] players) {
        StringBuilder builder = new StringBuilder();
        String[][] board = printBoard(aboard);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                builder.append(board[row][col]);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static String[][] printBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ((row < 6 && col < 6) || (row < 6 && col > 8) ||
                        (row > 8 && col < 6) || (row > 8 && col > 8) ||
                        (row >= 6 && row <= 8 && col >= 6 && col <= 8)) {
                    board[row][col] = "   ";
                }
            }
        }
        return board;
    }


}
