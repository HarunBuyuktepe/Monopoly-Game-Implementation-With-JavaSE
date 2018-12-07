package Game;

public class Bank extends Player {

    private int id;
    private String name;
    private int totalTour=0;
    private int position=0;
    private int money=0;
    private boolean inGame=false;
    private boolean isBank=false;
    private final int initialBankMoney = 100000000;

    Bank(int id,String name,boolean isBank){

        super(id,name);     //Our player is will created in here
        this.id=id;
        this.name=name;
        this.isBank=isBank;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void payMoney(Player player, int money){
        player.addMoney(money);
    }
}
