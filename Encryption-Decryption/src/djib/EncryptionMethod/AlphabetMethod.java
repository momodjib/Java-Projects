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
		} else if(item >= A && item <= Z){
			char shiftItem = (char) (((item - A + key) % size) + A);
			System.out.print(shiftItem);
		}else {
			System.out.print(item);
		}
	}
    }

    @Override
    public void decrypt(String message, int key) { 
	    
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	char[] alphabet = alpha.toCharArray();
	System.out.println(Arrays.toString(alphabet));
	char[] toCode = message.toCharArray();

	for (int i = 0; i < toCode.length; i++) {
		
		if(toCode[i] >= a && toCode[i] <= z || toCode[i] >= A && toCode[i] <= Z){
			for (int j = 0; j < alphabet.length; j++){

				if(toCode[i] == alphabet[j] && j-key >= 0){
					System.out.print(alphabet[j-key]);
					break;
				}else if(toCode[i] == alphabet[j] && j-key < 0){
					System.out.print(alphabet[25+(j-key+1)]);
					break;
				}
				else {
					final var b=toCode[i] == Character.toUpperCase(alphabet[j]);
						if(b && j-key >= 0){
						System.out.print(Character.toUpperCase(alphabet[j-key]));
						break;
					}else if(b && j-key < 0){
						System.out.print(Character.toUpperCase(alphabet[25+(j - key + 1)]));
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
