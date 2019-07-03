
package sc.fiji.howto.images;

import net.imagej.ImageJ;
import net.imagej.plugins.commands.display.AutoContrast;
import net.imglib2.img.Img;

import java.io.IOException;

public class ShowAutoContrast {

	public static void run() throws IOException {

		ImageJ ij = new ImageJ();

		// open images
		Img img = (Img) ij.io().open(Object.class.getResource("/m51.tif").getPath());

		// display images
		ij.ui().show(img);

		// create copy and display it
		Img img2 = img.copy();
		ij.ui().show(img2);

		// run autocontrast on copy
		ij.command().run(AutoContrast.class, true);

	}

	public static void main(String...args) throws IOException {
		run();
	}

}
