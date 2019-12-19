import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStep6 {

    private static Map<String, Integer> storedVariables = new TreeMap<>();
    private static final String SIGN = "([\\+ | \\-])*";
    private static final String LETTER = "[a-zA-Z]+";
    private static final String LETTERDIGIT = "([a-zA-Z]+|\\d+)";


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
    private static void processOperands(String line){
        
        String[]items = lineToArray(line, " ");
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
    }
    private static void processLine(String line){

        Pattern pattern = Pattern.compile(SIGN+"(\\d+\\s+"+SIGN+"\\s+\\d*)+");
        Matcher matcher = pattern.matcher(line);

        if (line.matches(SIGN+"\\d+\\s*")){
            if(line.charAt(0) == '+'){
                System.out.println(line.trim().substring(1));
            }else{
                System.out.println(line.trim());
            }
        }
        else if(line.matches("/"+"\\w+")){
            System.out.println("Unknown command");
        }
        else if(line.matches(LETTER+"\\s*=\\s*(\\d+|"+LETTER+")") || line.matches(LETTER) || line.matches(LETTER+"("+"\\s*"+SIGN+"\\s*"+LETTERDIGIT+")+")){
            processVariables(line);
        }
        else if (matcher.matches()){
            processOperands(line);
        }
        else if (line.isBlank() || line.isBlank()){
            //System.out.print();
        }
        else{
            String[] temp = line.split("=");
            if(temp.length>2 || line.matches(LETTER+"\\s*=\\s*[a-zA-Z]\\d+[a-zA-Z]*")){ //more than one '=' sign
                System.out.println("Invalid assignment");
            }
            else if (line.matches(LETTER+"\\d+\\s*=\\s*\\d+")){
                System.out.println("Invalid identifier");
            }
            else{
                System.out.println("Invalid expression");
            }
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
    private static void processVariables(String line){
        
        if(line.matches("\\w+")){
            if(storedVariables.containsKey(line)){
                System.out.println(storedVariables.get(line));
            }else{
                System.out.println("Unknown variable");
            }
        }
        else if(line.matches("\\w+\\s*=\\s*\\d+")){
            String[]temp = lineToArray(line, "=");
            storedVariables.put(temp[0].trim(),Integer.parseInt(temp[temp.length-1].trim()));
        }
        else if(line.matches("\\w+\\s*=\\s*\\w+")){
            String[]temp = lineToArray(line, "=");

            if(temp[0].trim().matches("\\w+\\d+\\w*") || temp[temp.length-1].trim().matches("\\w+\\d+\\w*")){
                System.out.println("Invalid assignment");
            }
            else if(storedVariables.containsKey(temp[temp.length-1].trim())){
                storedVariables.put(temp[0].trim(),storedVariables.get(temp[temp.length-1].trim()));
            }
            else{
                System.out.println("Unknown variable");
            }
        }
        else if (line.matches(LETTER+"("+"\\s*"+SIGN+"\\s*"+LETTERDIGIT+")+")){
            String[]temp = lineToArray(line, " ");
            String operands = "";

            for (String s :temp) {
                if(s.matches("[a-zA-Z]")){
                    if(storedVariables.containsKey(s)){
                        operands+=storedVariables.get(s)+" ";
                    }
                }else if(s.matches("\\d+" +"|"+ SIGN)){
                    operands+=s+" ";
                }
            }
            processOperands(operands);
        }
    }
    private static String[] lineToArray(String line, String separator){
        return line.replaceAll("\\s+"," ").split(separator);
    }
    
    public static void main(String[] args) {
       getInput(new Scanner(System.in));
    }
}