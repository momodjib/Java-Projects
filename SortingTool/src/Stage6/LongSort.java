package Stage6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class LongSort extends SortingToolTemplate {
    ArrayList<Integer> data = new ArrayList<>();
    Map<Integer, Integer> dataByCount = new TreeMap<>();

    @Override
    public void getData(String inputFile) throws FileNotFoundException {

        Scanner s;
        String potentialError = "";
        int singleInput;

        if(!inputFile.isEmpty()){
            s = new Scanner(new File(inputFile));
        }
        else{
            s = new Scanner(System.in);
        }
        do {
            try{
                potentialError = s.next();
                singleInput = Integer.parseInt(potentialError);
                data.add(singleInput);
            }
            catch (NumberFormatException e){
                System.out.println(potentialError + " isn't a valid long. It's skipped.");
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
    public void showResult(String sortingType, String inputFile, String outputFile) throws IOException {
        getData(inputFile);
        showResult(sortingType, data, dataByCount, "long", outputFile);
    }

}