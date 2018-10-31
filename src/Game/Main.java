package Game;


import java.io.IOException;
import java.util.ArrayList;


public class Main {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CakmaBoard a=new CakmaBoard();
        ArrayList<MapBox> outMap = null;

        ArrayList<MapBox> ourMap = a.getMap();
        for(int i=0; i < ourMap.size();i++)
            System.out.println(ourMap.get(i).getName());
	}
}
