package sc.fiji.howto.displays;

import net.imagej.ImageJ;
import org.scijava.ui.DialogPrompt;

/**
 * How to display a warning
 */
public class DisplayWarning {

	public static void run() {
		ImageJ ij = new ImageJ();
		// TODO this looks the same as a plain message with legacy dependency
		ij.ui().showDialog("This is a warning", DialogPrompt.MessageType.WARNING_MESSAGE);
	}

	public static void main(String...args) {
		run();
	}

}
