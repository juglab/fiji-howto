package net.imagej.howto;

import net.imagej.howto.classpath.GetInformationFromPOM;
import net.imagej.howto.io.OpenImage;
import org.junit.Test;

import java.io.IOException;

public class TestAll {

	@Test
	public void testIO() throws IOException {
		OpenImage.main();
	}

	@Test
	public void testClasspath() {
		GetInformationFromPOM.main();
	}
}
