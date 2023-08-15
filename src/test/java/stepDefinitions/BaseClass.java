package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import pageObject.AdminPage;
import pageObject.LoginOrange;
import pageObject.OrangeHomePage;
import utilities.WebDriverUtility;

public class BaseClass {
	public WebDriverUtility web;
public WebDriver driver;
	public LoginOrange login;
	public OrangeHomePage hp;
	public AdminPage ap;
	public Properties configprop;
	

}
