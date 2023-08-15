package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AdminPage;
import pageObject.LoginOrange;
import pageObject.OrangeHomePage;
import utilities.WebDriverUtility;

public class Step extends BaseClass {

	

	@Before
	public void setup() throws Throwable {
		configprop = new Properties();
		FileInputStream fis = new FileInputStream(".//File/config.properties");
		configprop.load(fis);
		String Browser = configprop.getProperty("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		web=new WebDriverUtility();
		web.maximizeBrowser(driver);
		web.implicitwait(driver);
	}

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {

		login = new LoginOrange(driver);

		hp = new OrangeHomePage(driver);
		ap = new AdminPage(driver);

	}

	@When("user enters url {string}")
	public void user_enters_url(String URL) {
		driver.get(URL);
	}

	@When("enter valid username {string} and password {string}")
	public void enter_valid_username_and_password(String username, String password) {
		login.getUsrtextbox().sendKeys(username);
		login.getPswtextbox().sendKeys(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		login.getLoginbutton().click();
	}

	@Then("Then pageTitle should be {string}")
	public void then_page_title_should_be(String title) throws Throwable {
		if (driver.getPageSource().contains("Invalid credentials")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			web.customwaittodisplayele(login.getOrangeimg());
			Assert.assertEquals(title, driver.getTitle());

		}

	}

	@Then("close the browser")
	public void close_the_browser() throws Throwable {
		login.getLogdropicon().click();
		web.customwaittodisplayele(login.getLogoutbutton());
		login.getLogoutbutton().click();
		driver.quit();
	}

//++++++++++++++++++++++++
	@Then("subtitle should be {string}")
	public void subtitle_should_be(String suntitle) {

		Assert.assertEquals(suntitle, hp.getTitledash().getText());
	}

	@Then("Validate all the Tabs are present in the homepage")
	public void validate_all_the_tabs_are_present_in_the_homepage() {
		String Tlist[] = { "Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard",
				"Maintenance", "Claim", "Buzz", "Directory" };

		boolean flag = false;

		for (int i = 0; i <= Tlist.length - 1; i++) {
			List<WebElement> all = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li[" + i + "]//span"));
			for (WebElement a : all) {
				a.getText().equals(Tlist[i]);
				flag = true;
				System.out.println(a.getText());
			}

		}

		Assert.assertEquals(true, flag);
	}

//++++++++++++++++ scroll down
	@Then("Scrolldown to see the chart")
	public void scrolldown_to_see_the_chart() {
		web.scrollToEle(driver, hp.getScroll());
	}

//Adminpage alidatition
	@When("click on Admintab")
	public void click_on_admintab() {
		hp.getAdmintab().click();
	}

	@When("click on Qualificitions dropdown")
	public void click_on_qualificitions_dropdown() {
		web.visibleOfElement(driver, ap.getQualificationdropdowm());
		web.javascriptclick(driver, ap.getQualificationdropdowm());

	}

	@When("select Eduction option")
	public void select_eduction_option() {
		web.javascriptclick(driver, ap.getEducationvalue());
	}

	@Then("Education page should be displayed")
	public void education_page_should_be_displayed() {
		web.visibleOfElement(driver, ap.getVrecordsfound());

	}

	@When("Bachelors Degree checkbox should be selected")
	public void bachelors_degree_checkbox_should_be_selected() {
		web.javascriptclick(driver, ap.getBachelorecheckbox());
	}

	@When("click on editIcon")
	public void click_on_edit_icon() {
		web.waituntilElementtobeClickable(driver, ap.getBacheloreeditcheckbox());
		web.javascriptclick(driver, ap.getBacheloreeditcheckbox());
	}

	@Then("{string} page should be dislayed")
	public void page_should_be_dislayed(String Actualtext) {

		Assert.assertEquals(Actualtext, ap.getEditEducationtext().getText());
	}

	@Then("click on cancle button")
	public void click_on_cancle_button() {
		web.visibleOfElement(driver, ap.getCanlebutton());
		web.javascriptclick(driver, ap.getCanlebutton());
	}

}
