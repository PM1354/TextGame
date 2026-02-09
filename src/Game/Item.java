package Game;

public class Item {
    private String name;
    private boolean edible= false;
    private boolean drinkable = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "item "+ name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public boolean isDrinkable() {
        return drinkable;
    }

    public void setDrinkable(boolean drinkable) {
        this.drinkable = drinkable;
    }

    public Item(String name, boolean edible, boolean drinkable) {
        this.name = name;
        this.edible = edible;
        this.drinkable = drinkable;
    }
}
