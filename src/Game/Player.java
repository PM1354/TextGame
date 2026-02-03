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

    public void move(){
        System.out.println("in what direction would u like to move (west, north, east, south)");
        String direction = scr.nextLine();
        direction = direction.toLowerCase();
        if(direction.equals("east")||direction.equals("west")||direction.equals("south")||direction.equals("north")){
            if (direction.equals("north")){
                if(current.getExit("north") == null){
                    System.out.println("zadna mistnost tu neni");
                }else {
                    current = current.getExit("north");
                }
            }
            if (direction.equals("east")){
                if(current.getExit("east") == null){
                    System.out.println("zadna mistnost tu neni");
                }else {
                    current = current.getExit("east");
                }
            }
            if (direction.equals("west")){
                if(current.getExit("west") == null){
                    System.out.println("zadna mistnost tu neni");
                }else {
                    current = current.getExit("west");
                }
            }
            if (direction.equals("south")){
                if(current.getExit("south") == null){
                    System.out.println("zadna mistnost tu neni");
                }else {
                    current = current.getExit("south");
                }
            }
        }else {
            System.out.println("no such direction exists");
        }
    }
    public void sleep(Room current){
        if (!quests.isAteToday() || !quests.isDrankToday()){
            alive = false;
        }
        if (current.getName().equals("room with campfire")){
            day++;
            System.out.println("novy den je tu vsechny questy se ti vyresetovaly");
            quests.setDrankToday(false);
            quests.setAteToday(false);
        }
    }
    public void eat(){
        System.out.println("what item would u like to eat?");
        String itemName = scr.nextLine();
        itemName = itemName.toLowerCase();
        for (Item i : inventory){
            if (i.getName().equals(itemName)){
                if (i.isEdible()) {
                    quests.setAteToday(true);
                    inventory.remove(i);
                }else {
                    System.out.println("this item isnt edible");
                }
            }else {
                System.out.println("this item doesnt exist or u dont have it in inventory");
            }
        }

    }
    public void drink(){
        System.out.println("what item would u like to drink");
        String itemName = scr.nextLine();
        itemName = itemName.toLowerCase();
        for (Item i : inventory){
            if (i.getName().equals(itemName)){
                if (i.isDrinkable()) {
                    quests.setDrankToday(true);
                    inventory.remove(i);
                }else {
                    System.out.println("this item isnt drinkable");
                }
            }else {
                System.out.println("this item doesnt exist or u dont have it in inventory");
            }
        }
    }
    public void store(){
        if(current.getName().equals("room with campfire")){
            System.out.println("muzes si tu ulozit 2 veci");
            System.out.println("jaky item sem chces ulozit (napis cislo podel poradi v inventari)");
            int prikaz = scr.nextInt();
            if(current.getItems().size() ==2){
                System.out.println("uz sem nemuzes nic dat");
            }else{
                if(prikaz == 1){
                    Item item = inventory.remove(0);
                    current.getItems().add(item);
                }
                if(prikaz == 2){
                    Item item = inventory.remove(1);
                    current.getItems().add(item);
                }
                if(prikaz == 3){
                    Item item = inventory.remove(2);
                    current.getItems().add(item);
                }
                if(prikaz == 4){
                    Item item = inventory.remove(3);
                    current.getItems().add(item);
                }
                if(prikaz == 5){
                    Item item = inventory.remove(4);
                    current.getItems().add(item);
                }
                if (prikaz>5||prikaz<1){
                    System.out.println("zadne takove cislo v tvem i nventari neni");
                }
            }

        }else{
            System.out.println("jsi ve spatne mistnosti");
        }
    }
    public void take (){
        System.out.println("jaky predmet chcete odnest (napiste cislo podle vypsani itemu v mistnosti) ");
        int prikaz = scr.nextInt();
        if (inventory.size()<5) {

            if (prikaz == 1) {
                inventory.add(current.getItems().get(0));
            }
            if (prikaz == 2) {
                if (current.getItems().size() != 2) {
                    System.out.println("zadny item na tomto miste tu neni");
                } else {
                    inventory.add(current.getItems().get(1));
                }
            }
            if (prikaz > 2 || prikaz < 1) {
                System.out.println("zadny item na tomto miste tu neni");
            }
        }else {
            System.out.println("vic toho nepoberes");
        }
    }
    public void combine(){
        if (inventory.size() <2){
            System.out.println("z 1 itemu nic neudelas");
        }
        Item i1 = new Item(" ");
        Item i2 = new Item(" ");
        System.out.println("jake 2 itemy chces zkombinovat");
        String item1 = scr.nextLine();
        String item2 = scr.nextLine();
        item1 = item1.toLowerCase();
        item2 = item2.toLowerCase();
        if (item1.equals("spider")&&item2.equals("rock bowl")){
            for (Item i : inventory){
                if(i.getName().equals("spider")){
                    i1 = i;
                }
                if (i.getName().equals("rock bowl")){
                    i2 = i;
                }
            }
            if(i1.getName().equals(" ")||i2.getName().equals(" ")){
                System.out.println("you dont have that items");
            }else{
                for (Item i : inventory){
                    if (i.getName().equals("spider")){
                        inventory.remove(i);
                    }
                    if (i.getName().equals("rock bowl")){
                        inventory.remove(i);
                    }
                }
                inventory.add(new Item("trap with bait"));
            }
        }
        if (item1.equals("stick")&&item2.equals("string")){
            for (Item i : inventory){
                if(i.getName().equals("stick")){
                    i1 = i;
                }
                if (i.getName().equals("string")){
                    i2 = i;
                }
            }
            if(i1.getName().equals(" ")||i2.getName().equals(" ")){
                System.out.println("you dont have that items");
            }else{
                for (Item i : inventory){
                    if (i.getName().equals("stick")){
                        inventory.remove(i);
                    }
                    if (i.getName().equals("string")){
                        inventory.remove(i);
                    }
                }
                inventory.add(new Item("fishingrod"));
            }
        }
    }
    public void time(){
        if(current.getName().equals("entrance")){
            System.out.println("je "+day+" den");
        }else{
            System.out.println("jsi ve spatne mistnosti");
        }
    }
    public void talk(){
        if (current.getNpcs() == null){
            System.out.println("neni tu nikdo");
        }else {
            for (Npc n : current.getNpcs()) {
                if (n.getName().equals("frog")) {
                    System.out.println("kvak... kvak");
                }
                if (n.getName().equals("mole")){
                    if (n.isHasQuest()){
                        System.out.println("Nemotora skoro slepý, hlína se mu na nos lepí.Pracuje i v neděli, razí v zemi tunely.Kdo je to?");
                        String odpoved = scr.nextLine();
                        if (odpoved.equals("krtek")){
                            inventory.add(new Item("klacek"));
                            System.out.println("spravne, na tu mas klacek");
                        }else {
                            System.out.println("spatne");
                        }
                    }
                }else {
                    System.out.println("krtek s tebou nechce mluvit protoze si mu sebral oblibeny klacek");
                }
            }
        }
    }


}
