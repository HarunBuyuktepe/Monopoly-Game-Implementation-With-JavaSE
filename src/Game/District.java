package Game;

import java.util.ArrayList;

public class District extends MapBox {
    int id;
    double priceAmount;
    double development;
    double rentAmount0;
    double rentAmount1;
    double rentAmount2;
    double rentAmount3;
    double rentAmount4;
    Player owner=null;
    String name;





    District(int id,String name,double priceAmount,double development,double rentAmount0, double rentAmount1, double rentAmount2, double rentAmount3, double rentAmount4,Player owner){
        this.id=id;
        this.name=name;
        this.priceAmount=priceAmount;
        this.development=development;
        this.rentAmount0=rentAmount0;
        this.rentAmount1=rentAmount1;
        this.rentAmount2=rentAmount2;
        this.rentAmount3=rentAmount3;
        this.rentAmount4=rentAmount4;
        this.owner=owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void doAction(Player player) {

    }

}
