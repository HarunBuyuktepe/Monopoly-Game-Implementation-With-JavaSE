package Game;

public class StartingPoint extends MapBox {
    int id;
    StartingPoint(int id){
        super.id=id;

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {
        player.addMoney(1000);
    }
}
