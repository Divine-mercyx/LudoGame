package ludoUpdate;

import java.util.Objects;

public class Piece {
    private Player player;
    private Square currentSquare;
    private Status status;
    private Board board;
    
    public Piece(Player player, Board board) {
        this.player = player;
        this.board = board;
        this.currentSquare = new Square( new Position(0, 0), false );
        this.status = Status.AT_HOME;
    }

    public void move(int steps) {
        if (this.status == Status.AT_HOME) {
            setCurrentSquareIfPlayerJustGotOut(steps);
        }
        else if (this.status == Status.ON_BOARD) {
            moveOnBoard(steps);
//            capturePiece();
            checkIfPlayerEnteredHome();
        }
    }

//    private void setCurrentSquareSteps(int steps) {
//        if (this.status == Status.ON_BOARD) {
//            int[][] currentSquareIndex = this.board.getSquareIndex(this.currentSquare);
//            this.currentSquare.removePiece(this);
//        }
//    }

    private void setCurrentSquareIfPlayerJustGotOut(int steps) {
        if (steps == 6) {
            this.status = Status.ON_BOARD;
            this.currentSquare = this.board.getStartingSquare(player);
            this.currentSquare.addPiece(this);
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




    private void moveOnBoard(int steps) {
        this.currentSquare = this.board.getNextSquare(this.currentSquare, this.player.getColor().toLowerCase(), steps);
        this.currentSquare.addPiece(this);
    }


//    private void capturePiece() {
//        for (Piece others : this.currentSquare.getOccupyingPieces()) {
//            if (!others.getPlayer().equals(this.player) && !this.currentSquare.isSafe()) {
//                others.setStatus(Status.AT_HOME);
//                others.setCurrentSquare(board.getSquares()[0][0]);
//                this.currentSquare.removePiece(others);
//                this.currentSquare.removePiece(this);
//                this.currentSquare.getOccupyingPieces().remove(others);
//                currentSquare.getOccupyingPieces().remove(this);
//
//                this.setStatus(Status.IS_FINISHED);
//                System.out.println("you just captured a piece, you finished");
//                return;
//            }
//        }
//    }


//    private void capturePiece() {
//        for (Piece others : this.currentSquare.getOccupyingPieces()) {
//            if (!others.getPlayer().equals(this.player) && !this.currentSquare.isSafe()) {
//                others.setStatus(Status.AT_HOME);
//                others.setCurrentSquare(board.getStartingSquare(others.getPlayer()));
//                this.currentSquare.removePiece(others);
//                this.currentSquare.getOccupyingPieces().remove(others);
//                this.status = Status.IS_FINISHED;
//                System.out.println("You just captured a piece!");
//                return;
//            }
//        }
//    }



    private void checkIfPlayerEnteredHome() {
        int row = this.currentSquare.getPosition().getRow();
        int col = this.currentSquare.getPosition().getCol();

        if (Objects.equals(player.getColor(), "red") && row == 7 && col <= 6) {
            this.setStatus(Status.IS_FINISHED);
            System.out.println("you have reached the final square");
        }

        if (Objects.equals(player.getColor(), "green") && col == 7 && row <= 6) {
            this.setStatus(Status.IS_FINISHED);
            System.out.println("you have reached the final square");
        }

        if (Objects.equals(player.getColor(), "blue") && row == 7 && col <= 13) {
            this.setStatus(Status.IS_FINISHED);
            System.out.println("you have reached the final square");
        }


        if (Objects.equals(player.getColor(), "yellow") && col == 7 && row <= 13) {
            this.setStatus(Status.IS_FINISHED);
            System.out.println("you have reached the final square");
        }
    }


}
