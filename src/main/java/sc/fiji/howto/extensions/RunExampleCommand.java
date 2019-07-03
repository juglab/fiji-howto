package sc.fiji.howto.extensions;

import net.imagej.ImageJ;

import java.util.concurrent.ExecutionException;

public class RunExampleCommand {

	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true);
	}

	public static void runWithParameters() {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true, "name", "Ada");
	}

	public static void runAndWait() throws ExecutionException, InterruptedException {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true, "name", "Ada").get();
	}

	public static void runWithoutPrePostProcessing() {
		ImageJ ij = new ImageJ();
		ij.command().run(ExampleCommand.class, false, "name", "Ada");
	}

	public static void main(String...args) throws ExecutionException, InterruptedException {
		run();
		runWithParameters();
		runAndWait();
		runWithoutPrePostProcessing();
	}

}
