package Game;

public class ChanceCard extends Card {

    private int value=10;
    private int id;

    ChanceCard(int id,String cardName){
        super(id,cardName);
    }

    public void doAction(Player player) {

        System.out.println("Congratulations! You Gain 10.000$ From Lottery");
        player.addMoney(10000);

    }

}
