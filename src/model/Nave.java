package model;

import java.util.Random;

import view.Display;

public class Nave extends NaveAbstract {
    private int shootPosC;
    private int shootPosL;

    // lamina de occam
    public Nave(boolean type) {
        if(type) {
            setSprite("🚀");
        } else setSprite("🛸");

        setEnergy(100);
        setHp(3);

        randomPosition();
    }

    /* Random position of according with scene limit size */
    public void randomPosition() {
        setPosL(random());
        setPosC(random());
    }
    
    /* Random value with scene limit size */
    public int random() {
        return (new Random()).nextInt(Display.getSizeScene());
    }

    public void shoot() {
        setShootPosC(getPosC());
        setShootPosL(getPosL()-1);
    }

    public int getShootPosC() {
        return shootPosC;
    }

    public void setShootPosC(int shootPosX) {
        this.shootPosC = shootPosX;
    }

    public int getShootPosL() {
        return shootPosL;
    }

    public void setShootPosL(int shootPosY) {
        this.shootPosL = shootPosY;
    }

    /* Implemments from abstract methods */
    @Override
    public void control(String command) {
        int posActualL = getPosL();
        int posActualC = getPosC();

        // movimenta no sentido negativo dos eixos
        if(command.equals("w") || command.equals("W")) {
            setPosL(posActualL-1);
        }
        if(command.equals("a") || command.equals("A")) {
            setPosC(posActualC-1);
        }

        if(command.equals("s") || command.equals("S")) {
            setPosL(posActualL+1);
        }
        
        // movimenta no sentido positivo dos eixos
        if(command.equals("d") || command.equals("D")) {
            setPosC(posActualC+1);
        }

        if(command.equals("m") || command.equals("M")) {
            // lança míssil
            shoot();
        }

        setOldPosC(posActualC);
        setOldPosL(posActualL);
    }

    @Override
    public void lostHp() {
        setHp(getHp() - 1);
    }

    @Override
    public void lostEnergy() {
        setEnergy(getEnergy()-10);
        
        if(getEnergy() == 0) {
            setSprite("💥");
        }
    }
}
