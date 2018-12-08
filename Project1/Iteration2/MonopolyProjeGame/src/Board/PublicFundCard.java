package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PublicFundCard extends Card {

    private int id;
    private String cardName;
    private Money value;
    private ArrayList<String[]> cards = new ArrayList<>();

    PublicFundCard(int id,String cardName) throws IOException
    {
        super(id , cardName);
        getCardsStrings();
    }
    private void getCardsStrings() throws IOException {
        File file = new File("PublicFundCard.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while((st = br.readLine()) != null)
        {
            if(st != null)
                createPublicFundCards(st);
        }
    }
    private void createPublicFundCards(String cardString) {
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
        int cardID = card.nextInt(13) ;

        return cardID;
    }

    public void doAction(Player player)
    {
        int chosenCard = chooseCard();
        System.out.println(cards.get(chosenCard)[2]);
        value = new Money(Double.parseDouble(cards.get(chosenCard)[3]));

        switch (chosenCard){
            case 0: case 1: case 2:
            case 4: case 5: case 7:
            case 10: case 12:  // BANKADAN PARA ALMA KARTLARI
                    Main.HEA_Bank.payMoney(player,value);
                    System.out.println(player.getName() + " Earned : " + (int)(value.getMoney()) + " ₺");
                break;
            case 3: //KODESTEN ÇIKMA KARTI
                    player.setHasPrisonExitCard(true); // PLAYERDA KODESTEN ÇIKMA KARTI METODU EKLEDIM
                break;
            case 6: // BASLANGIC NOKTASINA ILERLE, doAction
                    player.setPosition(0);
                    System.out.println(player.getName() + " is now at " + Main.boardForCards.get(player.getCurrentPosition()).getName());
                    Main.boardForCards.get(player.getCurrentPosition()).doAction(player);
                break;
            case 8: // 5 HANE ILERLE,BAHSIS ODE, doAction
                    Main.HEA_Bank.takeMoney(player,value);
                    System.out.println(player.getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To Bank");

                    player.setPosition((player.getCurrentPosition()+5) % 40);
                    System.out.println(player.getName() + " is now at " + Main.boardForCards.get(player.getCurrentPosition()).getName());
                    Main.boardForCards.get(player.getCurrentPosition()).doAction(player);

                break;
            case 9: // ISTEDIGIN HANEYE ILERLE
                    Random distNums = new Random();
                    int goSquare = distNums.nextInt(40);
                    int playerNewPosition = (player.getCurrentPosition() + goSquare) % 40;

                    if (playerNewPosition == 10 || playerNewPosition == 30)
                        playerNewPosition++;

              /*  (playerNewPosition == 10 || playerNewPosition == 30)||(Main.boardForCards.get(playerNewPosition).getOwner() != null)
                        || (Main.boardForCards.get(playerNewPosition).getOwner() != "") ||(Main.boardForCards.get(playerNewPosition).getOwner() != player.getName()) */
                    
                    player.setPosition(playerNewPosition);
                    System.out.println(player.getName() + " is now at " + Main.boardForCards.get(playerNewPosition).getName());
                    Main.boardForCards.get(player.getCurrentPosition()).doAction(player);
                break;

            case 11:  // BANKAYA PARA ODEME KARTI
                    Main.HEA_Bank.takeMoney(player,value);
                    System.out.println(player.getName() + " Payed : " + (int)(value.getMoney()) + " ₺ To Bank");
                break;
        }
    }

}