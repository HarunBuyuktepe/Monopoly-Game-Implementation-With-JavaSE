package Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private static final ArrayList<MapBox> map =new ArrayList<MapBox>();

    Board() throws IOException {
        MapCreator newMap = new MapCreator();
        newMap.create(map);
        for(int i=0;i<map.size();i++){
            System.out.println(map.get(i).getName());
        }



        /*
*
* Burada harita yani Buildingler oluşturulacak
* Haritayı ArrayListe kayıt ederiz
*
* Kullanıcılar burada alınacak(Kullanıcı 1,Kullanıcı 2 vs )
*
*  Oyun buraya yazacağımız methodlarla çalışacak
* Oyuncunun herhareketi burada işlenecek (Zar atma,ilerleme)
*
*
* */
    }//Gibi methodlar
    public void moveTo(){

    }
    public void nextTurn(){

    }



}
