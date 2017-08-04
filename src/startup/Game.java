package startup;

import cards.*;
import cards.actions.*;
import cards.text.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lingd on 8/4/17.
 */
public class Game {
    private int numPlayers;
    private ArrayList<String> names;
    private ArrayList<Player> players;
    private ArrayList<Card> deck;

    public Game(int num, ArrayList<String> names){
        this.numPlayers = num;
        this.names = names;
        players = new ArrayList<>();
        deck = new ArrayList<>();
        initDeck();
        initPlayers();
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
            deck.add(new NopeCard());
            deck.add(new ShuffleCard());
        }
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
