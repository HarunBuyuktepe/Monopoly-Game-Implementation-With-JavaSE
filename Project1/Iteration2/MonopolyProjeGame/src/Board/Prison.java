package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.*;

import java.util.Random;


public class Prison extends MapBox {

    private int id;
    private String name;
    private Money penance = new Money(50000);

    Prison(int id,String name){

        this.id = id;
        this.name = name;
    }
    @Override
    public String getName() {

        return name;
    }
    @Override
    public int getId() {

        return id;
    }
    @Override
    public void doAction(Player player)
    {
        Random r = new Random();

        if (getName().equals("Go Prison")) // GoPrison
        {
            player.setPosition(10);
            player.setInPrison(true);
            player.setInPrisonTime(1);
            System.out.println(player.getName() + " is set to Prison!");
        }
        else // PRISON(Visitor)
        {
            if (player.isInPrison())
            {
                if (player.getInPrisonTime() == 4)
                {
                    System.out.println(player.getName() + " can now leave from Prison.");
                    player.setInPrison(false);
                    player.setInPrisonTime(0);
                }
                else
                {
                    System.out.println(player.getName() + " is in Prison for the " + player.getInPrisonTime() + ". time/s.\n");

                    if (player.isHasPrisonExitCard())
                    {
                        player.setInPrisonTime(0);
                        player.setInPrison(false);
                        player.setHasPrisonExitCard(false);
                        System.out.println(player.getName() + " has 'Prison Exit Card'.");
                        System.out.println(player.getName() + " can leave from Prison.");
                    }
                    else
                    {
                        int decisionOfPlayer = r.nextInt(2);

                        if (decisionOfPlayer == 1 && player.getMoney().getMoney() > penance.getMoney())
                        {
                            Main.HEA_Bank.takeMoney(player,penance);
                            player.setInPrisonTime(0);
                            player.setInPrison(false);
                            System.out.println(player.getName() + " Payed " + (int)(penance.getMoney()) + " ₺ penance to exit from Prison.");
                            System.out.println(player.getName() + " can leave from Prison.");

                        }
                        else
                        {
                            int dice1 = player.tossDie();
                            int dice2 = player.tossDie();

                            if (dice1 == dice2)
                            {
                                player.setInPrisonTime(0);
                                player.setInPrison(false);
                                System.out.println(player.getName() + " Tossed Double Dice : " + dice1 + " & " + dice2);
                                System.out.println(player.getName() + " can leave from Prison.");
                            }
                            else
                            {
                                System.out.println(player.getName() + " Tossed Dice : " + dice1 + " & " + dice2);
                                player.setInPrisonTime(player.getInPrisonTime()+1);
                                player.setInPrison(true);
                                System.out.println(player.getName() + " is still in Prison");

                            }
                        }
                    }
                }

            }
            else
                System.out.println(player.getName() + " is in the Prison as a 'Visitor'.");

        }
    }
}
