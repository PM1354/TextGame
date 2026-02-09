package Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Command {
    Map<String,CommandExecute> prikazy = new HashMap();
    Scanner scr = new Scanner(System.in);

    public void vytvorMapu(){
        prikazy.put("move",new Move());//hotovo
        prikazy.put("clue",new Clue());//hotovo
        prikazy.put("combine", new Combine());//hotovo
        prikazy.put("help",new Help());//hotovo
        prikazy.put("inventory",new Inventory());//hotovo
        prikazy.put("sleep",new Sleep());//hotovo
        prikazy.put("store",new Store());//hotovo
        prikazy.put("take",new Take());//hotovo
        prikazy.put("talk",new Talk());//hotovo
        prikazy.put("time",new Time());//hotovo
        prikazy.put("use",new Use());//hotovo
        prikazy.put("eat",new Eat());//hotovo
        prikazy.put("drink",new Drink());//hotovo
    }

    public void proved(String prikaz){
        if (prikazy.containsKey(prikaz)){
            prikazy.get(prikaz).execute();
        }else{
            System.out.println("there is no choice like that");
        }
    }
}
