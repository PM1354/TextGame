package Game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * třída na testy
 */
class PlayerTest {
    private Player hrac = new Player();

    void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        hrac.scr = new java.util.Scanner(System.in);
    }
    @Test
    void testSleepUmrtiHladyNeboZizni() {
        Quests quests = new Quests();
        Player hrac = new Player();
        hrac.setQuests(quests);
        quests.setAteToday(false);
        quests.setDrankToday(false);
        hrac.setAlive(true);
        Room safeRoom = new Room("room with campfire");
        hrac.sleep(safeRoom);
        assertFalse(hrac.isAlive(), "Hráč by měl být po spánku mrtvý, pokud nejedl/nepil.");
    }
    @Test
    void testMoveNorth() {
        Room start = new Room("start");
        Room northRoom = new Room("north room");
        start.addExit("north", northRoom);
        hrac.setCurrent(start);
        simulateInput("north\n");
        hrac.move();
        assertEquals(northRoom, hrac.getCurrent(), "Hráč by se měl přesunout do severní místnosti.");
    }
    @Test
    void testTimeSpatnaLokalita() {
        Room wrongRoom = new Room("forest");
        hrac.setCurrent(wrongRoom);
        assertDoesNotThrow(() -> hrac.time());
    }
    @Test
    void TakePlnyInventar() {
        simulateInput("1\n");
        Room room = new Room("forest");
        Item item = new Item("stick");
        room.getItems().add(item);
        hrac.setCurrent(room);
        for (int i = 0; i < 5; i++) {
            hrac.getInventory().add(new Item("rock"));
        }
        hrac.take();
        assertFalse(hrac.getInventory().contains(item));
    }
    @Test
    void testTakePridaItem() {
        simulateInput("1\n");
        Room room = new Room("forest");
        Item item = new Item("stick");
        room.getItems().add(item);
        hrac.setCurrent(room);
        hrac.take();
        assertTrue(hrac.getInventory().contains(item));
    }
    @Test
    void testTalkFrog() {
        Room room = new Room("forest");
        Npc frog = new Npc("frog",false);
        room.addNpc(frog);
        hrac.setCurrent(room);
        assertDoesNotThrow(() -> hrac.talk());
    }
    @Test
    void testTalkZadnyNpcu() {
        Room room = new Room("forest");
        hrac.setCurrent(room);
        assertDoesNotThrow(() -> hrac.talk());
    }
}
