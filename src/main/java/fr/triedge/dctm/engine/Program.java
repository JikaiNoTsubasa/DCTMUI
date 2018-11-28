package fr.triedge.dctm.engine;

import fr.triedge.dctm.model.Model;
import fr.triedge.dctm.ui.MainWindow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class Program extends Application{
	
	private MainWindow mainWindow;
	private Model model;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		initProgram();
		initUI(stage);
		initActions();
	}

	private void initActions() {
		getMainWindow().getItemExit().setOnAction(e -> actionExit(e));
	}

	private void initUI(Stage stage) {
		setMainWindow(new MainWindow(stage, "/modena_dark.css"));
		getMainWindow().buildUI();
		getMainWindow().show();
	}

	private void initProgram() {
		// Setup model
		setModel(new Model());
		
		// Load docbases
		
	}
	
	public void openTab(String title, Node node) {
		Tab tab = new Tab(title, node);
		getMainWindow().getTabPane().getTabs().add(tab);
	}
	
	private void actionExit(ActionEvent e) {
		System.exit(0);
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
