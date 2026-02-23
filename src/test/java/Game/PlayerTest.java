package Game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player hrac = new Player();
    private Quests quests = new Quests();

    void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        hrac.scr = new java.util.Scanner(System.in);
    }
    @Test
    void testSleep_UmrtiHladyNeboZizni() {
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
    void testMoveNorthSuccess() {
        Room start = new Room("start");
        Room northRoom = new Room("north room");
        start.addExit("north", northRoom);
        hrac.setCurrent(start);
        simulateInput("north\n");
        hrac.move();
        assertEquals(northRoom, hrac.getCurrent(), "Hráč by se měl přesunout do severní místnosti.");
    }
    @Test
    void testTime_SpatnaLokalita() {
        Room wrongRoom = new Room("forest");
        hrac.setCurrent(wrongRoom);
        assertDoesNotThrow(() -> hrac.time());
    }
    @Test
    void testTake_PlnyInventar_NepridaItem() {
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
    void testTake_PridaItemDoInventare() {
        simulateInput("1\n");
        Room room = new Room("forest");
        Item item = new Item("stick");
        room.getItems().add(item);
        hrac.setCurrent(room);
        hrac.take();
        assertTrue(hrac.getInventory().contains(item));
    }
    @Test
    void testTalk_Frog_NehodiVyjimku() {
        Room room = new Room("forest");
        Npc frog = new Npc("frog",false);
        room.addNpc(frog);
        hrac.setCurrent(room);
        assertDoesNotThrow(() -> hrac.talk());
    }
    @Test
    void testTalk_ZadnyNpc_NehodiVyjimku() {
        Room room = new Room("forest");
        hrac.setCurrent(room);
        assertDoesNotThrow(() -> hrac.talk());
    }
}
