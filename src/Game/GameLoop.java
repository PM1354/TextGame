package Game;
import Command.Command;
import jsonData.WorldD;

import java.util.Scanner;

public class GameLoop {
    boolean end = false;
    Scanner scr = new Scanner(System.in);

    /**
     * loop celé hry
     */
    public void loop(){
        World world = WorldD.takeData();
        Player player = new Player();
        Quests q = new Quests();
        player.setQuests(q);
        player.setCurrent(world.getStartRoom());
        Command cmd = new Command(player);
        cmd.vytvorMapu();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("You are a world-renowned treasure hunter named Jeremy Kennedy.");
        System.out.println("You embark on various expeditions and bring back legendary lost artifacts.");
        System.out.println("These artifacts come from times when humanity could not read or write.");
        System.out.println("To some, these objects are just tall tales, but you find them despite all doubts.");
        System.out.println("Now you have your sights set on an object Peruvians have whispered about for centuries.");
        System.out.println("Its name is the Inti Diospa Estatua.");
        System.out.println("It is a small statue said to bring luck and wealth to all who touch it.");
        System.out.println("You set off to find it in the mountains of Peru, where you located an unexplored cave.");
        System.out.println("You step inside and suddenly you hear a sharp click.");
        System.out.println("The cave exit has vanished.");
        System.out.println("You hear the last static and the faint words of your team, camped three days away.");
        System.out.println("The last thing on your mind is to send a distress signal and survive until they rescue you.");
        while(!end){
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("you can use commands:");
            System.out.println("move");
            System.out.println("sleep");
            System.out.println("store");
            System.out.println("take");
            System.out.println("talk");
            System.out.println("time");
            System.out.println("use");
            System.out.println("inventory");
            System.out.println("help");
            System.out.println("eat");
            System.out.println("drink");
            System.out.println("combine");
            System.out.println("clue");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println(player.getCurrent());
            if (player.getDay()==3){
                end = true;
                System.out.println("winner");
            }
            if(!player.isAlive()){
                end = true;
                System.out.println("u lost");
            }
            String prikaz = scr.nextLine();
            prikaz =prikaz.toLowerCase();
            cmd.proved(prikaz);
        }
    }
}
