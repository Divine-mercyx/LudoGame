package ludoGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
    private Dice dice;

    @BeforeEach
    public void setUp() {
        dice = new Dice();
    }

    @Test
    public void testThatDiceWWhenRolledTheRandomNumberIsBetweenOneToSix_testDice() {
        assertTrue(dice.roll() <= 6);
        assertFalse(dice.roll() >= 6);
    }

}

