package cards.actions;

import cards.Card;
import startup.Player;
import test.PlayTest;

/**
 * Created by lingd on 8/4/17.
 */
public class FavorCard extends ActionCard{

    private Card select;

    public FavorCard(){
        super("Favor","Action","gimme gimme", true);
    }

    public void played(Player[] p){
        //front end method to set select and target players
        int[] re = PlayTest.favorPlayed(p[0].getGame());
        Player target = p[0].getGame().getPlayers().get(re[0]);
        Card select = target.getHand().get(re[1]);

        p[0].getHand().add(select);
        target.getHand().remove(select);

        removeActionCard(p[0]);
    }

    public void setSelected(Card select){
        this.select = select;
    }
}
