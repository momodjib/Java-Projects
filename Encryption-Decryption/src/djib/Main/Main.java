package djib.Main;

import djib.EncryptionMethod.MethodPicker;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		args = scanner.nextLine().split(",");
		MethodPicker picker = new MethodPicker();
		picker.getDetails(args);

	}
}
