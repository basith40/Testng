package test1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLink {
	@Test
	public void linkBroken() throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wegmans.com/");
		List<WebElement> footerTag = driver.findElements(By.cssSelector("ul[class='menu'] a"));
		for(WebElement link : footerTag) {
			String url = link.getAttribute("href");
		HttpURLConnection myUrl = (HttpURLConnection)new URL(url).openConnection();
		myUrl.setRequestMethod("HEAD");
		myUrl.connect();
		int code = myUrl.getResponseCode();
		if(code>400) {
			System.out.println(link.getText());
			Assert.assertTrue(false);
		}
	}
	}

}
