package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[contains(.,'Qualifications')]")
	private WebElement qualificationdropdowm;
	
	
	@FindBy(xpath = "//a[contains(.,'Education')]")
	private WebElement educationvalue;
	
	
	@FindBy(xpath="//div[.='Level']/../../..//div[@class='oxd-table-card'][1]//input")
	private WebElement Bachelorecheckbox;
	
	
	
	
	@FindBy(xpath="//div[.='Level']/../../..//div[@class='oxd-table-card'][1]//input/../../../../..//i[@class='oxd-icon bi-pencil-fill']")
	private WebElement Bacheloreeditcheckbox;
	

	@FindBy(xpath="//button[.=' Cancel ']")
	private WebElement canlebutton;
	
	@FindBy(xpath="//span[contains(.,' Records Found')]")
	private WebElement Vrecordsfound;
	
	
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private WebElement EditEducationtext;


	public WebElement getEditEducationtext() {
		return EditEducationtext;
	}


	public WebElement getVrecordsfound() {
		return Vrecordsfound;
	}


	public WebElement getQualificationdropdowm() {
		return qualificationdropdowm;
	}


	public WebElement getEducationvalue() {
		return educationvalue;
	}


	public WebElement getBachelorecheckbox() {
		return Bachelorecheckbox;
	}


	public WebElement getBacheloreeditcheckbox() {
		return Bacheloreeditcheckbox;
	}


	public WebElement getCanlebutton() {
		return canlebutton;
	}
	
	
}
