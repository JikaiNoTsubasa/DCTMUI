package fr.triedge.dctm.ui;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow {

	private Stage stage;
	private Scene scene;
	private String theme;
	private BorderPane root;
	private TabPane tabPane;
	private MenuBar menubar;
	private Menu menuFile, menuDctm;
	private MenuItem itemExit;
	
	public MainWindow(Stage stage, String theme) {
		super();
		this.stage = stage;
		this.theme = theme;
	}
	
	public void buildUI() {
		getStage().setTitle("DCTM FX");
		setRoot(new BorderPane());
		getRoot().getStylesheets().add(getClass().getResource(getTheme()).toExternalForm());
		setScene(new Scene(getRoot(), 800, 600));
		getStage().setScene(getScene());
		setTabPane(new TabPane());
		
		// Menu
		setMenubar(new MenuBar());
		setMenuFile(new Menu("File"));
		setMenuDctm(new Menu("DCTM"));
		setItemExit(new MenuItem("Exit"));
		getMenuFile().getItems().addAll(getItemExit());
		getMenubar().getMenus().addAll(getMenuFile(), getMenuDctm());
		
		getRoot().setTop(getMenubar());
		getRoot().setCenter(getTabPane());
	}
	
	public void show() {
		getStage().show();
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public void setTabPane(TabPane tabPane) {
		this.tabPane = tabPane;
	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Menu menuFile) {
		this.menuFile = menuFile;
	}

	public Menu getMenuDctm() {
		return menuDctm;
	}

	public void setMenuDctm(Menu menuDctm) {
		this.menuDctm = menuDctm;
	}

	public MenuItem getItemExit() {
		return itemExit;
	}

	public void setItemExit(MenuItem itemExit) {
		this.itemExit = itemExit;
	}
}
