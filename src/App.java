import java.util.List;
import java.util.Scanner;

import model.Missile;
import model.Nave;
import view.Display;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Display scene;
    private static Nave player = new Nave(true);
    //private static Nave[][] enemies;
    private static Nave enemy;
    static boolean running = true;

    App() {
        scanner = new Scanner(System.in);
        scene = new Display();
        player = new Nave(true);
        enemy = new Nave(false);
        scene.updateCharacterPosition(enemy);
        scene.updateCharacterPosition(player);
        scene.printScene(player, enemy);
        gaming();
        running = scanner.nextInt() > 0;
    }
    
    public static void main(String[] args) throws Exception {
        new App();
        
        if(running) {
            new App();
        } else scanner.close();
    }

    static void gaming(){
        while(player.getHp() > 0 && enemy.getEnergy() > 0){
            if(player.getHp() > 0) {
                enemy.updateEnemyPosition();
                scene.updateCharacterPosition(enemy);
                controlPlayer();
                scene.updateCharacterPosition(player);
            }
            
            scene.printScene(player, enemy);
        }
    }

    static void controlPlayer() {
        System.out.println("Movimente com as teclas W (cima), A (esquerda), S (baixo) e D (direita)");
        System.out.println("Lance o míssil com a tecla M");
        String input = scanner.next();

        player.control(input);

        List<Missile> missiles = player.getMissiles();
        if(missiles != null && missiles.isEmpty() == false) {
            for (Missile missile : missiles) {
                if(missile.getPosL() == enemy.getPosL() && 
                    missile.getPosC() == enemy.getPosC()) {
                    enemyHit();
                    missile.setActive(false);
                }   
            }
            player.updatePosLMissiles();
        }

    }

    static void enemyHit() {
        enemy.lostEnergy();

        if(enemy.getEnergy() == 0) {
            System.out.println("Você ganhou!");
            running = false;
        }
    }
}
