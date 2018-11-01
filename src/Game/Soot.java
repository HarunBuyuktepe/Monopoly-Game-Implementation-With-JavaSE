package MonopolyGame;

public class Soot extends MapBox {
    private int id;
    private String name;
    private double price;
    private double loan;
    Soot(int id,String name,double price,double loan){
        this.price=price;
        this.id=id;
        this.name=name;
        this.loan=loan;
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
