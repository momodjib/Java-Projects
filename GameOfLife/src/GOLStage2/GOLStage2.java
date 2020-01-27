package GOLStage2;

import java.util.Random;
import java.util.Scanner;

public class GOLStage2 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] currentGeneration;
    private static GenerationMaker game = new GenerationMaker();

    private static void startGame(int size, int seed, int depth){
        currentGeneration = new String[size][size];
        Random random = new Random(seed);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    currentGeneration[i][j] = "O";
                } else {
                    currentGeneration[i][j] = " ";
                }
            }
        }
        for (int i = 1; i <= depth; i++) {
            currentGeneration = game.nextGeneration(currentGeneration);
            showResult();
        }

    }

    public static void showResult(){
        for (int i = 0; i < currentGeneration.length; i++) {
            for (int j = 0; j < currentGeneration.length; j++) {
                System.out.print(currentGeneration[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        startGame(n,s,m);
    }
}
