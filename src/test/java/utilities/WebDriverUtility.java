package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class WebDriverUtility {

	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void customwaittodisplayele(WebElement element) throws Throwable {

		int count = 0;

		while (count < 40) {
			try {
				element.isDisplayed();
				break;
			} catch (Throwable e) {
				Thread.sleep(500);
				count++;
			}

		}
	}
	
	public void scrollToEle(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		
	}
	
	public void javascriptclick(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void waituntilElementtobeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void visibleOfElement(WebDriver driver, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	
}
