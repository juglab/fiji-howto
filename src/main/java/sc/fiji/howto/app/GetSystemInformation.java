package sc.fiji.howto.app;

import net.imagej.ImageJ;
import org.scijava.command.CommandModule;
import org.scijava.plugins.commands.debug.SystemInformation;

import java.util.concurrent.ExecutionException;

/**
 * How to get a bunch of useful information about your system and installation
 */
public class GetSystemInformation {

	/**
	 * .. using the SciJava command <code>SystemInformation</code>
	 */
	public static void run() throws ExecutionException, InterruptedException {
		ImageJ ij = new ImageJ();
		CommandModule module = ij.command().run(SystemInformation.class, true).get();
		String result = (String) module.getOutput("info");
		System.out.println(result);
	}

	public static void main(String...args) throws ExecutionException, InterruptedException { run(); }

}
