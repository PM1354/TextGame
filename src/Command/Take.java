package Command;
import Game.Player;

public class Take implements CommandExecute{
    private final Player player;

    public Take(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
    player.take();
    }
}
