package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.Money;
import Monopoly.Player.Player;

public class LuxuryTax extends TaxAdministration {

    private Money tax=new Money(50000);
    LuxuryTax(int id, double tax, String name) {
        super(id , tax , name);
    }

    @Override
    public void doAction(Player player) {

        System.out.println("Luxury Tax. You Should Pay "+ (int)tax.getMoney() +" ₺");
        Main.HEA_Bank.takeMoney(player,tax);
    }

}