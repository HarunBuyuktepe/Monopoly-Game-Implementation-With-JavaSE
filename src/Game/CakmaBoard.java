package Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CakmaBoard {

    // MARK: Properties

    private String boardName;
    private ArrayList<MapBox> blocks;

    // MARK: Constructors

    public CakmaBoard() throws IOException {

        blocks = new ArrayList<MapBox>();
        blocks.add(new MapBox() {
            @Override
            public int getId() {
                return 0;
            }

            public void doAction(Player player) {

            }
        });

        getBlockStrings();


        System.out.println("There are/is " + blocks.size() + " block determined.");
        for(int i=0;i<blocks.size();i++){
            //System.out.println(i+""+blocks.get(i).getId());
        }
    }

    // MARK: Encapsulation

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBlocks(ArrayList<MapBox> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<MapBox> getBlocks() {
        return blocks;
    }

    // MARK: Utilities
    private void getBlockStrings() throws IOException {
        File file = new File("C:\\dist.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            //System.out.println(st);
            if(st!=null){
                createBlock(st);
            }
        }


    }

    private void createBlock(String blockString) {

        MapBox block = null;
        String[] words = blockString.split(" ");
        int id=Integer.parseInt(words[0]);
        if(words[1].toLowerCase().contains("dist")) {
            String name = words[2];
            double priceAmount = Double.parseDouble(words[3]);
            double development = Double.parseDouble(words[4]);
            double rentAmount0 = Double.parseDouble(words[5]);
            double rentAmount1 = Double.parseDouble(words[6]);
            double rentAmount2 = Double.parseDouble(words[7]);
            double rentAmount3 = Double.parseDouble(words[8]);
            double rentAmount4 = Double.parseDouble(words[9]);
            //Deed deed = new Deed(moneyPrice, moneyRent0, moneyRent1, moneyRent2, moneyRent3, moneyRent4);
            block = new District(id,name,priceAmount,development,rentAmount0,rentAmount1 ,rentAmount2,rentAmount3,rentAmount4,null);

        } else if(words[1].toLowerCase().contains("incometax")) {
            double tax = Double.parseDouble(words[2]);
            block = new IncomeTax(id,tax);
        } else if(words[1].toLowerCase().contains("luxurytax")) {
            double tax = Double.parseDouble(words[2]);
            block = new LuxuryTax(id,tax);
        } else if(words[1].toLowerCase().contains("Prison(Visitor)")) {
            block = new Prison(id);
        }  else if(words[1].toLowerCase().contains("freeparking")) {
            block = new FreeParking(id);
        } else if(words[1].toLowerCase().contains("Prison")) {
            block = new Prison(id);
        } else if(words[1].toLowerCase().contains("Chance")) {
            block = new Card(id,"Chance");
        } else if(words[1].toLowerCase().contains("PublicFund")) {
            block = new Card(id,"PublicFund");
        } else if(words[1].toLowerCase().contains("StartingPoint")) {
            block = new StartingPoint(id);
        } else if(words[1].toLowerCase().contains("soot")) {
            double price = Double.parseDouble(words[3]);
            double loan = Double.parseDouble(words[4]);
            block = new Soot(id,words[2],price,loan);
        }

        System.out.println(id);
        blocks.add(block);
        System.out.println(id);
    }
}
