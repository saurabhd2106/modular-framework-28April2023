package utilis;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {
	


	public static Properties readConfig(String filename) throws Exception {
		filename = filename.trim();

		FileInputStream fileInStream = new FileInputStream(filename);

		Properties property = new Properties();

		property.load(fileInStream);

		return property;
	}



}
