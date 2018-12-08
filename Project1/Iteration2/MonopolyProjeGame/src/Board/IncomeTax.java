package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.Money;
import Monopoly.Player.Player;

public class IncomeTax extends TaxAdministration {
    private Money tax=new Money(30000);
    IncomeTax(int id, double tax, String name) {
        super(id , tax , name);
    }

    @Override
    public void doAction(Player player) {

        System.out.println("Income Tax. You Should Pay "+ (int)tax.getMoney() +" ₺");
        Main.HEA_Bank.takeMoney(player,new Money(tax.getMoney()));
    }

}