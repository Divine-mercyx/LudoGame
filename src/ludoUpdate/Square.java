package ludoUpdate;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private Position position;
    private boolean isSafe;
    private List<Piece> occupyingPieces;

    public Square(Position position, boolean isSafe) {
        this.position = position;
        this.isSafe = isSafe;
        this.occupyingPieces = new ArrayList<Piece>();
    }

    public void setSafe(boolean isSafe) {
        this.isSafe = isSafe;
    }

    public boolean isSafe() {
        return this.isSafe;
    }

    public Position getPosition() {
        return this.position;
    }

    public void addPiece(Piece piece) {
        this.occupyingPieces.add(piece);
    }

    public void removePiece(Piece piece) {
        this.occupyingPieces.remove(piece);
    }

    public List<Piece> getOccupyingPieces() {
        return this.occupyingPieces;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Square square = (Square) obj;
        return this.isSafe == square.isSafe && this.position.equals(square.position);
    }


}
