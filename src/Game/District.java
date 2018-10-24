package Game;

import java.util.ArrayList;

public class District extends MapBox {
    int id;
    int firstDevelopmentPrice=10;
    int secondDevelopmentPrice=10;
    int thirdDevelopmentPrice=10;
    int fourthDevelopmentPrice=10;
    int lastDevelopmentPrice=10;


    String name="";
    int loan=500;
    int price=1000;
    Player owner=null;


    District(String name,int loan,int price,Player owner){
        super(name, loan, price, owner);

    }
    District(String name,int loan,int price,Player owner,int id){
        super(name, loan, price, owner);
        this.id=id;
    }
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
