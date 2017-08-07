package cards;

import startup.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lingd on 8/4/17.
 */
public abstract class Card {
    private String name;
    private String type;
    private String text;
    private boolean interact;

    public Card(String name, String type, String text, boolean i){
        this.name = name;
        this.type = type;
        this.text = text;
        this.interact = i;
    }

    public abstract void played(Player[] p);

    public String getName(){
        return name;
    }

    public void stealRandom(Player[] p, String cardUsed){
        String[] used = {cardUsed, cardUsed};
        this.removeUsedCards(p[0], used);

        Collections.shuffle(p[1].getHand());
        Card rand = p[1].getHand().get(0);
        p[0].getHand().add(rand);
        p[1].getHand().remove(rand);
    }

    public void stealSpecific(Player[] p, String cardUsed, String cardWant){
        String[] used = {cardUsed, cardUsed, cardUsed};
        this.removeUsedCards(p[0], used);

        for(Card c: p[1].getHand()){
            if(c.getName().equals(cardWant)){
                p[0].getHand().add(c);
                p[1].getHand().remove(c);
                break;
            }
        }
    }

    public void removeUsedCards(Player p, String[] cards){
        ArrayList<Card> copy = new ArrayList<>();
        for(Card c: p.getHand()){
            copy.add(c);
        }

        for(String s: cards){
            for(Card c: copy){
                if(c.getName().equals(s)){
                    p.getHand().remove(c);
                    break;
                }
            }
        }
    }
}
