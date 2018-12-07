package Game;

public class LuxuryTax extends TaxAdministration {

    LuxuryTax(int id, double tax, String name) {

        super(id , tax , name);

    }

    @Override
    public void doAction(Player player) {

        System.out.println("Luxury Tax. You Should Pay 10.000$");
        player.substractMoney(10000);

    }

}