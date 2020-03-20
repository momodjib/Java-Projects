package Stage4;

public class DecisionMaker {
    SortingToolTemplate template;
    String sortingType = "natural";


    public void processArgs(String[] args) {
        String dataType = "word";

        for (int i = 0; i <= args.length-1; i++) {
            if (args[i].contains("-sortingType")) {
                sortingType = args[i+1];
                break;
            }
        }

        for (int i = 0; i <= args.length-1; i++) {
            if (args[i].contains("-dataType")) {
                dataType = args[i+1];
                break;
            }
        }
        pick(dataType);
    }

    public void setTemplate(SortingToolTemplate template) {
        this.template = template;
    }

    public void pick(String type) {
        switch (type) {
            case "word":
                setTemplate(new WordSort());
                break;
            case "long":
                setTemplate(new LongSort());
                break;
            case "line":
                setTemplate(new LineSort());
                break;
            case "integer":
                setTemplate(new IntegerSort());
        }
        template.showResult(sortingType);
    }
}