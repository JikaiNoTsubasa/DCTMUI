package fr.triedge.dctm.ui;

import java.util.Date;

import fr.triedge.dctm.engine.Program;
import fr.triedge.dctm.model.DateAxis;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class DocbasePanel extends BorderPane{
	
	private GridPane gridPane;
	private LineChart<Date, Number> indexChart;
	private LineChart<Date, Number> renditionChart;

	public DocbasePanel() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public void buildUI(Program program) {
		setGridPane(new GridPane());
		
		final DateAxis indexX = new DateAxis();
        final NumberAxis indexY = new NumberAxis();
        final DateAxis renderX = new DateAxis();
        final NumberAxis renderY = new NumberAxis();
        indexX.setLabel("Date");
        //creating the chart
        indexChart = new LineChart<Date,Number>(indexX,indexY);
        renditionChart = new LineChart<Date,Number>(renderX,renderY);
                
        indexChart.setTitle("Indexing Status");
        renditionChart.setTitle("Rendering");
        //defining a series
        XYChart.Series indexFailed = new XYChart.Series<>();
        indexFailed.setName("Index Failed");
        indexFailed.setData(program.getModel().getDocbaseDataManager().getListIndexError());
        XYChart.Series indexWarning = new XYChart.Series<>();
        indexWarning.setName("Index Warning");
        indexWarning.setData(program.getModel().getDocbaseDataManager().getListIndexWarning());
        XYChart.Series indexWaiting = new XYChart.Series<>();
        indexWaiting.setName("Index Waiting");
        indexWaiting.setData(program.getModel().getDocbaseDataManager().getListIndexWaiting());
        
        XYChart.Series renderingWaiting = new XYChart.Series<>();
        renderingWaiting.setName("Rendering Waiting");
        renderingWaiting.setData(program.getModel().getDocbaseDataManager().getListRenderingWaiting());
        
        indexChart.getData().addAll(indexFailed, indexWarning, indexWaiting);
        renditionChart.getData().addAll(renderingWaiting);
        
        getGridPane().add(indexChart, 0, 0);
        getGridPane().add(renditionChart, 1, 0);
        setCenter(getGridPane());
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public LineChart<Date, Number> getIndexChart() {
		return indexChart;
	}

	public void setIndexChart(LineChart<Date, Number> indexChart) {
		this.indexChart = indexChart;
	}

	public LineChart<Date, Number> getRenditionChart() {
		return renditionChart;
	}

	public void setRenditionChart(LineChart<Date, Number> renditionChart) {
		this.renditionChart = renditionChart;
	}
}
