package anan;

public abstract class MapBox {
    String name;
    int id;
    public int value;
    public MapBox(){}



    public abstract String getName() ;
    public abstract int getId();


    public void setName(String name) {
        this.name = name;
    }



    public abstract void doAction(Player player);


}
