package model;

public class Missile extends NaveAbstract {
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

    @Override
    public void randomPosition(int value) {}

    @Override
    public int random(int value) { return 0; }
}
