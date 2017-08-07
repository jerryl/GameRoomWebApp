package cards.actions;

import startup.Player;

import java.util.Collections;

/**
 * Created by lingd on 8/4/17.
 */
public class ShuffleCard extends ActionCard{

    public ShuffleCard(){
        super("Shuffle","Action","shuffle 'em up", false);
    }

    @Override
    public void played(Player[] p){
        Collections.shuffle(p[0].getDeck());
        removeActionCard(p[0]);
    }
}
