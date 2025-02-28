package ludoGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Piece pieceA;
    private Piece pieceB;
    private Piece pieceC;
    private Piece pieceD;


    private Player player1;
    private Piece piece1;
    private Piece piece2;
    private Piece piece3;
    private Piece piece4;

    @BeforeEach
    public void setUp() {
        Board board = new Board();
        player = new Player("fullname", "green", board);
        pieceA = player.getPieces().getLast();
        pieceB = player.getPieces().getFirst();
        pieceC = player.getPieces().get(1);
        pieceD = player.getPieces().get(2);

        player1 = new Player("fullname", "red", board);
        piece1 = player1.getPieces().getLast();
        piece2 = player1.getPieces().getFirst();
        piece3 = player1.getPieces().get(1);
        piece4 = player1.getPieces().get(2);
    }

    @Test
    public void testToCheckApiecePLayerName_compareWithPLayerName_testPlayer() {
        String name = piece1.getPlayer().getName();
        assertEquals(name, player.getName());
    }


    @Test
    public void testPLayerToMovePeiceAtHomeWithInvalidRoll_testPiece() {
        player.movePiece(pieceA, 3);
        assertEquals(Status.AT_HOME, pieceA.getStatus());
        assertNull(pieceA.getCurrentSquare());
    }


    @Test
    public void testPlayerToMoveWithFromHomeWithValidRoll_testPiece() {
        player.movePiece(pieceA, 6);
        assertEquals(Status.ON_BOARD, pieceA.getStatus());
        assertNotNull(pieceA.getCurrentSquare());
    }

    @Test
    public void testThatWHenPLayerPLaysPeiceItMOves_testPiece() {
        player.movePiece(pieceA, 6);
        Square initialSquare = pieceA.getCurrentSquare();
        player.movePiece(pieceA, 4);
        Square nextSquare = pieceA.getCurrentSquare();
        assertNotEquals(initialSquare, nextSquare);
    }

    @Test
    public void testThatPLayerReachesTheFinal_testPeice() {
        player.movePiece(pieceA, 6);
        int jumpToEndNumber = 52;
        player.movePiece(pieceA, jumpToEndNumber);
        assertEquals(Status.IS_FINISHED, pieceA.getStatus());
    }


    @Test
    public void testThatPlayerPlaysAfterFinishing_testPeice() {
        player.movePiece(pieceA, 6);
        int jumpToEndNumber = 52;
        player.movePiece(pieceA, jumpToEndNumber);
        assertEquals(Status.IS_FINISHED, pieceA.getStatus());
        Square finishedSquare = pieceA.getCurrentSquare();
        player.movePiece(pieceA, 6);
        assertEquals(Status.IS_FINISHED, pieceA.getStatus());
        assertEquals(finishedSquare, pieceA.getCurrentSquare());
    }

    @Test
    public void testThatEachPLayerPeicesMovesIndependently_testPlayer() {
        player.movePiece(pieceA, 6);
        player1.movePiece(piece1, 6);
        player.movePiece(pieceA, 32);
        player1.movePiece(piece1, 45);
        assertEquals(Status.IS_FINISHED, piece1.getStatus());
        assertEquals(Status.AT_HOME, pieceA.getStatus());
    }


    @Test
    public void testToCheckPlayerHasWon_testPlayer() {
        player.movePiece(pieceA, 6);
        player1.movePiece(piece1, 6);
        player.movePiece(pieceA, 32);
        player1.movePiece(piece1, 45);
        assertEquals(Status.IS_FINISHED, piece1.getStatus());
        assertEquals(Status.AT_HOME, pieceA.getStatus());

        player.movePiece(pieceB, 6);
        player1.movePiece(piece2, 6);
        player.movePiece(pieceB, 32);
        player1.movePiece(piece2, 45);
        assertEquals(Status.IS_FINISHED, piece2.getStatus());
        assertEquals(Status.AT_HOME, pieceB.getStatus());


        player.movePiece(pieceC, 6);
        player1.movePiece(piece3, 6);
        player.movePiece(pieceC, 32);
        player1.movePiece(piece3, 45);
        assertEquals(Status.IS_FINISHED, piece3.getStatus());
        assertEquals(Status.AT_HOME, pieceC.getStatus());


        player.movePiece(pieceD, 6);
        player1.movePiece(piece4, 6);
        player.movePiece(pieceD, 32);
        player1.movePiece(piece4, 45);
        assertEquals(Status.IS_FINISHED, piece4.getStatus());
        assertEquals(Status.AT_HOME, pieceC.getStatus());
//        System.out.println(piece1.getStatus());
        boolean hasWon = player1.getWinStatus();
        assertTrue(hasWon);
    }


    @Test
    public void testThatAfterBeingWon_andOpponentPLaysSixHisStartsFromTheBeginning() {
        player.movePiece(pieceA, 6);
        player1.movePiece(piece1, 6);
        player.movePiece(pieceA, 32);
        player1.movePiece(piece1, 45);
        assertEquals(Status.IS_FINISHED, piece1.getStatus());
        assertEquals(Status.AT_HOME, pieceA.getStatus());

        player.movePiece(pieceB, 6);
        player1.movePiece(piece2, 6);
        player.movePiece(pieceB, 32);
        player1.movePiece(piece2, 45);
        assertEquals(Status.IS_FINISHED, piece2.getStatus());
        assertEquals(Status.AT_HOME, pieceB.getStatus());


        player.movePiece(pieceC, 6);
        player1.movePiece(piece3, 6);
        player.movePiece(pieceC, 32);
        player1.movePiece(piece3, 45);
        assertEquals(Status.IS_FINISHED, piece3.getStatus());
        assertEquals(Status.AT_HOME, pieceC.getStatus());


        player.movePiece(pieceD, 6);
        player1.movePiece(piece4, 6);
        player.movePiece(pieceD, 32);
        player1.movePiece(piece4, 45);
        assertEquals(Status.IS_FINISHED, piece4.getStatus());
        assertEquals(Status.AT_HOME, pieceC.getStatus());
//        System.out.println(piece1.getStatus());
        boolean hasWon = player1.getWinStatus();
        assertTrue(hasWon);
        player.movePiece(pieceB, 6);
        assertEquals(Status.ON_BOARD, pieceB.getStatus());
    }


}
