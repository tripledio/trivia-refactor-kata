namespace Tests;

public class Dice
{
    private readonly int _diceSize;
    private readonly Random _randomGenerator;

    public Dice(int diceSize, int randomSeed) {
        if (diceSize < 1) throw new Exception("A dice must be larger than one");
        if (randomSeed < 0) throw new Exception("The random seed must be larger than zero");
        this._diceSize = diceSize;
        _randomGenerator = new Random(randomSeed);

    }

    public int Roll() {
        return _randomGenerator.Next(_diceSize) + 1;
    }
}