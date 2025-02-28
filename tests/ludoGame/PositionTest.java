package ludoGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(0, 0);
    }

    @Test
    public void testThatPositionHasCol_testPosition() {
        assertEquals(0, position.getCol());
    }


    @Test
    public void testThatPositionHasRow_testPosition() {
        assertEquals(0, position.getRow());
    }
}
