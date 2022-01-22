package com.adaptionsoft.games.trivia

import java.lang.RuntimeException
import java.util.*

internal class Dice(diceSize: Int, randomSeed: Long) {
    private val diceSize: Int
    private val randomGenerator: Random

    init {
        if (diceSize < 1) throw RuntimeException("A dice must be larger than one")
        if (randomSeed < 0) throw RuntimeException("The random seed must be larger than zero")
        this.diceSize = diceSize
        randomGenerator = Random(randomSeed)
    }

    fun roll(): Int {
        return randomGenerator.nextInt(diceSize) + 1
    }
}