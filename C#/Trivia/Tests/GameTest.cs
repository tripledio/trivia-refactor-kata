using ApprovalTests.Reporters;
using Xunit;

namespace Tests;

// note: use DiffReporter when not using Rider
// [UseReporter(typeof(DiffReporter))]
[UseReporter(typeof(RiderReporter))]
[ApprovalTests.Namers.UseApprovalSubdirectory("resources/approvaltests")]
public class GameTest
{
    [Fact]
    public void triviaGameForDataSetOne() {
        ApprovalGame.Create(5).RunTestScenario();
    }

    [Fact]
    public void TriviaGameForDataSetTwo() {
        ApprovalGame.Create(7).RunTestScenario();
    }

    [Fact]
    public void TriviaGameForDataSetThree() {
        ApprovalGame.Create(13).RunTestScenario();
    }

    [Fact]
    public void TriviaGameForDataSetFour() {
        ApprovalGame.Create(17).RunTestScenario();
    }

    [Fact]
    public void TriviaGameForDatSetFive() {
        ApprovalGame.Create(93).RunTestScenario();
    }
}