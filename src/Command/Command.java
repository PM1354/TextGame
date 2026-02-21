package Command;

import Game.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Command {
    Map<String,CommandExecute> prikazy = new HashMap();
    Scanner scr = new Scanner(System.in);
    private final Player player;

    public Command(Player player) {
        this.player = player;
    }

    /**
     * vytvoří mapu příkazů
     */
    public void vytvorMapu(){
        prikazy.put("move",new Move(player));
        prikazy.put("clue",new Clue());
        prikazy.put("combine", new Combine(player));
        prikazy.put("help",new Help(player));
        prikazy.put("inventory",new Inventory(player));
        prikazy.put("sleep",new Sleep(player));
        prikazy.put("store",new Store(player));
        prikazy.put("take",new Take(player));
        prikazy.put("talk",new Talk(player));
        prikazy.put("time",new Time(player));
        prikazy.put("use",new Use(player));
        prikazy.put("eat",new Eat(player));
        prikazy.put("drink",new Drink(player));
    }

    /**
     * provede jednotlivý příkaz z mapy příkazů
     * @param prikaz - parametr který zadává hráč
     */
    public void proved(String prikaz){
        if (prikazy.containsKey(prikaz)){
            prikazy.get(prikaz).execute();
        }else{
            System.out.println("there is no choice like that");
        }
    }
}
