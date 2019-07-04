package sc.fiji.howto.tables;

import net.imagej.ImageJ;
import org.scijava.table.DefaultGenericTable;
import org.scijava.table.GenericTable;

import java.io.IOException;
import java.nio.file.Files;

/**
 * How to save and load a table
 */
public class SaveAndLoadTable {

	public static void run() throws IOException {

		ImageJ ij = new ImageJ();

		//create table
		GenericTable table = new DefaultGenericTable();
		table.appendColumn("X");
		table.appendColumn("Y");
		table.appendRow();
		table.set("X", 0, 10);
		table.set("Y", 0, 20);
		table.appendRow();
		table.set("X", 1, 30);
		table.set("Y", 1, 40);


		// create temporary path to save image to
		String dest = Files.createTempFile("table", ".csv").toString();
		System.out.println("Saving table to " + dest);

		// save table
		// TODO does not work if I don't include the scijava-plugins-io-table dependency
		// TODO with the scijava-plugins-io-table dependency it saves and loads, but still throws errors
		// TODO related forum post: https://forum.image.sc/t/can-you-save-a-defaultgenerictable-displayed-with-uiservice/12036/7
		ij.io().save(table, dest);

		// load and show saved image
		Object savedTable = ij.io().open(dest);
		ij.ui().show("saved table", savedTable);
	}

	public static void main(String...args) throws IOException {
		run();
	}
}
