package net.imagej.howto.table;

import net.imagej.ImageJ;
import org.scijava.table.DefaultGenericTable;
import org.scijava.table.GenericTable;
import org.scijava.table.Table;
import org.scijava.table.TableDisplay;

import java.util.List;

public class GetOpenTables {

	public static void run() {

		// create tables
		GenericTable table1 = new DefaultGenericTable();
		GenericTable table2 = new DefaultGenericTable();

		// show tables
		ImageJ ij = new ImageJ();
		ij.ui().show("table1", table1);
		ij.ui().show("table2", table2);

		// list open tables NOT WORKING - ALTERNATIVE?
		System.out.println(ij.object().getObjects(Table.class));

		// list open table displays
		List<TableDisplay> tableDisplays = ij.object().getObjects(TableDisplay.class);
		System.out.println(tableDisplays);
	}

	public static void main(String...args) {
		run();
	}

}
