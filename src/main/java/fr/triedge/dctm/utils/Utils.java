package fr.triedge.dctm.utils;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.triedge.dctm.engine.DocbaseManager;

public class Utils {
	
	public static Properties config;
	public static final String CONF					= "conf/dctmui.properties";
	
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T loadXML(Class<T> clazz, File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (T) jaxbUnmarshaller.unmarshal(file);
	}
	
	public static <T> void storeXML(T clazz, File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(clazz, file);
	}

	/*
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
	*/
}
