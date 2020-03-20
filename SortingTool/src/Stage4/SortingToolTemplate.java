package Stage4;

public abstract class SortingToolTemplate<G> {
    //G[] sortedData;
    abstract G getMax();

    abstract int getMaxOccurrence();

    public abstract void getData();

    abstract int getMaxPercentage();

    abstract void showResult(String sortingType);

    public String lexicographicSort(String currentMax, String newLine) {
        String max = "";
        int index = currentMax.compareTo(newLine);
        if (index <= 0) {
            max = currentMax;
        } else {
            max = newLine;
        }
        return max;
    }

    public int getPercentage(Integer value, Integer size) {
        return value * 100 / size;
    }

//    void showResult() {
//        sortData();
//        System.out.println("total numbers: "+data.size()+".");
//        System.out.print("Sorted data: ");
//        for (G i : sortedData) {
//            System.out.print(i + " ");
//        }
//    }

}
