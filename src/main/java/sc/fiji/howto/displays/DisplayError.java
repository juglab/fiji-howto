package sc.fiji.howto.displays;

import net.imagej.ImageJ;
import org.scijava.ui.DialogPrompt;

/**
 * How to display an error
 */
public class DisplayError {

	public static void run() {
		ImageJ ij = new ImageJ();
		// TODO this looks the same as a plain message with legacy dependency
		ij.ui().showDialog("EXTERMINATE", DialogPrompt.MessageType.ERROR_MESSAGE);
	}

	public static void main(String...args) {
		run();
	}


}
