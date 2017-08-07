package cards.actions;

import cards.Card;
import startup.Player;
import test.PlayTest;

/**
 * Created by lingd on 8/7/17.
 */
public class FutureCard extends ActionCard{

    public FutureCard(){
        super("See the Future","Action","oooooeeeoo", false);
    }

    @Override
    public void played(Player[] p) {
        String[] three = new String[3];
        three[0] = p[0].getDeck().get(0).getName();
        three[1] = p[0].getDeck().get(1).getName();
        three[2] = p[0].getDeck().get(2).getName();

        //front end method to display three
        PlayTest.displayFuture(three);

        removeActionCard(p[0]);
    }

}
