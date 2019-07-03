package net.imagej.howto.classpath;

import org.scijava.util.POM;

import java.util.List;
import java.util.Optional;

public class GetVersionOfMavenArtifact {

	public static void run() {

		List<POM> poms = POM.getAllPOMs();
		Optional<POM> imageJOpsPOM = poms.stream().filter(pom -> pom.getArtifactId().equalsIgnoreCase("fiji-howto")).findFirst();
		if(imageJOpsPOM.isPresent()) {
			System.out.println(imageJOpsPOM.get().getVersion());
		}

	}

	public static void main(String ... args) {
		run();
	}
}
