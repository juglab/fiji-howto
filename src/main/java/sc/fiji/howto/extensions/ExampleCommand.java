package sc.fiji.howto.extensions;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, label = "Example Command")
public class ExampleCommand implements Command {

	@Parameter
	String name;

	@Parameter(type = ItemIO.OUTPUT)
	String response;

	@Override
	public void run() {
		response = "I am " + name;
	}
}
