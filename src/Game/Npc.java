package Game;

public class Npc {
    private String name;
    private boolean hasQuest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasQuest() {
        return hasQuest;
    }

    public void setHasQuest(boolean hasQuest) {
        this.hasQuest = hasQuest;
    }

    public Npc(String name, boolean hasQuest) {
        this.name = name;
        this.hasQuest = hasQuest;
    }

    public void talk(){}
}
