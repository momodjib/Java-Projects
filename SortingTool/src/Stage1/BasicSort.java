package Stage1;

import java.util.ArrayList;
import java.util.Scanner;

public class BasicSort {
    static ArrayList<Integer> data = new ArrayList<>();

    private static void getData(){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            data.add(s.nextInt());
        }
        intSort();
    }

    private static int getMax(){
        int max = 0;
        for (Integer i:data) {
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    private static int getMaxOccurrence(int max){
        int occurrence = 0;
        for (Integer i:data) {
            if(i == max){
                occurrence++;
            }
        }
        return occurrence;
    }

    private static void intSort(){
        System.out.println("Total numbers: "+data.size()+".");
        System.out.println("the greatest number: " +getMax()+" ("+getMaxOccurrence(getMax())+" time(s))");
    }

    public static void main(String[] args) {
        getData();
    }
}