package pageObjectPositiveTest;

import org.testng.annotations.Test;
import pageObjectBaseTest.PageBase;
import pageObjectPage.ItemsPage;
import pageObjectPage.LoginPage;

public class PositiveTest extends PageBase{
	@Test
	public void loginToTheApplication() {
		LoginPage lPage = new LoginPage(driver);
		lPage.login(properties.getProperty("username"),properties.getProperty("password"));
		ItemsPage myItem = new ItemsPage(driver);
		myItem.items();
	}

}
