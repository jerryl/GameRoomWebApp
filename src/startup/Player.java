package startup;

import cards.Card;
import cards.DefuseCard;
import cards.ExplodeCard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lingd on 8/4/17.
 */
public class Player {
    private ArrayList<Card> hand;
    private String id;
    private ArrayList<Card> deck;
    private Game g;

    public Player(String name, Game g){
        hand = new ArrayList<Card>();
        this.deck = g.getDeck();
        this.id = name;
        this.g = g;
        initHand();
    }

    private void initHand(){
        hand.add(new DefuseCard());
        for(int i=0; i<4; i++) {
            if(!(deck.get(0).getName().equals("Defuse") || deck.get(0).getName().equals("Explode"))) {
                hand.add(deck.remove(0));
            }
            else{
                i--;
                Collections.shuffle(deck);
            }
        }
    }

    public void drawTop(){
        Card top = deck.remove(0);
        if(top.getName().equals("Explode")){
            boolean noDefuse = true;
            for(Card c: hand) {
                if (c.getName().equals("Defuse")){
                    hand.remove(c);
                    noDefuse = false;

                    //front end method returns int: asks where to put exploding kitten
                    System.out.println("Kitten encountered and defused.");
                    ExplodeCard ec = new ExplodeCard();
                    deck.add(0, ec);
                    g.setActivePlayer(g.getActivePlayer()+1);
                    break;
                }
            }
            if(noDefuse) {
                System.out.println("Kitten exploded and RIP.");
                g.getPlayers().remove(this);
            }
        }
        else{
            hand.add(top);
            g.setActivePlayer(g.getActivePlayer()+1);
        }

        if(g.getActivePlayer() >= g.getPlayers().size()){
            g.setActivePlayer(0);
        }
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Game getGame(){ return g; }

    public String getId(){ return id; }
}
