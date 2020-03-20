package Stage4.Main;

import Stage4.DecisionMaker;

public class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //args = new String[]{"java","SortingTool","-sortingType","byCount","-dataType","line"};
        DecisionMaker picker = new DecisionMaker();
        picker.processArgs(args);
    }
}