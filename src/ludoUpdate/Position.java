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

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position position) {
            return position.row == this.row && position.col == this.col;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", row, col);
    }
}
