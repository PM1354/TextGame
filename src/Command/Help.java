package Command;
import Game.Player;
import Game.Quests;

public class Help implements CommandExecute{
    private final Player player;

    public Help(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println(player.getQuests());
    }
}
