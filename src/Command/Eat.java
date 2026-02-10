package Command;

import Game.Player;

public class Eat implements CommandExecute{
    private final Player player;

    public Eat(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.eat();
    }
}
