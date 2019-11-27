package djib.Main;

import djib.EncryptionMethod.MethodPicker;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		MethodPicker picker = new MethodPicker();
		picker.getDetails(args);
		picker.pick();
		picker.process();
	}
}
