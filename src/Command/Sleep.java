package Command;
import Game.Player;

public class Sleep implements CommandExecute{
    private Player player;

    @Override
    public void execute() {
        player.sleep(player.getCurrent());
    }
}
