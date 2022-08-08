import java.util.Scanner;

import model.Nave;
import view.Display;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Display scene;
    private static Nave player = new Nave(true);
    private static Nave[][] enemies;
    private static Nave enemy;

    App() {
        scanner = new Scanner(System.in);
        scene = new Display();
        player = new Nave(true);
        enemy = new Nave(false);
    }
    
    public static void main(String[] args) throws Exception {
        // initialize
        new App();
        scene.updateCharacterPosition(player);
        scene.updateCharacterPosition(enemy);

        while(scanner.nextInt() > 0) {
            // "clean"
            System.out.print("\033[H\033[2J");  

            displayPoints();
            scene.printScene();
            gaming();
        }

        scanner.close();
    }

    static void gaming(){
        while(player.getEnergy() > 0 && enemy.getEnergy() > 0){
            scene.updateCharacterPosition(player);
            scene.updateCharacterPosition(enemy);
            scene.printScene();
        }

    }

    static void displayPoints() {
        System.out.println("Vidas       💚 💚 💚");
        System.out.println("Energia       100%");
    }
}
