package Game;

public class StartingPoint extends MapBox {
    String name;
    int loan;
    int price;
    Player owner;
    StartingPoint(String name,int loan,int price,Player owner){
        super(name, loan, price, owner);

    }

    @Override
    public void doAction(Player player) {
        player.addMoney(1000);
    }
}
