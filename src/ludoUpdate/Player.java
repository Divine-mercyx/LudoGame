package ludoUpdate;


import java.util.ArrayList;
import java.util.List;

public class Player {
    private String color;
    private String name;
    private List<Piece> pieces;
    private Board board;


    public Player(String color, String name, Board board) {
        this.color = color;
        this.name = name;
        this.board = board;
        pieces = new ArrayList<Piece>();
        initializePieces();
    }

    public void movePiece(Piece piece, int steps) {
        piece.move(steps);
    }

    public String getName() {
        return this.name;
    }

    private void initializePieces() {
        for (int i = 0; i < 4; i++) {
            this.pieces.add( new Piece(this, this.board) );
        }
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public String getColor() {
        return this.color;
    }
}
