package jsonData;
import Game.World;
import com.fasterxml.jackson.databind.ObjectMapper;
import Game.Npc;
import Game.Item;
import Game.Room;

import java.util.HashMap;
import java.util.Map;


public class WorldD {
    public RoomD[] rooms;
    public String startroom;
    public static World takeData(){
        try {
            ObjectMapper om = new ObjectMapper();
            java.io.InputStream is = WorldD.class.getClassLoader().getResourceAsStream("characters.json");
            if (is == null) {
                System.out.println("Soubor nebyl nalezen");
                return null;
            }
            WorldD wd = om.readValue(is, WorldD.class);
            if (wd.rooms == null || wd.rooms.length == 0) {
                return null;
            }
            Map<String, Room> roomsMap = new HashMap<>();
            for (RoomD r : wd.rooms) {
                Room room = new Room(r.name);
                room.setHasFire(r.hasfire);
                roomsMap.put(r.name, room);
            }
            for (RoomD r : wd.rooms) {
                Room room = roomsMap.get(r.name);
                if (r.exits != null) {
                    for (Map.Entry<String, String> entry : r.exits.entrySet()) {
                        String dir = entry.getKey();
                        String target = entry.getValue();
                        if (target != null && roomsMap.containsKey(target)) {
                            room.addExit(dir, roomsMap.get(target));
                        }
                    }
                }
            }
            for (RoomD r : wd.rooms) {
                Room room = roomsMap.get(r.name);
                if (r.items != null) {
                    for (ItemD i : r.items) {
                        room.addItem(new Item(i.name));
                    }
                }
            }
            for (RoomD r : wd.rooms) {
                Room room = roomsMap.get(r.name);
                if (r.NPCS != null) {
                    for (NpcD n : r.NPCS) {
                        room.addNpc(new Npc(n.name, n.hasquest));
                    }
                }
            }
            World world = new World();
            world.setRoomMap(roomsMap);
            System.out.println("World nacten");
            return world;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
