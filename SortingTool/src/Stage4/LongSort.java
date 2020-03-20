package Stage4;

import java.util.*;

class LongSort extends SortingToolTemplate {
    ArrayList<Integer> data = new ArrayList<>();
    Map<Integer, Integer> dataByCount = new TreeMap();


    @Override
    public void getData() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            data.add(s.nextInt());
        }
        data.sort(Comparator.naturalOrder());
        sortDataByOccurrence();
    }

    public void sortDataByOccurrence(){
        for (Integer i : data) {
            if (dataByCount.containsKey(i)){
                dataByCount.put(i,dataByCount.get(i)+1);
            }
            else{
                dataByCount.put(i,1);
            }
        }
    }

    @Override
    public void showResult(String sortingType) {
        boolean isOver = false;
        int key = -1;
        getData();

        if (sortingType.equals("byCount")){
            System.out.println("Total numbers: " + data.size() + ".");
            while(!isOver){
                if(dataByCount.isEmpty()){
                    isOver = true;
                }
                else{
                    for (Map.Entry<Integer ,Integer> entry : dataByCount.entrySet()) {
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
            System.out.println("Total numbers: " + data.size() + ".");
            System.out.print("Sorted data: " );
            for (Integer i : data) {
                System.out.print(i + " ");
            }
        }
    }

    @Override
    public int getMaxPercentage() {
        return this.getMaxOccurrence() * 100 / data.size();
    }

    @Override
    public Integer getMax() {
        int max = 0;
        for (Integer i : data) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Override
    int getMaxOccurrence() {
        return 0;
    }

    public int getMinOccurrence() {
        int minOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<Integer ,Integer> entry : dataByCount.entrySet()) {
            if (entry.getValue() < minOccurrence ) {
                minOccurrence = entry.getValue();
            }
        }
        return minOccurrence;
    }
}