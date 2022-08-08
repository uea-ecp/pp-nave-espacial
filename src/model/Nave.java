package model;

import java.util.Random;

import view.Display;

public class Nave extends NaveAbstract {

    // lamina de occam
    public Nave(boolean type) {
        if(type) {
            setSprite("🚀");
        } else setSprite("🛸");

        randomPosition();
    }

    /* Random position of according with scene limit size */
    public void randomPosition() {
        setPosX(random());
        setPosY(random());
    }
    
    /* Random value with scene limit size */
    public int random() {
        return (new Random()).nextInt(Display.getSizeScene());
    }

    /* Implemments from abstract methods */
    @Override
    public void move(boolean order) {
        int posActualX = getPosX();
        int posActualY = getPosY();

        if(posActualX > 0 && posActualX < 10 && order) {
            setPosX(posActualX++);
        } else setPosX(posActualX--);
        
        if(posActualY > 0 && posActualY < 10 && order) {
            setPosY(posActualY++);
        } else setPosY(posActualY--);
        
        setOldPosX(posActualX);
        setOldPosY(posActualY);
    }

    @Override
    public void lostHp() {
        setHp(getHp()-1);
    }
}
