//package StepDefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import driver.TestBase;
//
//
//public class LoginSteps {
//
//    //WebDriver driver = new ChromeDriver();
//
//    @Given("the user is on the login page")
//    public void userIsOnLoginPage() throws Exception {
//    	TestBase.setupSelenium();
//		TestBase.getDriver().get("http://10.251.16.110:5601/3ibank/index.html");
//    }
//
//    @When("the user enters the username \"(.+)\"")
//    public void userEntersUsername(String username) {
//        WebElement usernameField = TestBase.getDriver().findElement(By.id("username"));
//        usernameField.sendKeys(username);
//    }
//
//    @And("the user enters the password \"(.+)\"")
//    public void userEntersPassword(String password) {
//        WebElement passwordField = TestBase.getDriver().findElement(By.id("password"));
//        passwordField.sendKeys(password);
//    }
//
//    @And("the user enters the 4 digits number \"(.+)\"")
//    public void userEntersFourDigitNumber(String number) {
//        WebElement numberField = TestBase.getDriver().findElement(By.id("card"));
//        numberField.sendKeys(number);
//    }
//
//    @And("the user clicks on the login button")
//    public void userClicksLoginButton() {
//        WebElement loginButton = TestBase.getDriver().findElement(By.id("login_btn"));
//        loginButton.click();
//    }
//    @When("the user clicks on the logout button")
//    public void userClicksLogoutButton() {
//        WebElement menuicon = TestBase.getDriver().findElement(By.id("profileimg"));
//        menuicon.click();
//        WebElement logoutButton = TestBase.getDriver().findElement(By.xpath("//span[text()='Logout']"));
//        logoutButton.click();
//    }
//
//    @Then("the user should be logged in successfully")
//    public void userLoggedInSuccessfully() {
//        // Add assertions or verifications for successful login
//    }
//
//    @Then("the user should see an error message")
//    public void userSeesErrorMessage() {
//        // Add assertions or verifications for error message
//    }
//}
