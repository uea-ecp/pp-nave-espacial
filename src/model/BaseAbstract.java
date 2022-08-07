package model;

/* *
 * @authors: Daniela Ferreira e Matheus 
 * This class implemments the base to 'Naves'
 */
abstract class BaseAbstract implements BaseInterface {
    private int posX;
    private int posY;
    private String sprite;

    public abstract void move();

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
