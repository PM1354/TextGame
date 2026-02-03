package Game;
import jsonData.WorldD;

public class GameLoop {
    boolean end = false;

    public void loop(){
        World world = WorldD.takeData();
        Player player = new Player();
        player.setCurrent(world.getStartRoom());
        while(!end){
            if (player.getDay()==3){
                end = true;
            }
        }
    }
}
