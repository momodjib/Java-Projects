package Stage3.Main;

import Stage3.DecisionMaker;

public class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //args = scanner.nextLine().split(" ");
        DecisionMaker picker = new DecisionMaker();
        picker.processArgs(args);
    }
}