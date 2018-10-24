package Game;

public class TaxAdministration extends MapBox{
    String name;
    int loan;
    int price;
    Player owner;
    TaxAdministration(String name,int loan,int price,Player owner){
        super(name, loan, price, owner);

    }

    public TaxAdministration() {
    }

    @Override
    public void doAction(Player player) {

    }
}
