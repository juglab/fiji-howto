package sc.fiji.howto.extensions;

import net.imagej.ImageJ;

import java.util.concurrent.ExecutionException;

/**
 * How to run a command
 */
public class RunExampleCommand {

	/**
	 * .. this will run the Command in a new Thread:
	 */
	public static void run() {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true);
	}

	/**
	 * .. this is how you can attach parameters to the Command:
	 */
	public static void runWithParameters() {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true, "name", "Ada");
	}

	/**
	 * .. how to wait for the Command to finish:
	 */
	public static void runAndWait() throws ExecutionException, InterruptedException {
		ImageJ ij = new ImageJ();
		ij.ui().showUI();
		ij.command().run(ExampleCommand.class, true, "name", "Ada").get();
	}

	/**
	 * .. how to avoid pre- and postprocessing (his will prevent the popup to open which asks the user for missing input parameters, this will also prevent output parameters to be displayed automatically):
	 */
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
