package djib.Main;
import djib.EncryptionMethod.AlphabetMethod;
import djib.EncryptionMethod.AsciiMethod;
import djib.EncryptionMethod.MethodPicker;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        MethodPicker picker = new MethodPicker();
        picker.getDetails(new String[]{"-mode","dec","-key","5","-in","dumb.txt","-out","oooo.txt"});
        picker.pick();
        picker.process();
    }
}
