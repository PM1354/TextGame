package Command;
import Game.Player;

public class Combine implements CommandExecute{
    private final Player player;

    public Combine(Player player) {
        this.player = player;
    }


    @Override
    public void execute() {
    player.combine();
    }
}
