import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Encrypt {
        private static String mode = "enc";
        private static int key = 0;
        private static String data = "";
        private static String in = "";
        private static String out = "";
        private static boolean fromFile = false, outToFile = false;

        private static String getData(String fileName){
            try{
                return new String(Files.readAllBytes(Paths.get(fileName)));
            }catch(IOException e){
                System.out.println("Error: "+e.toString());
                return "";
            }
        }
        private static void encrypt(String mode, int index) throws IOException {
            char[] chars;
            switch(mode){
                case "enc":
                    if(!fromFile || (fromFile && !data.equals(""))){
                        chars = data.toCharArray();
                        if(!outToFile){
                            for (char item : chars) {
                                char shiftItem = (char) (item + index);
                                System.out.print(shiftItem);
                            }
                        }else{
                            FileWriter writer = new FileWriter(new File(out));
                            for (char item : chars) {
                                char shiftItem = (char) (item + index);
                                writer.write(shiftItem);
                            }
                            writer.close();
                        }
                    }else{
                        File input = new File(in);
                        chars = getData(input.getName()).toCharArray();
                        if(!outToFile) {
                            for (char item : chars) {
                                char shiftItem = (char) (item + index);
                                System.out.print(shiftItem);
                            }
                        } else {
                            FileWriter writer = new FileWriter(new File(out));
                            for (char item : chars) {
                                char shiftItem = (char) (item + index);
                                writer.write(shiftItem);
                            }
                            writer.close();
                        }
                    }
                    break;
                case "dec":
                    if(!fromFile || (fromFile && !data.equals(""))){
                        chars = data.toCharArray();
                        if(!outToFile){
                            for (char item : chars) {
                                char shiftItem = (char) (item - index);
                                System.out.print(shiftItem);
                            }
                        }else{
                            FileWriter writer = new FileWriter(new File(out));
                            for (char item : chars) {
                                char shiftItem = (char) (item - index);
                                writer.write(shiftItem);
                            }
                            writer.close();
                        }
                    }else{
                        File input = new File(in);
                        chars = getData(input.getName()).toCharArray();
                        if(!outToFile){
                            for (char item : chars) {
                                char shiftItem = (char) (item - index);
                                System.out.print(shiftItem);
                            }
                        }else{
                            FileWriter writer = new FileWriter(new File(out));
                            for (char item : chars) {
                                char shiftItem = (char) (item - index);
                                writer.write(shiftItem);
                            }
                            writer.close();
                        }
                    }
                    break;
            }
        }
        private static void getDetails(String[] args) throws IOException {
            for(int i = 0; i < args.length; i++){
                switch(args[i]) {
                    case "-mode":
                        mode = args[i+1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i+1]);
                        break;
                    case "-data":
                        data = args[i+1];
                        break;
                    case "-in":
                        in = args[i+1];
                        fromFile = true;
                        break;
                    case "-out":
                        out = args[i+1];
                        outToFile = true;
                        break;
                }
            }
            encrypt(mode, key);
        }
        public static void main(String[] args) throws IOException {
            getDetails(args);
        }
}
