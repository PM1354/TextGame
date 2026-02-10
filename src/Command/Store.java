package Command;
import Game.Player;

public class Store implements CommandExecute{
    private final Player player;

    public Store(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
    player.store();
    }
}
