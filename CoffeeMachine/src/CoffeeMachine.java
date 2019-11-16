import java.util.Scanner;
public class CoffeeMachine {

    private static String action = "";
    private static Scanner scanner = new Scanner(System.in);
    private static int water;
    private static int milk;
    private static int beans;
    private static int cups;
    private static int money;

    private static void showStatus(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
        actionToPerform();
    }
    private static void actionToPerform(){
        while(!action.equals("exit")){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    return;
                case "remaining":
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println();
            showStatus();
        }
    }
    private static void buy() {
        String buyOption;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        buyOption = scanner.next();
        switch(buyOption) {
            case "1": // espresso
                if (checkAvailability("1")) {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    break;
                } else {
                    break;
                }
            case "2": // latte
                if (checkAvailability("2")) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    break;
                } else {
                    break;
                }
            case "3": // cappuccino
                if (checkAvailability("3")) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    break;
                } else {
                    break;
                }
            case "back":
                showStatus();
                break;
            default:
                System.out.println("invalid choice");
                break;
        }
    }
    private static void fill(){
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }
    private static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }
    private static boolean checkAvailability(String action){
        int w = 0;
        int m = 0;
        int b = 0;
        switch(action){
            case "1": //espresso
                w = 250;
                m = 0;
                b = 16;
                break;
            case "2":
                w = 350;
                m = 75;
                b = 20;
                break;
            case "3":
                w = 200;
                m = 100;
                b = 12;
                break;
        }
        if(water > w && milk > m && beans > b && cups >1){
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }else{
            System.out.println("Not enough resources");
            return false;
        }
    }

    public static void main(String[] args) {
        showStatus();
    }
}