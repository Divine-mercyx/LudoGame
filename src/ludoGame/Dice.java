package ludoGame;

import java.util.Random;

public class Dice {
    private Random rand = new Random();

    public int roll() {
        int dice = rand.nextInt(6) + 1;
        return dice;
    }
}
