package Stage5;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LineSort extends SortingToolTemplate<String> {
    ArrayList<String> data = new ArrayList<>();
    Map<String, Integer> dataByCount = new TreeMap<>();

    @Override
    public void getData() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            data.add(s.nextLine());
        }
        data.sort(String.CASE_INSENSITIVE_ORDER);
        sortDataByOccurrence();
    }

    public void showResult(String sortingType) {
        showResult(sortingType, data, dataByCount, "line");
    }

    public void sortDataByOccurrence(){
        for (String s : data) {
            if (dataByCount.containsKey(s)){
                dataByCount.put(s,dataByCount.get(s)+1);
            }
            else{
                dataByCount.put(s,1);
            }
        }
    }

}