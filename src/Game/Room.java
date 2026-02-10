package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private Map<String, Room> exits = new HashMap<>();
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Npc> npcs = new ArrayList<>();
    private boolean hasFire;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasFire() {
        return hasFire;
    }

    public void setHasFire(boolean hasFire) {
        this.hasFire = hasFire;
    }

    public void addExit(String dirction,Room r){
        exits.put(dirction,r);
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    public Map<String,Room> getExits(){
        return exits;
    }

    public void addItem(Item i){
    items.add(i);
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void removeItem(Item i){}

    public void addNpc(Npc n){
        npcs.add(n);
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
    }

    @Override
    public String toString() {
        return "you are in " + name ;
    }
}
