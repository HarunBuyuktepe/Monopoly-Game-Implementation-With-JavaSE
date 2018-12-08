package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.*;

public class StartingPoint extends MapBox {

    private int id;
    private String name;
    private Money money=new Money(20000);
    StartingPoint(int id,String name){

        this.id=id;
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void doAction(Player player) {
        Main.HEA_Bank.payMoney(player,money);
        System.out.println(player.getName() + " passed the starting point. Player gained 20.000₺ ");
    }
}