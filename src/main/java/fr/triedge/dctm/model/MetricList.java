package fr.triedge.dctm.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metriclist")
public class MetricList {

	private ArrayList<Metric> metrics = new ArrayList<>();
	private String name;

	public ArrayList<Metric> getMetrics() {
		return metrics;
	}

	@XmlElement(name="metric")
	public void setMetrics(ArrayList<Metric> metrics) {
		this.metrics = metrics;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
}
