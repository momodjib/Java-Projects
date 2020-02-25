package Stage3;

public class DecisionMaker {
    SortingToolTemplate template;

    public void processArgs(String[] args) {
        String type = "word";
        boolean isSortInteger = false;
        for (String arg : args) {
            if (arg.contains("-sortIntegers")) {
                type = "integer";
                isSortInteger = true;
                break;
            }
        }
        if (!isSortInteger) {
            for (int i = 0; i <= args.length-1; i++) {
                if (args[i].contains("-dataType")) {
                    type = args[i+1];
                    break;
                }
            }
        }
        pick(type);
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
        template.getData();
    }
}
