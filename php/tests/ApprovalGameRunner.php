<?php

//include __DIR__ . '/Game.php';


class ApprovalGameRunner
{
    private StringPresenter $bufferPresenter;
    private Dice $tenDice;
    private Dice $sixDice;

    public function __construct()
    {
        $this->bufferPresenter = new StringPresenter();
        $this->tenDice = new Dice(10);
        $this->sixDice = new Dice(6);
    }

    function runTestScenario($randomSeed)
    {
        srand($randomSeed);

        $notAWinner = true;
        $aGame = $this->createGame();

        do {
            $aGame->roll($this->sixDice->roll());
            if ($this->tenDice->roll() == 7) {
                $notAWinner = $aGame->wrongAnswer();
            } else {
                $notAWinner = $aGame->wasCorrectlyAnswered();
            }
        } while ($notAWinner);
    }

    public function getOutputData()
    {
        return $this->bufferPresenter->data;
    }

    public function createGame(): Game
    {
        $aGame = new Game($this->bufferPresenter);
        $aGame->add("Chet");
        $aGame->add("Pat");
        $aGame->add("Sue");
        $aGame->add("TripleD");
        return $aGame;
    }
}

class Dice
{
    private int $diceSize = 0;

    public function __construct(int $diceSize)
    {
        if ($diceSize < 1) throw new RuntimeException("A dice must be larger than one");
        $this->diceSize = $diceSize;
    }

    public function roll(): int
    {
        return rand(0, $this->diceSize) + 1;
    }
}

