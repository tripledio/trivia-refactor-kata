using ApprovalTests;
using Trivia;
using Xunit;

namespace Tests;

public class ApprovalGame
{
    private readonly BufferPresenter _bufferPresenter;
    private readonly Dice _fourDice;
    private readonly Dice _sixDice;

    private ApprovalGame(int randomSeed) {
        _fourDice = new Dice(4, randomSeed);
        _sixDice = new Dice(6, randomSeed);
        _bufferPresenter = new BufferPresenter();
    }

    public static ApprovalGame Create(int randomSeed) {
        return new ApprovalGame(randomSeed);
    }

    public void RunTestScenario() {
        var aGame = BuildGame();

        RunGame(aGame);

        ApproveMessages();
    }

    private void ApproveMessages() {
        Approvals.VerifyAll("", _bufferPresenter.GetBufferedMessages(), "label");
    }


    private void RunGame(Game aGame) {
        do {
            aGame.Roll(_sixDice.Roll());
        } while (DetermineAnswer(aGame));
    }

    private bool DetermineAnswer(Game aGame) {
        if (_fourDice.Roll() == 4) {
            return aGame.WrongAnswer();
        } else {
            return aGame.WasCorrectlyAnswered();
        }
    }


    private Game BuildGame() {
        var aGame = new Game(_bufferPresenter);
        aGame.Add("Jan");
        aGame.Add("Piet");
        aGame.Add("Joris");
        aGame.Add("Korneel");
        return aGame;
    }
}