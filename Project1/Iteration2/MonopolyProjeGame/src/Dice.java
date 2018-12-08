package Monopoly;

import java.util.Random;

public class Dice {
    public Dice (){

    }
    public int tossDie(){//Toss the die for the Player
        Random die = new Random();
        int face = 1 + die.nextInt(6);
        return face;
    }
}
