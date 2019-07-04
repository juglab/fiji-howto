package sc.fiji.howto.userinput;

import net.imagej.ImageJ;

import java.io.File;

/**
 * How to ask the user for a file
 */
public class AskForFile {

	public static void run() {
		ImageJ ij = new ImageJ();
		File chosenFile = ij.ui().chooseFile(ij.getApp().getBaseDirectory(), "");
		System.out.println(chosenFile.getAbsolutePath());
	}

	public static void main(String...args) { run(); }

}
