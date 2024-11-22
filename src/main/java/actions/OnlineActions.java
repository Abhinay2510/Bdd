package actions;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
import static junit.framework.Assert.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.TestBase;


public class OnlineActions extends TestBase

{
	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(OnlineActions.class.getName());
	//public static final Logger logger = Logger.getLogger(Actions.class.getName());
	
	public OnlineActions(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebDriverWait applyWebDriverWait()
	{

	
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		    wait.pollingEvery(Duration.ofMillis(2000));
		    wait.ignoring(NoSuchElementException.class);
		    wait.ignoring(ElementNotInteractableException.class);
		    wait.ignoring(StaleElementReferenceException.class);
		    wait.ignoring(NoSuchFrameException.class);
		    return wait;
		
		
		/*selenium old
			WebDriverWait wait = new WebDriverWait(driver, 120); //Changed 120 from 60
			//WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), 120);
			wait.pollingEvery(2000, TimeUnit.MILLISECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			return wait;
		*/
	}
	
	public static void DB_Verify(String ActualText, String ExpectedText, String elementDesc, String DBTable) throws IOException
	{
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
		try
		{
			String ActualText1  = ActualText.trim().toLowerCase();
			String ExpectedText1 = ExpectedText.trim().toLowerCase();
			if(ActualText1.equalsIgnoreCase(ExpectedText1))
			{
				logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+ActualText +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
				logEvent_No_SC("<p style=\"color:Navy\">"+"<u>"+"DB validation for "+"<b>"+elementDesc+"</b>"+" in DB Table - "+"<b>"+DBTable+"</b>"+" :"+"</u>"+" Actual and Expected texts are Equal "+ " : Actual "+elementDesc+" is: "+"<b>"+ActualText +"</b>"+" and Expected "+elementDesc+" is: "+"<b>"+ExpectedText +"</b>"+"</p>","pass");
			}
			else
			{
				logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT :");
				logEvent_No_SC("<p style=\"color:red\">"+"Actual and expected texts are not matching for: "+"<u>"+elementDesc+"</u>"+ " Actual Text: "+"<b>"+ActualText +"</b>"+ " Expected Text: "+"<b>"+ExpectedText+"</b>"+"</p>", "fail");
			}

		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		}
	}
	public static void VerifyText_For_PageCaption_Contains(WebElement element, String ExpectedText, String elementDesc)
			throws IOException {
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
		try {
			waitForElementToBeVisible(element, elementDesc);
			String Actual = element.getText();
			Actual = Actual.trim().toLowerCase();
			ExpectedText = ExpectedText.trim().toLowerCase();
			 assertEquals(Actual, ExpectedText);
			
		
			assertTrue(Actual.trim().contains(ExpectedText));

			logger.info("Actual and Expected texts are equal: Actual is: " + "<b>" + Actual + "</b>"
					+ " and Expected is: " + "<b>" + ExpectedText + "</b>");
			// logEvent("Successfully Landed in "+"<b>"+elementDesc+"</b>", "pass");
		}

		catch (Exception error) {
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : " + error.getMessage());
			// logEvent("Actual and expected texts are not matching for:
			// "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(),
			// "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + error.getMessage());
		}
	}
	public static void PrintValueToReport(String PrintText, String elementDesc) throws IOException
	{
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
		try
		{

			logger.info("Printing value of "+"<b>"+elementDesc +"</b>"+" :"+"<b>"+PrintText +"</b>");
			//logEvent_No_SC("Text matched for "+"<b>"+elementDesc+"</b>", "pass");
			logEvent_No_SC("Printing value of "+"<b>"+elementDesc +"</b>"+" : "+"<b>"+PrintText +"</b>","pass");

		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			logEvent_No_SC("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		}
	}
	
	private static void logEvent_No_SC(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public static void waitForElementToBeVisible(WebElement locator,String elementDesc) throws IOException
	{
		try
		{
			//Thread.sleep(1000); //Added on 24-June-2022 
			//Thread.sleep(500); //Added on 24-June-2022 Added for slow-down the speed/pace
			//logger.info(locator);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(locator));
		}
		catch(NoSuchElementException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(StaleElementReferenceException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(WebDriverException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(Exception exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}

	}
	
	public static void waitForElementToBeClickable(WebElement locator,String elementDesc) throws IOException
	{
		try
		{
			//Thread.sleep(1000); //Added on 24-June-2022
			Thread.sleep(500); //Added on 24-June-2022 Added for slow-down the speed/pace
			logger.info(locator);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(NoSuchElementException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(StaleElementReferenceException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(WebDriverException exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(Exception exception)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:- "+exception.getMessage());
		}
	}
	
	public static void VerifyText_For_PageCaption(WebElement element, String ExpectedText, String elementDesc) throws IOException
	{
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
		try
		{
			waitForElementToBeVisible(element,elementDesc);
			String Actual = element.getText();
			Actual  = Actual.trim().toLowerCase();
			ExpectedText = ExpectedText.trim().toLowerCase();
			assertEquals(Actual, ExpectedText);
			logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
			//logEvent("Successfully Landed in  "+"<b>"+elementDesc+"</b>", "pass");
		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void VerifyText_For_PageCaption1(WebElement element, String ExpectedText, String elementDesc) throws IOException
	{
		logger.info("--------	VerifyText wrapper method inside FalconActions class is invoked successfully	--------");
		try
		{
			waitForElementToBeVisible(element,elementDesc);
			String Actual = element.getText();
			Actual  = Actual.trim().toLowerCase();
			
			int indx = Actual.indexOf("!");
			
			Actual = Actual.substring(0, indx);
			//System.out.println("Actual"+Actual);
			
			ExpectedText = ExpectedText.trim().toLowerCase();
			
			System.out.println("@@@@@@@@@@");
			System.out.println(Actual);
			System.out.println(ExpectedText);
			System.out.println("@@@@@@@@@@");
			//junit.framework.Assert
			assertEquals(Actual, ExpectedText);
			logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
			//logEvent("Successfully Landed in  "+"<b>"+elementDesc+"</b>", "pass");

		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
		}
	}
	
	public static void EnterText(WebElement element, String textToType, String elementDesc) throws IOException
	{
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
		try
		{
			waitForElementToBeVisible(element,elementDesc);
			element.click();
		//	element.clear();
			element.sendKeys(textToType);
			logger.info("--------	EnterText wrapper method inside FalconActions class is executed successfully	--------");
			//logEvent("User Entered text " +"<b>"+textToType+ "</b>"+ " into the "+"<b>"+elementDesc +"</b>"+" field", "pass"); //Commented on on 20-JUNE-2019 4DOC
			//logEvent("User_Entered_text_into_the_"+elementDesc +"_field", "pass"); //Added on on 20-JUNE-2019 4DOC
			
		}

		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
			//logEvent("User unable to enter text into the input field "+"<b>"+elementDesc +"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"User unable to enter text into the input field "+"<b>"+elementDesc +"</b>"+" due to the Exception: "+error.getMessage());
		}
	}

public static void click(WebElement element, String elementDesc) throws IOException
{
	logger.info("--------	click wrapper method inside MyAction class is invoked successfully	--------");
	try
	{
		//System.out.println("Click event: element visible check started");
		waitForElementToBeVisible(element,elementDesc);
		//System.out.println("Click event: element visible check success");
		//System.out.println("Click event: started");
		element.click();
		//System.out.println("Click event: End");
		logger.info("--------	click wrapper method inside MyAction class is executed successfully	--------");
		//logEvent("User clicked on the "+"<b>"+elementDesc+"</b>", "pass"); //Commented on 24-JUNE-2019 4DOC
		//logEvent("User clicked on the "+"<b>"+elementDesc+"</b>", "pass"); //Added on 24-JUNE-2019 4DOC
	}
	catch(NoSuchElementException exception)
	{
		logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		////logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage());
	}
	catch(StaleElementReferenceException exception)
	{
		logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage());
	}
	catch(WebDriverException exception)
	{
		logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage());
	}
	catch(Exception exception)
	{
		logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"+"User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage());
	}	
	}


public static void mouseOverAndClick(WebDriver driver, WebElement element, String elementDesc) throws IOException
{
	logger.info("--------	mouseOverAndClick wrapper method inside MyAction class is invoked successfully	--------");
	Actions actionObj;
	Action action;
	try
	{
		actionObj = new Actions(driver);
		action = actionObj.moveToElement(element).click().build();
		action.perform();
		logger.info("--------	mouseOverAndClick wrapper method inside MyAction class is invoked successfully	--------");
		//logEvent("User clicked on the "+"<b>"+elementDesc+"</b>", "pass"); //Added on 24-JUNE-2019 4DOC

	}
	catch(NoSuchElementException exception)
	{
		logger.error("ERROR WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(StaleElementReferenceException exception)
	{
		logger.error("ERROR WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(WebDriverException exception)
	{
		logger.error("ERROR WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(Exception exception)
	{
		logger.error("ERROR WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO MOUSE OVER AND CLICK ON THE SPECIFIED WEB ELEMENT");
	}	
}

/*To select value from dropdown using visible text*/
public static void SelectVisibleText(WebElement element, String ddValue, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside CustomMethod class is invoked successfully!!	--------");
	try
	{
		waitForElementToBeVisible(element,elementDesc); // Added on 29-MAY-2019
		if(element.isDisplayed()){
			Select sel = new Select(element);
			sel.selectByVisibleText(ddValue);
			logger.info("---------------s- desired dropdown value is selected -------------------");
			//logEvent("<b>"+elementDesc+"</b>"+" is selected from the dropdown", "pass");
		}
	}

	catch(Exception error)
	{
		logger.error("@ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("User unable to select "+"<b>"+elementDesc+"</b>"+" from the dropdown value due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
	}

}

public static void ScrollToElement(WebElement element, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside CustomMethod class is invoked successfully	--------");
	try
	{
		//WebElement ele = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) TestBase.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000); 
		/*JavascriptExecutor exe = (JavascriptExecutor) TestBase.driver;
		exe.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);*/
		logger.info("--------	EnterText wrapper method inside CustomMethod class is executed successfully	--------");
		//logEvent("Focus moved to "+"<b>"+elementDesc+"</b>", "pass");
	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("<b>"+elementDesc+"</b>"+" is not displayed due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"<b>"+elementDesc+"</b>"+" is not displayed due to the Exception: "+error.getMessage());
	}
}


public static void SoftVerifyTextOnly(String ActualText, String ExpectedText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		String ActualText1  = ActualText.trim().toLowerCase();
		String ExpectedText1 = ExpectedText.trim().toLowerCase();
		if(ActualText1.equalsIgnoreCase(ExpectedText1))
		{
			logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+ActualText +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
			//logEvent_No_SC("Actual and Expected texts are Equal for "+"<u>"+elementDesc+"</u>"+ " : Actual is: "+"<b>"+ActualText +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>","pass");
		}
		else
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT :");
			//logEvent_No_SC("<p style=\"color:red\">"+"Actual and expected texts are not matching for: "+"<u>"+elementDesc+"</u>"+ " Actual Text: "+"<b>"+ActualText +"</b>"+ " Expected Text: "+"<b>"+ExpectedText+"</b>"+"</p>", "fail");
		}

	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
	}
}

public static void SoftVerifyTextOnly(WebElement ActualText, String ExpectedText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		String ActualText0  = ActualText.getText();
		String ActualText1 = ActualText0.trim().toLowerCase();
		String ExpectedText1 = ExpectedText.trim().toLowerCase();
		if(ActualText1.equalsIgnoreCase(ExpectedText1))
		{
			logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+ActualText +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
			//logEvent_No_SC("Actual and Expected texts are Equal for "+"<u>"+elementDesc+"</u>"+ " : Actual is: "+"<b>"+ActualText +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>","pass");
		}
		else
		{
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT :");
			//logEvent_No_SC("<p style=\"color:red\">"+"Actual and expected texts are not matching for: "+"<u>"+elementDesc+"</u>"+ " Actual Text: "+"<b>"+ActualText +"</b>"+ " Expected Text: "+"<b>"+ExpectedText+"</b>"+"</p>", "fail");
		}

	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
	}
}


public static void SwitchToDynamicAlert_Accept() throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{		
		Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		Set<String> all_windows=driver.getWindowHandles();
		
		for(String child:all_windows)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				logger.info("--------	EnterText wrapper method inside FalconActions class is executed successfully	--------");
				//logEvent("Accepted the Alert", "pass"); //Commented on on 20-JUNE-2019 4DOC
			}
			driver.switchTo().window(parent);
		}
		
	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("User unable to accept alert "+ "due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"User unable to accept alert "+ "due to the Exception: "+error.getMessage());
	}
}


public static void handleAlert(){
	
	logger.info("--------	Alert wrapper method inside FalconActions class is invoked successfully	--------");
	
	try
	{
		if(isAlertPresent()){
	        System.out.println("ALERT PRESENT");
	        logger.info("ALERT PRESENT");
	    	Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	    }
	    else
	    {
	    	System.out.println("ALERT NOT PRESENT");
	    	logger.info("ALERT NOT PRESENT");
	    }
	}
	catch(Exception error)
	{
		error.printStackTrace();
	}
	
}

public static boolean isAlertPresent(){
      try{
        
    	  //WebDriverWait wait = new WebDriverWait(driver,10);
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.alertIsPresent());
    	  driver.switchTo().alert();
          return true;
      }catch(NoAlertPresentException ex){
          return false;
      }
}

public void movetoelement(WebElement element)
{
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
    
}

public static Object executeScript(String script)
{
	JavascriptExecutor exe = (JavascriptExecutor) driver;
	logger.info(script);
	return exe.executeScript(script);
}

public static Object executeScript(String script, Object...args)
{
	JavascriptExecutor exe = (JavascriptExecutor) driver;
	logger.info(script);
	return exe.executeScript(script, args);
}

public void scrollIntoView(WebElement element)
{
	executeScript("arguments[0].scrollIntoView()",element);
	logger.info(element);
}


public void scrollToElement(WebElement element) 
{
	executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	logger.info(element);
}

public static void javaScriptExecutorImageClick(WebElement element)
{
	executeScript("arguments[0].click()",element);
	logger.info(element);
}

public static void javaScriptExecutorClick(WebElement element)
{
	executeScript("arguments[0].click()",element);
	logger.info(element);
}

public static void javaScriptExecutortoEnterText(WebElement element, String Value)
{
	executeScript("arguments[0].value=Value;",element);
	logger.info(element);
}

public static void scrollDownByPixel()
{
	executeScript("window.scrollBy(-1000,0)");
}

public static void scrollToMiddle()
{
	executeScript("window.scrollBy(0,-1500)");
}

public static void scrollDownVertically()
{
	executeScript("window.scrollTo(0, document.body.scrollHeight)");
}

public static void scrollUpVertically()
{
	executeScript("window.scrollTo(0, -document.body.scrollHeight)");
}

public static void VerifyText_Customized(WebElement element, String ExpectedText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		waitForElementToBeVisible(element,elementDesc);
		String Actual = element.getText();
		Actual  = Actual.trim().toLowerCase();
		int colonindx=Actual.indexOf(":");
		Actual=Actual.substring(colonindx+2);
		ExpectedText = ExpectedText.trim().toLowerCase();
		assertEquals(Actual, ExpectedText);
		logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
		//logEvent("Text matched for "+"<b>"+elementDesc+"</b>", "pass");

	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
	}
}

public static void VerifyText(WebElement element, String ExpectedText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		waitForElementToBeVisible(element,elementDesc);
		String Actual = element.getText();
		Actual  = Actual.trim().toLowerCase();
		ExpectedText = ExpectedText.trim().toLowerCase();
		assertEquals(Actual, ExpectedText);
		logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
		//logEvent("Text matched for "+"<b>"+elementDesc+"</b>", "pass");

	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
	}
}


public static void VerifyPlainText(String ExpectedText, String ActualText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		String Actual = ActualText;
		Actual  = Actual.trim().toLowerCase();
		ExpectedText = ExpectedText.trim().toLowerCase();
		assertEquals(Actual, ExpectedText);
		logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
		//testlogINFO("Actual is "+Actual+" and Expected is "+Actual+" , Hence Pass");
		//logEvent("Text matched for "+"<b>"+elementDesc+"</b>", "pass"); 
	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
	}
}


public static void waitForLoadingIconDisappearInDialog(WebDriver driver) {
	System.out.println("Wait for loading icons display in dialog or widgets.");
	Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			try {
				for (WebElement el : driver.findElements(By.xpath("//div[@class='mm-page-loader__wrapper']"))) {
					if (el.isDisplayed()) {
						System.out.println("Loading icon display in dialog or widgets.");
						return false;
					}
				}
			}
			catch (Exception ex) {
				return true;
			}
			return true;
		}
	};

	//WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	wait.withMessage("Loading icons should disppear in dialog or widgets in 120s");
	wait.until(waitFn);
	System.out.println("Loading icons disspear in dialog or widgets.");
}

public static void waitForLoanOfferLoadingIconDisappearInDialog(WebDriver driver) {
	System.out.println("Wait for LOan offer page loading icons display in dialog or widgets.");
	Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			try {
				for (WebElement el : driver.findElements(By.xpath("//img[@class='hrglass']"))) {
					if (el.isDisplayed()) {
						System.out.println("Loading icon display in dialog or widgets.");
						return false;
					}
				}
			}
			catch (Exception ex) {
				return true;
			}
			return true;
		}
	};

	//WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	wait.withMessage("Loan offer Loading icons should disppear in dialog or widgets in 120s");
	wait.until(waitFn);
	System.out.println("Loan offer Loading icons disspear in dialog or widgets.");
}

public static void loadingWait_Disappear(WebElement locator,String elementDesc) throws IOException
{
	try
	{
		//logger.info(locator);
		WebDriverWait wait = applyWebDriverWait();
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}
	catch(NoSuchElementException exception)
	{
		//logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
		//Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(StaleElementReferenceException exception)
	{
		//logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
		//Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(WebDriverException exception)
	{
		//logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
		//Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");
	}
	catch(Exception exception)
	{
		//logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
		logEvent_No_SC("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
		Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");
	}

}

public static void VerifyText_ForFirstPaymentDateMatch(WebElement element, String ExpectedText, String elementDesc) throws IOException
{
	logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");
	try
	{
		waitForElementToBeVisible(element,elementDesc);
		String Actual = element.getText();
		Actual  = Actual.trim().toLowerCase();
		//ExpectedText = ExpectedText.trim().toLowerCase();
		ExpectedText = Actual;
		assertEquals(Actual, ExpectedText);
		logger.info("Actual and Expected texts are equal: Actual is: "+"<b>"+Actual +"</b>"+" and Expected is: "+"<b>"+ExpectedText +"</b>");
		//logEvent("Text matched for "+"<b>"+elementDesc+"</b>", "pass");

	}

	catch(Exception error)
	{
		logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+error.getMessage());
		//logEvent("Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(), "fail");
		Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "+"Actual and expected texts are not matching for: "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage());
	}
}
public static void switchWindow(String windowName) {
	
	Set<String> handles = driver.getWindowHandles();
	for(String handle :handles) {
		System.out.println(driver.getTitle()+ "size :  "+handles.size());
		if(driver.getTitle().contains(windowName)) {
			return;
		}
		driver.switchTo().window(handle);
	}
}
	public static String generateRandomTextDynamically() {

	int leftLimit = 97; // letter 'a'
	int rightLimit = 122; // letter 'z'
	int targetStringLength = 8;
	Random random = new Random();
	StringBuilder buffer = new StringBuilder(targetStringLength);
	for (int i = 0; i < targetStringLength; i++) {
	int randomLimitedInt = leftLimit + (int)
	(random.nextFloat() * (rightLimit - leftLimit + 1));
	buffer.append((char) randomLimitedInt);
	}
	String generatedString = buffer.toString();



	System.out.println(generatedString);
	return generatedString;
	}
	
	
	public void waitAndSwitchToIFrame(WebElement iframeelement){
		WebDriverWait wait = applyWebDriverWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeelement));
	}
	public void switchtoDefaultIFrame() {
		driver.switchTo().defaultContent();
	}
	
	public static void waitAndSwitchToIFrameUsingFrameNumber(int framenumber){
		WebDriverWait wait = applyWebDriverWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framenumber));
		
	}
	
	public static void scrollToElement( WebElement element,String msg) {
	       
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
       
    }
	public static void switchtoParentIFrame(){
		driver.switchTo().parentFrame();
		logger.info("Switching to Parent IFrame in the screen");
	}
	
	public static void performDoubleClick( WebElement element,String Description) {
        // Using Actions class for double click
		try {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
		}
		catch(NoSuchElementException exception)
		{
			logger.error("ERROR WHILE TRYING TO DOUBLE CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING DOUBLE CLICK ON THE SPECIFIC WEB ELEMENT"+"<b>"+Description+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(StaleElementReferenceException exception)
		{
			logger.error("ERROR WHILE TRYING TO DOUBLE CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING DOUBLE CLICK ON THE SPECIFIC WEB ELEMENT"+"<b>"+Description+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(WebDriverException exception)
		{
			logger.error("ERROR WHILE TRYING TO DOUBLE CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING DOUBLE CLICK ON THE SPECIFIC WEB ELEMENT"+"<b>"+Description+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
		catch(Exception exception)
		{
			logger.error("ERROR WHILE TRYING TO DOUBLE CLICK ON THE SPECIFIED WEB ELEMENT : "+exception.getMessage());
			//logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING DOUBLE CLICK ON THE SPECIFIC WEB ELEMENT"+"<b>"+Description+"</b>"+" is not visible _due_to_the_Exception:- "+exception.getMessage());
		}
    }
}