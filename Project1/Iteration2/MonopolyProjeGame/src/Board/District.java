package Monopoly.Board;

import Monopoly.Main;
import Monopoly.Player.Player;
import Monopoly.Player.Money;

public class District extends MapBox {

    private int id;
    private Status status;
    private Money priceAmount;
    private Money development;
    private Money rentAmount0;
    private Money rentAmount1;
    private Money rentAmount2;
    private Money rentAmount3;
    private Money rentAmount4;
    private Player owner;
    private String name;

    District(int id, String name, double priceAmount, double development, double rentAmount0, double rentAmount1, double rentAmount2, double rentAmount3, double rentAmount4, Player owner){

        this.id=id;
        this.name=name;
        this.priceAmount=new Money(priceAmount);
        this.development=new Money(development);
        this.rentAmount0=new Money(rentAmount0);
        this.rentAmount1=new Money(rentAmount1);
        this.rentAmount2=new Money(rentAmount2);
        this.rentAmount3=new Money(rentAmount3);
        this.rentAmount4=new Money(rentAmount4);
        this.owner=owner;
        status = new Status();
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

        int random=0;
        if(owner == null)
        {
            random= (int) (Math.random()*2);
            if (player.getMoney().getMoney() > priceAmount.getMoney() && random>0)
            {
                Main.HEA_Bank.takeMoney(player,priceAmount);
                owner = player;
                District deed=new District(this.id,this.name,this.priceAmount.getMoney(),this.development.getMoney(),this.rentAmount0.getMoney(),this.rentAmount1.getMoney(),this.rentAmount2.getMoney(),this.rentAmount3.getMoney(),this.rentAmount4.getMoney(),player);
                owner.addDeed(deed);
                System.out.println(player.getName() + " Bought " + getName() + " : " + (int)(priceAmount.getMoney()) + " ₺");
            }
            else{
                Main.HEA_Bank.takeMoney(player,rentAmount0);
                System.out.println(player.getName()+" pay "+rentAmount0.getMoney()+" rent for visiting");
            }
        }

        else
        {
            if(owner.equals(player)){

                System.out.println("Now "+name+" is in own block.Player can develop own area...");
                random= (int) (Math.random()*2);
                if(owner.getMoney().getMoney()>development.getMoney() && random>0){
                    Main.HEA_Bank.takeMoney(player,development);
                    status.develop(this);
                    System.out.println("Now new rent amount comes "+rentAmount0.getMoney());
                    System.out.println(owner.getName()+" developed own area to "+status.toString()+".");
                }
            }
            else
            {
                Main.HEA_Bank.takeMoney(player,rentAmount0);//player pay money to owner on bank
                Main.HEA_Bank.payMoney(owner,rentAmount0);
                System.out.println(player.getName() + " Payed : " + (int)(rentAmount0.getMoney()) + " ₺ To " + owner.getName()+" for rent.");
            }



        }

    }  /* End of doAction Method */
    public Money[] getAllRentAmount(){
        Money[] rents={rentAmount0,rentAmount0,rentAmount1,rentAmount2,rentAmount3,rentAmount4};
        return rents;
    }

    public String getOwner() {
        if(owner==null)return "";
        return owner.getName();
    }
    public Money getPriceAmount(){
        return priceAmount;
    }
    public Money getHalfPriceAmount(){
        return new Money(priceAmount.getMoney()/2);
    }
    public void setOwner(Player newOwner){
        owner=newOwner;
    }
}