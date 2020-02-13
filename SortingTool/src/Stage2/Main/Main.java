package Stage2.Main;

import Stage2.DecisionMaker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        args = scanner.nextLine().split(" ");
        DecisionMaker picker = new DecisionMaker();
        picker.processArgs(args);
    }
}