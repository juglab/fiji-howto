package sc.fiji.howto.images.drawing;

import net.imagej.ImageJ;
import net.imglib2.RandomAccess;
import net.imglib2.algorithm.region.hypersphere.HyperSphere;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.real.DoubleType;

/**
 * How to draw a circle
 */
public class DrawCircle {

	public static void run() {

		ImageJ ij = new ImageJ();

		// create two images describing local shift
		Img<DoubleType> img = ij.op().create().img(new long[] { 256, 254 });

		RandomAccess<DoubleType> ra = img.randomAccess();
		ra.setPosition(new long[] { 70, 98 });

		HyperSphere<DoubleType> hyperSphere = new HyperSphere<>(img, ra, 30);
		for (DoubleType value : hyperSphere)
			value.set(25);

		ij.ui().show(img);
	}

	public static void main(String...args) { run(); }
}
