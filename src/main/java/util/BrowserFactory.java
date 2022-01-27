package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	static String browser;
	static String url;
	static WebDriver driver;
	public static void readConfigProperties()  {
		try {
		InputStream input = new FileInputStream(".\\src\\main\\java\\config.properties");
		Properties prop = new Properties();
		prop.load(input);
		browser = prop.getProperty("browser");
		System.out.println("Browser used: " + browser);
		url = prop.getProperty("url");}
		catch(IOException e) {e.printStackTrace();}
		
	}
	public static WebDriver init()  {
		readConfigProperties();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\driver2\\chromedriver.exe");
			}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\driver2\\geckodriver.exe");
		}
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}


}
