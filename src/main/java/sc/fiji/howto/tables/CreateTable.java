package sc.fiji.howto.tables;

import net.imagej.ImageJ;
import org.scijava.table.DefaultGenericTable;
import org.scijava.table.GenericTable;

/**
 * How to create a table
 */
public class CreateTable {

	public static void run() {

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

		//show table
		ImageJ ij = new ImageJ();
		ij.ui().show("tables", table);

		//print value in the first row of column "X"
		System.out.println(table.get("X", 1));
	}

	public static void main(String...args) {
		run();
	}
}
