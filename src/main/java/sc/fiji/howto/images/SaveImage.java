package sc.fiji.howto.images;

import net.imagej.ImageJ;
import net.imglib2.img.Img;

import java.io.IOException;
import java.nio.file.Files;

/**
 * How to save an image
 */
public class SaveImage {

	public static void run() throws IOException {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();

		// TODO why can I not save this image?
//		Img<DoubleType> img = ij.op().create().img(new long[]{20, 30});
		Img img = (Img) ij.io().open(Object.class.getResource("/blobs.png").getPath());

		// create temporary path to save image to
		String dest = Files.createTempFile("img", ".png").toString();
		System.out.println("Saving image to " + dest);

		// save image
		ij.io().save(img, dest);

		// load and show saved image
		Object savedImg = ij.io().open(dest);
		ij.ui().show("saved image", savedImg);
	}

	public static void main(String...args) throws IOException {run();}

}
