package fr.triedge.dctm.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.triedge.dctm.engine.DocbaseManager;

public class Utils {

	public static DocbaseManager loadDocbaseManager(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(DocbaseManager.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (DocbaseManager) jaxbUnmarshaller.unmarshal(file);
	}
	
	public static void storeDocbaseManager(DocbaseManager man, File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(DocbaseManager.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(man, file);
	}
}
