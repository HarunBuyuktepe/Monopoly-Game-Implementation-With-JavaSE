package Game;

public class TaxAdministration extends MapBox {
    private String name;
    private  double tax;
    private int id;
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
        return id;
    }

    @Override
    public void doAction(Player player) {

    }
}
