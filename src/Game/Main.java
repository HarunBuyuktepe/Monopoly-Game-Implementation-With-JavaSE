package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.print("Player Number(2-6): ");
        int playerNum = input.nextInt();

        while(playerNum < 2 || playerNum > 6){

            System.out.print("Please Enter Number of Player Between (2-6) : ");
            playerNum = input.nextInt();
        }

        System.out.println();

        ArrayList<Player> players = new ArrayList<Player>();
        int i = 1;

        while (i <= playerNum){

            String num = Integer.toString(i);
            System.out.println("Player" + i + " is Created ..");
            Player pl = new Player(i , num);
            pl.setPosition(0);
            pl.addMoney(150000);
            i++;
            players.add(pl);
        }

        System.out.println("\nPlayers are Ready To Play Game ..");
        Board b = new Board();
        System.out.println("Board is Ready To Play Game ..");
        System.out.print("\nIteration Number: ");
        int iteNum = input.nextInt();

        System.out.println();

        ArrayList<MapBox> ourMap = b.getMap();

        int doubleDices = 0;
        int numberOfIteration = 1;
        int position = 0;

        while(players.size()!=1 && numberOfIteration <= iteNum){    //oyuncu bire eşit olmadığı && itarsayon
            //tek tek
            int order = 0;

            for(;order < players.size(); order++)
            {

                Player currentPl = players.get(order);
                if (currentPl.inGame() == false)
                {
                    players.remove(order);
                    break;
                }
                int dice1 = currentPl.tossDie();
                int dice2 = currentPl.tossDie();
                int totalMove = dice1 + dice2;

                if(dice1 == dice2)
                {
                    doubleDices++;

                    if(doubleDices == 3)
                    {
                        System.out.println("Player" + currentPl.getName()+ " Tossed Double Dice -> " + dice1 + " and " +dice2 );
                        System.out.println("------------Player" + currentPl.getName()+ " Tossed  Three Times Double Dice");
                        System.out.println("Position of Player" + currentPl.getName()+ " is Set to Prison");
                        currentPl.setPosition(10);
                        System.out.println("Player" + currentPl.getName() + " is at " + ourMap.get(currentPl.getCurrentPosition()).getName());
                    }
                    else
                    {
                        System.out.println("Player" + currentPl.getName() + " Tossed Dices -> " + dice1 + " and " + dice2 + " ; Sum of Dices = " + totalMove);
                        position = totalMove + currentPl.getCurrentPosition();
                        currentPl.setPosition(position % 40);
                        System.out.println("Player" + currentPl.getName() + " is at " + ourMap.get(currentPl.getCurrentPosition()).getName());
                        System.out.println("Next Turn is Again Player" + currentPl.getName());
                        order--;
                    }

                }
                else {
                    System.out.println("Player" + currentPl.getName() + " Tossed Dices -> " + dice1 + " and " + dice2 + " ; Sum of Dices = " + totalMove);
                    position = totalMove + currentPl.getCurrentPosition();
                    currentPl.setPosition(position % 40);
                    doubleDices = 0;
                    System.out.println("Player" + currentPl.getName() + " is at " + ourMap.get(currentPl.getCurrentPosition()).getName());
                }
                System.out.println("Before Transaction: Player" + currentPl.getName() + " : " + currentPl.getMoney());

                b.getMap().get(currentPl.getCurrentPosition()).doAction(currentPl);

                if(currentPl.getMoney() > 0)
                    System.out.println("After Transaction: Player" + currentPl.getName() + " : " + currentPl.getMoney());
                else
                    System.out.println("Player" + currentPl.getName() + " went bankrupt!");

                currentPl.nextTurn();
                System.out.println("\nNext Turn...\n");
            }

            numberOfIteration++;

        }

    } /* End of Main Method */
}
