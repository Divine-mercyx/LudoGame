package ludoUpdate;

import java.util.Random;

public class Dice {
    private final Random rand = new Random();

    public int roll() {
        return rand.nextInt(6) + 1;
    }
}
