package design.lowleveldesign.snakenladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min=1;
    int max=6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceRoll=0;

        while (diceRoll<diceCount){
            totalSum+= ThreadLocalRandom.current().nextInt(min,max);
            diceRoll++;
        }
        return totalSum;
    }
}
