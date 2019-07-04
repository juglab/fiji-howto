package sc.fiji.howto.app;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * How to list all JARs in the current classpath
 */
public class GetJARsInClassPath {

	public static void run() {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		for(URL url: ((URLClassLoader)cl).getURLs()){
			System.out.println(url.getPath());
		}
	}

	public static void main(String...args) {
		run();
	}

}
