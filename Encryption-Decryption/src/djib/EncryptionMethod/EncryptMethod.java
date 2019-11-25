package djib.EncryptionMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class EncryptMethod {
    String in = "";
    String out = "";
    boolean fromFile = false, outToFile = false;

    abstract void encrypt(String message, int key) throws IOException;
    abstract void decrypt(String message, int key) throws IOException;

    String getData(String fileName){
        try{
            return new String(Files.readAllBytes(Paths.get(fileName)));
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
            return "";
        }
    }
}