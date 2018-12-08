package Monopoly.UnitTests;


import Monopoly.Player.Money;
import Monopoly.Player.Player;
import org.junit.Assert;
import org.junit.Test;



public class StartingPointTest {

    public Player a=new Player();
    private Money tax=new Money(20000);
    @Test
    public void doAction() {
        double PlayerMoney=a.getMoney().getMoney();
        double Tax=tax.getMoney();
        Assert.assertEquals(PlayerMoney+Tax,a.getMoney().getMoney()+tax.getMoney(),1);
    }
}
