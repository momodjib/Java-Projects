package sorting;

public class DecisionMaker {
    SortingToolTemplate template;

    public void processArgs(String[] args) {
        String type = "word";
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-dataType")) {
                type = args[i].substring(10);
                break;
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
        }
        template.getData();
    }
}
