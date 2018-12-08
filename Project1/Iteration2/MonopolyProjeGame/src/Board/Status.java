package Monopoly.Board;

import Monopoly.Player.*;

public class Status {
    private int level;
    public Status(){
        level=0;
    }
    public void develop(District dist){
        if(level<6) {
            level++;
        }
        int a = level;
        Money[] rents =dist.getAllRentAmount();
        switch (a){
            case 0:
                rents[0].setMoney(rents[1].getMoney());break;
            case 1:
                rents[0].setMoney(rents[2].getMoney());break;
            case 2:
                rents[0].setMoney(rents[3].getMoney());break;
            case 3:
                rents[0].setMoney(rents[4].getMoney());break;
            case 4:
                rents[0].setMoney(rents[5].getMoney());break;
        }
    }
    public int getLevel(){
        return level;
    }
    public String toString() {
        String toString="";
        switch(level){
            case 0:
                toString+="level 1";
                break;
            case 1:
                toString+="level 2";
                break;
            case 2:
                toString+="level 3";
                break;
            case 3:
                toString+="level 4";
                break;
            case 4:
                toString+="level 5";
                break;
        }
        return toString;
    }
}
