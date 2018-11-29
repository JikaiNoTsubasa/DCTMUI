package fr.triedge.dctm.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Metric {

	private String name, value;
	private Date date;
	
	public Metric() {
		setDate(new Date());
	}

	public String getValue() {
		return value;
	}

	@XmlElement
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}
	
}
