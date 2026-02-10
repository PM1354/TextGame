package Command;
import Game.Player;

public class Time implements CommandExecute{
    private final Player player;

    public Time(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.time();
    }
}
