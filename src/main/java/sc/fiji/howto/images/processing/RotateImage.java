package sandbox;

import bdv.util.BdvFunctions;
import io.scif.img.ImgOpener;
import net.imagej.ImageJ;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.RealRandomAccessible;
import net.imglib2.img.Img;
import net.imglib2.img.display.imagej.ImageJFunctions;
import net.imglib2.interpolation.randomaccess.NLinearInterpolatorFactory;
import net.imglib2.realtransform.AffineTransform3D;
import net.imglib2.realtransform.RealViews;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.view.Views;
import org.scijava.ui.UIService;

public class DummyMain
{
	public static void main(String... args) {
		@SuppressWarnings("unchecked")
		Img<UnsignedShortType > image = (Img< UnsignedShortType >)
				new ImgOpener().openImgs("/home/arzt/Documents/Datasets/Example/t1-head.tif").get(0);
		AffineTransform3D transform = new AffineTransform3D();
		transform.rotate(2, Math.PI / 3);
		transform.rotate(1, Math.PI / 4);
		RealRandomAccessible< UnsignedShortType >
				interpolated = Views.interpolate(Views.extendZero(image), new NLinearInterpolatorFactory<>());
		RealRandomAccessible< UnsignedShortType >
				transformed = RealViews.affine(interpolated, transform);
		RandomAccessibleInterval< UnsignedShortType >
				rai = Views.interval(Views.raster(transformed), image);
		ImageJFunctions.show(rai).setDisplayRange(0, 1200);
	}
}
