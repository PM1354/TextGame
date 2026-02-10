package Command;
import Game.Player;

public class Talk implements CommandExecute{
    private final Player player;

    public Talk(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
    player.talk();
    }
}
