package Game;

public class Quests {
    private boolean ateToday = false;
    private boolean drankToday = false;
    private boolean sleptToday = false;

    public boolean isSleptToday() {
        return sleptToday;
    }

    public void setSleptToday(boolean sleptToday) {
        this.sleptToday = sleptToday;
    }

    public boolean isDrankToday() {
        return drankToday;
    }

    public void setDrankToday(boolean drankToday) {
        this.drankToday = drankToday;
    }

    public boolean isAteToday() {
        return ateToday;
    }

    public void setAteToday(boolean ateToday) {
        this.ateToday = ateToday;
    }

    @Override
    public String toString() {
        return "jsi najedeny: " + ateToday + " jsi napity: " + drankToday + " jsi vyspany: " + sleptToday;
    }
}
