package Monopoly;

import Monopoly.Player.*;
import Monopoly.Board.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Bank HEA_Bank=new Bank();
    public static ArrayList<Player> playersForCards;
    public static ArrayList<MapBox> boardForCards;

    public static void main(String[] args) throws IOException {

        Money startingMoney = new Money(150000);      /* Initial Amount of Money(For Each Player) */
        PlayerManager playerManager=new PlayerManager();
        DiceManager diceManager=new DiceManager();
        Scanner input = new Scanner(System.in);

        System.out.print("\nPlayer Number(2-6): ");
        int playerNum=0;
        char CharPlayerNum = input.next().charAt(0);
        while(CharPlayerNum < '2' || CharPlayerNum > '6')       /* Number of Player Should be => 2 and <= 6 */
        {
            System.out.print("Please Enter Number of Player Between (2-6) : ");
            CharPlayerNum = input.next().charAt(0);
        }
        playerNum=CharPlayerNum-48;
        ArrayList <Player> players = new ArrayList<>();

        int i = 1;
        while (i <= playerNum)
        {
            System.out.print("\nEnter " + i + ".Player" + " Name: ");
            String name = input.next();
            System.out.println(i + ".Player is Created ..");
            Player pl = new Player(i , name);
            pl.setPosition(0);
            HEA_Bank.payMoney(pl,startingMoney);
            i++;
            players.add(pl);
        }

        System.out.println("\nPlayers are Ready To Play Monopoly ..");
        Board b = new Board();
        System.out.println("Board is Ready To Play Monopoly ..");

        while((players.size() >= 2 && players.size() <= 6)){    //  While # of Player Proper with Monopoly Rule && Iteration Number

            for(int order = 0; order < players.size(); order++)
            {
                boardForCards = b.getMap();
                playersForCards = players;

                if(players.size() == 0)
                    break;

                Player currentPl = players.get(order);

                if (!currentPl.isInPrison())
                {
                    diceManager.doThat(currentPl,b,0,false,currentPl.getCurrentPosition(), playerManager, players);
                }
                else
                    System.out.println(currentPl.getName() + " is at " + b.getMap().get(currentPl.getCurrentPosition()).getName());

                if (!currentPl.inGame())
                    break;
                else
                {
                    System.out.println("\n(Before Transaction) " + currentPl.getName() + " : " + (int)(currentPl.getMoney().getMoney()) + " ₺\n");

                    b.getMap().get(currentPl.getCurrentPosition()).doAction(currentPl);

                    System.out.println("\n(After Transaction) " + currentPl.getName() + " : " + (int)(currentPl.getMoney().getMoney()) + " ₺\n");

                    if (b.getMap().get(currentPl.getCurrentPosition()).getName().equals("Chance Card") ||
                            b.getMap().get(currentPl.getCurrentPosition()).getName().equals("Public Fund Card"))
                    {
                        for (i = 0; i < players.size(); i++)
                        {
                            if( players.get(i).getId() != currentPl.getId())
                            {
                                if (players.get(i).getMoney().getMoney()<0)     /* If The Player Go Bankrupt(Then Remove From The Monopoly) */
                                {
                                    playerManager.playerHasNoMoney(players.get(i),b);

                                    if(playerManager.alreadyHasNoMoney(players.get(i))){ /*If player has already debt,Game remove all record of player.*/
                                        System.out.println(players.get(i).getName() + " was bankrupt so out of game with debt "+players.get(i).getMoney().getMoney()+" ₺");
                                        players.remove(i);
                                    }

                                }
                            }
                        }
                    }
                    if (currentPl.getMoney().getMoney()<0)     /* If The Player Go Bankrupt(Then Remove From The Monopoly) */
                    {
                        playerManager.playerHasNoMoney(currentPl,b);


                        if(playerManager.alreadyHasNoMoney(currentPl)){ /*If player has already debt,Game remove all record of player.*/
                            System.out.println(currentPl.getName() + " was bankrupt so out of game with debt "+currentPl.getMoney().getMoney()+" ₺");
                            players.remove(order);
                            System.out.println("\nNext Turn...\n\n");
                            break;
                        }

                    }
                    currentPl.nextTurn();
                    System.out.println("\nNext Turn...\n\n");
                }

            }   /* End of for Loop */

        }   /* End of while Loop */

        System.out.println("\n------------------------------------");
        System.out.println("\n\t\t\tGame End");
        System.out.println("\n------------------------------------\n");

        String winnerName = players.get(0).getName();
        double winnerMoney = players.get(0).getMoney().getMoney();

        System.out.println("\n------------------------------------");
        System.out.println("\n Winner : " + winnerName + " -> " +(int)winnerMoney+" ₺");
        System.out.println("\n------------------------------------");

        for (int q=0;q<b.getMap().size();q++) {
            if (b.getMap().get(q).getOwner()!="") {
                System.out.println(b.getMap().get(q).getOwner() + "\t\tis owner of\t\t" + b.getMap().get(q).getName() + " .");
            }
        }

    } /* End of Main Method */

}
