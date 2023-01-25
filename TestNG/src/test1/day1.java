package test1;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day1 {
	WebDriver driver;
	@Test
	public void demo() throws InterruptedException, IOException {
		driver = new ChromeDriver();       
		driver.get("https://www.amazon.com/");		
		driver.findElement(By.cssSelector("#nav-link-accountList")).click();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("basithj@yahoo.com");
		driver.findElement(By.cssSelector("#continue")).click();
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("Shammi");
		driver.findElement(By.cssSelector("#signInSubmit")).click();
		Thread.sleep(3000);		
		String text = driver.findElement(By.cssSelector(".a-alert-content span")).getText();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/Users/basith301/downloads/src.png"));
		System.out.println(text);
		driver.close();
	}

}
