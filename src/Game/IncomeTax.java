package Game;

public class IncomeTax extends TaxAdministration {

    IncomeTax(int id, double tax, String name) {

        super(id , tax , name);
    }

    @Override
    public void doAction(Player player) {

        System.out.println("Income Tax. You Should Pay 20.000$");
        player.substractMoney(20000);

    }

}