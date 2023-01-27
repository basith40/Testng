package globalProperties;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalClass {
	public WebDriver driver;	
	public GlobalClass (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	public WebDriverWait waitForAppear(List<WebElement> allItems) {
		WebDriverWait eAppear = new WebDriverWait(driver, Duration.ofSeconds(5));
		eAppear.until(ExpectedConditions.visibilityOfAllElements(allItems));
		return eAppear;
	}
	public WebDriverWait waitForDisappear(WebElement by) {
		WebDriverWait eDisapper = new WebDriverWait(driver, Duration.ofSeconds(5));
		eDisapper.until(ExpectedConditions.invisibilityOf(by));
		return eDisapper;
	}

}
