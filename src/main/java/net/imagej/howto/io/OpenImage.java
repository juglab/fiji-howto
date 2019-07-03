package net.imagej.howto.io;

import io.scif.img.IO;
import net.imagej.ImageJ;
import net.imglib2.img.Img;

import java.io.IOException;

public class OpenImage {

	public static void openImage() throws IOException {

		ImageJ ij = new ImageJ();
		Img img = (Img) ij.io().open(Object.class.getResource("/blobs.png").getPath());

		System.out.println(img);
	}

	public static void openImageStatic() {

		Img img = IO.openImgs(Object.class.getResource("/blobs.png").getPath()).get(0);

		System.out.println(img);
	}

	public static void main() throws IOException {
		openImage();
		openImageStatic();
	}

}
