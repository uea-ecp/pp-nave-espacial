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
    }
    
    public static void main(String[] args) throws Exception {
        // initialize
        new App();
        
        while(running) {
            gaming();
            running = scanner.nextInt() > 0;
        }
        
        scanner.close();
    }

    static void gaming(){
        while(player.getEnergy() > 0 && enemy.getEnergy() > 0){
            scene.printScoreboard(player.getHp(), player.getEnergy());
            scene.updateCharacterPosition(enemy);
            scene.updateCharacterPosition(player);
            
            scene.printScene();
            controlPlayer();
        }
    }

    static void controlPlayer() {
        System.out.println("Movimente com as teclas W (cima), A (esquerda), S (baixo) e D (direita)");
        System.out.println("Lance o míssil com a tecla M");
        String input = scanner.next();

        player.control(input);

        List<Missile> missiles = player.getMissiles();
        if(missiles != null && missiles.isEmpty() == false) {
            player.updatePosLMissiles();

            for (Missile missile : missiles) {
                if(missile.getPosL() == enemy.getPosL() && 
                    missile.getPosC() == enemy.getPosC()) {
                    enemyHit();
                    missile.setActive(false);
                }   
            }
        }



        if(player.getPosL() == enemy.getPosL() && 
            player.getPosC() == enemy.getPosC()) {
            colision();
        }
    }
    
    static void colision() {
        player.lostHp();
        
        if(player.getHp() == 0) {
            System.out.println("Você perdeu!");
            running = false;
            return;
        }
    }

    static void enemyHit() {
        enemy.lostHp();

        if(enemy.getEnergy() == 0) {
            System.out.println("Você ganhou!");
            running = false;
        }

        
    }
}
