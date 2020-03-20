package Stage6;

import java.io.IOException;

public class DecisionMaker {
    SortingToolTemplate template;
    String sortingType = "natural";
    String inputFile = "";
    String outputFile = "";


    public void processArgs(String[] args) throws IOException {
        String dataType = "word";

        for (int i = 0; i <= args.length-1; i++) {

            if (args[i].contains("-sortingType")) {
                if( args.length < i+2 || !args[i+1].equals("natural") && !args[i+1].equals("byCount")){
                    System.out.println("No sorting type defined!");
                    return;
                }
                else{
                    sortingType = args[i+1];
                }
            }
            else if (args[i].contains("-dataType")) {

                if( args.length < i+2 || !args[i+1].equals("word") && !args[i+1].equals("line") && !args[i+1].equals("long")){
                    System.out.println("No data type defined!");
                    return;
                }
                else{
                    dataType = args[i+1];
                }
            }
            else if(args[i].contains("-inputFile")){
                inputFile = args[i+1];
            }
            else if(args[i].contains("-outputFile")){
                outputFile = args[i+1];
            }
            else if(args[i].matches("-\\w+")){
                System.out.println(args[i] + " isn't a valid parameter. It's skipped.");
            }

        }
        pick(dataType,inputFile,outputFile);
    }

    public void setTemplate(SortingToolTemplate template) {
        this.template = template;
    }

    public void pick(String dataType,String inputFile,String outputFile) throws IOException {
        switch (dataType) {
            case "word":
                setTemplate(new WordSort());
                break;
            case "long":
                setTemplate(new LongSort());
                break;
            case "line":
                setTemplate(new LineSort());
                break;
        }
        template.showResult(sortingType, inputFile, outputFile);
    }
}