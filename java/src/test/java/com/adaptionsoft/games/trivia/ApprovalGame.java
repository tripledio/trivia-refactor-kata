package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;

public class ApprovalGame {
    private final BufferPresenter bufferPresenter;
    private final Dice tenDice;
    private final Dice sixDice;

    private ApprovalGame(long randomSeed) {
        tenDice = new Dice(4, randomSeed);
        sixDice = new Dice(10, randomSeed);
        bufferPresenter = new BufferPresenter();
    }

    public static ApprovalGame create(long randomSeed) {
        return new ApprovalGame(randomSeed);
    }

    public void runTestScenario() {
        final Game aGame = buildGame();

        runGame(aGame);

        approveMessages();
    }

    private void approveMessages() {
        Approvals.verifyAll("", bufferPresenter.getBufferedMessages().toArray());
    }


    private void runGame(Game aGame) {
        do {
            aGame.roll(sixDice.roll());
        } while (determineAnswer(aGame));
    }

    private boolean determineAnswer(Game aGame) {
        if (tenDice.roll() == 7) {
            return aGame.wrongAnswer();
        } else {
            return aGame.wasCorrectlyAnswered();
        }
    }


    private Game buildGame() {
        final Game aGame = new Game(bufferPresenter);
        aGame.add("Jan");
        aGame.add("Piet");
        aGame.add("Joris");
        aGame.add("Korneel");
        return aGame;
    }
}
