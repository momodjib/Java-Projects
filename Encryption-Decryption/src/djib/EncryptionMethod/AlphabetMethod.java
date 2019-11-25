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

    }
}
