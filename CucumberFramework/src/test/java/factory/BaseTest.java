package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties config;
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log;

	public static WebDriver initializeBrowser() throws IOException {

		config = getProperties();

		String browser = config.getProperty("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		/*
		 * switch (browser.toLowerCase()) { case "chrome": driver = new ChromeDriver();
		 * break; case "edge": driver = new EdgeDriver(); break; case "firefox": driver
		 * = new FirefoxDriver(); break; default:
		 * System.out.println("No matching browser"); driver = null; }
		 */

		return driver;
	}

	public static Properties getProperties() throws IOException {
		if (driver == null) {
			config = new Properties();
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");

			config.load(fis);
		}
		return config;

	}

	public static Logger getLogger() {
		log = LogManager.getLogger();
		return log;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

}
