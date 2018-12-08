package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ChanceCard extends Card {

    private int id;
    private String cardName;
    private Money value;
    private ArrayList<String[]> cards = new ArrayList<>();

    ChanceCard(int id,String cardName) throws IOException{
        super(id,cardName);
        getCardsStrings();
    }

    private void getCardsStrings() throws IOException {
        File file = new File("ChanceCard.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while((st = br.readLine()) != null)
        {
            if(st != null)
                createChanceCards(st);
        }
    }

    private void createChanceCards(String cardString) {
        String [] splitted = cardString.split("['']+");
        String [] temp = splitted[0].split(" ");
        String [] words = new String[4];
        words[0] = temp[0];
        words[1] = temp[1];
        words[2] = splitted[1];
        words[3] = splitted[2];
        cards.add(words);

    }

    private int chooseCard() {
        Random card = new Random();
        int cardID = card.nextInt(14) ;

        return cardID;
    }

    public void doAction(Player player)
    {
        int chosenCard = chooseCard();
        System.out.println(cards.get(chosenCard)[2]);
        value = new Money(Double.parseDouble(cards.get(chosenCard)[3]));
        Money totalValue = new Money(Double.parseDouble(cards.get(chosenCard)[3]) * (Main.playersForCards.size()-1));
        String PorB = cards.get(chosenCard)[1];

        switch (PorB){
            case "P" : // PLAYER
                    switch (chosenCard){
                        case 0: case 5: // HER OYUNCUYA ÖDEME
                                Main.HEA_Bank.takeMoney(player,totalValue);

                                for (int i = 0; i < Main.playersForCards.size() ; i++) {
                                    if (player.getId() != Main.playersForCards.get(i).getId()){
                                        Main.HEA_Bank.payMoney(Main.playersForCards.get(i),value);
                                        System.out.println(player.getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To " + Main.playersForCards.get(i).getName());
                                    }
                                }
                            break;
                        case 1: case 2: // HER OYUNCUDAN ALMA
                                for (int i = 0; i < Main.playersForCards.size() ; i++) {
                                    if (player.getId() != Main.playersForCards.get(i).getId()){
                                        Main.HEA_Bank.takeMoney(Main.playersForCards.get(i),value);
                                        System.out.println(Main.playersForCards.get(i).getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To " + player.getName());
                                    }
                                }
                                Main.HEA_Bank.payMoney(player,totalValue);
                            break;
                        case 3: case 4: // RANDOM OYUNCUYA ÖDEME
                                Random playerNums = new Random();
                                int rndmPlayer = playerNums.nextInt(Main.playersForCards.size());
                                Main.HEA_Bank.takeMoney(player,value);

                                if (player.getId() == Main.playersForCards.get(rndmPlayer).getId()){
                                    if (rndmPlayer != 0)
                                        rndmPlayer--;
                                    else
                                        rndmPlayer++;

                                }
                                Main.HEA_Bank.payMoney(Main.playersForCards.get(rndmPlayer),value);
                                System.out.println(player.getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To " + Main.playersForCards.get(rndmPlayer).getName());

                            break;
                    }

                break;
            case "B" : // BANK
                    switch (chosenCard){
                        case 6 : // KODESE GİR KARTI
                            player.setPosition(30);
                            player.setInPrison(true);
                            Main.boardForCards.get(player.getCurrentPosition()).doAction(player);

                            break;
                        case 7: // BANKAYA PARA ÖDEME
                                Main.HEA_Bank.takeMoney(player,value);
                                System.out.println(player.getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To Bank");
                            break;
                        case 8: case 9: case 10:
                        case 11: case 12: case 13: // BANKADAN PARA KAZANMAK İÇİN ZAR ATMA
                                int dice1 = player.tossDie();
                                int dice2 = player.tossDie();
                                int totalDice = dice1 + dice2;

                                System.out.println(player.getName() + " Tossed Dice : " + dice1 + " & " +dice2);

                                if ((dice1 == dice2) || (totalDice >=8 && totalDice <=12)){
                                    Main.HEA_Bank.payMoney(player,value);
                                    System.out.println(player.getName() + " Tossed Double Dice or Total Dice is between 8 and 12 ");
                                    System.out.println(player.getName() + " Earned : " + (int)(value.getMoney()) + " ₺");
                                }
                                else
                                    System.out.println(player.getName() + " did not earn money from bank.");

                            break;
                    }
                break;
        }

    }

}
