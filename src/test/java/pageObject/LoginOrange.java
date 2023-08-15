package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrange {
	WebDriver driver;

	public LoginOrange(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement usrtextbox;

	@FindBy(name = "password")
	private WebElement pswtextbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Loginbutton;
	
	@FindBy(xpath = "//img[@alt='client brand banner']")
	private WebElement Orangeimg;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement logdropicon;
	
	@FindBy(xpath = "//a[@role='menuitem' and .='Logout']")
	private  WebElement logoutbutton;

	public WebElement getLogdropicon() {
		return logdropicon;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}

	public WebElement getOrangeimg() {
		return Orangeimg;
	}

	public WebElement getUsrtextbox() {
		return usrtextbox;
	}

	public WebElement getPswtextbox() {
		return pswtextbox;
	}

	public WebElement getLoginbutton() {
		return Loginbutton;
	}

	

}
