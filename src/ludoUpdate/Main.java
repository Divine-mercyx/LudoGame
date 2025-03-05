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
            Arrays.fill(ludo[i], " | ");
        }
        displayBoard(ludo);


        Player player1 = new Player("divine", "red", board);
        Player player2 = new Player("esther", "blue", board);
        Player player3 = new Player("oghene", "green", board);
        Player player4 = new Player("leke", "yellow", board);

        Player[] players = new Player[]{player1, player2, player3, player4};
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
                    }
                    else if (piece.getStatus() == Status.ON_BOARD) {
                        pieceToMove = piece;
                        break;
                    }
                }

                if (pieceToMove != null) {
                    Square aSquare = board.getSquares()[6][1];
                    pieceToMove.setCurrentSquare(aSquare);
//                    player.movePiece(pieceToMove, rolledDice);
                    int row = pieceToMove.getCurrentSquare().getPosition().getRow();
                    int col = pieceToMove.getCurrentSquare().getPosition().getCol();
                   ludo[row][col] = String.valueOf(player.getColor().charAt(0));
                 displayBoard(ludo);
                }
                else {
                    System.out.println("No piece could move. Try again next turn.");
                }

            }
        }
        scanner.close();
    }

    public static void displayBoard(String[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                builder.append(board[row][col]);
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
