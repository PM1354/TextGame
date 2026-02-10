package Command;
import Game.Player;

public class Inventory implements CommandExecute{
    private final Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println(player.getInventory());
    }
}
