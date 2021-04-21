package model.dice;

import java.util.Random;

public class DiceImpl implements Dice {

    private static final int MIN_VALUE_DICE = 1;
    private static final int MAX_VALUE_DICE = 6;

    @Override
    public int roll() {
        final Random rand = new Random();
        return rand.nextInt((MAX_VALUE_DICE - MIN_VALUE_DICE) + 1) + MIN_VALUE_DICE;
    }
}
