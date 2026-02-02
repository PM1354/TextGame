package Command;
import Game.Player;

public class Take implements CommandExecute{
    private Player player;
    @Override
    public void execute() {
    player.take();
    }
}
