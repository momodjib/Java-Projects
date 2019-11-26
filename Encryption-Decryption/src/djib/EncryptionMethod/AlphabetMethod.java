package djib.EncryptionMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetMethod extends EncryptMethod{

    private char a = 'a';
    private char z = 'z';
    private char A = 'A';
    private char Z = 'Z';
    private int size = 26;

    @Override
    public void encrypt(String message, int key) throws IOException {

		char[] chars;
		if(!fromFile){
			chars = message.toCharArray();
			if(!outToFile){
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
			}else{
                FileWriter writer = new FileWriter(new File(out));
				for (char item : chars) {
                    if (item >= a && item <= z) {
                        char shiftItem = (char) (((item - a + key) % size) + a);
                        writer.write(shiftItem);
                    } else if(item >= A && item <= Z){
                        char shiftItem = (char) (((item - A + key) % size) + A);
                        writer.write(shiftItem);
                    }else {
                        writer.write(item);
                    }
				}writer.close();
			}
		}else{
			File input = new File(in);
			chars = getData(input.getName()).toCharArray();
			if(outToFile){
                FileWriter writer = new FileWriter(new File(out));
				for (char item : chars) {
                    if (item >= a && item <= z) {
                        char shiftItem = (char) (((item - a + key) % size) + a);
                        writer.write(shiftItem);
                    } else if(item >= A && item <= Z){
                        char shiftItem = (char) (((item - A + key) % size) + A);
                        writer.write(shiftItem);
                    }else {
                        writer.write(item);
                    }
				}writer.close();
			}else{
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
		}
	}

    @Override
    public void decrypt(String message, int key) throws IOException {
	    
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	char[] alphabet = alpha.toCharArray();
	char[] toCode;


	if(!fromFile){
        toCode = message.toCharArray();
        for (int i = 0; i < toCode.length; i++) {
            if(toCode[i] >= a && toCode[i] <= z || toCode[i] >= A && toCode[i] <= Z){
                if(!outToFile){
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
                                System.out.print(Character.toUpperCase(alphabet[25+(j-key+1)]));
                                break;
                            }
                        }
                    }
                }else{
                    FileWriter writer = new FileWriter(new File(out));
                    for (int j = 0; j < alphabet.length; j++){
                        if(toCode[i] == alphabet[j] && j-key >= 0){
                            writer.write(alphabet[j-key]);
                        }else if(toCode[i] == alphabet[j] && j-key < 0){
                            writer.write(alphabet[25+(j-key+1)]);
                        }
                        else{
                            final var b=toCode[i] == Character.toUpperCase(alphabet[j]);
                            if(b && j-key >= 0){
                                writer.write(Character.toUpperCase(alphabet[j-key]));
                            }else if(b && j-key < 0){
                                writer.write(Character.toUpperCase(alphabet[25+(j-key+1)]));
                            }
                        }
                    }writer.close();
                }
            }
            else{
                if(!outToFile){
                    System.out.print(toCode[i]);
                }else{
                    FileWriter writer = new FileWriter(new File(out));
                    writer.write(toCode[i]);
                    writer.close();
                }
            }
        }
    }else{
        File input = new File(in);
        toCode = getData(input.getName()).toCharArray();
        for (int i = 0; i < toCode.length; i++) {
            if(toCode[i] >= a && toCode[i] <= z || toCode[i] >= A && toCode[i] <= Z){
                if(!outToFile){
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
                                System.out.print(Character.toUpperCase(alphabet[25+(j-key+1)]));
                                break;
                            }
                        }System.out.print(toCode[i]);
                    }
                }else{
                    FileWriter writer = new FileWriter(new File(out));
                    for (int j = 0; j < alphabet.length; j++){
                        if(toCode[i] == alphabet[j] && j-key >= 0){
                            writer.write(alphabet[j-key]);
                            break;
                        }else if(toCode[i] == alphabet[j] && j-key < 0){
                            writer.write(alphabet[25+(j-key+1)]);
                            break;
                        }
                        else{
                            final var b=toCode[i] == Character.toUpperCase(alphabet[j]);
                            if(b && j-key >= 0){
                                writer.write(Character.toUpperCase(alphabet[j-key]));
                                break;
                            }else if(b && j-key < 0){
                                writer.write(Character.toUpperCase(alphabet[25+(j-key+1)]));
                                break;
                            }
                        }writer.write(toCode[i]);
                    }writer.close();
                }
            }
//            else{
//                System.out.print(toCode[i]);
//            }
        }
    }
    }
}
