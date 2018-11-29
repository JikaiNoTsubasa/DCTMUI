package fr.triedge.dctm.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DocbaseInfo {

	private String name, host, username, password;
	private int port, id;
	
	public DocbaseInfo() {
	}
	
	public DocbaseInfo(String name, String host, String username, String password, int port) {
		super();
		this.name = name;
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getHost() {
		return host;
	}
	@XmlElement
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPort() {
		return port;
	}
	@XmlElement
	public void setPort(int port) {
		this.port = port;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
		.append(name)
		.append(" [")
		.append(host)
		.append(":")
		.append(port)
		.append("/")
		.append(username)
		.append("]");
		return builder.toString();
	}
	
	
}
