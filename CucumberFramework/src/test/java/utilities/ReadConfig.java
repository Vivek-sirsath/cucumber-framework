package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	// Store the path of config.properties file in a String variable
	String path = (System.getProperty("user.dir") + "/configuration/config.properties");

	// Create the object of Properties class
	Properties properties;

	public ReadConfig() {

		// Initialize the properties object
		properties = new Properties();

		// Create the FileInputStream object
		try {
			FileInputStream fis = new FileInputStream(path);

			// Load FileInputStream object
			properties.load(fis); // Here IOException comes

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// Change the 'FileNotFoundException' to 'Exception'
			System.out.println("Exception message of FileInputStream: " + e.getMessage());
		}

	}

	public String getBrowser() {

		String browser = properties.getProperty("browser");

		if (browser != null)
			return browser;
		else
			throw new RuntimeException("Browser not defined in 'config.properties' file");

	}

}
