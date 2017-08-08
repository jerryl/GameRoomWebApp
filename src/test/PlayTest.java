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
        names.add("Mike");
        Game g = new Game(3, names);

        int in;
        Scanner sc = new Scanner(System.in);

        addBombs(false, g);

        boolean turns = true;
        while(turns){
            curr = g.getPlayers().get(g.getActivePlayer());
            System.out.println(curr.getId() + "'s hand: ");
            for(Card c: curr.getHand()){
                System.out.print(c.getName() + " // ");
            }

            System.out.println("");
            System.out.println("0: end turn and draw a card. 1-x: play that card. Put '00' in between numbers to play multiple cards (eg. 1003004).");

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

            if(in > 1000){
                String conv = Integer.toString(in);

                String one = String.valueOf(conv.charAt(0));
                String two = String.valueOf(conv.charAt(conv.length()-1));
                Card o = curr.getHand().get(Integer.parseInt(one)-1);
                Card t = curr.getHand().get(Integer.parseInt(two)-1);

                if(in < 10000) {
                    if (g.verifySelectedCards(new String[]{
                            o.getName(),
                            t.getName()
                    }) == 2) {
                        System.out.println("Select a player to target: ");
                        int count = 1;
                        for (Player curr : g.getPlayers()) {
                            System.out.print(count + ": " + curr.getId() + " ");
                            count++;
                        }

                        int targ = sc.nextInt();
                        if (targ <= g.getPlayers().size() && targ > 0) {
                            o.stealRandom(new Player[]{
                                    curr,
                                    g.getPlayers().get(targ - 1)
                            }, o.getName());
                        }
                    }
                }
                else{
                    String three = String.valueOf(conv.charAt(3));
                    Card thr = curr.getHand().get(Integer.parseInt(three)-1);

                    if (g.verifySelectedCards(new String[]{
                            o.getName(),
                            t.getName(),
                            thr.getName()
                    }) == 3) {
                        System.out.println("Select a player to target: ");
                        int count = 1;
                        for (Player curr : g.getPlayers()) {
                            System.out.print(count + ": " + curr.getId() + " ");
                            count++;
                        }

                        int targ = sc.nextInt() - 1;
                        if (targ < g.getPlayers().size() && targ >= 0) {
                            System.out.println("Name a specific card to steal.");
                            String targetString = sc.next();
                            o.stealSpecific(new Player[]{
                                    curr,
                                    g.getPlayers().get(targ)
                            }, o.getName(), targetString);
                        }
                    }
                }


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

    public static int[] favorPlayed(Game g){
        Scanner sc = new Scanner(System.in);
        int[] re = new int[2];
        int count = 1;

        System.out.println("Select a player to target: ");
        for(Player curr: g.getPlayers()){
            System.out.print(count + ": " + curr.getId() +" ");
            count++;
        }

        int target = sc.nextInt();
        re[0] = target-1;
        System.out.println("");
        System.out.println("Targeted player, select a card to give: ");
        System.out.println("Your hand, from 1-x");
        for(Card c: g.getPlayers().get(target-1).getHand()){
            System.out.print(c.getName()+ " // ");
        }
        System.out.println("");
        re[1] = sc.nextInt() - 1;

        return re;
    }
}
