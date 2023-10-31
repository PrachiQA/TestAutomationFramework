package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {

		FileReader fileReader = new FileReader(
				"D:\\SeleniumAutomationFrameworkHybrid-Eclipse\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
		Properties property = new Properties();
		property.load(fileReader);
		System.out.println(property.getProperty("browser"));
		System.out.println(property.getProperty("testurl"));

	}

}
