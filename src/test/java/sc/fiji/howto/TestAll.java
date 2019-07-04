package sc.fiji.howto;

import sc.fiji.howto.app.GetFijiDirectory;
import sc.fiji.howto.app.GetJARsInClassPath;
import sc.fiji.howto.app.GetSystemInformation;
import sc.fiji.howto.displays.DisplayError;
import sc.fiji.howto.displays.DisplayInfo;
import sc.fiji.howto.displays.DisplayWarning;
import sc.fiji.howto.app.GetVersionOfMavenArtifact;
import sc.fiji.howto.extensions.GetExampleCommandResult;
import sc.fiji.howto.extensions.ListAllCommands;
import sc.fiji.howto.extensions.RunExampleCommand;
import sc.fiji.howto.headless.StartImageJHeadless;
import sc.fiji.howto.images.*;
import sc.fiji.howto.images.drawing.DrawCircle;
import sc.fiji.howto.images.drawing.DrawRectangle;
import sc.fiji.howto.images.processing.CountCells;
import sc.fiji.howto.services.CallService;
import sc.fiji.howto.services.ListAllServices;
import sc.fiji.howto.tables.CreateTable;
import sc.fiji.howto.tables.GetOpenTables;
import org.junit.Test;
import sc.fiji.howto.tables.SaveAndLoadTable;
import sc.fiji.howto.userinput.AskForFile;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TestAll {

	@Test
	public void testApp() throws ExecutionException, InterruptedException {
		GetFijiDirectory.main();
		GetVersionOfMavenArtifact.main();
		GetJARsInClassPath.main();
		GetSystemInformation.main();
	}

	@Test
	public void testTables() throws IOException {
		CreateTable.main();
		GetOpenTables.main();
//		SaveAndLoadTable.main();
	}

	@Test
	public void testHeadless() {
		StartImageJHeadless.main();
	}

	@Test
	public void testExtensions() throws ExecutionException, InterruptedException {
		ListAllCommands.main();
		RunExampleCommand.main();
		GetExampleCommandResult.main();
	}

	@Test
	public void testDisplays() {
		DisplayInfo.run();
		DisplayWarning.run();
		DisplayError.run();
	}

	@Test
	public void testImages() throws IOException {
		CreateImage.main();
		DuplicateImage.main();
//		GetOpenImages.main();
//		SaveImage.main();
		ShowAutoContrast.main();
		DrawCircle.main();
		DrawRectangle.main();
		CountCells.main();
//		OpenAndShowImage.main();
	}

	@Test
	public void testServices() {
		CallService.main();
		ListAllServices.main();
	}

	@Test
	public void testUserInput() {
//		AskForFile.main();
	}
}
