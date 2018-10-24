package Game;

public class Bank extends Player {
    int id;
    String name;
    int totalTour=0;
    int position=0;
    int money=0;
    boolean inGame=false;
    boolean isBank=false;
    private final int initialBankMoney = 100000000;
    Bank(int id,String name,boolean isBank){
        super(id,name);//Our player is will created in here
        this.id=id;
        this.name=name;
        this.isBank=isBank;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void payMoney(Player player,int money){
        player.addMoney(money);
    }
}
