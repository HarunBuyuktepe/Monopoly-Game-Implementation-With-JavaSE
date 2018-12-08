package Monopoly.Board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    // MARK: Properties
    private String boardName;
    private ArrayList<MapBox> blocks;

    // MARK: Constructors
    public Board() throws IOException {

        blocks = new ArrayList<>();
        getBlockStrings();
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

        File file = new File("dist.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
        {

            if(st != null)
                createBlock(st);

        }

    }

    private void createBlock(String blockString) throws IOException {

        MapBox block = null;
        String[] words = blockString.split(" ");

        int id = Integer.parseInt(words[0]);

        if(words[1].toLowerCase().contains("dist"))
        {
            String name = words[2];
            double priceAmount = Double.parseDouble(words[3]);
            double development = Double.parseDouble(words[4]);
            double rentAmount0 = Double.parseDouble(words[5]);
            double rentAmount1 = Double.parseDouble(words[6]);
            double rentAmount2 = Double.parseDouble(words[7]);
            double rentAmount3 = Double.parseDouble(words[8]);
            double rentAmount4 = Double.parseDouble(words[9]);
            block = new District(id,name,priceAmount,development,rentAmount0,rentAmount1 ,rentAmount2,rentAmount3,rentAmount4,null);
        }

        else if(words[1].toLowerCase().contains("ıncometax"))
        {
            double tax = Double.parseDouble(words[2]);
            block = new IncomeTax(id,tax,"Income Tax");
        }

        else if(words[1].toLowerCase().contains("luxurytax"))
        {
            double tax = Double.parseDouble(words[2]);
            block = new LuxuryTax(id,tax,"Luxury Tax");
        }

        else if(words[1].toLowerCase().contains("prison(visitor)"))
        {
            block = new Prison(id,"Prison Visitor");
        }

        else if(words[1].toLowerCase().contains("freeparking"))
        {
            block = new FreeParking(id,"Free Parking");
        }

        else if(words[1].toLowerCase().contains("goprison"))
        {
            block = new Prison(id,"Go Prison");
        }

        else if(words[1].toLowerCase().contains("chance"))
        {
            block = new ChanceCard(id,"Chance Card");
        }

        else if(words[1].toLowerCase().contains("publicfund"))
        {
            block = new PublicFundCard(id,"Public Fund Card");
        }

        else if(words[1].toLowerCase().contains("startingpoint"))
        {
            block = new StartingPoint(id,"Starting Point");
        }

        else if(words[1].toLowerCase().contains("soot"))
        {
            double price = Double.parseDouble(words[3]);
            double loan = Double.parseDouble(words[4]);
            double rent = Double.parseDouble(words[5]);
            block = new Soot(id,words[2],price,loan,rent, null);
        }

        blocks.add(block);
    }

    public ArrayList <MapBox> getMap()
    {
        return blocks;
    }
}