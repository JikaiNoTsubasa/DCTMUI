package fr.triedge.dctm.model;

import java.util.Date;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class DocbaseDataManager {

	private ObservableList<XYChart.Data<Date, Integer>> listIndexError, listIndexWaiting, listIndexWarning, listRenderingWaiting;

	public ObservableList<XYChart.Data<Date, Integer>> getListIndexError() {
		return listIndexError;
	}

	public void setListIndexError(ObservableList<XYChart.Data<Date, Integer>> listIndexError) {
		this.listIndexError = listIndexError;
	}

	public ObservableList<XYChart.Data<Date, Integer>> getListIndexWarning() {
		return listIndexWarning;
	}

	public void setListIndexWarning(ObservableList<XYChart.Data<Date, Integer>> listIndexWarning) {
		this.listIndexWarning = listIndexWarning;
	}

	public ObservableList<XYChart.Data<Date, Integer>> getListIndexWaiting() {
		return listIndexWaiting;
	}

	public void setListIndexWaiting(ObservableList<XYChart.Data<Date, Integer>> listIndexWaiting) {
		this.listIndexWaiting = listIndexWaiting;
	}

	public ObservableList<XYChart.Data<Date, Integer>> getListRenderingWaiting() {
		return listRenderingWaiting;
	}

	public void setListRenderingWaiting(ObservableList<XYChart.Data<Date, Integer>> listRenderingWaiting) {
		this.listRenderingWaiting = listRenderingWaiting;
	}

}
