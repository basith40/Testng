package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlyPractice2 {
	WebDriver driver;
	public OnlyPractice2(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()=' Australia']")
	WebElement country;
	@FindBy(css = "a[class*='action__submit']")
	WebElement submitItems;
	
	public void countrySelect() {
		country.click();
		
	}
	public void itemSubmit() {
		submitItems.click();
	}

}
