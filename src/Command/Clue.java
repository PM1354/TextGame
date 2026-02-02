package Command;

public class Clue implements CommandExecute{
    @Override
    public void execute() {
        System.out.println("you can combine these things:");
        System.out.println("spider + rock bowl");
        System.out.println("string + stick");
        System.out.println("you can use these things in certain areas:");
        System.out.println("trap with the lure in room with big lake");
        System.out.println("fishingrod in room with big lake");
        System.out.println("charcoal in room with campfire");
        System.out.println("rock bowl in corridor");
        System.out.println("every type of raw meat in room with campfire");

    }
}
