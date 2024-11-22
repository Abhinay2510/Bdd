//package StepDefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import driver.TestBase;
//
//
//public class LoginAndProfileSteps {
//
//	
//		  @Given("I am on the login page$")
//		  public void goToLoginPage() throws Exception {
//			  TestBase.setupSelenium();
//			  TestBase.getDriver().get("http://10.251.16.110:5601/3ibank/index.html");
//		  }
//
//		  @When("I enter username \"(.+)\" and password \"(.*)\"")
//		  public void enterUsernameAndPassword(String username, String password) {
//		    WebElement usernameInput = TestBase.getDriver().findElement(By.id("username"));
//		    usernameInput.sendKeys(username);
//
//		    WebElement passwordInput = TestBase.getDriver().findElement(By.id("password"));
//		    passwordInput.sendKeys(password);
//		  }
//
//		  @And("I enter 4 digit number \"(.*)\"")
//		  public void enterFourDigitNumber(String number) {
//		    WebElement numberInput = TestBase.getDriver().findElement(By.id("card"));
//		    numberInput.sendKeys(number);
//		  }
//
//		  @And("I click on Login button")
//		  public void clickLoginButton() {
//		    WebElement loginButton = TestBase.getDriver().findElement(By.id("login_btn"));
//		    loginButton.click();
//		  }
//
//		  // Implement the rest of the steps similarly
//
//		  @And("I click on Logout")
//		  public void clickLogout() {
//		    WebElement logouticon = TestBase.getDriver().findElement(By.id("profileimg"));
//		    logouticon.click();
//		    WebElement logoutButton = TestBase.getDriver().findElement(By.xpath("//span[text()='Logout']"));
//	        logoutButton.click();
//		  }
//
//		  @Then("I should be logged out")
//		  public void verifyLogout() {
//		    String currentUrl = TestBase.getDriver().getCurrentUrl();
//		    // Add assertion to check if the user is logged out
//		    // For example:
//		    // assert currentUrl.equals("https://www.example.com/logout");
//		    TestBase.getDriver().quit();
//		  }
//		
//	}
//
//
