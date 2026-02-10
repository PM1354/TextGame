package Command;
import Game.Player;

public class Sleep implements CommandExecute{
    private final Player player;

    public Sleep(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.sleep(player.getCurrent());
    }
}
