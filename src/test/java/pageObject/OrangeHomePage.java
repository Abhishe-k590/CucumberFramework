package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
	public WebDriver driver;
	
	
	public OrangeHomePage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	private WebElement titledash;
	
	
	@FindBy(xpath = "//p[.='Employee Distribution by Location']/..")
	private WebElement scroll;
	
	
	@FindBy(xpath = "//p[.='Time at Work']/..")
	private WebElement tawscroll;
	
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li[1]//span")
	private WebElement Admintab;


	public WebElement getAdmintab() {
		return Admintab;
	}

	public WebElement getTawscroll() {
		return tawscroll;
	}

	public WebElement getScroll() {
		return scroll;
	}

	public void setScroll(WebElement scroll) {
		this.scroll = scroll;
	}

	public WebElement getTitledash() {
		return titledash;
	}

	public void setTitledash(WebElement titledash) {
		this.titledash = titledash;
	}

}
