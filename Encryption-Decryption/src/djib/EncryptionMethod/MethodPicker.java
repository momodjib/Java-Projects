package djib.EncryptionMethod;

import java.io.IOException;

public class MethodPicker {

    private EncryptMethod method;
    private static String message = "";
    private static String mode = "enc";
    private static int key = 0;
    private static String in = "";
    private static String out = "";
    private static String alg = "";
    private static boolean fromFile = false, outToFile = false;

    public void setMethod(EncryptMethod method) {

        this.method = method;
    }

    void encrypt(String message, int key) throws IOException {

        this.method.encrypt(message, key);
    }

    void decrypt(String message, int key) throws IOException {

        this.method.decrypt(message, key);
    }

    public void getDetails(String[] args) throws IOException {

        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    fromFile = true;
                    break;
                case "-out":
                    out = args[i + 1];
                    outToFile = true;
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }
    }

    public void pick() {

        switch(alg) {
            case "shift":
                this.setMethod(new AlphabetMethod());
                this.setValues();
                break;
            case "unicode":
                this.setMethod(new AsciiMethod());
                this.setValues();
                break;
            default:
                System.out.println("Unknown method");
                break;
        }
    }

    public void setValues(){
        this.method.fromFile = fromFile;
        this.method.outToFile = outToFile;
        this.method.in = in;
        this.method.out = out;
    }

    public void process(){

       if(method instanceof AlphabetMethod) {

       }
       else if(method instanceof AsciiMethod){

        }
    }
}