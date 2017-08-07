package cards.actions;

import cards.Card;
import startup.Game;
import startup.Player;

/**
 * Created by lingd on 8/7/17.
 */
public class SkipCard extends ActionCard{

    public SkipCard(){
        super("Skip","Action","skip-a-dee-doo-da", false);
    }

    @Override
    public void played(Player[] p) {
        Game g = p[0].getGame();
        g.setActivePlayer(g.getActivePlayer()+1);
        if(g.getActivePlayer() >= g.getPlayers().size()){
            g.setActivePlayer(0);
        }

        removeActionCard(p[0]);
    }

}
