package Command;
import Game.Player;

public class Combine implements CommandExecute{
    private Player player;


    @Override
    public void execute() {
    player.combine();
    }
}
