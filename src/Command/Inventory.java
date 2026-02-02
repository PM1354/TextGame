package Command;
import Game.Player;

public class Inventory implements CommandExecute{
    private Player player;

    @Override
    public void execute() {
        System.out.println(player.getInventory());
    }
}
