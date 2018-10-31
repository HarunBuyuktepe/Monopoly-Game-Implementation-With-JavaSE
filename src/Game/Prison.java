package Game;

public class Prison extends MapBox {
    int id;
    Prison(int id){
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
