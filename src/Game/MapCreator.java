package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapCreator {

    ArrayList<MapBox> map;


    MapCreator() throws IOException {

    }
    public void create( ArrayList<MapBox> map) throws IOException {
        int i=0;
        try(BufferedReader br = new BufferedReader(new FileReader("C://dists.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                i++;
                District newDistrict=new District(line,1000,10000,null,i);
                map.add(newDistrict);
            }
            // line is not visible here.
        }



    }
}
