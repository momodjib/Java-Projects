package Stage5.Main;

import Stage6.DecisionMaker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DecisionMaker picker = new DecisionMaker();
        picker.processArgs(args);
    }
}