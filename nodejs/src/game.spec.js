require('approvals').mocha();

const seedrandom = require('seedrandom');
const Game = require('./game.js');

class BufferedPresenter {
  constructor() {
    this._messages = [];
  }

  get bufferedMessages() {
    return [...this._messages];
  }

  present(message) {
    this._messages.push(message);
  }
}

class Dice {
  constructor(sides, rng) {
    this._sides = sides;
    this._rng = rng;
  }

  roll() {
    return Math.floor(this._rng() * this._sides) + 1;
  }
}

class ApprovalGameRunner {
  constructor(randomSeed) {
    this._presenter = new BufferedPresenter();

    const rng = seedrandom(randomSeed);
    this._d6 = new Dice(6, rng);
    this._d10 = new Dice(10, rng);
  }

  runTestScenario() {
    const game = this._buildGame();
    this._playGame(game);
    return this._presenter.bufferedMessages.join('\n');
  }

  _playGame(game) {
    do {
      game.roll(this._d6.roll());
    } while (this._decideAnswer(game));
  }

  _decideAnswer(game) {
    if (this._answersWrong()) {
      return game.wrongAnswer();
    }

    return game.wasCorrectlyAnswered();
  }

  _answersWrong() {
    return this._d10.roll() === 8;
  }

  _buildGame() {
    const game = new Game(this._presenter);

    game.add('Jan');
    game.add('Piet');
    game.add('Joris');
    game.add('Korneel');

    return game;
  }
}

function verifyTestScenario(context, randomSeed) {
  context.verify(runTestScenario(randomSeed), { reporters: ["gitdiff"] });
}

function runTestScenario(randomSeed) {
  const gameRunner = new ApprovalGameRunner(randomSeed);
  return gameRunner.runTestScenario();
}

describe('Game scenario', function () {
  it('should match approval data set 1', function () {
    verifyTestScenario(this, 7);
  });

  it('should match approval data set 2', function () {
    verifyTestScenario(this, 35);
  });

  it('should match approval data set 3', function () {
    verifyTestScenario(this, 42);
  });

  it('should match approval data set 4', function () {
    verifyTestScenario(this, 1337);
  });

  it('should match approval data set 5', function () {
    verifyTestScenario(this, 22);
  });
});
