package cards.text;

import cards.Card;

/**
 * Created by lingd on 8/4/17.
 */
public abstract class TextCard extends Card{

    public TextCard(String name, String type, String text){
        super(name, type, text);
    }

    public void steal(){}

}
