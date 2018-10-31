package Game;

public class FreeParking extends MapBox {
    int id;
    FreeParking(int id){
        super.id=id;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
