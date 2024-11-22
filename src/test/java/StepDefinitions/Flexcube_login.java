package StepDefinitions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import actions.OnlineActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.TestBase;
import excelutils.Xls_Reader;
import pages.Flexcube_HomePage;
import pages.Flexcube_LoginPage;

public class Flexcube_login   
{
	
	
	String basseUrl="https://192.82.63.165:7013/FCJNeoWeb/LoginServlet";
	
			//"https://10.30.73.59:7013/FCJNeoWeb/LoginServlet";
	public static String mainWindowHandle;
	public static final Logger logger = Logger.getLogger(Flexcube_login.class.getName());
public static String CIF_number,CustomerAccountNumber;
	
	@Given("User open the Flexcube app url in the browser")
	public void User_opens_the_chrome_and_launch_bank_application() throws Throwable 
	{
	
		TestBase.setupSelenium();
		//Thread.sleep(500);
		
	//TestBase.getDriver().get("https://10.30.73.59:7013/FCJNeoWeb/")
		TestBase.getDriver().get(basseUrl);
		
	 mainWindowHandle = TestBase.getDriver().getWindowHandle();
//	
//
//    
//    Set<String> allWindowHandles = TestBase.getDriver().getWindowHandles();
//
//    // Check if there are multiple windows
//    
//        // Iterate through all window handles
//        for (String windowHandle : allWindowHandles) {
//            // Switch to the new window
//            if (!windowHandle.equals(mainWindowHandle)) {
//            	TestBase.getDriver().switchTo().window(windowHandle);
//
//                System.out.println("---------------------------------------Title of the new window: " + TestBase.getDriver().getTitle());
//
//	
//        }
//    }
    //creating common page object for reducing the object creation fo the pages
   
	}
	
	@When("Verify the Flexcube app login page")
	public void Enter_login_details_and_sigin_into_bank() throws Throwable 
	{
		
		
		
	Flexcube_LoginPage	login=new Flexcube_LoginPage(TestBase.getDriver());
		login.verifyLoginPage();
	//WebDriverWait wait=	applyWebDriverWait();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='USERID']")));
		
	//TestBase.getDriver().findElement(By.xpath("//input[@name='USERID'])"));
	
	}
	
	@When("User opens the chrome browser and launches the Oracle Flexcube Application")
	public void flexcubeLoginPage() throws Throwable 
	{
		TestBase.setupSelenium();
		//Thread.sleep(500);
		
	//TestBase.getDriver().get("https://10.30.73.59:7013/FCJNeoWeb/")
		TestBase.getDriver().get(basseUrl);
		
		mainWindowHandle = TestBase.getDriver().getWindowHandle();
		
		//commonobj for the pages
		
		
		Flexcube_LoginPage	login=new Flexcube_LoginPage(TestBase.getDriver());
		login.verifyLoginPage();
		hooks.bindreport(hooks.scenario, "FlexcubeLoginScreen");

	
	}
	
	
	
	@When("^Maker enter the login detailes and sigin into the Flexcube Application$")
	public void enterCred() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
				
		Flexcube_LoginPage	login=new Flexcube_LoginPage(TestBase.getDriver());
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
	   login.SuccessfullSigin(TestBase.getMapData.get("MAKER_LoginID"), TestBase.getMapData.get("MAKER_Password"));
	 
	   home.login_Info_Popup(TestBase.getMapData.get("MAKER_Password"));
	   hooks.bindreport(hooks.scenario, "HomePage");
	  // login.Signin();
	   home.ok_btn();
	   home.verifyhomepage();
	}
	
	@When("^Checker enter the login detailes and sigin into the Flexcube Application$")
	public void CheckerUserSigin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_LoginPage	login=new Flexcube_LoginPage(TestBase.getDriver());
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
	   login.SuccessfullSigin(TestBase.getMapData.get("Checker_LoginID"), TestBase.getMapData.get("Checker_Password"));
	   //login.Signin();
	   home.login_Info_Popup(TestBase.getMapData.get("Checker_Password"));
	  // login.Signin();
	   hooks.bindreport(hooks.scenario, "HomePage");
	   home.ok_btn();
	   home.verifyhomepage();
	}
	
//	@When("^the user enter the  \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void the_user_enter_the_and(String arg1, String arg2) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		login=new Flexcube_LoginPage(TestBase.getDriver());
//		home=pageobj.getHomePage();
//	   login.SuccessfullSigin(TestBase.getMapData.get(arg1), TestBase.getMapData.get(arg2));
//
//	}

	@When("^the user clicks on the Sign in button$")
	public void the_user_clicks_on_the_Sign_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	Flexcube_LoginPage	login=new Flexcube_LoginPage(TestBase.getDriver());
		login.Signin();
	}
//	@When("verify navigate to flexcube home and a popup message should displayed in the screen")
//	public void homescreen() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	   home=pageobj.getHomePage();
//	   home.login_Info_Popup();
//	}
	
//	@Then("^verify user navigate to flexcube home page and a popup message should displayed in the screen$")
//	public void verify_user_navigate_to_flexcube_home_page_and_a_popup_message_should_displayed_in_the_screen() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	   home=new Flexcube_HomePage(TestBase.getDriver());
//	   home.login_Info_Popup();
//	}

	@When("^user clicks on the Ok button in the popup screen$")
	public void user_clicks_on_the_Ok_button_in_the_popup_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		Flexcube_HomePage	 home=new Flexcube_HomePage(TestBase.getDriver());  
		home.ok_btn();
		hooks.bindreport(hooks.scenario, "Homepage");
		   
	}

	@Then("^Verify the home page$")
	public void verify_the_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home= pageobj.getHomePage();
		Flexcube_HomePage	 home=new Flexcube_HomePage(TestBase.getDriver());
		home.verifyhomepage();
	}

	@When("^user clicks on the user profile icon and select sign off option from the list$")
	public void user_clicks_on_the_userprofile_icon_on_the_top_right_corner_of_the_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home= pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.selecting_signOff_from_user();
		hooks.bindreport(hooks.scenario, "Signoff");
	   
	}

	@When("^Click on Sign off from the list$")
	public void click_on_Sign_off_from_the_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Confirm Message popup should be displayed with ok and cancel buttons$")
	public void confirm_Message_popup_should_be_displayed_with_ok_and_cancel_buttons() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  // home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.signOff_ConfirmMsg_popup();
		hooks.bindreport(hooks.scenario, "ConfirmSignoff");;
	   
	}

	@When("^user click on Ok button$")
	public void user_click_on_Ok_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());  
		home.ok_btn();
		hooks.bindreport(hooks.scenario, "okbtn");
	}

	@Then("^user Successfully logs out from the page  and navigate to the Flexcube login page$")
	public void user_Successfully_logs_out_from_the_page_and_navigate_to_the_Flexcube_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//login=pageobj.getLoginPage();
		Flexcube_LoginPage login =new Flexcube_LoginPage(TestBase.getDriver());
		login.verifyLoginPage();
		hooks.bindreport(hooks.scenario, "Hoepage");
	   
	}
	
	@When("^Enter fastpath code \"([^\"]*)\" and click on go button$")
	public void enterFastpath(String fastpath) throws Throwable {
	
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());  
		home.enterFastpath(fastpath);
		hooks.bindreport(hooks.scenario, fastpath);
		home.clickGo_btn();
		
	}

	@Then("click go button")
	public void clickgobtn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	//	home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		 home.clickGo_btn();
	   
	}
	@Then("Verify the Customer Mainteance Screen is displayed")
	public void verifyCM() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.verifyCustomerMainteance();
		hooks.bindreport(hooks.scenario, "MAKER_CustomerMaintenance");
	   
	}
	@Then("Click on New Option in the screen")
	public void newBtn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.clicknew_btn();
		hooks.bindreport(hooks.scenario, "FieldsareEnabled");
	   
	}
	
	
	@Then("^Verify Customer No is  in readonly state\\.$")
	public void verify_Customer_No_is_in_readonly_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Verify Customer no filed is enabled state$")
	public void verify_Customer_no_filed_is_enabled_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^user click on \"([^\"]*)\" customer type$")
	public void user_click_on_customer_type(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
//		String type
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		if(arg1.equalsIgnoreCase("Individual")) {
			OnlineActions.click(home.Type_Individual, "Click on the Individual type customer");
		}else if(arg1.equalsIgnoreCase("Corporate")) {
			OnlineActions.click(home.Type_Corporate, "Click on the Corporate type customer");
		}
		else if(arg1.equalsIgnoreCase("Bank")) {
			OnlineActions.click(home.Type_Bank, "Click on the Bank type customer");
		}
		hooks.bindreport(hooks.scenario, arg1);
//	   
	}

	@Then("^Click on Custmer no P button in the screen$")
	public void click_on_Custmer_no_P_button_in_the_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		OnlineActions.click(home.cutumer_btn_p, "Able to click the P under Customer No: ");
		hooks.bindreport(hooks.scenario, "CustomerNoGenerated");
	}
	
	@Then("^Save the Generate Customer Number$")
	public void save_the_Customer_Number_in_the_excel_sheet() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		CIF_number=home.Customer_Summary_customerNo_column.getText();
		Xls_Reader datatable = new Xls_Reader( System.getProperty("user.dir")+"\\ExcelData\\TestCases.xlsx",  System.getProperty("user.dir")+"\\ExcelData\\TestData.xlsx" );
		datatable.setCellDataForTestData_online(hooks.testCaseName, "CIF_number", 1, CIF_number);
		System.out.println("CIF number is : "+CIF_number);
		hooks.bindreport(hooks.scenario, "SaveCIFNumber");
		
		
	}
	@Then("^Save the Customer Account Number$")
	public void saveCustomerAccountNumber() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		CustomerAccountNumber=home.Customer_Account_Summary_customerAccountNo_column.getText();
		Xls_Reader datatable = new Xls_Reader( System.getProperty("user.dir")+"\\ExcelData\\TestCases.xlsx",  System.getProperty("user.dir")+"\\ExcelData\\TestData.xlsx" );
		datatable.setCellDataForTestData_online(hooks.testCaseName, "CustomerAccountNumber", 1, CustomerAccountNumber);
		System.out.println("CustomerAccountNumber is : "+CustomerAccountNumber);
		hooks.bindreport(hooks.scenario, "SaveNumber");
		
		
	}

	@Then("^user click and enter Full Name \"([^\"]*)\"$")
	public void user_click_and_enter_Full_Name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		OnlineActions.EnterText(home.fullname,TestBase.getMapData.get(arg1),"Entered Full Name in the field");
		hooks.bindreport(hooks.scenario, "CustomerFullName");
	}

	@Then("^User click and enter Short Name \"([^\"]*)\"$")
	public void user_click_and_enter_Short_Name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		OnlineActions.EnterText(home.shortName,TestBase.getMapData.get(arg1),"Entered Short Name in the field");
		hooks.bindreport(hooks.scenario, "Shortname");
	}

	@When("^Enter Customer Category$")
	public void enter_Customer_Category() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		OnlineActions.EnterText(home.customerCateg,TestBase.getMapData.get("CustomerCategory"),"Entered Customer Category in the field");
		hooks.bindreport(hooks.scenario, "CustomerCatg");
	}

	@When("^Enter Address1 under the Personal tab$")
	public void enter_Address_under_the_Personal_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.EnterText(home.addressLine1,TestBase.getMapData.get("AddressLine1"),"Entered Address line 1 in the field");
	}

	@When("^Enter Country Code under the Personal tab$")
	public void enter_the_Country_Code_under_the_Personal_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	//	home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.EnterText(home.country,TestBase.getMapData.get("CountryCode"),"Entered Country code in the field");
	}

	@When("^Enter Nationality under the Personal tab$")
	public void enter_Nationality_under_the_Personal_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.EnterText(home.nationality,TestBase.getMapData.get("NationalityCode"),"Entered Nationality code in the field");
	}
	@When("^Select Gender Type as \"([^\"]*)\"$")
	public void selectGender(String gender) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		home.scrollToElement(home.Gender_male, "");
		//.home=pageobj.getHomePage();
		
		if(gender.equalsIgnoreCase("Male")) {
			home.click(home.Gender_male, "Gender Male radio button should be selected");
		}else if(gender.equalsIgnoreCase("Female")) {
			home.click(home.Gender_male, "Gender Female radio button should be selected");
		}else if(gender.equalsIgnoreCase("Other")) {
			home.click(home.Gender_male, "Gender Other radio button should be selected");
		}else if(gender.equalsIgnoreCase("No")) {
			home.click(home.Gender_male, "Gender Other radio button should be selected");
		}
		
	}
	@When("^Enter the Birth Country place$")
	public void birthCountry() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.scrollToElement(home.birthcountry, "Scrolling to the birth country in the screen");
		home.EnterText(home.birthcountry, TestBase.getMapData.get("BIRTH_COUNTRY"), "fill the birth country in the filed");
	
	}
	
	@When("^Enter the Date of Birth of Customer")
	public void bod() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	//	home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.scrollToElement(home.DOB, "Scrolling to the date of Birth in the screen");
		home.EnterText(home.DOB, TestBase.getMapData.get("DOB"), "fill the date of Birth in the filed");
	}
	
	
	@When("^Enter Language")
	public void lanugage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.scrollToElement(home.language, "Scrolling to the date of Birth in the screen");
		home.EnterText(home.language, TestBase.getMapData.get("LANGUAGE"), "fill the date of Birth in the filed");
	}
	@When("^Enter Place of birth place")
	public void PLACE_OF_BIRTH() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.scrollToElement(home.PLACE_OF_BIRTH, "Scrolling to the PLACE_OF_BIRTH in the screen");
		home.EnterText(home.PLACE_OF_BIRTH, TestBase.getMapData.get("PLACE_OF_BIRTH"), "fill the PLACE_OF_BIRTH in the filed");
	}
	@When("^Click on Save button")
	public void saveCIF() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.click(home.save_btn, "Save button should be clicked");;
		hooks.bindreport(hooks.scenario, "Savebutton");
		
	}
	
	@When("^User click on Additional tab")
	public void additionaltab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		home.click(home.Additionaltab,"Additional tab be displayed");
		hooks.bindreport(hooks.scenario, "Additionaltab");
		
		
	}
	
	@When("^Enter data of location and Media fields under additional tab")
	public void location_mediaField() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		Thread.sleep(500);
		
		home.scrollToElement(home.location, "location field box should be displayed");
		home.EnterText(home.location, TestBase.getMapData.get("LOCATION"), "fill the location of the customer in the filed");
		
		home.EnterText(home.media, TestBase.getMapData.get("MEDIA"), "fill the media of the customer in the filed");
		hooks.bindreport(hooks.scenario, "AdditionalInfo");
	}
	
	@When("^Remarked pop up should be display")
	public void remarkedpopup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//home=pageobj.getHomePage();
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
		 
		home.waitAndSwitchToIFrame(home.iframe_remarks);
		hooks.bindreport(hooks.scenario, "RemarkedPopup");
		
		
	}
	
	@When("^Override description popup should be displayed")
	public void overridepoup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Thread.sleep(2000);
		 Flexcube_HomePage home=new Flexcube_HomePage(TestBase.getDriver());
//		home=pageobj.getHomePage();
//		
//		   home.waitAndSwitchToIFrame(home.iframe_Overide_Msg);
		//TestBase.getDriver().switchTo().parentFrame();
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		//System.out.println(frame.size());
		TestBase.getDriver().switchTo().frame(0);
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
//		for(WebElement el: frame) {
//			System.out.println(el.getAttribute("id"));
//			if(el.getAttribute("id").equalsIgnoreCase("ifr_AlertWin")) {
//		TestBase.getDriver().switchTo().frame(0);
		TestBase.getDriver().switchTo().frame(0);
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		//System.out.println(frame.size());
	//	System.out.println(TestBase.getDriver().getPageSource());
//		break;
//		
//		}
//		
//		}
		hooks.bindreport(hooks.scenario, "MakerCIFAuthorizationRequest");
		
	}
	
	@When("^user click on Accept button in the popup")
	public void acceptbtn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		Thread.sleep(500);
		   home.click(home.accept_btn,"User able to click the accept button in the Override message popup screen");
		   hooks.bindreport(hooks.scenario, "SuccessfullMsg");
		   //TestBase.getDriver().findElement(By.xpath("//input[@id='BTN_ACCEPT']")).click();
		
	}
	@When("^Successfully Created the customer number and sent to Checker for the Authorization")
	public void successfullyCIFNumber() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		home.switchtoParentIFrame();
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		
		System.out.println(frame.size());
		for(int frameindex=0;frameindex<frame.size();frameindex++) {
			System.out.println("Frames present in the Screen are: "+frame.get(frameindex).getAttribute("id"));
			
			
		
		}
		TestBase.getDriver().switchTo().frame(0);
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		 //  home.waitAndSwitchToIFrame(home.iframe_login);
		
	
		   home.ok_btn();
		   
		  // Thread.sleep(7000);
		   home.switchtoDefaultIFrame();
		   
		   home.waitAndSwitchToIFrame(home.ifr_launchW);
		   frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		   for(int frameindex=0;frameindex<frame.size();frameindex++) {
			   
				System.out.println("Frames present in after ok btn the Screen are: "+frame.get(frameindex).getAttribute("id"));
				
				
		
			}
//		   String Authorizationstatus=home.AuthorizationStatus.getAttribute("value");
//		   System.out.println("Authorization status is: "+Authorizationstatus);
		   
//		   try {
//		
//			 Assert.assertEquals(home.AuthorizationStatus.getAttribute("value"),"Unauthorized", "account is unathorized");
//		   }
//		   catch(Exception e) {
//			   
//		   }
		   hooks.bindreport(hooks.scenario, "CIF_unathorizedState");
		
//		   home.click(home.exit_btn, "exit from the Customer MAINTENANCE SCREEN");
//		   Thread.sleep(2000);
//		   home.switchtoDefaultIFrame();
		
		
	}
	
	@When("^Open the Oracle flexcube in the new window tab")
	public void newwindow() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_LoginPage login=new Flexcube_LoginPage(TestBase.getDriver());
		String currentwindow=TestBase.getDriver().getWindowHandle();
		TestBase.getDriver().switchTo().newWindow(WindowType.TAB);
		TestBase.getDriver().get(basseUrl);
		login.verifyLoginPage();
		hooks.bindreport(hooks.scenario, "Checker_loginscreen");
		
	}
	@When("^Verify the Customer Summary is displayed")
	public void customerSummary() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		home.waitAndSwitchToIFrame(home.ifr_launchW);
		home.waitForElementToBeVisible(home.customerSummary_title, "Customer Summary screen should be displayed");
		hooks.bindreport(hooks.scenario, "Checker_CustomerSummary");
	}
	@When("^Verify the Customer Account Summary is displayed")
	public void customerAccountSummary() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		home.waitAndSwitchToIFrame(home.ifr_launchW);
		home.waitForElementToBeVisible(home.customerSummary_title, "Customer account Summary screen should be displayed");
		hooks.bindreport(hooks.scenario, "CustomerAccountSummary");
	}
	
	
	@When("^Verify the Customer Account Maintenance screen")
	public void CustomerAccountMaintenance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		home.waitAndSwitchToIFrame(home.ifr_launchW);
		home.waitForElementToBeVisible(home.customerAccountMaintenancetitle, "Customer Account Maintenance screen should be displayed");
		hooks.bindreport(hooks.scenario, "MAKER_CustomerAccountMaintenance");
	}
	
	@When("^Search for \"([^\"]*)\" Customer number in the Customer summary screen")
	public void searchCustomerThroughCustomerNo(String auth_unauth) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		Select select =new Select(home.auth_status);
		if(auth_unauth.equalsIgnoreCase("UnAuthorized")){
			select.selectByValue("U");
		
		}else if(auth_unauth.equalsIgnoreCase("Authorized")){
			select.selectByValue("A");
		
		}else if(auth_unauth.equalsIgnoreCase("Rejected")){
			select.selectByValue("R");
		
		}
		home.EnterText(home.summaryScreen_customerName_filed, TestBase.getMapData.get("CustomerFullName"), "Enter the customer full name");
		home.EnterText(home.summaryScreen_customerCategory_filed, TestBase.getMapData.get("CustomerCategory"), "Enter the customer category name");
		home.EnterText(home.country, TestBase.getMapData.get("CountryCode"), "ENTER THE COUNTRYinto the text filed");
	home.click(home.search_btn, "Search button should be clickable");	
	hooks.bindreport(hooks.scenario, auth_unauth+" recoreds list");
	}
	@When("^Search for \"([^\"]*)\" Customer number in the Customer Account summary screen")
	public void searchCustomerAS(String auth_unauth) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		Select select =new Select(home.auth_status);
		if(auth_unauth.equalsIgnoreCase("UnAuthorized")){
			select.selectByValue("U");
		
		}else if(auth_unauth.equalsIgnoreCase("Authorized")){
			select.selectByValue("A");
		
		}else if(auth_unauth.equalsIgnoreCase("Rejected")){
			select.selectByValue("R");
		
		}
		
		home.EnterText(home.cusNo_field, CIF_number, "Enter the CIF number");
		home.EnterText(home.currencycode, TestBase.getMapData.get("CurrencyCode"), "Enter the currency code number");
		home.EnterText(home.accountclass, TestBase.getMapData.get("ACCOUNTCLASS"), "Enter the Account class code");
//		
		//home.EnterText(home.blk_customerNo_field, TestBase.getMapData.get("CustomerNumber"), "Saved customer number should be entered into the text filed");
	home.click(home.search_btn, "Search button should be clickable");	
	hooks.bindreport(hooks.scenario, auth_unauth+" recoreds list");
	}
	@When("^Double click on the UnAuthorized Customer number in the list")
	public void doubleclick() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		//td[@name='SHORTNAME']/div/a[text()='SAI']
		//String xpath="(//td[@name='SHORTNAME']/div/a[text()='"+TestBase.getMapData.get("CustomerShortName")+"'])[2]";
		home.performDoubleClick(home.Customer_Summary_Result_rowdata, "Double click on the customer short name in the table");
		hooks.bindreport(hooks.scenario, "Checker_CustomerMaintenance");
		
	}
	@When("^Verify the Unauthorized Customer Record in the Customer Maintenance screen")
	public void CustomerMainteance_CheckerScreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		//td[@name='SHORTNAME']/div/a[text()='SAI']
		Thread.sleep(2500);
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		TestBase.getDriver().switchTo().parentFrame();
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		 String regex = "ifr_LaunchWin\\d+$";
		 Pattern pattern = Pattern.compile(regex);
		for(WebElement el: frame) {
			System.out.println(el.getAttribute("id"));
			
			 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//			if(matcher.matches()) {
//				TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//			}
		}
		
		TestBase.getDriver().switchTo().frame(1);
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		//TestBase.getDriver().switchTo().frame(0);
		
		//System.out.println(TestBase.getDriver().getPageSource());
		hooks.bindreport(hooks.scenario, "Chekcer_CustomerMaintenance");
	}
	@When("^Click on the Authorize button in the screen")
	public void Authorize_btn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		//td[@name='SHORTNAME']/div/a[text()='SAI']
		home.click(home.authorize_btn, "Authorize button in checker customer maintenace screen");
		Thread.sleep(2000);
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		hooks.bindreport(hooks.scenario, "Authorized screen");
		
	}
	
	@When("^user click on Accept button in the Authorize screen")
	public void acceptAuthorizescreen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
		
		List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println("accept--- "+frame.size());
		for(WebElement el: frame) {
			System.out.println("Frames present in the Screen are: "+el.getAttribute("id"));
			
		//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//			if(matcher.matches()) {
//				TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//			}
		}
		home.waitAndSwitchToIFrameUsingFrameNumber(1);
//		TestBase.getDriver().switchTo().frame(1);
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		home.click(home.Authorize_acceptbtn, "Accept button in the Authorize screen");
		frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
		System.out.println(frame.size());
		for(WebElement el: frame) {
			System.out.println(el.getAttribute("id"));
			
		//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//			//if(matcher.matches()) {
//				TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//			}
		}
		hooks.bindreport(hooks.scenario, "CIFNO_Authorized");
	}
		
		@When("^Successfully Created the CIF number for the Individual Customer")
		public void successfullyCIFRecord_Checker() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			home.waitAndSwitchToIFrameUsingFrameNumber(0);
			home.ok_btn();
			Thread.sleep(500);
			
			
			hooks.bindreport(hooks.scenario, "AuthorizedCIFNO");
		
	}
		@When("^Close the Customer Maintenance and Customer Summary Screen")
		public void closeAllCheckerwindows() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Thread.sleep(500);
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println("CustomerMaintenance summary "+frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			home.waitAndSwitchToIFrameUsingFrameNumber(1);
			
			home.click(home.exit_btn, "exit from the Customer MAINTENANCE SCREEN");
			Thread.sleep(500);
//			String Authorizationstatus=home.AuthorizationStatus.getAttribute("value");
//			   System.out.println("Authorization status is: "+Authorizationstatus);
			
			 home.switchtoDefaultIFrame();
			 Thread.sleep(500);
			   home.waitAndSwitchToIFrameUsingFrameNumber(0);
			   home.click(home.Customer_Summary_exit_btn, "exit from the Customer summory SCREEN");
			   home.switchtoDefaultIFrame();
			   hooks.bindreport(hooks.scenario, "Homescreen");
			//home.dynamiciframeSwitching(home.exit_btn, "Exit button is displayed in the Customer Maintenance screen");
		
	}
		
		@When("^Close the Customer Maintenance and Customer Account Summary Screen")
		public void closeAllCheckers() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Thread.sleep(500);
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println("CustomerMaintenance summary "+frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			//home.waitAndSwitchToIFrameUsingFrameNumber(1);
			//home.waitAndSwitchToIFrameUsingFrameNumber(0);
			home.click(home.exit_btn, "exit from the Customer MAINTENANCE SCREEN");
			Thread.sleep(500);
//			String Authorizationstatus=home.AuthorizationStatus.getAttribute("value");
//			   System.out.println("Authorization status is: "+Authorizationstatus);
			
			 home.switchtoDefaultIFrame();
			 Thread.sleep(500);
			   home.waitAndSwitchToIFrameUsingFrameNumber(0);
			   home.click(home.Customer_Summary_exit_btn, "exit from the Customer summory SCREEN");
			   home.switchtoDefaultIFrame();
			   hooks.bindreport(hooks.scenario, "Homescreen");
			//home.dynamiciframeSwitching(home.exit_btn, "Exit button is displayed in the Customer Maintenance screen");
		
	}
		
		
		@When("^User Fills all Mandatory field under Personal tab")
		public void mandatoryFieldUnderPersonaltab() throws Throwable {
			enter_Address_under_the_Personal_tab();
			enter_the_Country_Code_under_the_Personal_tab();
			enter_Nationality_under_the_Personal_tab();
			
			selectGender(TestBase.getMapData.get("GENDER"));
			birthCountry();
			PLACE_OF_BIRTH();
			bod();
			lanugage();
			hooks.bindreport(hooks.scenario, "PersonalInfo");
		}
		@When("^Enter the Mandatory Customer number,Account class code and Currency Code fields in the screen")
		public void CIFNO_CurrencyCode() throws Throwable {
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
					
					
			home.EnterText(home.cusNo_field, CIF_number, "Enter the CIF number");
			home.EnterText(home.currencycode, TestBase.getMapData.get("CurrencyCode"), "Enter the currency code number");
			home.EnterText(home.accountclass, TestBase.getMapData.get("ACCOUNTCLASS"), "Enter the Account class code");
			hooks.bindreport(hooks.scenario, "EnterMandatoryField_In_CAM");
		}
		
		@When("^Click on Fetch button and Generate the Customer Account Number")
		public void generateAccountNo() throws Throwable {
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			
			
			home.click(home.fetch_btn, "User able to click on fetch button in the screen");
			Thread.sleep(500);
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			
			home.waitAndSwitchToIFrame(home.iframe_remarks);
			Thread.sleep(500);
			frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			
			home.waitForElementToBeVisible(home.accountnumbergeneration_title, CIF_number);
			hooks.bindreport(hooks.scenario, "AccountGenerator screen");
			home.click(home.CustomerAccountGenerate_ok_btn,"Click on ok button in the screen");
			Thread.sleep(500);
			home.switchtoParentIFrame();
			Thread.sleep(500);
			frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			home.waitForElementToBeVisible(home.fetch_btn, CIF_number);
			hooks.bindreport(hooks.scenario, "CustomerAccountNumber_Generated");
			
			
		}
		
		
		
		@When("^user click on MIS and Provided the pool code")
		public void mispoolcode() throws Throwable {
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			
			
			home.click(TestBase.getDriver().findElement(By.xpath("//li[@id=\"MICACCTM\"]")), "User able to click on mis button in the screen");
			Thread.sleep(500);
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			
			home.waitAndSwitchToIFrame(home.iframe_remarks);
			Thread.sleep(500);
			frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			
			//home.waitForElementToBeVisible(, CIF_number);
			
			home.EnterText(TestBase.getDriver().findElement(By.xpath("//input[@name='POOLCD']")),TestBase.getMapData.get("POOLCODE"),"Enter the code into the code on ok button in the screen");
			hooks.bindreport(hooks.scenario, "POOLCODE_MIS_Screen");
			home.click(TestBase.getDriver().findElement(By.xpath("//input[@name=\"BTN_OK\"]")), "User able to click on ok button in the screen");
			Thread.sleep(500);
			
			home.switchtoParentIFrame();
			Thread.sleep(500);
			frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			home.waitForElementToBeVisible(home.fetch_btn, CIF_number);
			
			
		}
		
		@When("^Enter Mandatory fields in Main tab")
		public void maintab_Mandatory() throws Throwable {
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			//home.scrollToElement(TestBase.getDriver().findElement(By.xpath("//input[@name=\"BTN_OK\"]")), "scroll to location filed");
			home.scrollToElement(home.location, "location field box should be displayed");
			home.EnterText(home.location, TestBase.getMapData.get("Main_Location"), "fill the location of the customer in the filed");
			
			home.EnterText(home.media, TestBase.getMapData.get("MEDIA"), "fill the media of the customer in the filed");
			hooks.bindreport(hooks.scenario, "Main tab");
			
		}
		
		
		
		@When("^Successfully Created Customer Account and sent to Checker for Authorization")
		public void CASACreation() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			home.switchtoParentIFrame();
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			
			System.out.println(frame.size());
			for(int frameindex=0;frameindex<frame.size();frameindex++) {
				System.out.println("Frames present in the Screen are: "+frame.get(frameindex).getAttribute("id"));
				
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			TestBase.getDriver().switchTo().frame(0);
			frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			 //  home.waitAndSwitchToIFrame(home.iframe_login);
			
		
			   home.ok_btn();
			   
			  // Thread.sleep(7000);
			   home.switchtoDefaultIFrame();
			   
			   home.waitAndSwitchToIFrame(home.ifr_launchW);
			   frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			   for(int frameindex=0;frameindex<frame.size();frameindex++) {
				   
					System.out.println("Frames present in after ok btn the Screen are: "+frame.get(frameindex).getAttribute("id"));
					
					
			
				}
	
			  
			   hooks.bindreport(hooks.scenario, "UnAuthorizedCASA_number");
			
			
		}
		
		@When("^Close the Customer Maintenance screen$")
		public void closeCustomerMaintenance() throws Throwable{
			Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			hooks.bindreport(hooks.scenario, "CMS");
		 home.click(home.exit_btn, "exit from the Customer MAINTENANCE SCREEN");
		   Thread.sleep(1000);
		   home.switchtoDefaultIFrame();
		   
		
		}
		@When("^Successfully Authorized the Customer Account and  Created Customer Account number")
		public void successfullyAccountRecord_Checker() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
					Flexcube_HomePage	home=new Flexcube_HomePage(TestBase.getDriver());
			List<WebElement> frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			String frame_id;
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
				
			//	 Matcher matcher = pattern.matcher(el.getAttribute("id"));
//				//if(matcher.matches()) {
//					TestBase.getDriver().switchTo().frame(el.getAttribute("id"));
//				}
			}
			home.waitAndSwitchToIFrameUsingFrameNumber(0);
			home.ok_btn();
			Thread.sleep(500);
			 frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			//frame=TestBase.getDriver().findElements(By.xpath("//iframe"));
			System.out.println(frame.size());
			
			for(WebElement el: frame) {
			 frame_id=	el.getAttribute("id");
				System.out.println(frame_id);
			}
			home.waitAndSwitchToIFrameUsingFrameNumber(1);
			hooks.bindreport(hooks.scenario, "AuthorizedCustomerAccountNum");
			
			
			Thread.sleep(1000);
			
		
	}

		//button[@title="Fetch"]
	
	
}
