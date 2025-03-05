package ludoUpdate;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position p) {
            return p.row == this.row && p.col == this.col;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", row, col);
    }
}
