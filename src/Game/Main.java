package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		//
		try {
			Board a=new Board();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Player pl=new Player(18,"harun");
		MapBox st=new StartingPoint("Start",0,0,pl);
		st.doAction(pl);
		System.out.println(pl.getMoney());
		System.out.println(st.getName());*/


	}
}
