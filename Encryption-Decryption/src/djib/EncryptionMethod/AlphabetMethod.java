package djib.EncryptionMethod;

public class AlphabetMethod extends EncryptMethod{

    private char a = 'a';
    private char z = 'z';
    private int size = 26;

    @Override
    public void encrypt(String message, int key) {

        char[] chars = message.toCharArray();
        for (char item : chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + key) % size) + a);
                System.out.print(shiftItem);
            } else {
                System.out.print(item);
            }
        }
    }

    @Override
    public void decrypt(String message, int key) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = alpha.toCharArray();
        char[] toCode = message.toCharArray();
        char shiftItem;

        for (int i = 0; i < toCode.length; i++) {
            for (int j = 0; j < alphabet.length; j++){

                if(toCode[i] == alphabet[j] && j+key < alphabet.length){
                    //shiftItem = alphabet[j+key];
                    System.out.print(alphabet[j+key]);
                }else if(toCode[i] == alphabet[j] && j+key >= alphabet.length){
                    //shiftItem = alphabet[0];
                    //int x = key -(1+25-i);
                    //shiftItem = alphabet[key -(1+25-i)];
                    System.out.print(alphabet[key -(1+25-i)]);
                }else{
                    System.out.print(toCode[i]);
                }
            }

            //System.out.print(shiftItem);
        }

    }
}
