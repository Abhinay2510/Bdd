package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.TestBase;


public class Bank_ApplyLoanSteps {

    WebDriver driver;

    @Given("User opens the browser and navigates to the application")
    public void openBrowserAndNavigateToApplication() throws Exception {
    	 TestBase.setupSelenium();
		  TestBase.getDriver().get("http://10.251.16.110:5601/3ibank/index.html");
	  
        //TestBase.getDriver().manage().window().maximize();
    }

    @When("User enters \"(.+)\" and \"(.+)\"")
    public void enterCredentials(String username, String password) {
        WebElement usernameField = TestBase.getDriver().findElement(By.id("username"));
        WebElement passwordField = TestBase.getDriver().findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("User enters a 4 digit number")
    public void enterFourDigitNumber() {
        WebElement numberField = TestBase.getDriver().findElement(By.id("card"));
        numberField.sendKeys("1234");
    }

    @And("User clicks on the Login button")
    public void clickloginButton() {
        WebElement loginButton = TestBase.getDriver().findElement(By.id("login_btn"));
        loginButton.click();
    }

    @And("User clicks on the Apply Now button")
    public void clickApplyNowButton() {
        WebElement applyNowButton = TestBase.getDriver().findElement(By.xpath("//button[text()='Apply Now']"));
        applyNowButton.click();
    }

    @And("User scrolls down until the checkbox is visible")
    public void scrollToCheckbox() {
        WebElement checkbox = TestBase.getDriver().findElement(By.id("myCheck"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) TestBase.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", checkbox);
    }

    @And("User selects the checkbox")
    public void selectCheckbox() {
        WebElement checkbox = TestBase.getDriver().findElement(By.id("myCheck"));
        checkbox.click();
    }

    @And("User clicks on the Agree and Continue button")
    public void clickAgreeAndContinueButton() {
        WebElement agreeAndContinueButton = TestBase.getDriver().findElement(By.id("accept_agree"));
        agreeAndContinueButton.click();
    }

    @And("User clicks on the Profile button")
    public void clickProfileButton() {
        WebElement profileButton = TestBase.getDriver().findElement(By.id("profileimg"));
        profileButton.click();
    }

    @And("User clicks on the Logout button")
    public void clickLogoutButton() {
        WebElement logoutButton = TestBase.getDriver().findElement(By.xpath("//span[text()='Logout']"));
        logoutButton.click();
    }

    @After
    public void tearDown() {
        TestBase.getDriver().quit();
    }
}