package com.adaptionsoft.games.trivia;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void triviaGameForDataSetOne() {
        ApprovalGame.create(5L).runTestScenario();
    }

    @Test
    public void triviaGameForDataSetTwo() {
        ApprovalGame.create(7L).runTestScenario();
    }

    @Test
    public void triviaGameForDataSetThree() {
        ApprovalGame.create(13L).runTestScenario();
    }

    @Test
    public void triviaGameForDataSetFour() {
        ApprovalGame.create(17L).runTestScenario();
    }

    @Test
    public void triviaGameForDatSetFive() {
        ApprovalGame.create(93L).runTestScenario();
    }


}
