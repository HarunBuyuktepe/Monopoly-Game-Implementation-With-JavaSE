package Monopoly.Board;

import Monopoly.Player.*;


public abstract class MapBox { //This class will provide to abstract squares of game

    String name;
    int id;
    private Player owner;
    public MapBox(){}


    public abstract String getName() ;
    public abstract int getId();


    public void setName(String name) {

        this.name = name;
    }

    public abstract void doAction(Player player); /*abstract operation of the class ; Different classes which are
                                                    extended this class have different implementation.*/
    public void setOwner(Player newOwner){
        owner=newOwner;
    }
    public String getOwner(){
        return "";
    }
    public Money getHalfPriceAmount(){return null;}
}