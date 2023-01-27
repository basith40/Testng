package pageObjectBaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

public class PageBase {
	public WebDriver driver;
	public Properties properties;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public WebDriver browserSelect() throws IOException {
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/globalProperties/application.properties");
		properties.load(fileInputStream);
		String browserinboke = properties.getProperty("browser");
		if (browserinboke.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserinboke.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserinboke.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		driver.get(properties.getProperty("webaddress"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	//@AfterMethod
	public void applicationClose() {
		driver.close();
	}

}
