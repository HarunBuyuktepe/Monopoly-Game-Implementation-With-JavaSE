package MonopolyGame;

public class FreeParking extends MapBox {
    private int id;
    private String name;
    FreeParking(int id,String name){
        this.id=id;
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
