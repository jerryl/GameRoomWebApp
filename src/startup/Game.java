package startup;

import cards.*;
import cards.actions.*;
import cards.text.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lingd on 8/4/17.
 */
public class Game {
    private int numPlayers;
    private int activePlayer;
    private ArrayList<String> names;
    private ArrayList<Player> players;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;

    public Game(int num, ArrayList<String> names){
        this.numPlayers = num;
        this.names = names;
        players = new ArrayList<>();
        deck = new ArrayList<>();
        discard = new ArrayList<>();
        initDeck();
        initPlayers();
        activePlayer = 0;
    }

    private void initPlayers(){
        for(int i=0; i<numPlayers; i++){
            Player p = new Player(names.get(i), this);
            players.add(p);
        }
    }

    private void initDeck(){
        for(int i=0; i<names.size()-1; i++) {
            deck.add(new ExplodeCard());
        }
        for(int k=0; k<5; k++) {
            deck.add(new ZombieCard());
            deck.add(new DefuseCard());
            deck.add(new FavorCard());
            //deck.add(new NopeCard());
            deck.add(new ShuffleCard());
            deck.add(new SkipCard());
            deck.add(new FutureCard());
            deck.add(new SchrodingerCard());
            deck.add(new AttackCard());
        }
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setActivePlayer(int ap){
        activePlayer = ap;
    }

    public int getActivePlayer(){
        return activePlayer;
    }

    public int verifySelectedCards(String[] card){
        if(card.length == 2){
            if(!card[0].equals(card[1])){
                return -1;
            }
            return 2;
        }
        else if(card.length == 3){
            if(!card[0].equals(card[1]) || !card[0].equals(card[2])){
                return -1;
            }
            return 3;
        }
        else if(card.length == 5){
            Set<String> dups = new HashSet<String>();
            for(String s: card){
                if(dups.contains(s)){
                    return -1;
                }
                else{
                    dups.add(s);
                }
            }
            return 4;
        }
        else if(card.length == 1){
            return 1;
        }
        return -1;
    }
}
