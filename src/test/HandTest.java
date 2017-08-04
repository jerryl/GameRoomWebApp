package test;

import cards.Card;
import startup.Game;
import startup.Player;

import java.util.ArrayList;

/**
 * Created by lingd on 8/4/17.
 */
public class HandTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            createGame();
        }
    }

    private static void createGame(){
        ArrayList<String> names = new ArrayList<>();
        names.add("den");
        names.add("jerry");
        Game g = new Game(2, names);

        ArrayList<Player> p = g.getPlayers();
        ArrayList<Card> c1 = p.get(0).getHand();
        ArrayList<Card> c2 = p.get(1).getHand();
        for(int i=0; i<c1.size(); i++) {
            System.out.println("1 " + c1.get(i).getName());
            System.out.println("2 " + c2.get(i).getName());
        }
        System.out.println("*****");
    }
}
