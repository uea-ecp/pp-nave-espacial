package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.Display;

public class Nave extends EntidadeAbstract {
    List<Missile> missiles;
    private int energy;

    // lamina de occam
    public Nave(boolean type) {
        int value = Display.getSizeScene()/2;

        if(type) {
            setSprite("🚀");
            missiles = new ArrayList<Missile>();
            randomPosition(value+1, Display.getSizeScene());
            setHp(3);
        } else {
            randomPosition(0, value);
            setSprite("🛸");
            setEnergy(100);
        }
    }

    /* Random position of according with scene limit size */
    public void randomPosition(int min, int max) {
        setPosL(random(min, max));
        setPosC(random(min, max));
    }
    
    /* Random value with scene limit size */
    public int random(int value) {
        return (new Random()).nextInt(value) + 1;
    }

    public int random(int min, int max) {
        return (new Random()).nextInt(max + 1 - min) + min;
    }

    /* Movimentação mais fluida com posicao +1 ou -1 */

    public void shoot() {
        Missile missile = new Missile();
        missile.setPosC(getPosC());
        missile.setPosL(getPosL());
        missiles.add(missile);
    }

    public List<Missile> getMissiles() {
        return this.missiles;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
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
                missile.moveMissile(missile.getPosL());  
            }
        }
    }

    public void updateEnemyPosition() {
        int posActualL = getPosL();
        int posActualC = getPosC();

        int posRandom = random(4);
        
        /* 
         * 0 - Cima
         * 1 - Direita
         * 2 - Baixo
         * 3 - Esquerda
         */
        if(posRandom == 0) {
            setPosL(posActualL-1);
        }
        if(posRandom == 1) {
            setPosC(posActualC-1);
        }

        if(posRandom == 2) {
            setPosL(posActualL+1);
        }
        
        if(posRandom == 3) {
            setPosC(posActualC+1);
        }

        // teletransporta
        if(getPosC() == getOldPosC() && getOldPosL() == getPosL()) {
            setSprite("🌀");
            randomPosition(0, Display.getSizeScene());
        } else {
            setSprite("🛸");
        }

        setOldPosC(posActualC);
        setOldPosL(posActualL);
    }

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

    public void lostHp() {
        setHp(getHp() - 1);
    }

    public void lostEnergy() {
        setEnergy(getEnergy()-10);
    }
}
