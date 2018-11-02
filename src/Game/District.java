package Game;

public class District extends MapBox {

    private int id;
    private double priceAmount;
    private double development;
    private double rentAmount0;
    private double rentAmount1;
    private double rentAmount2;
    private double rentAmount3;
    private double rentAmount4;
    private Player owner=null;
    private String name;

    District(int id, String name, double priceAmount, double development, double rentAmount0, double rentAmount1, double rentAmount2, double rentAmount3, double rentAmount4, Player owner){

        this.id=id;
        this.name=name;
        this.priceAmount=priceAmount;
        this.development=development;
        this.rentAmount0=rentAmount0;
        this.rentAmount1=rentAmount1;
        this.rentAmount2=rentAmount2;
        this.rentAmount3=rentAmount3;
        this.rentAmount4=rentAmount4;
        this.owner=owner;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Override
    public void doAction(Player player) {
        // System.out.println("Before transaction : Player " + player.getName() + " : " + player.getMoney());
        if (player.getMoney() > priceAmount){

            if(owner != null)
                owner.addMoney(priceAmount);

            player.substractMoney(priceAmount);
            owner = player;
            System.out.println("Player " + player.getName() + " bought " + getName() + " with " + priceAmount);
        }


        else{

            if (owner != null) {
                owner.addMoney(rentAmount0);
                player.substractMoney(rentAmount0);
                System.out.println("Player " + player.getName() + " payed " + rentAmount0 + " to Player " + owner.getName());
            }

        }

    }  /* End of doAction Method */
}