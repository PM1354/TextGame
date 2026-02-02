package Command;
import Game.Player;
import Game.Quests;

public class Help implements CommandExecute{
    private Player player;
    @Override
    public void execute() {
        System.out.println(player.getQuests());
    }
}
