package com.adaptionsoft.games.trivia

import com.adaptionsoft.games.trivia.ApprovalGame.Companion.create
import org.junit.jupiter.api.*

internal class GameTest {
    @Test
    fun triviaGameForDataSetOne() {
        create(5L).runTestScenario()
    }

    @Test
    fun triviaGameForDataSetTwo() {
        create(7L).runTestScenario()
    }

    @Test
    fun triviaGameForDataSetThree() {
        create(13L).runTestScenario()
    }

    @Test
    fun triviaGameForDataSetFour() {
        create(17L).runTestScenario()
    }

    @Test
    fun triviaGameForDatSetFive() {
        create(93L).runTestScenario()
    }
}