package Game;

import java.util.Map;

public class World {

    public World() {
    }

    private Room startRoom;
    private Map<String,Room>roomMap;

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public Room getRoom(String name){
        return roomMap.get(name);
    }

    public void setRoomMap(Map<String, Room> roomMap) {
        this.roomMap = roomMap;
    }


}
