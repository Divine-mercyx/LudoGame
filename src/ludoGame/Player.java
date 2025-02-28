package ludoGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String color;
    private List<Piece> pieces;
    private Board board;

    public Player(String name, String color, Board board) {
        this.name = name;
        this.color = color;
        this.board = board;
        this.pieces = new ArrayList<Piece>();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 4; i++) {
            this.pieces.add( new Piece(this, board) );
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void movePiece(Piece piece, int steps) {
        System.out.println("you played: " + piece.getPlayer().getColor() + "\nrolled: " + steps);
        piece.move(steps);
    }

    public boolean getWinStatus() {
        int count = 0;
        for (Piece piece : this.pieces) {
            if (piece.getStatus().equals(Status.IS_FINISHED)) {
                count++;
            }
        }
        return count == this.pieces.size();
    }
}
