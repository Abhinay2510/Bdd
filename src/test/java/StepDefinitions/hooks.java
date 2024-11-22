package StepDefinitions;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.TestBase;
import utils.UtilityMethods;

public class hooks extends TestBase {
	
	public static WebDriver driver;
	//public String testCaseName, testDataSetName; Commented on 28-May-2022
	public static long start, end;	
	public static String atTime;
	
	public static Scenario scenario;
	public static final Logger logger = Logger.getLogger(hooks.class.getName());
	//public Scenario scenario;
	
	public static void takeScreenshotimage(WebDriver driver,String FileNameWithExtension) throws IOException, InterruptedException{
				
	{
		
		WebDriver driver1 = new Augmenter().augment(driver);
		File acutalFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		try{
			@SuppressWarnings("unused")
			BufferedImage fullImg = ImageIO.read(acutalFile);
			FileUtils.copyFile(acutalFile, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+FileNameWithExtension+".png"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	}
	
	@SuppressWarnings("static-access")
	@Before
	public void beforeScenario(Scenario scenario) throws IOException 
	{
		//System.out.println("BEFORE HOOK EXECUTED");
		//System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
    	this.scenario =scenario; 
        System.out.println("Executing Scenario : " + scenario.getName()); 
        
        
        TestBase.currentGlobalScenarioName = scenario; //Added on 26-June-2022 PPTEST
        
        
		        
        
        start = System.currentTimeMillis();
		atTime = UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan(); //PPAdded on 03-APR-2019
        
        /*
        VRLoginTest a = new VRLoginTest();
        a.getClass().getSimpleName();
        System.out.println("CLASS NAME IS "+ a.getClass().getSimpleName());
        */
        String scenarioId=scenario.getId(); 
        System.out.println("scenarioId              :"+scenarioId);
        int indxofpipe = scenarioId.indexOf("|");
        //System.out.println(indxofpipe);
        System.out.println("***********************************************************");
        System.out.println("Scenatio Reference :  "+scenarioId.substring(indxofpipe+1));
        //System.out.println(scenarioId.substring(indxofpipe+1).replaceAll("-", "_").toUpperCase());
        testCaseName = scenarioId.substring(indxofpipe+1).replaceAll("-", "_").toUpperCase();
        testDataSetName = scenarioId.substring(indxofpipe+1).replaceAll("-", "_").toUpperCase()+"_DS1";
        System.out.println(testCaseName);
        System.out.println(testDataSetName);
   
        //added july 2022 start
        logLoanDetailsPath = rootPath+"\\logger\\"+UtilityMethods.getDate_ddMMyyyy()+"\\"+testCaseName+"_LoanDetails_"+UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan();
      //Added on 28-May-2022 end
   
        logLoanDetails.add("###################################################");
		logLoanDetails.add("Executing Scenario : " + scenario.getName());
		logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End

        
        
        //Added on 28-May-2022 Start
		logLoanDetails.add("***********************************************************");
		logLoanDetails.add("Start Time : "+atTime); //Added on 27-June-2022
		logLoanDetails.add(testCaseName);
		logLoanDetails.add(testDataSetName);
		logLoanDetails.add("***********************************************************");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(logLoanDetailsPath, logLoanDetails);;
		logLoanDetails.clear();
		//Added on 28-May-2022 End
        
        System.out.println("***********************************************************");
        
        try {
			loadExcelData(testCaseName, testDataSetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void afterScenario() throws InterruptedException 
	{
		System.out.println("AFTER HOOK EXECUTED");
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			try {
				bindreport(scenario, Scenario_Description);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(rowcount == 0)
			{
				rowcount = rowcount + 1;
			}
			
			logger.info("===onTestFailure Start===");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Status",rowcount+1, "FAIL");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"ExecutedAt",rowcount+1, atTime);
			
			if(webDriverIntialized  && getDriver() != null)
			{
				try
				{
					//getDriver().close(); //Commented - Need to Uncomment later
					//getDriver().close(); 
					//logger.info("Driver closed");
				}
				catch(Exception e)
				{
					Assert.fail("Attaching screenshot to report failed due to : "+e.getMessage());
					logger.info("Driver closing error"+e.getMessage());
				}
			}
		}	
		else
		{
			if(rowcount == 0)
			{
				rowcount = rowcount + 1;
			}
			logger.info("===onTestSuccess Start===");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Status",rowcount+1, "PASS");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"ExecutedAt",rowcount+1, atTime);
			//scenario.embed(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			writeExcelReport(testCaseName, "Environment", "Device", "OS", "Version", browser);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		if(webDriverIntialized  && getDriver() != null)
		{
			try
			{
				//getDriver().close(); Commented - Need to Uncomment later
				//getDriver().close(); 
				//logger.info("Driver closed");
			}
			catch(Exception e)
			{
				Assert.fail("Attaching screenshot to report failed due to : "+e.getMessage());
				logger.info("Driver closing error"+e.getMessage());
			}
		}
		getDriver().quit();
		
	}
//	public static void bindreport(Scenario scenario, String screenshotName) throws IOException, InterruptedException
//	{
//		if(TestBase.getPropertyValue("IsStepLevelScreenshotNeeded").equalsIgnoreCase("yes") || scenario.isFailed()) {
//			TestBase.logger.info("Taking screenshot for every step in the scearnario");
//		byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
//	    scenario.embed(screenshot, "image/png");
//	    takeScreenshotimage(getDriver(), screenshotName);
//	   // Reporter.addScreenCaptureFromPath(screenshotName, screenshotName)
//		Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenshotName+".png");
//		}else if(TestBase.getPropertyValue("IsStepLevelScreenshotNeeded").equalsIgnoreCase("No") ) {
//			TestBase.logger.info("Proceed without screenshots for every step in the scenario");
//		}
//		
//		if(scenario.isFailed()) {
//			byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
//		    scenario.embed(screenshot, "image/png");
//		    takeScreenshotimage(getDriver(), screenshotName);
//		   // Reporter.addScreenCaptureFromPath(screenshotName, screenshotName)
//			Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenshotName+".png");
//		}
//	}
	
	
	
	public static void writeExcelReport(String TestScript, String Environment, String Device, String OS,String Version, String Browser) throws InterruptedException
    {
		Thread.sleep(3000);
		//logger.info("Writing of excel report started");
    	getTestScriptRowNumstatic = getTestCasePositionBasedOnScriptName(getPropertyValue("xlsTestCasesSheetname"),TestScript);
    	//logger.info("getTestScriptRowNumstatic : "+getTestScriptRowNumstatic);
    	if(getTestScriptRowNumstatic < 0)
    	{
    		getTestScriptRowNumstatic = 0;
    	}
    	//getTestScriptRowNum = getTestScriptRowNum + NumberOfTime;
    	rowcount = datatable.getRowCount(getPropertyValue("xlsReportsSheetname"));
    	//System.out.println("Current Report row Count :"+rowcount);
    	if(getTestScriptRowNumstatic > 0)
    	{
	    	logger.info("SCENARIO AVAILABLE WITH REFERENCE TO FEATURE->SCENARIO");
    		// Alternet way  by index
	    	// testcaseid = datatable.getCellData("TestCases", 0, getTestScriptRowNumstatic);
	    	// testcasename = datatable.getCellData("TestCases", 1, getTestScriptRowNumstatic);
	    	// testdescription = datatable.getCellData("TestCases", 2, getTestScriptRowNumstatic);
	    	// testscriptname = datatable.getCellData("TestCases", 3, getTestScriptRowNumstatic);
	    	Feature_Name = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Feature_Name",getTestScriptRowNumstatic);
	    	Feature_Id = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Feature_Id",getTestScriptRowNumstatic);
	    	Feature_Description = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Feature_Description",getTestScriptRowNumstatic);
	    	Scenario_Id = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Scenario_Id",getTestScriptRowNumstatic);
	    	Scenario_Description = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Scenario_Description",getTestScriptRowNumstatic);
	    	logger.info("!!!!!!!!!!SCENARIO DATA!!!!!!!!!!");
	    	logger.info("Feature name ===> "+Feature_Name);
	    	logger.info("Feature id ===> "+Feature_Id);
	    	logger.info("Feature description ===> "+Feature_Description);
	    	logger.info("Scenario id ===> "+Scenario_Id);
	    	logger.info("Scenario description ===> "+Scenario_Description);
	    	logger.info("!!!!!!!!!!SCENARIO DATA!!!!!!!!!!");
	    	//22-Nov-2020 Removed + 1 for testing START - ICICISWIFTDEMO
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Name",rowcount, Feature_Name);
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Id",rowcount, Feature_Id);
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Description",rowcount, Feature_Description);
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Scenario_Id",rowcount, Scenario_Id);
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Scenario_Description",rowcount, Scenario_Description);
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Browser",rowcount, Browser);
	       //Added on 18-Mar-2021 Start
	        String testcaseStatus = datatable.getCellData(getPropertyValue("xlsReportsSheetname"), "Status", rowcount);
	        if(testcaseStatus.equalsIgnoreCase("PASS"))
	        {
	        	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCaseRemarks",rowcount, Feature_Name+" is SUCCESSFULL");	       
	        }
	        else
	        {
	        	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCaseRemarks",rowcount, Feature_Name+" is UN-SUCCESSFULL, Please check Report for reason");
	        }
	     	}
    	else
    	{
    		logger.info("TEST CASE NOT AVAILABLE WITH REFERENCE TO TEST SCRIPT");
    		datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Name",rowcount, "Not Available");
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Id",rowcount, "Not Available");
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Feature_Description",rowcount, "Not Available");
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Scenario_Id",rowcount, "Not Available");
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Scenario_Description",rowcount,"Not Available");
	    	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Browser",rowcount, Browser);
	        String testcaseStatus = datatable.getCellData(getPropertyValue("xlsReportsSheetname"), "Status", rowcount);
	        if(testcaseStatus.equalsIgnoreCase("PASS"))
	        {
	        	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCaseRemarks",rowcount, Feature_Name+" is SUCCESSFULL");	       
	        }
	        else
	        {
	        	datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCaseRemarks",rowcount, Feature_Name+" is UN-SUCCESSFULL, Please check Report for reason");
	        }
	        logger.info("Writing of excel report done");
    	}
    }
}