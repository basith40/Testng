package test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wegmans {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://www.wegmans.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("cookie_action_close_header")).click();

		List<WebElement> manu = driver.findElements(By.cssSelector("ul>li[class='category']"));
		System.out.println(manu.size());
		for (int i = 0; i < manu.size(); i++) {
			System.out.println(manu.get(i).getText());
			if (manu.get(i).getText().contains("Seafood")) {
				manu.get(i).click();
				break;

			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping-context-container")));
		driver.findElement(By.cssSelector(".icon-delete")).click();

		List<WebElement> food = driver.findElements(By.cssSelector("a>div[class='css-1gbmuvq']"));
		System.out.println(food.size());
		for (int i = 0; i < food.size(); i++) {
			System.out.println(food.get(i).getText());
			if (food.get(i).getText().contains("Frozen Fish")) {
				food.get(i).click();
				break;

			}
		}

	}

}
