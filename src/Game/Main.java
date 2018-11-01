package anan;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter player number between 1-7 : ");
        int playerNum=input.nextInt();
        while(playerNum <= 1 || playerNum>6){
            System.out.println("Please enter player number between 1-7 : ");
            playerNum=input.nextInt();
        }
        ArrayList<Player> players = null;
        int i=1;
        while (i<=playerNum){
            String num=Integer.toString(i);
            System.out.println(i+"Player is created...");
            Player pl=new Player(i,num);
            i++;
        }
        System.out.println("\nPlayers are ready to play game...");
        System.out.println();
        Board a=new Board();
        System.out.println("\nBoard is ready to play game...");
        System.out.println("\nAre you ready?");
        boolean ready=input.nextBoolean();
        ArrayList<MapBox> ourMap = a.getMap();
        //for(int i=0; i < ourMap.size();i++)
            //System.out.println(ourMap.get(i).getName());
	}
}
