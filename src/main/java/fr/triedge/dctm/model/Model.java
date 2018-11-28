package fr.triedge.dctm.model;

import fr.triedge.dctm.engine.DocbaseManager;

public class Model {

	private DocbaseManager docbaseManager = new DocbaseManager();

	public DocbaseManager getDocbaseManager() {
		return docbaseManager;
	}

	public void setDocbaseManager(DocbaseManager docbaseManager) {
		this.docbaseManager = docbaseManager;
	}
}
