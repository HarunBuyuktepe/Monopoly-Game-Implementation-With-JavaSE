package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.Money;
import Monopoly.Player.Player;

public class Soot extends MapBox {

    private int id;
    private String name;
    private Money price;
    private Money loan;
    private Money rent;
    private Player owner;

    Soot(int id, String name, double price, double loan, double rent, Player owner)
    {
        this.id = id;
        this.name = name;
        this.price = new Money(price);
        this.loan = new Money(loan);
        this.rent = new Money(rent);
        this.owner = owner;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getId()
    {
        return id;
    }

    public void setOwner(Player player){
        owner=player;
    }
    public Money getHalfPriceAmount(){
        return new Money(price.getMoney()/2);
    }

    public void setId()
    {
        this.id = id;
    }

    @Override
    public void doAction(Player player)
    {
        int r = 0;

        if(owner == null)    /* If Specified Soot Has no Owner */
        {

            r = (int)(Math.random() * 2);

            if(player.getMoney().getMoney() > price.getMoney() && r > 0)    /* If The Player Wants To Buy This Soot */
            {
                Main.HEA_Bank.takeMoney(player , price);
                owner = player;
                Soot deed = new Soot(this.id, this.name, this.price.getMoney(), this.loan.getMoney(), this.rent.getMoney(), player);
                owner.addDeed(deed);
                System.out.println(player.getName() + " Bought " + getName() + " : " + (int)(price.getMoney()) + " ₺");
            }

            else    /* If The Player Doesn't Want To Buy This Soot(Then Pay Rent)  */
            {
                Main.HEA_Bank.takeMoney(player , loan);
                System.out.println(player.getName() + " Pay : " + (int)(loan.getMoney()) + " ₺ (Rent For Visiting)");
            }

        }

        else     /* If Specified Soot Has Owner */
        {

            if(owner.equals(player))
            {
                System.out.println("This is Your Own Soot!!");
            }

            else   /* If The Player Come To Another Player's Soot(Then Pay Rent) */
            {
                Main.HEA_Bank.takeMoney(player , rent);
                Main.HEA_Bank.payMoney(owner , rent);
                System.out.println(player.getName() + " Payed : " + (int)(rent.getMoney()) + " ₺ To " + owner.getName() + " (For Rent)");
            }

        }


    }   /* End of doAction Method */
}