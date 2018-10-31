package Game;

public class TaxAdministration extends MapBox{
    String name;
    double tax;

    TaxAdministration(int id,double tax,String name){
        this.id=id;
        this.tax=tax;
        this.name=name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
