package Stage2;

import java.util.ArrayList;
import java.util.Scanner;

public class WordSort extends SortingToolTemplate {
    ArrayList<String> data = new ArrayList<>();

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
            data.add(s.next());
        }
        showResult();
    }

    @Override
    public void showResult() {
        System.out.println("Total words: " + data.size() + ".");
        System.out.println("the longest word: " + this.getMax() + " (" + this.getMaxOccurrence() + " time(s)), " + this.getMaxPercentage() + "%)");
    }

    @Override
    public int getMaxPercentage() {
        return getMaxOccurrence() * 100 / data.size();
    }
}
