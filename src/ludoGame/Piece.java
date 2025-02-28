package ludoGame;

public class Piece {
    private Player player;
    private Status status;
    private Square currentSquare;
    private Board board;

    public Piece(Player player, Board board) {
        this.player = player;
        this.status = Status.AT_HOME;
        this.currentSquare = null;
        this.board = board;
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

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void move(int steps) {
        if (this.status == Status.AT_HOME) {
            setCurrentSquareIfPlayerJustGotOut(steps);
        }
        else {
            setCurrentSquareWithSteps(steps);
        }

    }

    private void setCurrentSquareIfPlayerJustGotOut(int steps) {
        if (steps == 6) {
            this.status = Status.ON_BOARD;
            this.currentSquare = board.getStartingSquareForPlayer(player);
            this.currentSquare.addPiece(this);
        } else {
            System.out.println("roll six to get out");
        }
    }

    private void setCurrentSquareWithSteps(int steps) {
        if (this.status == Status.ON_BOARD) {
            int currentSquareIndex = board.getSquareIndex(this.currentSquare);
            if (canEnterFinalLane(currentSquareIndex, steps)) {
                this.currentSquare = board.getNextFinalSquare(this.player.getColor(), currentSquare, steps);
            } else {
                this.currentSquare.removePiece(this);
                this.currentSquare = board.getNextSquare(currentSquare, steps);
            }
            this.currentSquare.addPiece(this);
            captureAPiece();
            System.out.println("youre currently in this position: " + currentSquare.getPosition());
            checkIfPieceHasFinished();
        }
    }


    private void captureAPiece() {
        for (Piece others : currentSquare.getOccupyingPieces()) {
            if (!others.getPlayer().equals(this.player) && !currentSquare.isSafe()) {
                others.setStatus(Status.AT_HOME);
                others.setCurrentSquare(null);
                currentSquare.removePiece(others);

                currentSquare.getOccupyingPieces().remove(others);
                currentSquare.getOccupyingPieces().remove(this);


                this.setStatus(Status.IS_FINISHED);
                System.out.println("you just captured a piece, you finished");
                return;
            }
        }
    }

    private void checkIfPieceHasFinished() {
        if (board.isReachedFinalSquare(currentSquare, player)) {
            this.status = Status.IS_FINISHED;
            System.out.println("you have reached the final square");
        }
    }

    private boolean canEnterFinalLane(int currentSquareIndex, int steps) {
        return (currentSquareIndex + steps) >= 52;
    }

}
