package Stage2;

abstract class SortingToolTemplate<G> {
    abstract G getMax();

    abstract int getMaxOccurrence();

    public abstract void getData();

    abstract int getMaxPercentage();

    abstract void showResult();

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
}
