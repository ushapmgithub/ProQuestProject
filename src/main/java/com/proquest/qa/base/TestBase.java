package com.proquest.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream("C:\\Users\\YATHI\\eclipse-workspace\\"
					+ "ProQuestProject\\src\\main\\java\\com\\proquest\\qa\\config\\config.properties");
			prop.load(in);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void init(String browserName) {
		//String browserName = prop.getProperty("BROWSER");
		if(browserName.equals("FF")) {
			//set the system properties of the Firefox browser driver
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			//Launch the browser
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){
			//set the system properties of the Firefox browser driver
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//Launch the browser
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	}
}

