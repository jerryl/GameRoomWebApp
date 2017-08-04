package cards.actions;

import cards.Card;

/**
 * Created by lingd on 8/4/17.
 */
public abstract class ActionCard extends Card {

    public ActionCard(String name, String type, String text){
        super(name, type, text);
    }

    public abstract void action();
}
