package pageObjectPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import globalProperties.GlobalClass;

public class ItemsPage extends GlobalClass{

	public ItemsPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy (css = ".row .mb-3")
	List<WebElement> allItems;
	public void items() {		
		String selectedItem = "ZARA COAT 3";
		waitForAppear(allItems);
		WebElement items1 = allItems.stream().filter(neededitem -> neededitem.
				findElement(By.cssSelector("b")).getText().
				contains(selectedItem)).findAny().orElse(null);
		
		items1.click();
		
		}
		
	}
	


