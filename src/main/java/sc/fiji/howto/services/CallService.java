package sc.fiji.howto.services;

import net.imagej.ImageJ;
import org.scijava.Context;
import org.scijava.io.IOService;

/**
 * How to call a service
 */
public class CallService {

	public static void call() {

		// get an IOService instance
		ImageJ ij = new ImageJ();
		IOService io = ij.io();

		// print the name of the class implementing the IOService
		System.out.println(io.getClass().getName());
	}

	public static void callWithoutImageJ() {

		// get an IOService instance
		Context context = new Context(IOService.class);
		IOService io = context.getService(IOService.class);

		// print the name of the class implementing the IOService
		System.out.println(io.getClass().getName());
	}

	public static void main(String...args) {
		call();
		callWithoutImageJ();
	}

}
