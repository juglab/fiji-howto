package net.imagej.howto;

import net.imagej.howto.classpath.GetVersionOfMavenArtifact;
import net.imagej.howto.image.DrawCircle;
import net.imagej.howto.image.GetOpenImages;
import net.imagej.howto.image.OpenImage;
import net.imagej.howto.table.CreateTable;
import net.imagej.howto.table.GetOpenTables;
import org.junit.Test;

import java.io.IOException;

public class TestAll {

	@Test
	public void testIO() throws IOException {
		OpenImage.main();
		GetOpenImages.main();
		DrawCircle.main();
	}

	@Test
	public void testClasspath() {
		GetVersionOfMavenArtifact.main();
	}

	@Test
	public void testTables() {
		CreateTable.main();
		GetOpenTables.main();
	}
}
