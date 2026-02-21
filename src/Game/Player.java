package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int day = 0;
    private boolean alive = true;
    private Room current;
    private Quests quests;

    Scanner scr = new Scanner(System.in);

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Room getCurrent() {
        return current;
    }

    public void setCurrent(Room current) {
        this.current = current;
    }

    ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Quests getQuests() {
        return quests;
    }

    public void setQuests(Quests quests) {
        this.quests = quests;
    }

    /**
     * posune hráče do další místnosti podle směru který zadá
     */
    public void move() {
        System.out.println("in what direction would u like to move (west, north, east, south)");
        String direction = scr.nextLine();
        direction = direction.toLowerCase();
        if (direction.equals("east") || direction.equals("west") || direction.equals("south") || direction.equals("north")) {
            if (direction.equals("north")) {
                if (current.getExit("north") == null) {
                    System.out.println("there is no room here");
                } else {
                    current = current.getExit("north");
                }
            }
            if (direction.equals("east")) {
                if (current.getExit("east") == null) {
                    System.out.println("there is no room here");
                } else {
                    current = current.getExit("east");
                }
            }
            if (direction.equals("west")) {
                if (current.getExit("west") == null) {
                    System.out.println("there is no room here");
                } else {
                    current = current.getExit("west");
                }
            }
            if (direction.equals("south")) {
                if (current.getExit("south") == null) {
                    System.out.println("there is no room here");
                } else {
                    current = current.getExit("south");
                }
            }
        } else {
            System.out.println("no such direction exists");
        }
    }

    /**
     * jestli je hráč ve správné místnosti tak se vyspí, přejde na další den a resetují se mu questy
     *
     * @param current - room ve kterém hráč právě je
     */
    public void sleep(Room current) {
        if (!quests.isAteToday() || !quests.isDrankToday()) {
            alive = false;
        }
        if (current.getName().equals("room with campfire")) {
            day++;
            System.out.println("a new day is here, all your quests have been reset");
            quests.setDrankToday(false);
            quests.setAteToday(false);
        } else {
            System.out.println("you are not in the safe room to sleep");
        }
    }

    /**
     * jestli je item který hráč napíše poživatelný (edible), tak se nají a splní se mu jeden z questů
     */
    public void eat() {
        System.out.println("what item would u like to eat?");
        String itemName = scr.nextLine();
        itemName = itemName.toLowerCase();
        for (Item i : inventory) {
            if (i.getName().equals(itemName)) {
                if (i.isEdible()) {
                    quests.setAteToday(true);
                    inventory.remove(i);
                } else {
                    System.out.println("this item isnt edible");
                }
            } else {
                System.out.println("this item doesnt exist or u dont have it in inventory");
            }
        }
    }

    /**
     * pokud je item pitelný (drinkable) tak se hráč napije a splí se mu jeden quest
     */
    public void drink() {
        System.out.println("what item would u like to drink");
        String itemName = scr.nextLine();
        itemName = itemName.toLowerCase();
        for (Item i : inventory) {
            if (i.getName().equals(itemName)) {
                if (i.isDrinkable()) {
                    quests.setDrankToday(true);
                    inventory.remove(i);
                    inventory.add(new Item("rock bowl", false, true));
                } else {
                    System.out.println("this item isnt drinkable");
                }
            } else {
                System.out.println("this item doesnt exist or u dont have it in inventory");
            }
        }
    }

    /**
     * když je hráč v místnosti s ohněm tak si tam může uložit 2 věci
     */
    public void store() {
        System.out.println(inventory);
        if (current.getName().equals("room with campfire")) {
            System.out.println("you can store 2 things here");
            System.out.println("which item do you want to store here (type the number according to inventory order)");
            int prikaz = scr.nextInt();
            if (current.getItems().size() == 2) {
                System.out.println("you cannot put anything else here");
            } else {
                if (prikaz == 1) {
                    Item item = inventory.remove(0);
                    current.getItems().add(item);
                }
                if (prikaz == 2) {
                    Item item = inventory.remove(1);
                    current.getItems().add(item);
                }
                if (prikaz == 3) {
                    Item item = inventory.remove(2);
                    current.getItems().add(item);
                }
                if (prikaz == 4) {
                    Item item = inventory.remove(3);
                    current.getItems().add(item);
                }
                if (prikaz == 5) {
                    Item item = inventory.remove(4);
                    current.getItems().add(item);
                }
                if (prikaz > 5 || prikaz < 1) {
                    System.out.println("no such number exists in your inventory");
                }
            }

        } else {
            System.out.println("you are in the wrong room");
        }
    }

    /**
     * hráč si z místnosti může vzít předmět který tam je
     */
    public void take() {
        System.out.println(inventory);
        System.out.println("which item do you want to take (type the number according to the item list in the room) ");
        int prikaz = scr.nextInt();
        if (inventory.size() < 5) {

            if (prikaz == 1) {
                inventory.add(current.getItems().get(0));
            }
            if (prikaz == 2) {
                if (current.getItems().size() != 2) {
                    System.out.println("there is no item at this position");
                } else {
                    inventory.add(current.getItems().get(1));
                }
            }
            if (prikaz > 2 || prikaz < 1) {
                System.out.println("there is no item at this position");
            }
        } else {
            System.out.println("you can't carry any more");
        }
    }

    /**
     * hráč může kombinovat 2 předměty aby získal jeden užitečnější
     */
    public void combine() {
        System.out.println(inventory);
        if (inventory.size() < 2) {
            System.out.println("you can't make anything out of 1 item");
        }
        Item i1 = new Item(" ");
        Item i2 = new Item(" ");
        System.out.println("which 2 items do you want to combine?");
        String item1 = scr.nextLine();
        String item2 = scr.nextLine();
        item1 = item1.toLowerCase();
        item2 = item2.toLowerCase();
        if (item1.equals("spider") && item2.equals("rock bowl")) {
            for (Item i : inventory) {
                if (i.getName().equals("spider")) {
                    i1 = i;
                }
                if (i.getName().equals("rock bowl")) {
                    i2 = i;
                }
            }
            if (i1.getName().equals(" ") || i2.getName().equals(" ")) {
                System.out.println("you dont have those items");
            } else {
                for (Item i : inventory) {
                    if (i.getName().equals("spider")) {
                        inventory.remove(i);
                    }
                    if (i.getName().equals("rock bowl")) {
                        inventory.remove(i);
                    }
                }
                inventory.add(new Item("trap with bait"));
            }
        }
        if (item1.equals("stick") && item2.equals("string")) {
            for (Item i : inventory) {
                if (i.getName().equals("stick")) {
                    i1 = i;
                }
                if (i.getName().equals("string")) {
                    i2 = i;
                }
            }
            if (i1.getName().equals(" ") || i2.getName().equals(" ")) {
                System.out.println("you dont have those items");
            } else {
                for (Item i : inventory) {
                    if (i.getName().equals("stick")) {
                        inventory.remove(i);
                    }
                    if (i.getName().equals("string")) {
                        inventory.remove(i);
                    }
                }
                inventory.add(new Item("fishingrod"));
            }
        }
    }

    /**
     * hráč si u vchodu u jeskně může podívat na čas
     */
    public void time() {
        if (current.getName().equals("entrance")) {
            System.out.println("it is day " + day);
        } else {
            System.out.println("you are in the wrong room");
        }
    }

    /**
     * hráč si může povidat s npcs ktere jsou v mistnosti
     */
    public void talk() {
        if (current.getNpcs() == null) {
            System.out.println("no one is here");
        } else {
            for (Npc n : current.getNpcs()) {
                if (n.getName().equals("frog")) {
                    System.out.println("ribbit... ribbit");
                }
                if (n.getName().equals("mole")) {
                    if (n.isHasQuest()) {
                        System.out.println("Clumsy and almost blind, dirt sticks to his nose. He works even on Sundays, boring tunnels in the ground. Who is it?");
                        String odpoved = scr.nextLine();
                        if (odpoved.equals("mole") || odpoved.equals("krtek")) {
                            inventory.add(new Item("stick"));
                            System.out.println("correct, here is a stick for you");
                        } else {
                            System.out.println("incorrect");
                        }
                    }
                } else {
                    System.out.println("the mole doesn't want to talk to you because you took his favorite stick");
                }
            }
        }
    }

    /**
     * hráč podle toho v jake mistnosti je tak může použít předmět aby  něco získal
     */
    public void use() {
        System.out.println(inventory);
        System.out.println("which item do you want to use?");
        String itemName = scr.nextLine().toLowerCase();
        Item usedItem = null;
        for (Item i : inventory) {
            if (i.getName().toLowerCase().equals(itemName)) {
                usedItem = i;
                break;
            }
        }
        if (usedItem == null) {
            System.out.println("you don't have such an item");
            return;
        }
        if (current.getName().equals("room with big lake")) {

            if (usedItem.getName().equals("trap with bait")) {
                for (Item i : current.getItems()) {
                    if (i.getName().equals(usedItem.getName())) {
                        current.getItems().remove(i);
                    }
                }
                System.out.println("you set the trap and caught a frog");
                inventory.remove(usedItem);
                Item frog = new Item("frog");
                inventory.add(frog);
                return;
            }

            if (usedItem.getName().equals("fishingrod")) {
                for (Item i : current.getItems()) {
                    if (i.getName().equals(usedItem.getName())) {
                        current.getItems().remove(i);
                    }
                }
                System.out.println("you caught fish with the rod");
                Item fish = new Item("fish");
                inventory.add(fish);
                inventory.add(fish);
                inventory.remove(usedItem);
                return;
            }
        }
        if (current.getName().equals("room with campfire")) {

            if (usedItem.getName().equals("charcoal")) {
                System.out.println("you started a fire and can now cook");
                inventory.remove(usedItem);
                return;
            }

            if (usedItem.getName().equals("fish")) {
                System.out.println("you cooked the fish");
                inventory.remove(usedItem);
                Item cookedFish = new Item("cooked fish");
                cookedFish.setEdible(true);
                inventory.add(cookedFish);
                return;
            }
            if (usedItem.getName().equals("frog")) {
                System.out.println("you cooked the frog");
                inventory.remove(usedItem);
                Item cookedFrog = new Item("cooked frog");
                cookedFrog.setEdible(true);
                inventory.add(cookedFrog);
                return;
            }
        }
        if (current.getName().equals("corridor")) {

            if (usedItem.getName().equals("rock bowl")) {
                System.out.println("you collected water into the bowl");
                inventory.remove(usedItem);
                Item bowlWW = new Item("bowl with water");
                bowlWW.setDrinkable(true);
                inventory.add(bowlWW);
                return;
            }
        }
        System.out.println("you cannot use this item here");
    }
}