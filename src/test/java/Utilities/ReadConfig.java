package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	//create object for properties
	Properties properties;
	
	//path of properties
	String path = "config.properties";
	
	//constructor
	public ReadConfig() {
		
		//initiate properties object
		properties = new Properties();
		
		//to read path create object fileinputstream NEXT TRY Catch method usage
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//create method for browser
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null) {
			return value;
		} else {
			throw new RuntimeException("browser are not specified in file");
		}
	}
}
