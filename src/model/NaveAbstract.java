package model;

/* *
 * This class implemments the base to 'Naves'
 */
abstract class NaveAbstract implements NaveInterface {
    private final static int SizeScene = 10;
    private int posL;
    private int posC;
    private int oldPosL;
    private int oldPosC;
    private String sprite;
    private int hp;
    private int energy;

    public abstract void randomPosition();
    public abstract int random();
    public abstract void control(String command);
    public abstract void lostHp();
    public abstract void lostEnergy();

    public int getOldPosL() {
        return oldPosL;
    }

    public void setOldPosL(int oldPosX) {
        this.oldPosL = oldPosX;
    }

    public int getOldPosC() {
        return oldPosC;
    }

    public void setOldPosC(int oldPosY) {
        this.oldPosC = oldPosY;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getPosC() {
        return posC;
    }

    public void setPosC(int pos) {
        if(pos < SizeScene && pos >= 0) {
            this.posC = pos;
        }
    }

    public int getPosL() {
        return posL;
    }

    public void setPosL(int pos) {
        if(pos < SizeScene && pos >= 0) {
            this.posL = pos;
        }
    }
}
