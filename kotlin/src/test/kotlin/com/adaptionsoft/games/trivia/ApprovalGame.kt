package com.adaptionsoft.games.trivia


import com.adaptionsoft.games.uglytrivia.*
import org.approvaltests.*

internal class ApprovalGame private constructor(randomSeed: Long) {
    private val bufferPresenter: BufferPresenter
    private val fourDice: Dice
    private val sixDice: Dice

    init {
        fourDice = Dice(4, randomSeed)
        sixDice = Dice(6, randomSeed)
        bufferPresenter = BufferPresenter()
    }

    fun runTestScenario() {
        val aGame = buildGame()
        runGame(aGame)
        approveMessages()
    }

    private fun approveMessages() {
        Approvals.verifyAll<Any>("", bufferPresenter.bufferedMessages.toTypedArray())
    }

    private fun runGame(aGame: Game) {
        do {
            aGame.roll(sixDice.roll())
        } while (determineAnswer(aGame))
    }

    private fun determineAnswer(aGame: Game): Boolean {
        return if (fourDice.roll() == 4) {
            aGame.wrongAnswer()
        } else {
            aGame.wasCorrectlyAnswered()
        }
    }

    private fun buildGame(): Game {
        val aGame = Game(bufferPresenter)
        aGame.add("Jan")
        aGame.add("Piet")
        aGame.add("Joris")
        aGame.add("Korneel")
        return aGame
    }

    companion object {
        @JvmStatic
        fun create(randomSeed: Long): ApprovalGame {
            return ApprovalGame(randomSeed)
        }
    }
}