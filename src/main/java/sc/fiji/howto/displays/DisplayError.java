package sc.fiji.howto.displays;

import net.imagej.ImageJ;
import org.scijava.ui.DialogPrompt;

public class DisplayError {

	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().showDialog("EXTERMINATE", DialogPrompt.MessageType.ERROR_MESSAGE);
	}

	public static void main(String...args) {
		run();
	}


}
