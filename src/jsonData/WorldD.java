package jsonData;
import Game.World;
import com.fasterxml.jackson.databind.ObjectMapper;
import Game.Npc;
import Game.Item;
import Game.Room;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class WorldD {


    public RoomD[] rooms;
    public static World takeData(){
        try {

            ObjectMapper om = new ObjectMapper();
            WorldD wd = om.readValue(new File("resources/character.json"), WorldD.class);
            Map<String, Room> rooms = new HashMap<>();
            for (RoomD r : wd.rooms) {
                Room room = new Room(r.name);
                room.setHasFire(r.hasfire);
                rooms.put(r.name, room);
            }
            for (RoomD r : wd.rooms) {
                Room room = rooms.get(r.name);

                for (String dir : r.exits.keySet()) {
                    String target = r.exits.get(dir);
                    if (target != null) {
                        room.addExit(dir, rooms.get(target));
                    }
                }
            }
            for (RoomD r : wd.rooms) {
                Room room = rooms.get(r.name);

                for (ItemD i : r.items) {
                    room.addItem(new Item(i.name));
                }

                for (NpcD n : r.NPCS) {
                    room.addNpc(new Npc(n.name, n.hasquest));
                }
            }
            World world = new World();
            world.setRoomMap(rooms);
            System.out.println(world);
            return world;

        }catch (Exception e){
            return null;
        }
    }


}
