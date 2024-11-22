//package StepDefinitions;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//
//import org.apache.log4j.Logger;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import driver.TestBase;
//import pages.Pg_01_Home;
//
//public class ILLoandenied 
//{
//	public static final Logger logger = Logger.getLogger(ILLoandenied.class.getName());
//
////	@Given("^User opens the chrome and launch online application$")
////	public void base_line() throws Throwable 
////	{
////	
////	TestBase.setupSelenium();
////	TestBase.getDriver().get(TestBase.getPropertyValue("SL_URL"));
////
////	}
////	
////	@When("^Enter login details and sigin$")
////	public void test() throws Throwable 
////	{
////	
////	Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
////	obj_home.username_password();
////	
////	}
////	
////
////	@And("^Add any product into the cart By clicking Add to Cart button$")
////	public void add_cart() throws Throwable 
////	{
////	
////	Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
////	obj_home.add_cart();
////	
////	}
////	@When("^User should logout$")
////	public void logout() throws Throwable 
////	{
////	
////	Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
////	obj_home.logout();
////	
////	}
//	
//	
//	@Given("^User opens the chrome and launch online application$")
//	public void user_opens_the_chrome_and_launch_online_application() throws Throwable 
//	{
//		TestBase.setupSelenium();
//		TestBase.getDriver().get(TestBase.getPropertyValue("SL_URL"));
//	  
//	}
//
//	@When("^Enter login details and sigin$")
//	public void enter_login_details_and_sigin() throws Throwable {
//		Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
//		obj_home.username_password();
//	    
//	}
//
//	@When("^Add any product into the cart By clicking Add to Cart button$")
//	public void add_any_product_into_the_cart_By_clicking_Add_to_Cart_button() throws Throwable {
//		Pg_01_Home obj_home = new Pg_01_Home(TestBase.getDriver());
//		obj_home.add_cart();
//	}
//
//	@Then("^User should logout$")
//	public void user_should_logout() throws Throwable {
//	  
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
//
//
