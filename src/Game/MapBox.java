package Game;

public abstract class MapBox {
    String name;
    int loan;
    int price;
    Player owner;
    public int value;

    public MapBox(String name, int loan, int price, Player owner) {//Tapular burda
        this.name = name;
        this.loan = loan;
        this.price = price;
        this.owner = owner;
    }

    public MapBox() {
    }

    public String getName() {
        return name;
    }

    public int getLoan() {
        return loan;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void doAction(Player player);


}
