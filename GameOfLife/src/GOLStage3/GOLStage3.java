package GOLStage3;

import GOLStage2.GenerationMaker;

import java.util.Random;
import java.util.Scanner;

public class GOLStage3 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] currentGeneration;
    private static GenerationMaker game = new GenerationMaker();
    private static int generationNumber = 1;

    private static void startGame(int size){
        currentGeneration = new String[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    currentGeneration[i][j] = "O";
                } else {
                    currentGeneration[i][j] = " ";
                }
            }
        }
        for (int i = 1; i <= 10; i++) {
            currentGeneration = game.nextGeneration(currentGeneration);
            showResult();
            clrscrn();
        }

    }

    public static void showResult(){
        System.out.println("Generation #"+generationNumber++);
        System.out.println("Alive: "+totalAliveCells());

        for (int i = 0; i < currentGeneration.length; i++) {
            for (int j = 0; j < currentGeneration.length; j++) {
                System.out.print(currentGeneration[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalAliveCells(){
        int total = 0;
        for (int i = 0; i < currentGeneration.length; i++) {
            for (int j = 0; j < currentGeneration.length; j++) {
                if(currentGeneration[i][j].equals("O")){
                    total++;
                }
            }
        }
        return total;
    }

    public static void clrscrn(){
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }

    }
    public static void main(String[] args) {
//        int n = scanner.nextInt();
        startGame(10);
    }
}