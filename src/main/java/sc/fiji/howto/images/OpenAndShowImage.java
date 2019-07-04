package sc.fiji.howto.images;

import io.scif.img.IO;
import net.imagej.ImageJ;
import net.imglib2.img.Img;
import net.imglib2.img.display.imagej.ImageJFunctions;

import java.io.IOException;

/**
 * How to open and show an image
 */
public class OpenAndShowImage {

	/**
	 * .. from the ImageJ instance:
	 */
	public static void run() throws IOException {

		ImageJ ij = new ImageJ();

		// open image from local resource
		Img img = (Img) ij.io().open(Object.class.getResource("/blobs.png").getPath());

		// show image
		ij.ui().show(img);
	}

	/**
	 * .. by using static methods:
	 */
	public static void runStatic() {

		//TODO displays image, but throws this exception:
		// Required service is missing: net.imagej.legacy.LegacyService

		// open image statically
		Img img = IO.openImgs(Object.class.getResource("/blobs.png").getPath()).get(0);

		// display image statically
		ImageJFunctions.show(img);
	}

	public static void main(String...args) throws IOException {
//		run();
		runStatic();
	}

}
