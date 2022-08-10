package view;

import java.util.Arrays;
import java.util.List;

import model.Missile;
import model.Nave;

/* *
 * This class implemments the game graphics
 */
public class Display {
    private final static int SizeScene = 10;
    private final static String Separator = " ";

    private static String scene[][];

    // renderize the inicial scene
    public Display() {
        scene = new String[SizeScene][SizeScene];

        for (int i = 0; i < SizeScene; i++) {
            for (int j = 0; j < SizeScene; j++) {
                scene[i][j] = Separator;
            }
        }
    }

    // set position X and Y from character
    public void updateCharacterPosition(Nave character) {
        if (character.getOldPosC() != character.getPosC() ||
            character.getOldPosL() != character.getPosL()) {
            scene[character.getPosL()][character.getPosC()] = character.getSprite();
            scene[character.getOldPosL()][character.getOldPosC()] = Separator;
        }

        List<Missile> missiles = character.getMissiles();

        if(missiles != null && missiles.isEmpty() == false) {
            for (Missile missile : missiles) {
                if (missile.getOldPosL() != missile.getPosL()
                    && missile.getPosL() >= 0 && missile.getPosL() < SizeScene) {
                    if(scene[missile.getPosL()][missile.getPosC()] == Separator) {
                        scene[missile.getPosL()][missile.getPosC()] = missile.getSprite();
                    }
                    
                    if (missile.getOldPosL() != character.getPosL()) {
                        scene[missile.getOldPosL()][missile.getPosC()] = Separator;
                    }

                    if(missile.getActive() == false && 
                        scene[missile.getPosL()][missile.getPosC()] == missile.getSprite()) {
                        scene[missile.getPosL()][missile.getPosC()] = Separator;
                    }
            }
        }
    }
    }

    public void printScene(Nave player, Nave enemy) {
        System.out.println("┍--------------------┒");
        
        for (int i = 0; i < SizeScene; i++) {
            System.out.print("|");

            for (int j = 0; j < SizeScene; j++) {
                System.out.print(scene[i][j]);

                if((j == SizeScene - 1) && (player.getPosL() == i
                    || enemy.getPosL() == i)) {
                    System.out.print("");
                } else System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }

        System.out.println("┖--------------------┙");
    }

    public void printScoreboard(int hp, int energy) {
        System.out.print("Vidas       ");

        for (int i = 0; i < hp; i++) {
            System.out.print(" 💚");
        }

        System.out.println("\nEnergia       " + energy);
    }

    public String[][] getScene() {
        return scene;
    }

    public static int getSizeScene() {
        return SizeScene;
    }
}
