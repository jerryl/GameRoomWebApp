package startup;

import cards.Card;
import cards.DefuseCard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lingd on 8/4/17.
 */
public class Player {
    private ArrayList<Card> hand;
    private String id;
    private Game g;

    public Player(String x, Game g){
        hand = new ArrayList<Card>();
        this.g = g;
        this.id = x;
        initHand();
    }

    private void initHand(){
        hand.add(new DefuseCard());
        for(int i=0; i<4; i++) {
            if(!(g.getDeck().get(0).getName().equals("Defuse") || g.getDeck().get(0).getName().equals("Explode"))) {
                hand.add(g.getDeck().remove(0));
            }
            else{
                i--;
                Collections.shuffle(g.getDeck());
            }
        }
    }

    public ArrayList<Card> getHand(){
        return hand;
    }
}
