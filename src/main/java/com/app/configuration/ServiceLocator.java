//package com.app.configuration;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Properties;
//
//public class ServiceLocator {
//	private static Properties properties;
//
//	private static final String PROPERTY_FILE_PATH = "";
//	private static final String PROPERTY_FILE = "/home/ranjanmondal/Documents/project/practise-app/src/main/resources/application-dev.properties";
//
//
//	//private static final File configDirectory = new File(System.getProperty("catalina.base"), "bin/properties");
//
//	//private static final File configDirectory = new File("/home/ranjanmondal/Documents/project/practise-app/src/main/java/com/app/configuration/application-stag.properties");
//
//	private static ServiceLocator getInstance = null;
//
//	static {
//		if (getInstance == null) {
//			synchronized (ServiceLocator.class) {
//				getInstance = new ServiceLocator();
//				propertiesFileReader();
//			}
//		}
//	}
//
//	public static ServiceLocator getInstance() {
//		if (getInstance == null) {
//			synchronized (ServiceLocator.class) {
//				getInstance = new ServiceLocator();
//				propertiesFileReader();
//			}
//		}
//		return getInstance;
//	}
//
//	public String getValueAsPerKey(String key) {
//		return properties.getProperty(key);
//	}
//
//
//	private static void propertiesFileReader() {
////		try {
////			Files.list(new File("/home/ranjanmondal/Documents/project/practise-app/src/main/java/com/app/configuration/application-stag.properties").toPath())
////					.limit(10)
////					.forEach(path -> {
////						System.out.println(path);
////					});
////		}catch (Exception e){
////			System.out.println(e);
////		}
//
//		properties = new Properties();
//		try {
//			File configFile = new File(PROPERTY_FILE);
//			FileInputStream fis = new FileInputStream(configFile);
//			properties.load(fis);
//			fis.close();
//		} catch (Exception e) {
//			System.out.println("Exception in properties " + e);
//			//MediaSchedulerErrorLogger.INSTANCE.getLogger().error("ServiceLocator::propertiesFileReader::EXCEPTION IN PROPERTY FILE READER:: {}", e.getMessage());
//			System.exit(0);
//		}
//	}
//
//	public String reloadProperties() {
//
//		String result = null;
//		try {
//			propertiesFileReader();
//			result = "Success";//ResponseLiteral.SUCCESS;
//		} catch (Exception ex) {
//			result = ex.getMessage();
//		}
//
//		return result;
//	}
//
//	public void setValue(String pKey, String pValue) {
//		properties.setProperty(pKey, pValue);
//		try {
//			File configFile = new File(PROPERTY_FILE);
//			FileOutputStream outFile = new FileOutputStream(configFile);
//			properties.store(outFile, "---- SERVICE LOCATOR PROPERTY ---- ");
//			outFile.close();
//		} catch (Exception e) {
//			System.out.println("Exception in properties " + e);
//		}
//	}
//}
