package fr.triedge.dctm.engine;

import java.util.Date;

import fr.triedge.dctm.model.DocbaseDataManager;
import fr.triedge.dctm.utils.Utils;
import javafx.application.Platform;
import javafx.scene.chart.XYChart.Data;

public class ProcessUpdate implements Runnable{

	private Program program;
	private int seconds;
	
	public ProcessUpdate(Program program, int seconds) {
		super();
		this.program = program;
		this.seconds = seconds;
	}

	@Override
	public void run() {
		while (true) {
			try {
				DocbaseDataManager man = getProgram().getModel().getDocbaseDataManager();
				Platform.runLater(new Runnable() {
	                 @Override public void run() {
	                     man.getListIndexError().add(new Data<Date, Integer>(new Date(), Utils.random(1, 100)));
	                     man.getListIndexWarning().add(new Data<Date, Integer>(new Date(), Utils.random(1, 100)));
	                     man.getListIndexWaiting().add(new Data<Date, Integer>(new Date(), Utils.random(1, 100)));
	                     man.getListRenderingWaiting().add(new Data<Date, Integer>(new Date(), Utils.random(1, 10)));
	                 }
	             });
				if (man.getListIndexError().size() > 5) {
					man.getListIndexError().remove(0);
				}
				if (man.getListIndexWarning().size() > 5) {
					man.getListIndexWarning().remove(0);
				}
				if (man.getListIndexWaiting().size() > 5) {
					man.getListIndexWaiting().remove(0);
				}
			} catch(Exception e) {
				
			}
			try {
				Thread.sleep(1000 * getSeconds());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
