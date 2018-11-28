package fr.triedge.dctm.engine;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import fr.triedge.dctm.model.DocbaseInfo;

@XmlRootElement(name="root")
public class DocbaseManager {

	private ArrayList<DocbaseInfo> docbaseInfo =new ArrayList<>();

	public ArrayList<DocbaseInfo> getDocbaseInfo() {
		return docbaseInfo;
	}

	@XmlElement(name="docbase")
	public void setDocbaseInfo(ArrayList<DocbaseInfo> docbaseInfo) {
		this.docbaseInfo = docbaseInfo;
	}
}
