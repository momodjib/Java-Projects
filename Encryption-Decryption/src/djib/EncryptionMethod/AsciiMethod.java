package djib.EncryptionMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AsciiMethod extends EncryptMethod {
    private char[] chars;
    @Override
    public void encrypt(String message, int key) throws IOException {

        if(!fromFile || (fromFile && !message.equals(""))){
            chars = message.toCharArray();
            if(!outToFile){
                for (char item : chars) {
                    char shiftItem = (char) (item + key);
                    System.out.print(shiftItem);
                }
            }else{
                FileWriter writer = new FileWriter(new File(out));
                for (char item : chars) {
                    char shiftItem = (char) (item + key);
                    writer.write(shiftItem);
                }
                writer.close();
            }
        }else{
            File input = new File(in);
            chars = getData(input.getName()).toCharArray();
            if(!outToFile) {
                for (char item : chars) {
                    char shiftItem = (char) (item + key);
                    System.out.print(shiftItem);
                }
            }else {
                FileWriter writer = new FileWriter(new File(out));
                for (char item : chars) {
                    char shiftItem = (char) (item + key);
                    writer.write(shiftItem);
                }
                writer.close();
            }
        }
    }

    @Override
    public void decrypt(String message, int key) throws IOException {

        if(!fromFile || (fromFile && !message.equals(""))){
            chars = message.toCharArray();
            if(!outToFile){
                for (char item : chars) {
                    char shiftItem = (char) (item - key);
                    System.out.print(shiftItem);
                }
            }else{
                FileWriter writer = new FileWriter(new File(out));
                for (char item : chars) {
                    char shiftItem = (char) (item - key);
                    writer.write(shiftItem);
                }
                writer.close();
            }
        }else{
            File input = new File(in);
            chars = getData(input.getName()).toCharArray();
            if(!outToFile){
                for (char item : chars) {
                    char shiftItem = (char) (item - key);
                    System.out.print(shiftItem);
                }
            }else{
                FileWriter writer = new FileWriter(new File(out));
                for (char item : chars) {
                    char shiftItem = (char) (item - key);
                    writer.write(shiftItem);
                }
                writer.close();
            }
        }
    }
}
