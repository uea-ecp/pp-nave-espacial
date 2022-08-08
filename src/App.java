import java.util.Scanner;

import model.Nave;
import view.Display;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Display scene;
    private static Nave player = new Nave(true);
    private static Nave[][] enemies;
    private static Nave enemy;
    static boolean running = true;

    App() {
        scanner = new Scanner(System.in);
        scene = new Display();
        player = new Nave(true);
        enemy = new Nave(false);
    }
    
    public static void main(String[] args) throws Exception {
        // initialize
        new App();
        
        while(running) {
            // "clean"
            System.out.print("\033[H\033[2J");  

            scene.updateCharacterPosition(enemy);
            scene.updateCharacterPosition(player);

            gaming();
            running = scanner.nextInt() > 0;
        }
        
        scanner.close();
    }

    static void gaming(){
        while(player.getEnergy() > 0 && enemy.getEnergy() > 0){
            scene.printScoreboard(player.getHp(), player.getEnergy());
            
            

            scene.printScene();
            controlPlayer();


        }
    }

    static void controlPlayer() {
        System.out.println("Movimente com as teclas W (cima), A (esquerda), S (baixo) e D (direita)");
        System.out.println("Lance o míssil com a tecla M");
        String input = scanner.next();
        System.out.println(input);
        if(input.equals("w") || input.equals("W")
        || input.equals("a") || input.equals("A")) {
            // movimenta no sentido negativo dos eixos
            player.move(false);
            System.out.println("Foi W ou A");
        }

        if(input.equals("s") || input.equals("S")
        || input.equals("d") || input.equals("D")) {
            // movimenta no sentido positivo dos eixos
            player.move(true);
            System.out.println("Foi S ou D");
        }

        if(input.equals("m") || input.equals("M")) {
            // lança míssil
            System.out.println("Atira míssil");
        }

        scene.updateCharacterPosition(player);

        scene.printScene();
    }
    
    static int colision() {
        if(player.getPosX() == enemy.getPosX() && 
            player.getPosY() == enemy.getPosY()) {
                player.lostHp();
        }

        return player.getHp();
    }
}
