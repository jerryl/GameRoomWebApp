package cards.actions;

import cards.Card;
import startup.Player;

/**
 * Created by lingd on 8/4/17.
 */
public abstract class ActionCard extends Card {

    public ActionCard(String name, String type, String text, boolean i){
        super(name, type, text, i);
    }

    public void removeActionCard(Player p){
        super.removeUsedCards(p, new String[]{this.getName()});
    }

}
