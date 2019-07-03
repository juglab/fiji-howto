package sc.fiji.howto.headless;

import net.imagej.ImageJ;

public class StartImageJHeadless {

	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().setHeadless(true);
		System.out.println("headless: " + ij.ui().isHeadless());
	}

	public static void main(String...args) {run();}

}
