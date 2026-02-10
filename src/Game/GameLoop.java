package Game;
import Command.Command;
import jsonData.WorldD;

import java.util.Scanner;

public class GameLoop {
    boolean end = false;
    Scanner scr = new Scanner(System.in);

    public void loop(){
        World world = WorldD.takeData();
        Player player = new Player();
        Quests q = new Quests();
        player.setQuests(q);
        player.setCurrent(world.getStartRoom());
        Command cmd = new Command(player);
        cmd.vytvorMapu();
        while(!end){
            if (player.getDay()==3){
                end = true;
            }
            String prikaz = scr.nextLine();
            prikaz =prikaz.toLowerCase();
            cmd.proved(prikaz);
        }
        System.out.println("winner");
    }
}
