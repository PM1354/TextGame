package Command;
import Game.Player;

public class Move implements CommandExecute{
    private final Player player;

    public Move(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.move();
    }
}
