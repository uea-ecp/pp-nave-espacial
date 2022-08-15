package view;

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

            scene[character.getOldPosL()][character.getOldPosC()] = Separator;
            scene[character.getPosL()][character.getPosC()] = character.getSprite();

            /* if(scene[character.getOldPosL()][character.getOldPosC()] == character.getSprite()) {
            } */
        }

        List<Missile> missiles = character.getMissiles();

        if(missiles != null && missiles.isEmpty() == false) {

            for (Missile missile : missiles) {

                // está em nova posicao
                if (missile.getOldPosL() != missile.getPosL()
                    && missile.getPosL() >= 0 && missile.getPosL() < SizeScene) {

                    // se celula vazia, seta o missel nela
                    if(scene[missile.getPosL()][missile.getPosC()] == Separator) {
                        scene[missile.getPosL()][missile.getPosC()] = missile.getSprite();
                    }

                    if(missile.getPosL() == character.getPosL() && 
                        missile.getPosC() == character.getPosC()) {
                        character.lostEnergy();

                        if(character.getEnergy() == 0) {
                            System.out.println("Você ganhou!");
                            return;
                        }
                        
                        missile.setActive(false);
                    }   
                    
                    // se houve colisão nessa celula, limpa
                    /* if(scene[missile.getOldPosL()][missile.getOldPosC()] == "💥") {
                        scene[missile.getOldPosL()][missile.getOldPosC()] = Separator;
                    } */

                    if(scene[missile.getPosL()][missile.getPosC()] == missile.getSprite()) {
                        if (missile.getOldPosL() != character.getPosL()) {
                            scene[missile.getOldPosL()][missile.getPosC()] = Separator;
                        }

    
                        if(missile.getActive() == false) {
                            scene[missile.getPosL()][missile.getPosC()] = Separator;
                        }
                    }
            }
        }
    }
    }

    public void updateOldPosition(Nave player, Nave enemy) {
        if(scene[player.getOldPosL()][player.getOldPosC()] == player.getSprite()) {
            scene[player.getOldPosL()][player.getOldPosC()] = Separator;
        }
    }

    public void printScene(Nave player, Nave enemy) {
        // exibe placar

        if(scene[player.getOldPosL()][player.getOldPosC()] == "💥") {
            scene[player.getOldPosL()][player.getOldPosC()] = Separator;
        }

        if(player.getPosL() == enemy.getPosL() && 
            player.getPosC() == enemy.getPosC()) {
            player.lostHp();
            scene[player.getPosL()][player.getPosC()] = "💥";
        }
        
        printScoreboard(player.getHp(), enemy.getEnergy());

        System.out.println("┍--------------------┒");
        
        for (int i = 0; i < SizeScene; i++) {
            System.out.print("|");

            for (int j = 0; j < SizeScene; j++) {
                System.out.print(scene[i][j]);
                /* if(player.getPosL() == enemy.getPosL() && 
                player.getPosC() == enemy.getPosC() && 
                i == player.getPosL() && j == player.getPosC()) {
                    System.out.print("💥");
                } else System.out.print(scene[i][j]); */

                if(j == enemy.getOldPosC() && i == enemy.getOldPosL() && hasAnyMissileInPos(player.getMissilesActives(), enemy.getPosL() , enemy.getPosC())) {
                    System.out.print("💥");
                }// else System.out.print(scene[i][j]);

                if(j == player.getPosC() && i == player.getPosL() 
                || j == enemy.getPosC() && i == enemy.getPosL() 
                || hasAnyMissileInPos(player.getMissilesActives(), i , j)) {
                    System.out.print("");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.print("\n");
        }

        System.out.println("┖--------------------┙");

        if(player.getHp() == 0) {
            System.out.println("\nVocê perdeu! Deseja jogar de novo?");
            System.out.println("(1) Sim \n(0) Não");
        }
    }

    public boolean hasAnyMissileInPos(List<Missile> missiles, final int i, final int j){
        return missiles.stream().anyMatch(o -> o.getPosL() == i && o.getPosC() == j);
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

    public void enemyHit(Nave enemy) {
        scene[enemy.getPosL()][enemy.getPosC()] = "💥";
    }
}
