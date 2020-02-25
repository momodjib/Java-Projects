package Stage3;

import java.util.ArrayList;
import java.util.Scanner;

class LongSort extends SortingToolTemplate {
    ArrayList<Integer> data = new ArrayList<>();

    @Override
    public void getData() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            data.add(s.nextInt());
        }
        showResult();
    }

    @Override
    public void showResult() {
        System.out.println("Total numbers: " + data.size() + ".");
        System.out.println("the greatest number: " + this.getMax() + " (" + this.getMaxOccurrence() +
                " time(s)), " + this.getMaxPercentage() + "%)");
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
    public int getMaxOccurrence() {
        int occurrence = 0;
        for (Integer i : data) {
            if (i.equals(this.getMax())) {
                occurrence++;
            }
        }
        return occurrence;
    }
}