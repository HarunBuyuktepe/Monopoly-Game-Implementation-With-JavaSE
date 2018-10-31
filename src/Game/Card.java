package Game;

public class Card extends MapBox{

    String cardName;
    int id;
    public Card(int id,String cardName){
        this.id=id;
        this.cardName=cardName;
    }

    @Override
    public String getName() {
        return cardName;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void doAction(Player player) {

    }
}
