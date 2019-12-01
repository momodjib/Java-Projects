import java.util.Scanner;

public class Calculator {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int sum = 0;
            while(sc.hasNext()){
                String line = sc.nextLine();
                switch(line){
                    case "":
                        break;
                    case "/exit":
                        System.out.println("Bye!");
                        break;
                    case "/help":
                        System.out.println("The program calculates the sum of numbers");
                        break;
                    default:
                        String[] operands = line.split(" ");
                        if (operands[1].isBlank()){
                            System.out.println(operands[0]);
                        }else{
                            for (String s:operands) {
                                sum += Integer.parseInt(s);
                            }
                        }
                }
            }
        }
}
