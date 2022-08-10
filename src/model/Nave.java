package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.Display;

public class Nave extends NaveAbstract {
    List<Missile> missiles;

    // lamina de occam
    public Nave(boolean type) {
        if(type) {
            setSprite("🚀");
            missiles = new ArrayList<Missile>();
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
        Missile missile = new Missile();
        missile.setPosC(getPosC());
        missile.setPosL(getPosL()+1);
        missiles.add(missile);
    }

    public List<Missile> getMissiles() {
        return this.missiles;
    }

    public List<Missile> getMissilesActives() {
        List<Missile> actives = new ArrayList<Missile>();

        if(missiles != null) {
            for (Missile missile : missiles) {
                if(missile.getActive()) {
                    actives.add(missile);
                } 
            }
        }

        return actives;
    }

    public void updatePosLMissiles() {
        for (Missile missile : missiles) {
            if(missile.getPosL() == 0) {
                missile.setActive(false);
            } else {
                missile.setOldPosL(missile.getPosL());   
                missile.setPosL(missile.getPosL());  
            }
        }
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
