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

        super.id=id;
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
