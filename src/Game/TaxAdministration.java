package anan;

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
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
