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
        player.setCurrent(world.getStartRoom());
        while(!end){
            if (player.getDay()==3){
                end = true;
            }
            String prikaz = scr.nextLine();
            prikaz =prikaz.toLowerCase();
            Command cmd = new Command();
            cmd.vytvorMapu();
            cmd.proved(prikaz);
        }
        System.out.println("winner");
    }
}
