package fr.triedge.dctm.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.xml.bind.JAXBException;

import fr.triedge.dctm.model.DocbaseDataManager;
import fr.triedge.dctm.model.DocbaseInfo;
import fr.triedge.dctm.model.Model;
import fr.triedge.dctm.ui.DocbasePanel;
import fr.triedge.dctm.ui.MainWindow;
import fr.triedge.dctm.ui.UI;
import fr.triedge.dctm.utils.Utils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.chart.XYChart.Data;
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
		getMainWindow().getItemOpenDctmDashboard().setOnAction(e -> actionOpenDctmDashboard(e));
	}

	private void actionOpenDctmDashboard(ActionEvent e) {
		DocbaseInfo res = UI.dialogChoose(getModel().getDocbaseManager().getDocbaseInfo());
		if (res == null)
			return;
		DocbasePanel pan = new DocbasePanel();
		openTab(res.getName(), pan);
		DocbaseDataManager man = getModel().getDocbaseDataManager();
		man.setListIndexError(FXCollections.observableArrayList());
		man.setListIndexWarning(FXCollections.observableArrayList());
		man.setListIndexWaiting(FXCollections.observableArrayList());
		man.setListRenderingWaiting(FXCollections.observableArrayList());
		pan.buildUI(this);
		
		ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
		
		ProcessUpdate pu = new ProcessUpdate(this, 1);
		executor.execute(pu);
	}

	private void initUI(Stage stage) {
		setMainWindow(new MainWindow(
				stage, 
				Utils.config.getProperty("dctmui.fx.theme", "/modena_dark.css"), 
				Utils.config.getProperty("dctmui.fx.title", "DCTM FX")
				));
		getMainWindow().buildUI();
		getMainWindow().show();
	}

	private void initProgram() {
		// Init config
		Utils.config = new Properties();
		try {
			Utils.config.load(new FileInputStream(new File(Utils.CONF)));
		} catch (IOException e1) {
			UI.error("Cannot load config", e1);
		}
		
		// Setup model
		setModel(new Model());
		
		// Load docbases
		try {
			DocbaseManager doc = Utils.loadXML(DocbaseManager.class, new File(Utils.config.getProperty("dctmui.docbase.storage", "storage")));
			getModel().setDocbaseManager(doc);
		} catch (JAXBException e) {
			UI.error("Cannot load docbases", e);
		}
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
