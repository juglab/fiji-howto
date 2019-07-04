package sc.fiji.howto.extensions;

import net.imagej.ImageJ;
import org.scijava.command.CommandModule;

import java.util.concurrent.ExecutionException;

/**
 * How to get the result of a command
 */
public class GetExampleCommandResult {

	public static void run() throws ExecutionException, InterruptedException {
		ImageJ ij = new ImageJ();
		CommandModule command = ij.command().run(ExampleCommand.class, true, "name", "Ada").get();
		Object output = command.getOutput("response");
		System.out.println(output);
	}

	public static void main(String...args) throws ExecutionException, InterruptedException {
		run();
	}

}
