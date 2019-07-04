package sc.fiji.howto.app;

import net.imagej.ImageJ;

import java.io.File;

/**
 *  How to get the current Fiji installation directory
 */
public class GetFijiDirectory {

	public static void run() {
		ImageJ ij = new ImageJ();
		File base = ij.app().getApp().getBaseDirectory();
		System.out.println(base.getAbsolutePath());
	}

	public static void main(String...args) { run(); }
}
