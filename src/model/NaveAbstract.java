package model;

/* *
 * This class implemments the base to 'Naves'
 */
abstract class NaveAbstract implements NaveInterface {
    private int posX;
    private int posY;
    private int oldPosX;
    private int oldPosY;
    private String sprite;
    private int hp;
    private int energy;

    public abstract void randomPosition();
    public abstract int random();
    public abstract void move(boolean order);
    public abstract void lostHp();

    public int getOldPosX() {
        return oldPosX;
    }

    public void setOldPosX(int oldPosX) {
        this.oldPosX = oldPosX;
    }

    public int getOldPosY() {
        return oldPosY;
    }

    public void setOldPosY(int oldPosY) {
        this.oldPosY = oldPosY;
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

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    
}
