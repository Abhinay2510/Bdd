package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;
import driver.TestBase;


public class Flexcube_HomePage extends OnlineActions {

	
	public Flexcube_HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}


	
	@FindBy (how=How.XPATH, using = "//span[@title='Information Message']")
	public static WebElement informationMsg;
	@FindBy (how=How.XPATH, using = "//span[@title='Confirmation Message']")
	public static WebElement confirmMsg;
	@FindBy (how=How.XPATH, using = "//span[contains(text(),'Home')]")
	public static WebElement home_btn;
	@FindBy (how=How.XPATH, using = "//input[@title='Ok']")
	public static WebElement Ok_btn;
	@FindBy (how=How.XPATH, using = "//input[@title='Cancel']")
	public static WebElement Cancel_btn;
	@FindBy (how=How.XPATH, using = "//li[@class='user']")
	public static WebElement user;
	@FindBy (how=How.ID, using = "ifr_AlertWin")
	public static WebElement iframe_login;
	@FindBy (how=How.XPATH, using = "((//ul[contains(@class,'listPop')])[5]/li[@class='pD'])[2]")
	public static WebElement signOff_btn;
	@FindBy (how=How.XPATH, using = "//input[@id='fastpath']")
	public static WebElement fastpath;
	@FindBy (how=How.XPATH, using = "//button[@id='btnGo']")
	public static WebElement go_btn;
	@FindBy (how=How.XPATH, using = "//a[@class='TBitem']")
	public static WebElement new_btn;
	@FindBy (how=How.XPATH, using = "//h1[contains(text(),'Customer Maintenance')]")
	public static WebElement customerMaintenance_title;
	
	@FindBy (how=How.XPATH, using = "(//iframe[contains(@id,'ifr_LaunchWin')])[1]")
	public static WebElement ifr_launchW;
	
	@FindBy (how=How.XPATH, using = "//button[@id='BLK_CUSTOMER__BTN_P']")
	public static WebElement cutumer_btn_p;
	
	@FindBy (how=How.XPATH, using = "//input[@name='CUSTNO']")
	public static WebElement cusNo_field;
	
	@FindBy (how=How.XPATH, using = "//input[@name='FULLNAME']")
	public static WebElement fullname;
	
	@FindBy (how=How.XPATH, using = "//input[@name='SNAME']")
	public static WebElement shortName;
	
	@FindBy (how=How.XPATH, using = "//input[@name='CCATEG']")
	public static WebElement customerCateg;
	
	@FindBy (how=How.XPATH, using = "//input[@name='ADDRLN1']")
	public static WebElement addressLine1;
	
	@FindBy (how=How.XPATH, using = "//input[@name='COUNTRY']")
	public static WebElement country;
	
	@FindBy (how=How.XPATH, using = "//input[@name='NLTY']")
	public static WebElement nationality;
	
	@FindBy (how=How.XPATH, using = "//label[@for='BLK_CUSTPERSONAL__SEX']")
	public static WebElement Gender_male;
	
	@FindBy (how=How.XPATH, using = "//iframe[@id='ifrSubScreen']")
	public static WebElement iframe_remarks;
	
	@FindBy (how=How.XPATH, using = "//input[@id='BTN_OK']")
	public static WebElement okbtn;
	
	@FindBy (how=How.XPATH, using = "//input[@id='BLK_CUSTPERSONAL__DOBI']")
	public static WebElement DOB;
	
	@FindBy (how=How.XPATH, using = "//label[@for=\"BLK_CUSTOMER__CTYPE\"]")
	public static WebElement Type_Individual;
	
	@FindBy (how=How.XPATH, using = "//label[@for=\"BLK_CUSTOMER__CTYPE2\"]")
	public static WebElement Type_Corporate;
	
	@FindBy (how=How.XPATH, using = "//label[@for=\"BLK_CUSTOMER__CTYPE3\"]")
	public static WebElement Type_Bank;
	
	@FindBy (how=How.XPATH, using = "//input[@name='PLACE_OF_BIRTH']")
	public static WebElement placeofbirth;
	
	@FindBy (how=How.XPATH, using = "//input[@name='BIRTH_COUNTRY']")
	public static WebElement birthcountry;
	
	@FindBy (how=How.XPATH, using = "//input[@name='LANG']")
	public static WebElement language;
	
	@FindBy (how=How.XPATH, using = "//input[@name='PLACE_OF_BIRTH']")
	public static WebElement PLACE_OF_BIRTH;
	
	@FindBy (how=How.XPATH, using = "//*[@id='TAB_ADDITIONAL']")
	public static WebElement Additionaltab;
	@FindBy (how=How.XPATH, using = "//input[@name='LOC']")
	public static WebElement location;
	
	@FindBy (how=How.XPATH, using = "//input[@name='MEDIA']")
	public static WebElement media;
	
	@FindBy (how=How.XPATH, using = "//iframe[@id='ifr_AlertWin']")
	public static WebElement iframe_Overide_Msg;
	
	@FindBy (how=How.XPATH, using = "//input[@id='BTN_ACCEPT']")
	public static WebElement accept_btn;
	
	
	@FindBy (how=How.XPATH, using = "//input[@name='BTN_EXIT']")
	public static WebElement exit_btn;
	@FindBy (how=How.XPATH, using = "//li[@id=\"Save\"]")
	public static WebElement save_btn;
	@FindBy (how=How.XPATH, using = "//iframe[@id='ifr_AlertWin']")
	public static List<WebElement> ifr_override_msg;
	
	@FindBy (how=How.XPATH, using = "//span[@title='Confirmation Message']")
	public static WebElement confirmationMsg;
	
	
	@FindBy (how=How.XPATH, using = "//h1[contains(text(),'Summary')]")
	public static WebElement customerSummary_title;
	
	@FindBy (how=How.XPATH, using = "//select[@name='AUTHSTAT']")
	public static WebElement auth_status;
	
	@FindBy (how=How.XPATH, using = "//input[@name='CUSTNAME']")
	public static WebElement summaryScreen_customerName_filed;
	
	@FindBy (how=How.XPATH, using = "//input[@name='CCATEGORY']")
	public static WebElement summaryScreen_customerCategory_filed;
	
	@FindBy (how=How.XPATH, using = "//input[@name='SHORTNAME']")
	public static WebElement summaryScreen_shortName_filed;
	
	
	@FindBy (how=How.XPATH, using = "//input[@id=\"BLK_CUSTOMER_QUERY__CUSTNO\"]")
	public static WebElement blk_customerNo_field;
	
	@FindBy (how=How.XPATH, using = "//a[text()='Search']")
	public static WebElement search_btn;
	
	@FindBy (how=How.XPATH, using = "//input[@name='SHORTNAME']")
	public static WebElement shortname_filed;
	
	@FindBy (how=How.XPATH, using = "//*[@class=\"BTNIconAuthorize\"]/a")
	public static WebElement authorize_btn;
	
	@FindBy (how=How.XPATH, using = "//input[@name='BTN_OK']")
	public static WebElement Authorize_acceptbtn;
	
	@FindBy (how=How.XPATH, using = "//input[@id='newpwd']")
	public static WebElement reenterPwd;
	
	
	@FindBy (how=How.XPATH, using = "//h1[contains(text(),'Customer Accounts Maintenance')]")
	public static WebElement customerAccountMaintenancetitle;
	
	@FindBy (how=How.XPATH, using = "//table[@id='TBL_QryRslts']/tbody/tr/td[4]")
	public static WebElement Customer_Summary_customerNo_column;
	
	@FindBy (how=How.XPATH, using = "//table[@id='TBL_QryRslts']/tbody/tr/td[5]")
	public static WebElement Customer_Account_Summary_customerAccountNo_column;
	//table[@id='TBL_QryRslts']/tbody/tr/td[5]
	
	@FindBy (how=How.XPATH, using = "//table[@id='TBL_QryRslts']/tbody/tr")
	public static WebElement Customer_Summary_Result_rowdata;
	
	@FindBy (how=How.XPATH, using = "//*[@id='BTN_EXIT']")
	public static WebElement Customer_Summary_exit_btn;
	
	@FindBy (how=How.XPATH, using = "//input[@name='CCY']")
	public static WebElement currencycode;
	
	@FindBy (how=How.XPATH, using = "//button[@title=\"Fetch\"]")
	public static WebElement fetch_btn;
	@FindBy (how=How.XPATH, using = "//input[@title=\"Account Class\"]")
	public static WebElement accountclass;
	
	@FindBy (how=How.XPATH, using = "//h1[contains(text(),\"Account Number Generation\")]")
	public static WebElement accountnumbergeneration_title;
	
	@FindBy (how=How.XPATH, using = "//*[@id=\"BTN_OK\"]")
	public static WebElement CustomerAccountGenerate_ok_btn;
	
	
	@FindBy (how=How.XPATH, using = "//input[@type='submit']")
	public static WebElement Clear_user_Okbtn;
	
	@FindBy (how=How.XPATH, using = "//label[@for=\"AUTHSTATI\"]/following-sibling::input")
	public static WebElement AuthorizationStatus;
	
	
	
	
	
//===========================================Methods==================================================//
public  void login_Info_Popup(String password) throws IOException {
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	waitAndSwitchToIFrame(iframe_login);
	try {
	if(confirmationMsg.isDisplayed()) {
		TestBase.logger.info("User already logined into the application");
		waitForElementToBeVisible(confirmationMsg, "Information Message  popup should be displayed in the home page");
		okbtn.click();
		switchtoDefaultIFrame();
		Thread.sleep(1000);
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		waitAndSwitchToIFrameUsingFrameNumber(0);
		
		EnterText(reenterPwd,password , "Enter the re enter password filed");
		Clear_user_Okbtn.click();
		switchtoDefaultIFrame();
		Thread.sleep(1000);
		 frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		
		waitAndSwitchToIFrameUsingFrameNumber(0);
		//waitAndSwitchToIFrame(iframe_login);
		
		
	}
	
	
	}
	catch(Exception e) {
		TestBase.logger.info("User ");
	}
    // System.out.println(alertMessage);
	waitForElementToBeVisible(informationMsg, "Information Message  popup should be displayed in the home page");
	
	
}
public  void ok_btn() throws IOException {
	click(Ok_btn, "Click on ok button in the popup");
	
}
	
public  void verifyhomepage() throws IOException {
	switchtoDefaultIFrame();
	waitForElementToBeVisible(home_btn, "home page should be dispalyed");
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120));
//	wait.until(ExpectedConditions.)
}	
	
public void selecting_signOff_from_user() throws IOException {
	Actions actions = new Actions(driver);
	 actions.moveToElement(user).perform();
	// waitForElementToBeVisible(signOff_btn, "Information Message  popup should be displayed in the home page");
//	 WebElement signoff =user.findElement(By.xpath("//li[contains(text(),'Sign Off')]"));
//	 signoff.click();
	//click(signOff_btn, "Able to click on the user profile icon");
	// actions.moveToElement(signOff_btn).perform();
	// WebElement listItem= TestBase.getDriver().findElement(By.xpath("//li"));
	 //WebElement element;
	List<WebElement> ListItems = TestBase.getDriver().findElements(By.xpath("//ul[@class='listPop show']/li"));
System.out.println(ListItems.size());
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Text: " + ListItems.get(8).getText());
ListItems.get(8).click();
//	for (WebElement element : ListItems) {
//        // Perform actions on each element
//        System.out.println("Text: " + element.getText());
//      //  System.out.println("Href: " + element.getAttribute("href"));
//
//        // You can perform other actions as needed
//        // For example, click on the element
//        
//        if(element.getText().contains("Sign Off")) {
//        	element.click();
//        	
//        }
//       // element.click();
//    }

//    for(ListItems:e)
//    
}

public  void signOff_ConfirmMsg_popup() throws IOException {
	
	
	
	waitAndSwitchToIFrame(iframe_login);
	
   //  System.out.println(alertMessage);
	waitForElementToBeVisible(confirmMsg, "Information Message  popup should be displayed in the home page");
	Ok_btn.isDisplayed();
	Cancel_btn.isDisplayed();
	
	
}
	
public  void enterFastpath(String fastpathname) {
	//waitForElementToBeClickable(fastpath, );
	try {
		EnterText(fastpath, fastpathname, "Able to enter fastpath code :"+fastpathname);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public  void clickGo_btn() throws IOException {
	click(go_btn, "Click on go button in the fastpath");
	
}
public  void verifyCustomerMainteance() throws IOException {
	waitAndSwitchToIFrame(ifr_launchW);
	waitForElementToBeVisible(customerMaintenance_title, "Customer Maintenance screen should be displayed");
	
}	

public  void clicknew_btn() throws IOException {
	click(new_btn, "Click on New button in the Customer Maintenance screen");
	
}
public void custmerbtn_isdisabled(String status) {
	
}


}