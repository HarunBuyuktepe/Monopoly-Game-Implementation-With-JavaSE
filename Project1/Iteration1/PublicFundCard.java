package Game;

public class PublicFundCard extends Card {

    private int id;
    private String cardName;

    PublicFundCard(int id,String cardName){
        super(id , cardName);
    }


    public void doAction(Player player) {

        System.out.println("You Sold Your Sport Car! Take 15.000$ From The Bank");
        player.addMoney(15000);

    }

}