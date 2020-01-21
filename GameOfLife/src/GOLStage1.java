import java.util.Random;
import java.util.Scanner;

public class GOLStage1 {
    private static Scanner scanner = new Scanner(System.in);

    private static void generateGame(int size, int seed){
        Random random = new Random(seed);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        generateGame(n,s);
    }
}
