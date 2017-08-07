package test;

import cards.Card;
import cards.ExplodeCard;
import startup.Game;
import startup.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Kinda replaces some front-end functionality, but game play is shitty through scanner.
 * Created by lingd on 8/7/17.
 */
public class PlayTest {

    private static Player curr;

    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        names.add("Dennis");
        names.add("Jerry");
        Game g = new Game(2, names);

        int in;
        Scanner sc = new Scanner(System.in);

        addBombs(true, g);

        boolean turns = true;
        while(turns){
            curr = g.getPlayers().get(g.getActivePlayer());
            System.out.println(curr.getId() + "'s hand: ");
            for(Card c: curr.getHand()){
                System.out.print(c.getName() + " // ");
            }

            System.out.println("");
            System.out.println("0: end turn and draw a card. 1-x: play that card.");

            in  = sc.nextInt();
            if(in == 0){
                int before = curr.getHand().size();
                curr.drawTop();
                if(curr.getHand().size() > before) {
                    System.out.println("Drew a " + curr.getHand().get(curr.getHand().size() - 1).getName() + ".");
                }
                System.out.println("Turn ended.");
                System.out.println("");
            }
            else if(in > 0 && in <= curr.getHand().size()){
                curr.getHand().get(in-1).played(new Player[]{curr});
            }

            if(g.getPlayers().size() == 1){
                turns = false;
                System.out.println(g.getPlayers().get(0).getId() + " WINS!!!!");
            }

        }
    }

    private static void addBombs(boolean t, Game g){
        if(t){
            for(int i=0; i< 10; i++) {
                g.getDeck().add(new ExplodeCard());
                Collections.shuffle(g.getDeck());
            }
        }
    }

    public static void displayFuture(String[] cards){
        System.out.println("Three cards in order are: " );
        for(String c: cards){
            System.out.print(c + ", ");
        }
        System.out.println("");

    }
}
