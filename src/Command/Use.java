package Command;
import Game.Player;

public class Use implements CommandExecute{
    private final Player player;

    public Use(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
    player.use();
    }
}
