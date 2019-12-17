import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static Scanner scanner = new Scanner(System.in);

    private static void getInput(Scanner scanner){

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            switch(line){
                case "/exit":
                    System.out.println("Bye!");
                    return;
                case "/help":
                    System.out.println("The program calculates the sum and subtraction of numbers");
                    break;
                default:
                    processLine(line);
                    break;
            }
        }
    }
    private static void processLine(String line){

        String sign = "([\\+ | \\-])*";
        Pattern pattern = Pattern.compile(sign+"(\\d+\\s+"+sign+"\\s+\\d*)+");
        Matcher matcher = pattern.matcher(line);

        if (line.matches(sign+"\\d+\\s*")){
            if(line.charAt(0) == '+'){
                System.out.println(line.trim().substring(1));
            }else{
                System.out.println(line.trim());
            }
        }else if(line.matches("/"+"\\w+")){
            System.out.println("Unknown command");
        }
        else if (matcher.matches()){
            line = line.replaceAll("\\s+"," ");
            String[] items = line.split(" ");
            int result = Integer.parseInt(items[0]);

            try{
                for (int i = 1; i < items.length; i+=2){
                    String operator = getSign(items[i]);
                    if(operator.equals("+")){
                        result += Integer.parseInt(items[i+1]);
                    }else if (operator.equals("-")){
                        result -= Integer.parseInt(items[i+1]);
                    }
                }
                System.out.println(result);
            }catch(NullPointerException e){
                System.out.println(result);
            }
        }else{
            System.out.println("Invalid expression");
        }
    }

    private static String getSign(String sign){

        String temp = String.valueOf(sign.charAt(0));
        for (int i = 1; i < sign.length(); i++) {
            temp += sign.charAt(i);

            switch (temp){
                case "++":
                case "--":
                    temp = "+";
                    break;
                case "+-":
                case "-+":
                    temp = "-"; 
                    break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        getInput(scanner);
    }
}
