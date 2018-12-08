package Monopoly.Player;

public class Money {
    double money;
    public Money(double money){
        this.money=money;
    }
    public double getMoney() {   //To know the Player's money
        return money;
    }

    public void addMoney(Money amount) {   //To add money to the Player at any time
        this.money+=amount.getMoney();
    }

    public void substractMoney(Money amount) {   //To substract money from the Player
        this.money=money-amount.getMoney();
    }
    public void setMoney(double cons){
        money=cons;
    }
}
