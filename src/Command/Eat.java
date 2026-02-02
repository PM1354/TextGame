package Command;

import Game.Player;

public class Eat implements CommandExecute{
    private Player player;
    @Override
    public void execute() {
        player.eat();
    }
}
