package fr.triedge.dctm.ui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Optional;

import fr.triedge.dctm.utils.Utils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class UI {

	public static <T> T dialogChoose(ArrayList<T> list) {
		ChoiceDialog<T> dialog = new ChoiceDialog<T>( null, list);
		dialog.setTitle("Choice Dialog");
		dialog.setHeaderText("");
		dialog.setContentText("Select an item:");
		dialog.getDialogPane().getStylesheets().add(UI.class.getResource(Utils.config.getProperty("dctmui.fx.theme", "/modena_dark.css")).toExternalForm());
		
		Optional<T> result = dialog.showAndWait();
		if (result.isPresent()){
		    return result.get();
		}
		return null;
	}
	
	public static void error(String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("");
		alert.setContentText(content);
		alert.getDialogPane().getStylesheets().add(UI.class.getResource(Utils.config.getProperty("dctmui.fx.theme", "/modena_dark.css")).toExternalForm());

		alert.showAndWait();
	}
	
	public static void error(String content, Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("");
		alert.setContentText("Error message: "+e.getMessage());
		alert.getDialogPane().getStylesheets().add(UI.class.getResource(Utils.config.getProperty("dctmui.fx.theme", "/modena_dark.css")).toExternalForm());

		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String exceptionText = sw.toString();


		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(textArea, 0, 0);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
}
