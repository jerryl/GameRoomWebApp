package cards.actions;

import startup.Game;
import startup.Player;

/**
 * Created by lingd on 8/8/17.
 */
public class AttackCard extends ActionCard {

    public AttackCard(){ super("Attack","Action","rawr",true); }

    @Override
    public void played(Player[] p) {
        Game g = p[0].getGame();
        g.setActivePlayer(g.getActivePlayer()+1);
        if(g.getActivePlayer() >= g.getPlayers().size()){
            g.setActivePlayer(0);
        }

        g.getPlayers().get(g.getActivePlayer()).setAttacked(true);
        if(p[0].getAttacked()){ p[0].setAttacked(false); } ;

        removeActionCard(p[0]);
    }
}
