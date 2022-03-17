package FrameworkPackages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configPropReader {
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir") + "//src//test//resources//configs//userproperties.properties";
	 
	 
	 public configPropReader(){
	 BufferedReader reader;
	 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
	 try {
		 properties.load(reader);
		 reader.close();
	 } catch (IOException e) {
		 e.printStackTrace();
	 }
	} catch (FileNotFoundException e) {
		 e.printStackTrace();
	 throw new RuntimeException("userprop.properties not found at " + propertyFilePath);
	 } 
	}
	 
	 public long getImplicitlyWait() { 
		 String implicitlyWait = properties.getProperty("implicitlyWait");
		 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		 else throw new RuntimeException("implicitlyWait not specified in the userprop.properties file."); 
	 }
	 
	 public String getApplicationUrl() {
		 String URL = properties.getProperty("url");
		 if(URL != null) return URL;
		 else throw new RuntimeException("url not specified in the userprop.properties file.");
	 }
	 
	 public String getItem() {
		 String item = properties.getProperty("item");
		 if(item != null) return item;
		 else throw new RuntimeException("item not specified in the userprop.properties file.");
	 }

}
