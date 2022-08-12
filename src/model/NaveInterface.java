package model;

/* *
 * @authors: Daniela Ferreira e Matheus 
 * This interface implemments the base to 'Naves'
 */
public interface NaveInterface {
    int posL = 0;
    int posC = 0;
    int oldPosL = 0;
    int oldPosC = 0;
    String sprite = "";

    void randomPosition(int value);
    int random(int value);
}
