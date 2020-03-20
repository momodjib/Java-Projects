package Stage4;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LineSort extends SortingToolTemplate {
    ArrayList<String> data = new ArrayList<>();
    Map<String, Integer> dataByCount = new TreeMap();


    @Override
    public String getMax() {
        String max = "";
        for (String s : data) {
            if (s.length() > max.length()) {
                max = s;
            } else if (s.length() == max.length()) {
                max = lexicographicSort(max, s);
            }
        }
        return max; //what about same length for many lines ?
    }

    @Override
    public int getMaxOccurrence() {
        int occurrence = 0;
        for (String s : data) {
            if (s.equals(this.getMax())) {
                occurrence++;
            }
        }
        return occurrence;
    }

    @Override
    public void getData() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            data.add(s.nextLine());
        }
        data.sort(String.CASE_INSENSITIVE_ORDER);
        sortDataByOccurrence();
        // showResult();
    }

    //    @Override
//    public void showResult(String sortingType) {
//        getData();
//        System.out.println("Total lines: " + data.size() + ".");
//        System.out.println("the longest line: ");
//        System.out.println(this.getMax());
//        System.out.println(" (" + this.getMaxOccurrence() + " time(s)), " + this.getMaxPercentage() + "%)");
//    }
    public void showResult(String sortingType) {
        boolean isOver = false;
        String key = "";
        getData();

        if (sortingType.equals("byCount")){
            System.out.println("Total lines: " + data.size() + ".");
            while(!isOver){
                if(dataByCount.isEmpty()){
                    isOver = true;
                }
                else{
                    for (Map.Entry<String ,Integer> entry : dataByCount.entrySet()) {
                        int minOcc = getMinOccurrence();
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
            System.out.println("Total lines: " + data.size() + ".");
            System.out.print("Sorted data: " );
            for (String s : data) {
                System.out.print(s + " ");
            }
        }
    }

    public int getMinOccurrence() {
        int minOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<String ,Integer> entry : dataByCount.entrySet()) {
            if (entry.getValue() < minOccurrence ) {
                minOccurrence = entry.getValue();
            }
        }
        return minOccurrence;
    }

    @Override
    public int getMaxPercentage() {
        return getMaxOccurrence() * 100 / data.size();
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