package web.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration {
	
	public Properties properties;
	
	public Properties getPropertyObject() {
		
		FileInputStream file = null;
		try {
			properties = new Properties();
			file = new FileInputStream(System.getProperty("user.dir") + "//web.resources//GlobalData.properties");
			properties.load(file);
		} catch (FileNotFoundException e) {
			System.out.println("did not find globaldata file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error while loading file");
			e.printStackTrace();
		}
		return properties;
	}
}
