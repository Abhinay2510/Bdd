package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import actions.OnlineActions;
import driver.TestBase;

public class Pg_01_Home extends OnlineActions{

	//WebDriver driver;
	public Pg_01_Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='login_logo']")
	WebElement caption;

	
	@FindBy (how=How.XPATH, using = "//input[@id='user-name']")
	public static WebElement User_name;
	
	@FindBy (how=How.XPATH, using = "//input[@id='username']")
	public static WebElement Username;
	
	
	
	@FindBy (how=How.XPATH, using = "//input[@id='password']")
	public static WebElement password;
	
	@FindBy (how=How.XPATH, using = "//input[@id='login-button']")
	public static WebElement signin;
	
	
	@FindBy (how=How.XPATH, using = "//span[@class='title']")
	public static WebElement producttittle;
	
	@FindBy (how=How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public static WebElement addcart;
	
	@FindBy (how=How.XPATH, using = "//span[@class='shopping_cart_badge']")
	public static WebElement carticon;
	
	
	@FindBy (how=How.XPATH, using = "//button[@id='react-burger-menu-btn']")
	public static WebElement menu_icon;
	
	@FindBy (how=How.XPATH, using = "//a[@id='logout_sidebar_link']")
	public static WebElement logout;
	
	
	
	public void username_password() throws Exception
	{
	
		VerifyText_For_PageCaption(caption, "Swag Labs", "Swag Labs, Hence Passed");
		EnterText(User_name, getMapData.get("Username"), "user name");
		EnterText(password, getMapData.get("Password"), "user password");
		click(signin, "login button");
		
}
	
	
	
	public void username_password1() throws Exception
	{
	
		//VerifyText_For_PageCaption(caption, "Swag Labs", "Swag Labs, Hence Passed");
		EnterText(Username, getMapData.get("Username"), "user name");
		EnterText(password, getMapData.get("Password"), "user password");
		click(signin, "login button");
		
}
	
	
	
	public void add_cart() throws Exception
	{
	
		VerifyText_For_PageCaption(producttittle, "Products", "Products, Hence Passed");
		waitForElementToBeVisible(addcart, "addcart");
		click(addcart, "add cart button");
		click(carticon, "add cart icon button");
		
}

	public void logout() throws Exception
	{
		waitForElementToBeVisible(producttittle, "tittle");
		VerifyText_For_PageCaption(producttittle, "Your Cart", "Your Cart, Hence Passed");
		click(menu_icon, "menu icon");
		waitForElementToBeVisible(logout, "logout");
		click(logout, "logout");
		
}

	

}
