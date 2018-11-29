package fr.triedge.dctm.model;

import fr.triedge.dctm.engine.DocbaseManager;

public class Model {

	private DocbaseManager docbaseManager = new DocbaseManager();
	private DocbaseDataManager docbaseDataManager = new DocbaseDataManager();

	public DocbaseManager getDocbaseManager() {
		return docbaseManager;
	}

	public void setDocbaseManager(DocbaseManager docbaseManager) {
		this.docbaseManager = docbaseManager;
	}

	public DocbaseDataManager getDocbaseDataManager() {
		return docbaseDataManager;
	}

	public void setDocbaseDataManager(DocbaseDataManager docbaseDataManager) {
		this.docbaseDataManager = docbaseDataManager;
	}
}
