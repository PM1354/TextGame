package Command;

import Game.Player;

public class Drink implements CommandExecute{
    private Player player;
    @Override
    public void execute() {
        player.drink();

    }
}
