package Stage5;

import java.util.*;

class LongSort extends SortingToolTemplate {
    ArrayList<Integer> data = new ArrayList<>();
    Map<Integer, Integer> dataByCount = new TreeMap();


    @Override
    public void getData() {
        Scanner s = new Scanner(System.in);

        String error = "";
        int var;

        do {
            try{
                error = s.next();
                var = Integer.parseInt(error);
                data.add(var);
            }
            catch (NumberFormatException e){
                System.out.println(error + " isn't a valid long. It's skipped.");
            }

        }while (s.hasNext());

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
        showResult(sortingType, data, dataByCount, "long");
    }

}