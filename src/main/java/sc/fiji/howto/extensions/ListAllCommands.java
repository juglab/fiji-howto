package sc.fiji.howto.extensions;

import net.imagej.ImageJ;
import org.scijava.command.CommandInfo;

import java.util.List;

public class ListAllCommands {

	public static void run() {
		ImageJ ij = new ImageJ();
		List<CommandInfo> commands = ij.command().getCommands();
		for(CommandInfo info : commands) {
			System.out.println(info.getClassName());
		}
	}

	public static void main(String...args) { run(); }
}
