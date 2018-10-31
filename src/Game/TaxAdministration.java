package Game;

public class TaxAdministration extends MapBox{
    String name;
    double tax;

    TaxAdministration(int id,double tax){
        super.id=id;
        this.tax=tax;

    }


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
