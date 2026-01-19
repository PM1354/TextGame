package Game;

import java.util.ArrayList;

public class Player {
    private int day;
    private boolean ateToday;
    private boolean drankToday;
    private boolean sleptToday;
    private boolean alive;
    ArrayList<Item> inventory = new ArrayList<>();

    public void move(String direction){}
    public void sleep(){}
    public void eat(Item i){}
    public void drink(Item i){}
    public void store(Item i){}
    public void drop(Item i){}
    public void combine(Item i, Item it){}


}
