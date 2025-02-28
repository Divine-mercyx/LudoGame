package ludoGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PieceTest {

    private Player player;
    private Piece piece;

    @BeforeEach
    public void setUp() {
        Board board = new Board();
        player = new Player("fullname", "green", board);
        piece = player.getPieces().getLast();
    }


    @Test
    public void testThatPieceIsHomeByDefault_testPiece() {
        assertEquals(Status.AT_HOME, piece.getStatus());
    }

    @Test
    public void testThatPieceCurrentSquareIsNullOnCreation_testPiece() {
        assertNull(piece.getCurrentSquare());
    }

    @Test
    public void testThatPieceCanMoveWithVAlidStep_testPiece() {
        piece.move(6);
    }
}
