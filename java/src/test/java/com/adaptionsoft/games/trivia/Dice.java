package com.adaptionsoft.games.trivia;

import java.util.Random;

final class Dice {

    private final int diceSize;
    private final Random randomGenerator;

    public Dice(int diceSize, long randomSeed) {
        if (diceSize < 1) throw new RuntimeException("A dice must be larger than one");
        if (randomSeed < 0) throw new RuntimeException("The random seed must be larger than zero");
        this.diceSize = diceSize;
        this.randomGenerator = new Random(randomSeed);

    }

    int roll() {
        return randomGenerator.nextInt(diceSize) + 1;
    }

}
