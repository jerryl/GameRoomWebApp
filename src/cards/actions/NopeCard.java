package cards.actions;

import startup.Player;

/**
 * Created by lingd on 8/4/17.
 */
public class NopeCard extends ActionCard{

    public NopeCard(){
        super("Nope","Action","denied", true);
    }

    @Override
    public void played(Player[] p){}
}
