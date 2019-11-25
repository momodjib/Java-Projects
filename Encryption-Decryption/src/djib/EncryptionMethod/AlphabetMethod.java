package djib.EncryptionMethod;

public class AlphabetMethod extends EncryptMethod{

    private char a = 'a';
    private char z = 'z';
    private char A = 'A';
	private char Z = 'Z';
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
	public void decrypt(String message, int key) { //To be corrected to decrypt instead of encrypting
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabet = alpha.toCharArray();
		char[] toCode = message.toCharArray();
		char shiftItem;

		for (int i = 0; i < toCode.length; i++) {
			if(toCode[i] >= a && toCode[i] <= z || toCode[i] >= A && toCode[i] <= Z){
				for (int j = 0; j < alphabet.length; j++){

					if(toCode[i] == alphabet[j] && j+key < alphabet.length){
						System.out.print(alphabet[j+key]);
						break;
					}else if(toCode[i] == alphabet[j] && j+key >= alphabet.length){
						System.out.print(alphabet[key -(1+25-j)]);
						break;
					}
					else {
						final var b=toCode[i] == Character.toUpperCase(alphabet[j]);
						if(b && j+key < alphabet.length){
							System.out.print(Character.toUpperCase(alphabet[j+key]));
							break;
						}else if(b && j+key >= alphabet.length){
							System.out.print(Character.toUpperCase(alphabet[key -(1+25-j)]));
							break;
						}
					}
				}
			}
			else{
				System.out.print(toCode[i]);
			}
		}

	}
}
