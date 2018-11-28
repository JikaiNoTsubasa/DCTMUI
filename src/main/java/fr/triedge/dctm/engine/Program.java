package fr.triedge.dctm.engine;

import fr.triedge.dctm.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application{
	
	private MainWindow mainWindow;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		initProgram();
	}

	private void initProgram() {
		
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

}
