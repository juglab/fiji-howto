package sc.fiji.howto.displays;

import net.imagej.ImageJ;
import org.scijava.ui.DialogPrompt;

public class DisplayWarning {

	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().showDialog("This is a warning", DialogPrompt.MessageType.WARNING_MESSAGE);
	}

	public static void main(String...args) {
		run();
	}

}
