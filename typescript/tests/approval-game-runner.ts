import {Game} from "../src/game";
import Presenter from "../src/presenter";
import seedrandom from "seedrandom";

class BufferedPresenter implements Presenter {
    private messages: string[] = [];

    present(message: string | undefined) {
        this.messages.push(message || "");
    }

    get bufferedMessages() {
        return [...this.messages];
    }
}

class Dice {
    constructor(private rng: any, private sides: number) { }

    roll() {
        const randomNumber = this.rng() as number;
        return Math.floor(randomNumber * this.sides) + 1;
    }
}

export default class ApprovalGameRunner {

    private presenter = new BufferedPresenter();
    private d6: Dice;
    private d10: Dice;

    constructor(randomSeed: number) {
        const rng = seedrandom(randomSeed);

        this.d6 = new Dice(rng, 6);
        this.d10 = new Dice(rng, 10);
    }

    runTestScenario(): string {
        const game = this.buildGame();
        this.playGame(game);
        return this.gatherGameOutput();
    }

    private buildGame(): Game {
        const game = new Game(this.presenter);

        game.add("Jan");
        game.add("Piet");
        game.add("Joris");
        game.add("Korneel");

        return game;
    }

    private playGame(game: Game) {
        do {
            game.roll(this.d6.roll());
        } while (this.decideWinner(game));
    }

    private decideWinner(game: Game): boolean {
        if (this.d10.roll() == 8) {
            return game.wrongAnswer();
        } else {
            return game.wasCorrectlyAnswered();
        }
    }

    private gatherGameOutput(): string {
        return this.presenter.bufferedMessages.join('\n')
    }

}
