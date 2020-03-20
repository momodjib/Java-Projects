package Stage6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordSort extends SortingToolTemplate {
    ArrayList<String> data = new ArrayList<>();
    Map<String, Integer> dataByCount = new TreeMap<>();

    @Override
    public void getData(String inputFile) throws FileNotFoundException {

        Scanner s;
        if(!inputFile.isEmpty()){
            s = new Scanner(new File(inputFile));
        }
        else{
            s = new Scanner(System.in);
        }
        do {
            data.add(s.next());
        }while (s.hasNext());
        data.sort(Comparator.naturalOrder());
        sortDataByOccurrence();
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

    @Override
    public void showResult(String sortingType,  String inputFile, String outputFile) throws IOException {
        getData(inputFile);
        showResult(sortingType, data, dataByCount, "word", outputFile);

    }
}