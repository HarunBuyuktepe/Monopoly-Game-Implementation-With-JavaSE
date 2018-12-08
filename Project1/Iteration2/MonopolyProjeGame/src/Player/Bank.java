package Monopoly.Player;

public class Bank {

    private String name;

    private final Money money=new Money(200000000);

    public Bank(){

    }
    public void payMoney(Player player, Money money){
        player.getMoney().addMoney(money);
        this.money.substractMoney(money);
    }
    public void takeMoney(Player player,Money money){
        player.getMoney().substractMoney(money);
        this.money.addMoney(money);
    }

}
