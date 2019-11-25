package djib.Main;
import djib.EncryptionMethod.AlphabetMethod;
import djib.EncryptionMethod.AsciiMethod;
import djib.EncryptionMethod.MethodPicker;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        MethodPicker picker = new MethodPicker();
        picker.getDetails(new String[]{"-mode","enc","-key","5","-data","welcome","-alg","shift","-out","dumb.txt"});
        picker.pick();
        picker.process();
    }
}
