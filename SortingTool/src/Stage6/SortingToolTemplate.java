package Stage6;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public abstract class SortingToolTemplate<G> {

    public abstract void getData(String inputFile) throws FileNotFoundException;

    abstract void showResult(String sortingType,String inputFile,String outputFile) throws IOException;

    public int getPercentage(Integer value, Integer size) {
        return value * 100 / size;
    }

    public void showResult(String sortingType, ArrayList<G> data, Map<G, Integer> dataByCount, String dataType, String outputFile) throws IOException {

        boolean isOver = false;
        G key = null;

        if(outputFile.isEmpty()){
            if (sortingType.equals("byCount")){
                switch (dataType) {
                    case "line":
                        System.out.println("Total lines: " + data.size() + ".");
                        break;
                    case "word":
                        System.out.println("Total words: " + data.size() + ".");
                        break;
                    case "long":
                        System.out.println("Total numbers: " + data.size() + ".");
                        break;
                }

                while(!isOver){
                    if(dataByCount.isEmpty()){
                        isOver = true;
                    }
                    else{
                        for (Map.Entry<G ,Integer> entry : dataByCount.entrySet()) {
                            int minOcc = getMinOccurrence(dataByCount);
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
                if (dataType.equals("line")){
                    System.out.println("Total lines: " + data.size() + ".");
                    System.out.println("Sorted data: " );
                    for (G s : data) {
                        System.out.println(s);
                    }
                }
                else {

                    if(dataType.equals("word")){
                        System.out.println("Total words: " + data.size() + ".");
                    }
                    else if((dataType.equals("long"))){
                        System.out.println("Total numbers: " + data.size() + ".");
                    }

                    System.out.print("Sorted data: " );
                    for (G s : data) {
                        System.out.print(s + " ");
                    }

                }
            }
        }

        //write to a file
        else{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outputFile))));

            if (sortingType.equals("byCount")){
                switch (dataType) {
                    case "line":
                        writer.write("Total lines: " + data.size() + ".");
                        writer.newLine();
                        break;
                    case "word":
                        writer.write("Total words: " + data.size() + ".");
                        writer.newLine();
                        break;
                    case "long":
                        writer.write("Total numbers: " + data.size() + ".");
                        writer.newLine();
                        break;
                }

                while(!isOver){
                    if(dataByCount.isEmpty()){
                        isOver = true;
                    }
                    else{
                        for (Map.Entry<G ,Integer> entry : dataByCount.entrySet()) {
                            int minOcc = getMinOccurrence(dataByCount);
                            if (entry.getValue() == minOcc){
                                writer.write(entry.getKey() + ": "+ entry.getValue() + " time(s), "+ getPercentage(entry.getValue(),data.size())+"%");
                                writer.newLine();
                                key = entry.getKey();
                                break;
                            }
                        }
                        dataByCount.remove(key);
                    }
                }
            }
            else {
                if (dataType.equals("line")){
                    writer.write("Total lines: " + data.size() + ".");
                    writer.newLine();
                    writer.write("Sorted data: " );
                    for (G s : data) {
                        writer.write(s + " ");
                        writer.newLine();
                    }
                }
                else {

                    if(dataType.equals("word")){
                        writer.write("Total words: " + data.size() + ".");
                    }
                    else if((dataType.equals("long"))){
                        writer.write("Total numbers: " + data.size() + ".");
                    }

                    writer.newLine();
                    writer.write("Sorted data: " );
                    for (G s : data) {
                        writer.write(s + " ");
                    }

                }
            }
            writer.close();
        }
    }

    public int getMinOccurrence(Map<G, Integer> dataByCount) {
        int minOccurrence = Integer.MAX_VALUE;
        for (Map.Entry<G ,Integer> entry : dataByCount.entrySet()) {
            if (entry.getValue() < minOccurrence ) {
                minOccurrence = entry.getValue();
            }
        }
        return minOccurrence;
    }
}