package sc.fiji.howto.displays;

import net.imagej.ImageJ;
import org.scijava.ui.DialogPrompt;

public class DisplayInfo {

	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().showDialog("Everything is fine", DialogPrompt.MessageType.INFORMATION_MESSAGE);
	}

	public static void main(String...args) {
		run();
	}

}
