package Stage3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IntegerSort extends SortingToolTemplate {
    ArrayList<Integer> data = new ArrayList<>();
    Integer[] sortedData;

    @Override
    Object getMax() {
        return null;
    }

    @Override
    int getMaxOccurrence() {
        return 0;
    }

    public void getData() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            this.data.add(s.nextInt());
        }
        showResult();
    }

    @Override
    int getMaxPercentage() {
        return 0;
    }

    void sortData() {
        this.sortedData = data.toArray(new Integer[data.size()]);
        Arrays.sort(sortedData);
    }

    void showResult() {
        sortData();
        System.out.println("total numbers: "+data.size()+".");
        System.out.print("Sorted data: ");
        for (Integer i : sortedData) {
            System.out.print(i + " ");
        }
    }
}