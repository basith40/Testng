package test1;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test2Test implements ITestListener {
	WebDriver driver;
	ExtentReports eReports;
	
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"/Reports/tests.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Multi Test Report");
		reporter.config().setReportName("Basith Enterprise");
		eReports = new ExtentReports();
		eReports.attachReporter(reporter);
		eReports.setSystemInfo("Tester", "Abdul Basith");
	}
	@AfterTest
	public void endConfig() {
		eReports.flush();
	}
	@Test
	public void errorPage() throws MalformedURLException, IOException {
		eReports.createTest("Error Page");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationstepbystep.com/");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popmake-close"))); 
//		driver.findElement(By.cssSelector(".popmake-close")).click();
		
		List <WebElement> firstBar = driver.findElements(By.cssSelector("nav ul .menu-item a"));
		for(WebElement myElement : firstBar) {
			String links = myElement.getAttribute("href");
			System.out.println(myElement.getText());
		HttpURLConnection connection =	(HttpURLConnection) new URL(links).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int code = connection.getResponseCode();
		if(code>400) {
			Assert.assertTrue(false);
		}
		}	
			WebElement manu = firstBar.stream().filter(bar->bar.getText().contains("Training")).findFirst().orElse(null);		
		manu.click();
		File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ssFile, new File("/users/basith301/downloads/ji.png"));
	
		driver.close();

	}

	@Test
	public void linkbroke() throws MalformedURLException, IOException, InterruptedException {
		eReports.createTest("Link Broken");
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.wegmans.com/");
		List<WebElement> allLink = driver.findElements(By.cssSelector("ul[id='menu-main-menu'] li a"));
		for (WebElement link : allLink) {
			System.out.println(link.getText());
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int recode = conn.getResponseCode();
			if (recode > 400) {
				System.out.println(link.getText());
				Assert.assertTrue(false);

			}
			File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(shot, new File("/users/basith301/downloads/j.jpg"));
		}
		driver.quit();
	}

	@Test
	public void wegmansManu() throws MalformedURLException, IOException {
		eReports.createTest("Wagmans");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.wegmans.com/");
		List<WebElement> manu = driver.findElements(By.cssSelector("ul[class=\"categories-menu\"] li a"));
		for (WebElement mlist : manu) {
			System.out.println(mlist.getText());
			String manuName = mlist.getAttribute("href");
			HttpURLConnection connection = (HttpURLConnection) new URL(manuName).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int code = connection.getResponseCode();
			if (code > 400) {
				System.out.println(mlist.getText());
				Assert.assertTrue(false);

			}

		}
		driver.close();
	}

	@Test
	public void bedssl() {
		eReports.createTest("Bed SSL");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.close();

	}

	@Test
	public void test2() throws IOException, InterruptedException {
		eReports.createTest("Test2");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.youtube.com/");
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.cssSelector("#center #search-input"));
		search.click();
		driver.findElement(By.cssSelector("input[name=\"search_query\"]")).sendKeys("Selnium");
		driver.findElement(By.xpath("//ul[@class=\"sbsb_b\"]/li[1]")).click();
		File nFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(nFile, new File("/users/basith301/downloads/h.gif"));
		driver.close();
		

	}
	

}