import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorStep7 {

    private static Map<String, Integer> storedVariables = new TreeMap<>();
    private static Deque<String> operators = new ArrayDeque<>();
    private static Deque<String> result = new ArrayDeque<>();
    private static String SIGN = "([\\+ | \\-])*";
    private static String MIDDLESIGN = "[(\\/)"+"|"+"(\\*)"+"|"+"(\\++)"+"|"+"(\\-+)]";
    private static final String SIGNSUP = "([\\* | \\/])*";
    private static final String LETTER = "[a-zA-Z]+";
    private static final String LETTERDIGIT = "([a-zA-Z]+|\\d+)";


    private static void getInput(Scanner scanner){

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            operators = new ArrayDeque<>();
            result = new ArrayDeque<>();
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
                }else if(operator.equals("*")){
                    result *= Integer.parseInt(items[i+1]);
                }else if(operator.equals("/")){
                    result /= Integer.parseInt(items[i+1]);
                }
            }
            System.out.println(result);
        }catch(NullPointerException e){
            System.out.println(result);
        }
    }
    private static void processLine(String line){

        Pattern pattern = Pattern.compile(SIGN+"(\\d+\\s+"+MIDDLESIGN+"*"+"\\s+\\d*)+");
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
        else if (line.matches(SIGNSUP+"(\\d+\\s+"+SIGNSUP+"\\s+\\d*)+")){
            System.out.println("Invalid expression");
        }
        else if(line.matches(LETTER+"\\s*=\\s*(\\d+|"+LETTER+")") || line.matches(LETTER) || line.matches(LETTER+"("+"\\s*"+SIGN+"\\s*"+LETTERDIGIT+")+")){
            processVariables(line);
        }
        else if(line.contains("(") || line.contains(")") || line.contains("*") || line.contains("/")){
            getPostfix(line);
        }
        else if (matcher.matches() ){
            processOperands(line);
        }
        else if (line.isBlank() || line.isEmpty()){
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
                default:
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
        if(line.contains(" ")){
            return line.replaceAll("\\s+"," ").split(separator);
        }else{
            return line.split("");
        }
    }
    public static String insertBracesToStack(String line){
        for(int i = 0; i < line.length(); i++){
            while(line.charAt(i) == '('){
                operators.push(Character.toString(line.charAt(i)));
                line = line.substring(1);
            }
        }
        return line;
    }
    public static void getPostfix(String line){

        String[] temp = lineToArray(line," ");
        String postfix = "";

        try{
            for (String s : temp) {
                if(s.matches("\\d+") || s.matches(LETTER)){
                    postfix+=s+" ";
                }
                else if(s.matches("\\(+"+"\\d+") || s.matches("\\("+LETTER)){
                    s = insertBracesToStack(s);
                    postfix+= s+" ";
                }
                else if(s.matches("\\d+" +"\\)") || s.matches(LETTER+"\\)")){
                    postfix+= s.substring(0,s.length()-1)+" ";
                    while(!operators.peek().equals("(")){
                        postfix+= operators.pop()+" ";
                    }
                    operators.pop();
                }
                else if(s.equals(")")){
                    while(!operators.peek().equals("(")){
                        postfix+= operators.pop()+" ";
                    }
                    operators.pop();
                }
                else if(s.equals("(")){
                    operators.push(s);
                }
                else{
                    if(s.equals("*") || s.equals("/")){
                        if(operators.size() > 0){
                            if(operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("(")){
                                operators.push(s);
                            }
                            else if(operators.peek().equals("*") || operators.peek().equals("/")){
                                while(operators.size() > 0 && !operators.peek().equals("(") && !operators.peek().equals("+") && !operators.peek().equals("-")){
                                    postfix+= operators.pop()+" ";
                                }
                                operators.push(s);
                            }
                        }else{
                            operators.push(s);
                        }
                    }
                    else if(s.matches(MIDDLESIGN+"*")) {
                        s = getSign(s);
                        if(operators.size() > 0){
                            while (operators.size() > 0 && !operators.peek().equals("(")) {
                                postfix += operators.pop() + " ";
                            }
                            operators.push(s);
                        }else{
                            operators.push(s);
                        }
                    }
                }
            }
            for (String s:operators) {
                if(s.equals("(")){
                    System.out.println("Invalid expression");
                    return;
                }
                else {
                    postfix += operators.pop() + " ";
                }
            }
        }catch(Throwable e){
            System.out.println("Invalid expression");
            return;
        }
        computePostFix(postfix);
    }
    public static void computePostFix(String line){
        String[] temp = lineToArray(line," ");

        for(int i = 0; i < temp.length; i++){
            if(temp[i].matches("\\d+")){
                result.push(temp[i]);
            }else if(temp[i].matches(LETTER)){
                if(storedVariables.containsKey(temp[i])){
                    result.push(String.valueOf(storedVariables.get(temp[i])));
                }else{
                    System.out.println("Unknown variable");
                }
            }
            else if(temp[i].matches(SIGN) || temp[i].matches(SIGNSUP)){
                Integer a = Integer.valueOf(result.pop());
                Integer b = Integer.valueOf(result.pop());
                switch (temp[i]){
                    case "+":
                        result.push(String.valueOf(a+b));
                        break;
                    case "*":
                        result.push(String.valueOf(a*b));
                        break;
                    case "-":
                        result.push(a > b ? String.valueOf(a-b) : String.valueOf(b-a));
                        break;
                    case "/":
                        result.push(a > b ? String.valueOf(a/b) : String.valueOf(b/a));
                        break;
                }
            }
        }
        System.out.println(result.pop());
    }
     public static void main(String[] args) {
         getInput(new Scanner(System.in));
     }

}