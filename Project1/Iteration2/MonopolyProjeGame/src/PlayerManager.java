package Monopoly;

import Monopoly.Board.*;
import Monopoly.Player.*;

import java.util.List;

import static Monopoly.Main.HEA_Bank;

public class PlayerManager {

    void playerHasNoMoney(Player currentPl, Board b){
        System.out.println(currentPl.getName() + " was bankrupt so out of game with debt "+currentPl.getMoney().getMoney()+" ₺");
        List<MapBox> search= currentPl.getDeed();
        List<MapBox> toDelete=b.getMap();
        System.out.println("All assets of "+currentPl.getName());

        for(int y=0;y<search.size();y++){
            System.out.println(search.get(y).getName());
        }
        Money debtFor=new Money(0);

        for(int sss=search.size()-1;sss>-1;sss--){/*Player sells all assets until pay all debt.*/
            if (debtFor.getMoney()<(int)Math.abs(currentPl.getMoney().getMoney())){/*If player can pay own debt with own assets*/

                search.get(sss).setOwner(null);
                debtFor.addMoney(search.get(sss).getHalfPriceAmount());
                System.out.println(currentPl.getName()+" sold "+search.get(sss).getName()+" with "+search.get(sss).getHalfPriceAmount().getMoney()+" ₺");

                for(int u=0;u<toDelete.size();u++){/*After Selling asset,Define new state of asset*/
                    if(toDelete.get(u).getId()==search.get(sss).getId()){
                        toDelete.get(u).setOwner(null);/*Define the asset state to main map to show other player*/
                    }
                }
                search.remove(search.get(sss));/*Take deed of asset from older Owner*/
            }

        }

        HEA_Bank.payMoney(currentPl,debtFor); /*Adding money which come selling assets*/

    }
    boolean alreadyHasNoMoney(Player currentPl){
        if(currentPl.getMoney().getMoney()<0)
            return true;
        else return false;
    }
}
