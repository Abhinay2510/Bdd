package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;


public class Flexcube_LoginPage extends OnlineActions {

	
	public Flexcube_LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}


	
	@FindBy (how=How.XPATH, using = "//input[@name='USERID']")
	private static WebElement userid;
	@FindBy (how=How.XPATH, using = "//input[@name='user_pwd']")
	private static WebElement pwd;
	@FindBy (how=How.XPATH, using = "//div[@class='loginSubmitBtn']")
	private static WebElement Signin_btn;
	
	
//===========================================Methods==================================================//
public  void SuccessfullSigin(String username,String password) throws IOException {
	EnterText(userid, username, "Enter valid user id in the Flexcube login screen");
	
	EnterText(pwd, password, "Enter valid password in the Flexcube login screen");
	click(Signin_btn, "Click on submit button in the Flexcube login screen");
	
}
public  void Signin() throws IOException {
	click(Signin_btn, "Click on submit button in the Flexcube login screen");
}
	
public  void verifyLoginPage() throws IOException {
	waitForElementToBeVisible(userid, "Userid field should be displayed in the the logibg screen");
}	
	
	
	
	
	
	
	
	
}