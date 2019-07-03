package sc.fiji.howto.app;

import org.scijava.util.POM;

import java.util.List;
import java.util.Optional;

public class GetVersionOfMavenArtifact {

	public static void run() {

		List<POM> poms = POM.getAllPOMs();
		Optional<POM> imageJOpsPOM = poms.stream().filter(pom -> pom.getArtifactId().equalsIgnoreCase("imagej-ops")).findFirst();
		if(imageJOpsPOM.isPresent()) {
			String version = imageJOpsPOM.get().getVersion();
			System.out.println(version);
		}

	}

	public static void runWithPath() {

		List<POM> poms = POM.getAllPOMs();
		POM imageJOpsPOM = null;
		for(POM pom : poms) {
			if(pom.getArtifactId().equalsIgnoreCase("imagej-ops")) {
				imageJOpsPOM = pom;
				break;
			}
		}
		if(imageJOpsPOM != null) {
			String version = imageJOpsPOM.cdata("project/version");
			System.out.println(version);
		}

	}

	public static void main(String ... args) {
		run();
		runWithPath();
	}
}
