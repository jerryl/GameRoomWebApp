package cards;

/**
 * Created by lingd on 8/4/17.
 */
public abstract class Card {
    private String name;
    private String type;
    private String text;

    public Card(String name, String type, String text){
        this.name = name;
        this.type = type;
        this.text = text;
    }

    public String getName(){
        return name;
    }
}
