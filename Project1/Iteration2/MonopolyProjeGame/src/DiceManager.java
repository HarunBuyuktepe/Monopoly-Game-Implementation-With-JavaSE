package Monopoly;

import Monopoly.Board.*;
import Monopoly.Player.*;

import java.util.ArrayList;

public class DiceManager {

    void doThat(Player currentPl,Board b,int doubleDices,boolean doubleDiceCheckNextTurn,int position, PlayerManager playerManager, ArrayList<Player> players){
        int order = 0;
        int dice1 = currentPl.tossDie();   // First Dice
        int dice2 = currentPl.tossDie();   // Second Dice
        int totalMove = dice1 + dice2;     // First + Second Dice

        if(dice1 == dice2)    /* If Dices are Equal */
        {
            doubleDices++;

            if(doubleDices == 3)    /* If The Player Tossed Double Dice at 3 Times(Then Go To Jail) */
            {
                System.out.println("\n" + currentPl.getName()+ " Tossed Double Dice -> " + dice1 + " & " +dice2 );
                System.out.println(currentPl.getName()+ " Tossed  Three Times Double Dice");
                //System.out.println(currentPl.getName()+ " is Set to Prison");
                currentPl.setPosition(30);
                System.out.println(currentPl.getName() + " is at " + b.getMap().get(30).getName());
                doubleDiceCheckNextTurn = false;
            }

            else    /* If The Player Tossed Double Dice 1 or 2 Times */
            {
                System.out.println("\n" + currentPl.getName() + " Tossed Double Dices -> " + dice1 + " & " + dice2 + "; Sum of Dices: " + totalMove);
                position = totalMove + currentPl.getCurrentPosition();  // New Position of The Player
                currentPl.setPosition(position % 40);   // Put The Player in The New Position
                System.out.println(currentPl.getName() + " is at " + b.getMap().get(currentPl.getCurrentPosition()).getName());     // Print New Position

                if (currentPl.getCurrentPosition() != 30)
                {
                    System.out.println("Next Turn is Again " + currentPl.getName());
                    doubleDiceCheckNextTurn = true;
                }
                else
                    doubleDiceCheckNextTurn = false;
            }
        }

        else     /* If Dices are not Equal */
        {
            System.out.println("\n" + currentPl.getName() + " Tossed Dices -> " + dice1 + " & " + dice2 + "; Sum of Dices: " + totalMove);
            position = totalMove + currentPl.getCurrentPosition();      // New Position of The Player
            currentPl.setPosition(position % 40);       // Put The Player in The New Position
            doubleDices = 0;
            System.out.println(currentPl.getName() + " is at " + b.getMap().get(currentPl.getCurrentPosition()).getName());     // Print New Position
            doubleDiceCheckNextTurn = false;

        }

        if(doubleDiceCheckNextTurn) {
            System.out.println("\n(Before Transaction) " + currentPl.getName() + " : " + (int)(currentPl.getMoney().getMoney()) + " ₺\n");


            b.getMap().get(currentPl.getCurrentPosition()).doAction(currentPl);

            System.out.println("\n(After Transaction) " + currentPl.getName() + " : " + (int)(currentPl.getMoney().getMoney()) + " ₺\n");

            if (b.getMap().get(currentPl.getCurrentPosition()).getName().equals("Chance Card") ||
                    b.getMap().get(currentPl.getCurrentPosition()).getName().equals("Public Fund Card"))
            {
                for (int i = 0; i < players.size(); i++)
                {
                    if( players.get(i).getId() != currentPl.getId())
                    {
                        if (players.get(i).getMoney().getMoney()<0)     /* If The Player Go Bankrupt(Then Remove From The Monopoly) */
                        {
                            playerManager.playerHasNoMoney(players.get(i),b);


                            if(playerManager.alreadyHasNoMoney(players.get(i))){ /*If player has already debt,Game remove all record of player.*/
                                System.out.println(players.get(i).getName() + " was bankrupt so out of game with debt " +players.get(i).getMoney().getMoney()+" ₺");
                                players.remove(i);
                                    /*System.out.println("\nNext Turn...\n\n");
                                    break;*/
                            }

                        }
                    }

                }
            }
            for(int i = 0; i < players.size(); i++)
            {
                if (players.get(i).getId() == currentPl.getId())
                    order = i;
            }

            if (currentPl.getMoney().getMoney()<0)     /* If The Player Go Bankrupt(Then Remove From The Monopoly) */
            {
                playerManager.playerHasNoMoney(currentPl,b);

                if(playerManager.alreadyHasNoMoney(currentPl)){ /*If player has already debt,Game remove all record of player.*/
                    System.out.println(currentPl.getName() + " was bankrupt so out of game with debt "+currentPl.getMoney().getMoney()+" ₺");
                    players.remove(order);
                    //System.out.println("\nNext Turn...\n\n");
                    //break;
                }

            }

            if (currentPl.inGame())
                doThat(currentPl, b, doubleDices, doubleDiceCheckNextTurn, position, playerManager, players);
        }

    }
}
