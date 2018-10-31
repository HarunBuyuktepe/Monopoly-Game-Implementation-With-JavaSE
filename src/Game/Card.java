package Game;

public class Card extends MapBox{

    String cardName;
    int id;
    public Card(int id,String cardName){
        super.id=id;
        this.cardName=cardName;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
