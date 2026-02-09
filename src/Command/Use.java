package Command;
import Game.Player;

public class Use implements CommandExecute{
    private Player player;

    @Override
    public void execute() {
    player.use();
    }
}
