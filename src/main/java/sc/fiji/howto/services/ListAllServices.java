package sc.fiji.howto.services;

import net.imagej.ImageJ;
import org.scijava.plugin.PluginInfo;
import org.scijava.plugin.SciJavaPlugin;
import org.scijava.service.Service;

import java.util.List;

public class ListAllServices {

	public static void run() {
		ImageJ ij = new ImageJ();
		List<PluginInfo<Service>> services = ij.plugin().getPluginsOfType(Service.class);
		for(PluginInfo service : services) {
			System.out.println(service.getPluginClass());
		}
	}

	public static void main(String...args) {
		run();
	}
}
