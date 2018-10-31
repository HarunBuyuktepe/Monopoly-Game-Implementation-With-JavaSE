package Game;

public class Soot extends MapBox {
    int id;
    String name;
    double price;
    double loan;
    Soot(int id,String name,double price,double loan){
        this.price=price;
        super.id=id;
        this.name=name;
        this.loan=loan;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
