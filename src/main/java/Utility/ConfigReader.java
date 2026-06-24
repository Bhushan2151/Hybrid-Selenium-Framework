package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	 Properties prop;

	    public ConfigReader() {

	        try {

	            FileInputStream file = new FileInputStream("src/test/resources/config.properties");

	            prop = new Properties();

	            prop.load(file);

	        }

	        catch(IOException e) {

	            e.printStackTrace();
	        }
	    }

	    public String getProperty(String key) {

	        return prop.getProperty(key);
	    }
}
