package Game;

public class Card {

    int value=0;
    int id;
    public Card(int value,int id){
        this.id=id;
        this.value=value;
    }
    public void getCard(Player player,int value){
        if(value<0){
            player.substractMoney(value);
        }
        else{
            player.addMoney(value);
        }
    }
}
