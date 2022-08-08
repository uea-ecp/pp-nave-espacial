package model;

/* *
 * @authors: Daniela Ferreira e Matheus 
 * This interface implemments the base to 'Naves'
 */
public interface NaveInterface {
    int posX = 0;
    int posY = 0;
    int oldPosX = 0;
    int oldPosY = 0;
    int energy = 100;
    int hp = 3;
    String sprite = "";

    void lostHp();
    void randomPosition();
    int random();
    void move(boolean order);
}
