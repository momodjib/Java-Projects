package Stage2;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Debut2 {

    static Scanner scanner = new Scanner(System.in);
    static String[] newReleases = {"Mountains [Sia, Diplo, Labrinth]","Runaway [Lil Peep]","The Greatest Show [Panic! At The Disco]","All Out Life [Slipknot]"};
    static String[] featured = {"Mellow Morning","Wake Up and Smell the Coffee","Monday Motivation","Songs to Sing in the Shower"};
    static String[] categories = {"Top Lists","Pop","Mood","Latin"};
    static String[] Pop = {"popTrack-1","popTrack-2","popTrack-3"};
    static String[] Mood = {"moodTrack-1","moodTrack-2","moodTrack-3"};
    static String[] Latin = {"latinTrack-1","latinTrack-2","latinTrack-3"};
    private static boolean isAuthenticated = false;

    public static void readInput(){
        while(true){
            String input = scanner.next();

            if (isAuthenticated) {
                if(!input.isBlank() && !input.isEmpty()){
                    switch (input){
                        case "featured":
                            if (isAuthenticated){
                                printFeatured();
                            }else{
                                printFailureMessage();
                            }
                            break;
                        case "new":
                            printNew();
                            break;
                        case "categories":
                            printCategories();
                            break;
                        case "exit":
                            exit();
                            return;
                        default:
                            printPlaylist(input);
                            break;
                    }
                }
            }
            else if (StringUtils.equals(input,"auth")) {
                authenticate();
            }
            else if (StringUtils.equals(input,"exit")){
                exit();
                return;
            }
            else{
                printFailureMessage();
            }
        }
    }

    public static void setAuthenticationStatus(boolean status){
        isAuthenticated = status;
    }

    public static void exit(){
        System.out.println("---GOODBYE!---");
    }

    public static void printFailureMessage(){
        System.out.println("Please, provide access for application.");
    }

    private static void authenticate(){
        setAuthenticationStatus(true);
        System.out.println("https://accounts.spotify.com/authorize?client_id=f6595702327d4963bb2d78126af144b0&redirect_uri=http://localhost:8080&response_type=code");
        System.out.println("---SUCCESS---");
    }

    public static void print(String[] array){
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void printFeatured(){
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