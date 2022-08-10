package model;

public class Missile {
    private final static int SizeScene = 10;
    private boolean active;
    private String sprite;
    private int posL;
    private int posC;
    private int oldPosL;

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

    public int getPosC() {
        return posC;
    }

    public boolean getActive() {
        return active;
    }

    public void setPosC(int pos) {
        this.posC = pos;
    }

    public int getPosL() {
        return posL;
    }

    public void setPosL(int pos) {
        if(pos < SizeScene && pos >= 0) {
            this.posL = pos - 1;
        }
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getOldPosL() {
        return oldPosL;
    }

    public void setOldPosL(int pos) {
        this.oldPosL = pos;
    }
}
