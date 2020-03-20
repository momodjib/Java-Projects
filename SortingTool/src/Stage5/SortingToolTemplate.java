package Stage5;

import java.util.ArrayList;
import java.util.Map;

public abstract class SortingToolTemplate<G> {

    public abstract void getData();

    abstract void showResult(String sortingType);

    public int getPercentage(Integer value, Integer size) {
        return value * 100 / size;
    }

    public void showResult(String sortingType, ArrayList<G> data, Map<G, Integer> dataByCount, String dataType)  {
        boolean isOver = false;
        G key = null;
        getData();

        if (sortingType.equals("byCount")){

            if(dataType.equals("line")){
                System.out.println("Total lines: " + data.size() + ".");
            }
            else if(dataType.equals("word")){
                System.out.println("Total words: " + data.size() + ".");
            }
            else if(dataType.equals("long")){
                System.out.println("Total numbers: " + data.size() + ".");
            }

            while(!isOver){
                if(dataByCount.isEmpty()){
                    isOver = true;
                }
                else{
                    for (Map.Entry<G ,Integer> entry : dataByCount.entrySet()) {
                        int minOcc = getMinOccurrence(dataByCount);
                        if (entry.getValue() == minOcc){
                            System.out.println(entry.getKey() + ": "+ entry.getValue() + " time(s), "+ getPercentage(entry.getValue(),data.size())+"%");
                            key = entry.getKey();
                            break;
                        }
                    }
                    dataByCount.remove(key);
                }
            }
        }
        else {
            if (dataType.equals("line")){
                System.out.println("Total lines: " + data.size() + ".");
                System.out.println("Sorted data: " );
                for (G s : data) {
                    System.out.println(s + " ");
                }
            }
            else if(dataType.equals("word")){
                System.out.println("Total words: " + data.size() + ".");
                System.out.print("Sorted data: " );
                for (G s : data) {
                    System.out.print(s + " ");
                }
            }
            else if(dataType.equals("long")){
                System.out.println("Total numbers: " + data.size() + ".");
                System.out.print("Sorted data: " );
                for (G s : data) {
                    System.out.print(s + " ");
                }
            }

        }
    }

    public int getMinOccurrence(Map<G, Integer> dataByCount) {
        int minOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<G ,Integer> entry : dataByCount.entrySet()) {
            if (entry.getValue() < minOccurrence ) {
                minOccurrence = entry.getValue();
            }
        }
        return minOccurrence;
    }
}