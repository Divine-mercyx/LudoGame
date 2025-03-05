package ludoUpdate;

public class Piece {
    private Player player;
    private Square currentSquare;
    private Status status;
    private Board board;
    
    public Piece(Player player, Board board) {
        this.player = player;
        this.board = board;
        this.currentSquare = null;
        this.status = Status.AT_HOME;
    }

    public void move(int steps) {
        if (this.status == Status.AT_HOME) {
            setCurrentSquareIfPlayerJustGotOut(steps);
        }
//        else {
//
//        }
    }

    private void setCurrentSquareIfPlayerJustGotOut(int steps) {
        if (steps == 6) {
            this.status = Status.ON_BOARD;
            this.currentSquare = this.board.getStartingSquare(player);
            if (this.currentSquare == null) {
                System.out.println("it is null");
            }
        } else {
            System.out.println("roll six to get out");
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Status getStatus() {
        return this.status;
    }

    public Square getCurrentSquare() {
        return this.currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) { this.currentSquare = currentSquare; }


}
