package sc.fiji.howto.images.processing;

import net.imagej.ImageJ;
import net.imglib2.algorithm.labeling.ConnectedComponents;
import net.imglib2.img.Img;
import net.imglib2.roi.labeling.ImgLabeling;
import net.imglib2.roi.labeling.LabelRegions;
import net.imglib2.type.numeric.IntegerType;

import java.io.IOException;

/**
 * How to count cells / blobs in an image (2D)
 */
public class CountCells {

	public static void run() throws IOException {

		ImageJ ij = new ImageJ();

		//load image
		Img img = (Img) ij.io().open(Object.class.getResource("/blobs.png").getPath());

		//blur image
		Img blurredImg = (Img) ij.op().filter().gauss(img, 3);

		//threshold image
		Img segmentedImg = (Img) ij.op().threshold().otsu(blurredImg);

		//calculate connected components
		ImgLabeling cca = ij.op().labeling().cca(segmentedImg, ConnectedComponents.StructuringElement.FOUR_CONNECTED);

		//show result
		ij.ui().show(cca.getIndexImg());

		//get count of connected components
		LabelRegions<IntegerType> regions = new LabelRegions(cca);
		int cells = regions.getExistingLabels().size();

		//print result
		System.out.println("Counted " + cells + " cells.");
	}

	public static void main(String...args) throws IOException { run(); }

}
