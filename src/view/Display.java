package view;

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
        for (int i = 0; i < SizeScene; i++) {
            if(i == character.getPosX()) {
                for (int j = 0; j < SizeScene; j++) {
                    if(j == character.getPosY()) {
                        scene[i][j] = character.getSprite();
                    }
                }
            }

            if (i == character.getOldPosX()) {
                for (int j = 0; j < SizeScene; j++) {
                    if(j == character.getOldPosY()) {
                        scene[i][j] = Separator;
                    }
                }
            }
        }
    }

    public void printScene() {
        System.out.println("______________________");
        for (String[] line : scene) {
            System.out.print("|");
            for (String item : line) {
                System.out.print(item + " ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("______________________");
    }

    public void printScoreboard(int hp, int energy) {
        System.out.print("Vidas       ");
        
        for (int i = 0; i <= hp; i++) {
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
