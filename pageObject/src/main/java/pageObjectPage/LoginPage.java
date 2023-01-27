package pageObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import globalProperties.GlobalClass;

public class LoginPage extends GlobalClass{
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(css = "#userEmail")
	WebElement email;
	@FindBy(css = "#userPassword")
	WebElement password;
	@FindBy(css = "#login")
	WebElement submit;
	
	public void login(String id,String pass) {
		email.sendKeys(id);
		password.sendKeys(pass);
		submit.click();
	}

}
