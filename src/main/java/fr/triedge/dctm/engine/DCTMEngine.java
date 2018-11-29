package fr.triedge.dctm.engine;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.common.DfException;

import fr.triedge.dctm.model.DocbaseInfo;
import fr.triedge.dctm.model.Metric;
import fr.triedge.dctm.ui.UI;

public class DCTMEngine {

	public Metric getIndexFailed(IDfSession session, DocbaseInfo info) {
		String dqlIndexFailed = "select count(*) as cnt from dm_queue_item where name like 'dm_fulltext%' and task_state ='failed'";
		IDfCollection colIndexFailed;
		try {
			colIndexFailed = DFC.executeDQL(session, dqlIndexFailed);
			int res = 0;
			while (colIndexFailed.next()) {
				res = colIndexFailed.getInt("cnt");
			}
			Metric met = new Metric();
			met.setName("index");
			met.setValue(res+"");
			return met;
		} catch (DfException e) {
			UI.error("Cannot execute DQL", e);
		}
		return null;
	}
	
}
