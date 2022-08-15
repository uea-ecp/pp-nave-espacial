package model;

public class Missile extends EntidadeAbstract {
    private boolean active;

    // lamina de occam
    public Missile() {
        active = true;
        setSprite(" ❖");
    }

    /* Getters and Setters */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public void moveMissile(int pos) {
        setPosL(pos - 1);
    }

    public void randomPosition(int min, int max) {}

    public int random(int value) { return 0; }
}
