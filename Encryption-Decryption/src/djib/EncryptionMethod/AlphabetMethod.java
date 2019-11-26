package djib.EncryptionMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetMethod extends EncryptMethod {

	private char a='a';
	private char z='z';
	private char A='A';
	private char Z='Z';
	private String alpha="abcdefghijklmnopqrstuvwxyz";
	private char[] alphabet=alpha.toCharArray();
	private char[] toCode;

	@Override
	public void encrypt(String message, int key) throws IOException {

		char[] chars;
		int size=26;
		if(!fromFile) {
			chars=message.toCharArray();
			if(!outToFile) {
				for (char item : chars) {
					if(item >= a && item <= z) {
						char shiftItem=(char) (((item - a + key) % size) + a);
						System.out.print(shiftItem);
					} else if(item >= A && item <= Z) {
						char shiftItem=(char) (((item - A + key) % size) + A);
						System.out.print(shiftItem);
					} else {
						System.out.print(item);
					}
				}
			} else {
				FileWriter writer=new FileWriter(new File(out));
				for (char item : chars) {
					if(item >= a && item <= z) {
						char shiftItem=(char) (((item - a + key) % size) + a);
						writer.write(shiftItem);
					} else if(item >= A && item <= Z) {
						char shiftItem=(char) (((item - A + key) % size) + A);
						writer.write(shiftItem);
					} else {
						writer.write(item);
					}
				}
				writer.close();
			}
		} else {
			File input=new File(in);
			chars=getData(input.getName()).toCharArray();
			if(outToFile) {
				FileWriter writer=new FileWriter(new File(out));
				for (char item : chars) {
					if(item >= a && item <= z) {
						char shiftItem=(char) (((item - a + key) % size) + a);
						writer.write(shiftItem);
					} else if(item >= A && item <= Z) {
						char shiftItem=(char) (((item - A + key) % size) + A);
						writer.write(shiftItem);
					} else {
						writer.write(item);
					}
				}
				writer.close();
			} else {
				for (char item : chars) {
					if(item >= a && item <= z) {
						char shiftItem=(char) (((item - a + key) % size) + a);
						System.out.print(shiftItem);
					} else if(item >= A && item <= Z) {
						char shiftItem=(char) (((item - A + key) % size) + A);
						System.out.print(shiftItem);
					} else {
						System.out.print(item);
					}
				}
			}
		}
	}

	@Override
	public void decrypt(String message, int key) throws IOException {

		if(fromFile){
			if(outToFile){
				fromFileToFile(message, key);
			}else{
				fromFileToConsole(message, key);
			}
		}else{
			if(outToFile){
				fromConsoleToFile(message, key);
			}else{
				fromConsoleToConsole(message, key);
			}
		}
	}


	private void fromFileToFile(String message, int key) throws IOException {

		File input=new File(in);
		FileWriter writer=new FileWriter(new File(out));
		toCode=getData(input.getName()).toCharArray();

		for (char c : toCode) {
			if(c >= a && c <= z || c >= A && c <= Z) {
				for (int j=0; j < alphabet.length; j++) {
					if(c == alphabet[j] && j - key >= 0) {
						writer.write(alphabet[j - key]);
						break;
					} else if(c == alphabet[j] && j - key < 0) {
						writer.write(alphabet[25 + (j - key + 1)]);
						break;
					} else {
						final var b=c == Character.toUpperCase(alphabet[j]);
						if(b && j - key >= 0) {
							writer.write(Character.toUpperCase(alphabet[j - key]));
							break;
						} else if(b && j - key < 0) {
							writer.write(Character.toUpperCase(alphabet[25 + (j - key + 1)]));
							break;
						}
					}
				}
			} else {
				writer.write(c);
			}
		}
		writer.close();
	}

	private void fromFileToConsole(String message, int key){

		File input = new File(in);
		toCode = getData(input.getName()).toCharArray();

		for (char c : toCode) {
			if(c >= a && c <= z || c >= A && c <= Z) {
				for (int j=0; j < alphabet.length; j++) {
					if(c == alphabet[j] && j - key >= 0) {
						System.out.print(alphabet[j - key]);
						break;
					} else if(c == alphabet[j] && j - key < 0) {
						System.out.print(alphabet[25 + (j - key + 1)]);
						break;
					} else {
						final var b=c == Character.toUpperCase(alphabet[j]);
						if(b && j - key >= 0) {
							System.out.print(Character.toUpperCase(alphabet[j - key]));
							break;
						} else if(b && j - key < 0) {
							System.out.print(Character.toUpperCase(alphabet[25 + (j - key + 1)]));
							break;
						}
					}
				}
			} else {
				System.out.print(c);
			}
		}
	}

	private void fromConsoleToConsole(String message, int key){

		toCode=message.toCharArray();

		for (char c : toCode) {
			if(c >= a && c <= z || c >= A && c <= Z) {
				for (int j=0; j < alphabet.length; j++) {
					if(c == alphabet[j] && j - key >= 0) {
						System.out.print(alphabet[j - key]);
						break;
					} else if(c == alphabet[j] && j - key < 0) {
						System.out.print(alphabet[25 + (j - key + 1)]);
						break;
					} else {
						final var b=c == Character.toUpperCase(alphabet[j]);
						if(b && j - key >= 0) {
							System.out.print(Character.toUpperCase(alphabet[j - key]));
							break;
						} else if(b && j - key < 0) {
							System.out.print(Character.toUpperCase(alphabet[25 + (j - key + 1)]));
							break;
						}
					}
				}
			} else {
				System.out.print(c);
			}
		}
	}

	private void fromConsoleToFile(String message, int key) throws IOException{

		toCode = message.toCharArray();
		FileWriter writer = new FileWriter(new File(out));

		for (char c : toCode) {
			if(c >= a && c <= z || c >= A && c <= Z) {
				for (int j=0; j < alphabet.length; j++) {
					if(c == alphabet[j] && j - key >= 0) {
						writer.write(alphabet[j - key]);
					} else if(c == alphabet[j] && j - key < 0) {
						writer.write(alphabet[25 + (j - key + 1)]);
					} else {
						final var b=c == Character.toUpperCase(alphabet[j]);
						if(b && j - key >= 0) {
							writer.write(Character.toUpperCase(alphabet[j - key]));
						} else if(b && j - key < 0) {
							writer.write(Character.toUpperCase(alphabet[25 + (j - key + 1)]));
						}
					}
				}
			} else {
				writer.write(c);
			}
		}
		writer.close();
	}
}
