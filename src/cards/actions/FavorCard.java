package cards.actions;

import cards.Card;
import startup.Player;

/**
 * Created by lingd on 8/4/17.
 */
public class FavorCard extends ActionCard{

    private Card select;

    public FavorCard(){
        super("Favor","Action","gimme gimme", true);
    }

    public void played(Player[] p){
        //front end method to set select

        p[0].getHand().add(select);
        p[1].getHand().remove(select);

        removeActionCard(p[0]);
    }

    public void setSelected(Card select){
        this.select = select;
    }
}
