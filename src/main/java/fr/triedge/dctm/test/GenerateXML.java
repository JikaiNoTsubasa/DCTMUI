package fr.triedge.dctm.test;

import java.io.File;

import javax.xml.bind.JAXBException;

import fr.triedge.dctm.engine.DocbaseManager;
import fr.triedge.dctm.model.DocbaseInfo;
import fr.triedge.dctm.utils.SBIEncrypter;
import fr.triedge.dctm.utils.Utils;

public class GenerateXML {

	public static void main(String[] args) {
		DocbaseManager man = new DocbaseManager();
		DocbaseInfo info = new DocbaseInfo("DOCBASE_NAME", "DOCBASE_HOST", "USERNAME", SBIEncrypter.encrypt("PASSWORD"), 1489);
		man.getDocbaseInfo().add(info);
		try {
			Utils.storeXML(man, new File("storage/docbases.sbi"));
			System.out.println("Terminated");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
