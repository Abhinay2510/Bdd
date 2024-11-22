package reports;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.TestBase;
import utils.UtilityMethods;

public class Reports extends TestBase
{
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static String rootPath = System.getProperty("user.dir");

	//Report variables
	public static ExtentHtmlReporter htmlReporter; 
	public static ExtentReports extent; 
	public static ExtentTest test; 
	public static int rowcountone;
	public static String StepLevelScreenshot;
	public static String Screenshotname;
	// To initialize report Objects
	public void initializeReports()
	{
		htmlReporter = new ExtentHtmlReporter(rootPath+"/Report/"+getRunnerPropertyValue("releaseVersion")+"_Run"+getRunnerPropertyValue("runcount")+"_"+UtilityMethods.getDate_ddMMyyyy()+"/"+UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan()+".html");
		htmlReporter.config().setDocumentTitle("3i-Infotech Test Automation - Execution Reports"); 
		htmlReporter.config().setReportName("Build-Regv2.0");
		htmlReporter.config().setChartVisibilityOnOpen(true); //Added on 24-APR-2019 AfterDemo
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger.info("Loading extent report done"); 
		StepLevelScreenshot = getPropertyValue("IsStepLevelScreenshotNeeded");

	}

	public void DisplayTestDataInReport()
	{
		/*String testDataRepotLabel = "TEST DATA OF *** "+TestBase.env+"_"+TestBase.browsr+" ***"; 
		test.info(setReportLabel(testDataRepotLabel));
		String[][] testdata = {
				{"<b>Province<b>", "<b>FirstName<b>", "<b>LastName<b>", "<b>Email<b>", "<b>Confirm Email<b>"},
				{getMapData.get("Province"), getMapData.get("FirstName"), getMapData.get("LastName"),getMapData.get("Email"), getMapData.get("Email")}
		};
		test.info(setReportwithTestDataUsed(testdata));
		String[][] testdata1 = {
				{"<b>SIN<b>", "<b>DateOfBirth<b>","<b>Address<b>","<b>POBox<b>","<b>City<b>"},
				{getMapData.get("SIN"),getMapData.get("DOB"), getMapData.get("Address"), getMapData.get("POBox"),getMapData.get("City")}
		};
		test.info(setReportwithTestDataUsed(testdata1));
		String[][] testdata2 = {
				{"<b>PostalCode<b>","<b>PhoneHome<b>","<b>PhoneCell<b>","<b>Gender<b>"},
				{getMapData.get("PostalCode"),getMapData.get("PhoneHome"),getMapData.get("PhoneCell"),getMapData.get("Gender")}
		};
		test.info(setReportwithTestDataUsed(testdata2));*/
	}
	//write report to extent report
	public static void writeExtentReport()
	{
		try
		{
			extent.flush();
			logger.info("Writing of extent report done");
		}
		catch(Exception e)
		{
			logger.error("Writing extent report failed due to : "+e.getMessage());
			Assert.fail("Writing extent report failed due to : "+e.getMessage());
		}

	}

	//return Label for extent report
	public static Markup setReportLabel(String labelText)
	{
		Markup lable_m;
		lable_m = MarkupHelper.createLabel(labelText, ExtentColor.ORANGE);
		return lable_m;
	}

	//return Table for extent report
	public static Markup setReportwithTestDataUsed(String[][] testdata)
	{
		Markup table_m;
		table_m = MarkupHelper.createTable(testdata);
		return table_m;
	}

	public static void logEvent(String description, String status) throws IOException{
		//String propertyvalueHc = "No"; //Added to reduce time of property read
		//if(getPropertyValue("IsStepLevelScreenshotNeeded") == "Yes")
		if(StepLevelScreenshot.equalsIgnoreCase("Yes")) //Added to reduce time of property read
		{	
			Screenshotname = description.replaceAll("\\s+", "_").replaceAll("TAKESCREENSHOT", "").replaceAll("<b>", "").replaceAll("</b>", "");
			description = description.replaceAll("TAKESCREENSHOT", "");
			switch(status.toLowerCase().trim()){
			case "pass":
				//test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build());
				test.log(Status.PASS, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build()); 
				//test.log(Status.PASS, description); //Added on 30-MAY-2019
				//test.info(description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build()); 
				break;

			case "fail":
				//test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build()); 
				test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build()); 
				//test.log(Status.FAIL, description); //Added on 30-MAY-2019
				break;	

			case "info":
				test.log(Status.INFO, description);
				break;	

			case "warning":
				//test.log(Status.WARNING, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build());
				test.log(Status.WARNING, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build());
				//test.log(Status.WARNING, description); //Added on 30-MAY-2019
				break;	
			}
		}
		else
		{
			switch(status.toLowerCase().trim()){
			case "pass":
				//test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build());

				if(description.contains("TAKESCREENSHOT"))
				{
					Screenshotname = description.replaceAll("\\s+", "_").replaceAll("TAKESCREENSHOT", "").replaceAll("<b>", "").replaceAll("</b>", "");
					description = description.replaceAll("TAKESCREENSHOT", "");
					test.log(Status.PASS, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build());
					break;
				}
				else
				{
					test.log(Status.PASS, description);
					break;
				}

				/*
				//test.log(Status.PASS, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build()); Commented on 30-MAY-2019
				test.log(Status.PASS, description); //Added on 30-MAY-2019
				//test.info(description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build()); 
				break;
				 */

			case "fail":

				if(description.contains("TAKESCREENSHOT"))
				{
					Screenshotname = description.replaceAll("\\s+", "_").replaceAll("TAKESCREENSHOT", "").replaceAll("<b>", "").replaceAll("</b>", "");
					description = description.replaceAll("TAKESCREENSHOT", "");
					test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build());
					break;
				}
				else
				{
					test.log(Status.FAIL, description);
					break;
				}

				/*
				//test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build()); Commented on 30-MAY-2019
				test.log(Status.FAIL, description); //Added on 30-MAY-2019
				break;	
				 */

			case "info":
				test.log(Status.INFO, description);
				break;	

			case "warning":

				if(description.contains("TAKESCREENSHOT"))
				{
					Screenshotname = description.replaceAll("\\s+", "_").replaceAll("TAKESCREENSHOT", "").replaceAll("<b>", "").replaceAll("</b>", "");
					description = description.replaceAll("TAKESCREENSHOT", "");
					test.log(Status.WARNING, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(Screenshotname+"@")).build());
					break;
				}
				else
				{
					test.log(Status.WARNING, description);
					break;	
				}
				/*
				//test.log(Status.WARNING, description, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build());Commented on 30-MAY-2019
				test.log(Status.WARNING, description); //Added on 30-MAY-2019
				break;	
				 */
			}
		}


	}
	//Attach screenshot to report
	public static void attachScreenshottoReport(String screen) throws InterruptedException
	{
		//Thread.sleep(3000); // Added on 28-MAY-2019 

		try {
			test.addScreenCaptureFromPath(screen, "Screen title");
			test.info("Complete Page :=> ", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("")).build());

			logger.info("Screen shot captured from path : "+screen);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Attaching screenshot to report failed due to : "+e.getMessage());
			Assert.fail("Attaching screenshot to report failed due to : "+e.getMessage());
		}
	}

	public static void logEvent_No_SC(String description, String status) throws IOException{
		//String propertyvalueHc = "No"; //Added to reduce time of property read
		//if(getPropertyValue("IsStepLevelScreenshotNeeded") == "Yes")

		switch(status.toLowerCase().trim()){
		case "pass":

			test.log(Status.PASS, description);
			break;

		case "fail":

			test.log(Status.FAIL, description);
			break;					

		case "info":
			test.log(Status.INFO, description);
			break;	

		case "warning":

			test.log(Status.WARNING, description);
			break;	

		}		
	}

	//Added on 13-MAY-2019 - Extent test and logger methods - START
	public static void createTest(String sTestname)
	{
		try
		{
			loggerINFO("createTest method called : "+sTestname);
			test = extent.createTest(sTestname);	
		}
		catch(Exception e)
		{
			loggerERROR("Create test failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to create test : "+e.getMessage());
		}
	}
	public static void assingCategory(String sCatagory)
	{
		try
		{
			loggerINFO("assingCategory method called : "+sCatagory);
			test.assignCategory(sCatagory);	
		}
		catch(Exception e)
		{
			loggerERROR("Assign test category failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to assign test category : "+e.getMessage());
		}
	}
	public static void testlogINFO(String slogDescription)
	{
		try
		{
			loggerINFO("testlogINFO method called : "+slogDescription);
			test.log(Status.INFO, slogDescription);	
		}
		catch(Exception e)
		{
			loggerERROR("testlogINFO method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log INFO : "+e.getMessage());
		}
	}
	public static void testlogPASS(String slogDescription)
	{
		try
		{
			loggerINFO("testlogPASS method called : "+slogDescription);
			test.log(Status.PASS, slogDescription);
		}
		catch(Exception e)
		{
			loggerERROR("testlogPASS method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log PASS : "+e.getMessage());
		}
	}
	public static void testlogFAIL(String slogDescription)
	{
		try
		{
			loggerINFO("testlogFAIL method called : "+slogDescription);
			test.log(Status.FAIL, slogDescription);
		}
		catch(Exception e)
		{
			loggerERROR("testlogFAIL method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log FAIL : "+e.getMessage());
		}
	}
	public static void testlogERROR(String slogDescription)
	{
		try
		{
			loggerINFO("testlogERROR method called : "+slogDescription);
			test.log(Status.ERROR, slogDescription);
		}
		catch(Exception e)
		{
			loggerERROR("testlogERROR method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log ERROR : "+e.getMessage());
		}
	}
	public static void testlogSKIP(String slogDescription)
	{
		try
		{
			loggerINFO("testlogSKIP method called : "+slogDescription);
			test.log(Status.SKIP, slogDescription);	
		}
		catch(Exception e)
		{
			loggerERROR("testlogSKIP method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log SKIP : "+e.getMessage());
		}
	}	
	public static void loggerINFO(String sLoggerinfo)
	{
		try
		{
			logger.info(sLoggerinfo);
		}
		catch(Exception e)
		{
			loggerERROR("loggerINFO method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log loggerINFO : "+e.getMessage());
		}
	}
	public static void loggerERROR(String sLoggererror)
	{
		try
		{
			logger.error(sLoggererror);
		}
		catch(Exception e)
		{
			logger.error("loggerERROR method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to log loggerERROR : "+e.getMessage());
		}
	}
	public static void printInConsole(String sTesttoprint)
	{
		try
		{
			System.out.println(sTesttoprint);	
		}
		catch(Exception e)
		{
			loggerERROR("printInConsole method failed due to exception : "+e.getMessage());
			Assert.fail("Exception : While trying to printInConsole : "+e.getMessage());
		}
	}

	/*
	public static void PreReq_Test() throws MalformedURLException
	{
		printInConsole("TESTCASENAME "+TestBase.gettestCaseName());
		loggerINFO("TESTCASENAME "+TestBase.gettestCaseName());
		createTest(TestBase.gettestCaseName()+"_"+TestBase.getEnvironment()+"_"+TestBase.getDevice()+"_"+TestBase.getOS1()+"_"+TestBase.getOSVersion()+"_"+TestBase.getBrowser());
		testlogINFO("Starting "+testName.get()+" scenario");
		System.out.println(TestBase.getEnvironment()+" - "+TestBase.getOS1()+" - "+TestBase.getDevice()+" - "+TestBase.getBrowser()+" - "+TestBase.getOSVersion());
		setupSelenium(TestBase.getEnvironment(),TestBase.getOS1(), TestBase.getDevice(), TestBase.getBrowser(),TestBase.getOSVersion());
		launchURL(getPropertyValue("BaseURL"));
		loggerINFO(getPropertyValue("BaseURL")+" URL launched");
		printInConsole("()()()()()(()()() Object creation initiated()()()()()(()()()");
	}
	*/
	//Added on 13-MAY-2019 - Extent test and logger methods - END
	//write report to excel
	/*
	public static void writeExcelReport(String TestScript, String Environment, String Device, String OS,String Version, String Browser) throws InterruptedException
	{
		Thread.sleep(2000);
		logger.info("Writing of excel report started");
		getTestScriptRowNumstatic = getTestCasePositionBasedOnScriptName(getPropertyValue("xlsTestCasesSheetname"),TestScript);

		logger.info("getTestScriptRowNumstatic : "+getTestScriptRowNumstatic);

		if(getTestScriptRowNumstatic < 0)
		{
			getTestScriptRowNumstatic = 0;
		}
		//getTestScriptRowNum = getTestScriptRowNum + NumberOfTime;
		rowcount = datatable.getRowCount(getPropertyValue("xlsReportsSheetname"));
		System.out.println("Current Report row Count :"+rowcount);
		rowcountone = datatable.getRowCount(getPropertyValue("xlsReportsConsolidatedSheetname")); //Added on 06-MAY-2019
		System.out.println("Consolidated Report row Count :"+rowcountone);

		if(getTestScriptRowNumstatic > 0)
		{
			logger.info("TEST CASE AVAILABLE WITH REFERENCE TO TEST SCRIPT");
			// Alternet way  by index
			// testcaseid = datatable.getCellData("TestCases", 0, getTestScriptRowNumstatic);
			// testcasename = datatable.getCellData("TestCases", 1, getTestScriptRowNumstatic);
			// testdescription = datatable.getCellData("TestCases", 2, getTestScriptRowNumstatic);
			// testscriptname = datatable.getCellData("TestCases", 3, getTestScriptRowNumstatic);

			testcaseid = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"TestCase_Id",getTestScriptRowNumstatic);
			testcasename = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Test case name",getTestScriptRowNumstatic);
			testdescription = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Test Desc",getTestScriptRowNumstatic);
			testscriptname = datatable.getCellData(getPropertyValue("xlsTestCasesSheetname"),"Test Script Name",getTestScriptRowNumstatic);

			logger.info("!!!!!!!!!!TEST CASE DATA!!!!!!!!!!");
			logger.info("Test Case id ===> "+testcaseid);
			logger.info("Test Case name ===> "+testcasename);
			logger.info("Test Case description ===> "+testdescription);
			logger.info("Test Script name ===> "+testscriptname);
			logger.info("!!!!!!!!!!TEST CASE DATA!!!!!!!!!!");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCase_Id",rowcount+1, testcaseid);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test case name",rowcount+1, testcasename);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test Desc",rowcount+1, testdescription);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test Script Name",rowcount+1, testscriptname);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Environment",rowcount+1, Environment);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Device",rowcount+1, Device);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"OS",rowcount+1, OS);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Version",rowcount+1, Version);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Browser",rowcount+1, Browser);
			//Added on 06-MAY-2019 START - for consolidated test report 
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"TestCase_Id",rowcountone+1, testcaseid);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test case name",rowcountone+1, testcasename);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test Desc",rowcountone+1, testdescription);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test Script Name",rowcountone+1, testscriptname);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Environment",rowcountone+1, Environment);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Device",rowcountone+1, Device);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"OS",rowcountone+1, OS);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Version",rowcountone+1, Version);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Browser",rowcountone+1, Browser);
			//Added on 06-MAY-2019 END - for consolidated test report
		}
		else
		{
			logger.info("TEST CASE NOT AVAILABLE WITH REFERENCE TO TEST SCRIPT");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"TestCase_Id",rowcount+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test case name",rowcount+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test Desc",rowcount+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Test Script Name",rowcount+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Environment",rowcount+1, Environment);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Device",rowcount+1, Device);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"OS",rowcount+1, OS);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Version",rowcount+1, Version);
			datatable.setCellData(getPropertyValue("xlsReportsSheetname"),"Browser",rowcount+1, Browser);
			//Added on 06-MAY-2019 START - for consolidated test report
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"TestCase_Id",rowcountone+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test case name",rowcountone+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test Desc",rowcountone+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Test Script Name",rowcountone+1, "Not Available");
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Environment",rowcountone+1, Environment);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Device",rowcountone+1, Device);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"OS",rowcountone+1, OS);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Version",rowcountone+1, Version);
			datatable.setCellData(getPropertyValue("xlsReportsConsolidatedSheetname"),"Browser",rowcountone+1, Browser);
			//Added on 06-MAY-2019 END - for consolidated test report
		}
		logger.info("Writing of excel report done");
	}
	*/
}
