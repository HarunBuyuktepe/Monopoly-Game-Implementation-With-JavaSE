package Game;

public class StartingPoint extends MapBox {
    private int id;
    private String name;
    StartingPoint(int id,String name){
        this.id=id;
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
        player.addMoney(1000);
    }
}
