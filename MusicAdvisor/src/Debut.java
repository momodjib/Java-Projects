import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Debut {

    static Scanner scanner = new Scanner(System.in);
    static String[] newReleases = {"Mountains [Sia, Diplo, Labrinth]","Runaway [Lil Peep]","The Greatest Show [Panic! At The Disco]","All Out Life [Slipknot]"};
    static String[] featured = {"Mellow Morning","Wake Up and Smell the Coffee","Monday Motivation","Songs to Sing in the Shower"};
    static String[] categories = {"Top Lists","Pop","Mood","Latin"};
    static String[] Pop = {"popTrack-1","popTrack-2","popTrack-3"};
    static String[] Mood = {"moodTrack-1","moodTrack-2","moodTrack-3"};
    static String[] Latin = {"latinTrack-1","latinTrack-2","latinTrack-3"};

    public static void readInput(){
        while(true){
            String input = scanner.next();
            if(!input.isBlank() && !input.isEmpty()){

                switch (input){
                    case "featured":
                        printFeatures();
                        break;
                    case "new":
                        printNew();
                        break;
                    case "categories":
                        printCategories();
                        break;
                    case "exit":
                        System.out.println("---GOODBYE!---");
                        return;
                    default:
                        printPlaylist(input);
                        break;
                }
            }
        }
    }

    public static void print(String[] array){
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void printFeatures(){
        System.out.println("---FEATURED---");
        print(featured);
    }

    public static void printNew(){
        System.out.println("---NEW RELEASES---");
        print(newReleases);
    }

    public static void printCategories(){
        System.out.println("---CATEGORIES---");
        print(categories);
    }

    public static void printPlaylist(String categoryName){


        if(StringUtils.equalsIgnoreCase(categoryName,"Mood") || StringUtils.equalsIgnoreCase(categoryName,"Pop") || StringUtils.equalsIgnoreCase(categoryName,"Latin")){
            System.out.println("---"+ categoryName +" PLAYLISTS---");
            switch(categoryName.toLowerCase()){
                case "mood":
                    print(Mood);
                    break;
                case "pop":
                    print(Pop);
                    break;
                case "latin":
                    print(Latin);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        readInput();
    }
}