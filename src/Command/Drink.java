package Command;

import Game.Player;

public class Drink implements CommandExecute{
    private  final Player player;

    public Drink(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.drink();

    }
}
