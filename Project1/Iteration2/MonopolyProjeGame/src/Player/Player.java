package Monopoly.Player;

import Monopoly.Board.MapBox;
import Monopoly.Dice;


import java.util.ArrayList;
import java.util.List;


public class Player {
    private ArrayList<MapBox> blocks=new ArrayList<>();
    private int id;
    private String name;
    private int totalTour = 0;
    private Position position = new Position();
    private Money money = new Money(0);
    private boolean inGame = false;
    private Dice die=new Dice();
    private boolean hasPrisonExitCard = false;
    private boolean inPrison = false;
    private int inPrisonTime;

    public Player(int id,String name){   // Our Player Created in here

        this.id=id;
        this.name=name;
    }

    public Player() {
    }

    public int getCurrentPosition() {//To get current position
        return position.getCurrentPosition();
    }

    public void setPosition(int position) {   //Monopoly action
        this.position.setPosition(position);
    }

    public void nextTurn() {     //To update the tour number for the Player
        totalTour++;
    }


    public int tossDie(){//Toss the die for the Player
        int face=die.tossDie();
        return face;
    }

    public Money getMoney() {   //To know the Player's money
        return money;
    }



    /*-------------Money and Winner Control Method-------------*/
    public boolean inGame() {

        if (money.getMoney() < 0){
            setInGame(false);
        }
        else{
            setInGame(true);
        }

        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void addDeed(MapBox deed){
        blocks.add(deed);
    }
    public List<MapBox> getDeed(){
        return blocks;
    }

    public boolean isInPrison() {
        return inPrison;
    }

    public void setInPrison(boolean inPrison) {
        this.inPrison = inPrison;
    }

    public boolean isHasPrisonExitCard() {
        return hasPrisonExitCard;
    }

    public void setHasPrisonExitCard(boolean hasPrisonExitCard) {
        this.hasPrisonExitCard = hasPrisonExitCard;
    }

    public int getInPrisonTime() {
        return inPrisonTime;
    }

    public void setInPrisonTime(int inPrisonTime) {
        this.inPrisonTime = inPrisonTime;
    }
}
