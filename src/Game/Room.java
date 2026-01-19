package Game;

import java.util.ArrayList;
import java.util.Map;

public class Room {

    private String name;
    private Map<String, Room> exits;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Npc> npcs = new ArrayList<>();
    private boolean hasFire;

    public void addItem(Item i){}
    public void removeItem(Item i){}
    public void addNpc(Npc n){}
}
