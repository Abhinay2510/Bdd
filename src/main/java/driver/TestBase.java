package driver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import driver.TestBase;

import cucumber.api.Scenario;
import excelutils.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import utils.UtilityMethods;

public class TestBase

{
	
	public static String generatedCustomerName;
	public static String generatedaccountnumber;
	public static String rootPath = System.getProperty("user.dir");
	public static String generatedEmail; //Added on 11-MAy-2022 from page_01
	public static String FinalgeneratedFirstName;
	public static String applicationID;// = "154415";
	//public static String applicationID = "155475";
	public static String generatedPhoneNum;
	public static Scenario  currentGlobalScenarioName;   //Added 23 july 2022
	public static String testCaseName, testDataSetName; //Added on 28-May-2022
	public static List<String> logLoanDetails = new ArrayList<String>(); //Added on 28-May-2022
	public static String logLoanDetailsPath; //Added on 28-May-2022
	
	public static String OTPfromYopMailForEmailID;
	public static String parent;
	
	public static String runningDriver;
	
	public static String env;
	
	public static int myCapture = 0;
	public static String[] str = new String[10000];

	public static String imageLocation;
	
	public static WebDriver driver;
	public static TreeMap<String, String> getMapData;
	public static Xls_Reader datatable = null;
	public static Properties OR;
	public static Properties OR1; 
	public static File f1;
	public static File f2;
	public static FileInputStream file; 
	public static FileInputStream file1; 
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static int getTestScriptRowNum, getTestScriptRowNumstatic, rowcount; 
	public static String Feature_Name, Feature_Id, Feature_Description, Scenario_Id, Scenario_Description;
	public static boolean webDriverIntialized = false;
	public static String browser;
	
	static 
	{
	    System.out.println("INITI...");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	   datatable = new Xls_Reader(rootPath+"\\ExcelData\\TestCases.xlsx", rootPath+"\\ExcelData\\TestData.xlsx" ); 
			    TestBase.loadProperiesFile();
	    logger.info("Static Initialization done");
	    datatable.removeSheet(getPropertyValue("xlsReportsSheetname"));
		System.out.println("Removed Sheet");
		logger.info("Removed Sheet");
		datatable.addSheet(getPropertyValue("xlsReportsSheetname"));
		System.out.println("Added Sheet");
		logger.info("Added Sheet");
		datatable.setHeader(getPropertyValue("xlsReportsSheetname"));
		System.out.println("Created Sheet");
		logger.info("Created Sheet");
		
		UtilityMethods.createReportFolderStructure();
		
		//Added on 28-May-2022 Start
		//logLoanDetailsPath = rootPath+"\\logger\\LoanDetails"+UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan();
		//Added on 28-May-2022 End
		
		/*
		try {
			UtilityMethods.getFeaturesTobeExecutedAndBackup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	@SuppressWarnings("deprecation")
	public static void setupSelenium() throws Exception
	{
		
		//System.setProperty("webdriver.chrome.driver",rootPath+"\\Driver\\chromedriver.exe");
			ChromeOptions chromeOptions =new ChromeOptions();
			//chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
		System.out.println("Sysout");
		//driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriverIntialized = true;
		browser = "Chrome";
	}
	
	
	//To load all the values into object memory from property file
		public static void loadProperiesFile()
		{
			// General configuration
			OR = new Properties();
			f1 = new File(rootPath+"/Config/Config.properties");
			try {
				file = new FileInputStream(f1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				OR.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Log4j configuration
			f1 = new File(rootPath+"/Config/log4j.properties");
			try {
				file = new FileInputStream(f1);

				PropertyConfigurator.configure(file);

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				OR.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

			//PPAdded on 03-APR-2019 Start
			// Runner configuration
			OR1 = new Properties();
			f2 = new File(rootPath+"/Config/Runner.properties");
			try {
				file1 = new FileInputStream(f2);

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				OR1.load(file1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//PPAdded on 03-APR-2019 End
		}
	
		// To retrieve property value based on input
		public static String getPropertyValue(String value)
		{
			String catchValue = null;
			try
			{
				catchValue = OR.getProperty(value);
			}
			catch(Exception e)
			{
				logger.error("Exception when reading property value : "+e.getMessage());
				//test.log(Status.ERROR, "Exception when reading property value : "+e.getMessage()); //Commented on 23-APR-2019 AfterDemo
				Assert.fail("Exception when reading property value : "+e.getMessage());
			}
			return catchValue;		
		}
		
	public static void loadExcelData(String testCaseName, String testDataSetName) throws Exception
	{
		getMapData = new TreeMap<String, String>();
		getMapData  = Xls_Reader.getCellDataBasedOnRowValuefromTestData(testCaseName, testDataSetName);
		logger.info("Scenario data initialized.");
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}

	
	public static void bindreport(Scenario scenario, String screenshotName) throws IOException, InterruptedException
	{
//		byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
//	    scenario.embed(screenshot, "image/png");
//	    takeScreenshotimage(getDriver(), screenshotName);
//		Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenshotName+".png");
		
		if(TestBase.getPropertyValue("IsStepLevelScreenshotNeeded").equalsIgnoreCase("yes") || scenario.isFailed()) {
			TestBase.logger.info("Taking screenshot for every step in the scearnario");
		byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
	    takeScreenshotimage(getDriver(), screenshotName);
	   // Reporter.addScreenCaptureFromPath(screenshotName, screenshotName)
		Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenshotName+".png");
		}else if(TestBase.getPropertyValue("IsStepLevelScreenshotNeeded").equalsIgnoreCase("No") ) {
			TestBase.logger.info("Proceed without screenshots for every step in the scenario");
		}
		
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		    scenario.embed(screenshot, "image/png");
		    takeScreenshotimage(getDriver(), screenshotName);
		   // Reporter.addScreenCaptureFromPath(screenshotName, screenshotName)
			Reporter.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\screenshots\\"+screenshotName+".png");
		}
	}
	
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
	
	public static String getRunnerPropertyValue(String value)
	{
		String catchValue = null;
		try
		{
			catchValue = OR1.getProperty(value);

		}
		catch(Exception e)
		{
			logger.error("Exception when reading property value : "+e.getMessage());
			//test.log(Status.ERROR, "Exception when reading property value : "+e.getMessage()); //Commented on 23-APR-2019 AfterDemo
			Assert.fail("Exception when reading property value : "+e.getMessage());
		}
		return catchValue;		
	}
	//PPAdded on 03-APR-2019 Start
	
	
	public static String getScreenshot(String screenShotName)
	{
		// Updated on 27-MAY-2019 for sync web and desktop START
		if(runningDriver == "Web") // Added on 27-MAY-2019
		{
			if(screenShotName.equalsIgnoreCase(""))
			{
				screenShotName = "blank";
			}
			File image = ((TakesScreenshot)TestBase.getDriver()).getScreenshotAs(OutputType.FILE);
			//String imageLocation = rootPath+"/Screenshots/"+getRunnerPropertyValue("releaseVersion")+"_Run"+getRunnerPropertyValue("runcount")+"_"+UtilityMethods.getDate_ddMMyyyy()+"/"; //PPUpdated on 03-APR-2019 Commented on 24-JUNE-2018 4DOC
			imageLocation = rootPath+"/Screenshots/"+getRunnerPropertyValue("releaseVersion")+"_Run"+getRunnerPropertyValue("runcount")+"_"+UtilityMethods.getDate_ddMMyyyy()+"/"+testCaseName+"_"+getEnvironment()+"/"; //Added on 24-JUNE-2018 4DOC


			System.out.println("imageLocation : "+imageLocation);
			String actualImageName = imageLocation+screenShotName+UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan()+".png";
			System.out.println("actualImageName : "+actualImageName);
			File destFile = new File(actualImageName);
			try {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileUtils.copyFile(image, destFile);

			} catch (IOException e) {
				e.printStackTrace();
			}

			str[myCapture] = actualImageName; //Added on 24-JUNE-2019 4DOC
			myCapture = myCapture + 1; //Added on 24-JUNE-2019 4DOC

			return actualImageName;
		}
		else // Added on 27-MAY-2019
		{
			if(screenShotName.equalsIgnoreCase(""))
			{
				screenShotName = "blank";
			}
			File image = ((TakesScreenshot)TestBase.getDriver()).getScreenshotAs(OutputType.FILE); // Updated on 27-MAY-2019
			String imageLocation = rootPath+"/Screenshots/"+getRunnerPropertyValue("releaseVersion")+"_Run"+getRunnerPropertyValue("runcount")+"_"+UtilityMethods.getDate_ddMMyyyy()+"/"; //PPUpdated on 03-APR-2019
			System.out.println("imageLocation : "+imageLocation);
			String actualImageName = imageLocation+screenShotName+UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan()+".png";
			System.out.println("actualImageName : "+actualImageName);
			File destFile = new File(actualImageName);
			try {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileUtils.copyFile(image, destFile);

			} catch (IOException e) {
				e.printStackTrace();
			}

			//str[myCapture] = actualImageName; //Added and commented on 24-JUNE-2019 4DOC
			//myCapture = myCapture + 1; //Added and commented on 24-JUNE-2019 4DOC

			return actualImageName;
		}
		// Updated on 27-MAY-2019 for sync web and desktop END


	}


	//AddedPP on 03-APR-2019 Start
	public static void setProperyValue(String sProperty, String sValue) throws IOException
	{
		logger.info("===========setProperyValue Start=================");
		logger.info("sProperty : "+sProperty);
		logger.info("sValue : "+sValue);
		//f2 = new File(rootPath+"/Config/Runner.properties"); 
		OR1.setProperty(sProperty, sValue);
		FileOutputStream fileOut = new FileOutputStream(f2); 
		OR1.store(fileOut, "Updating "+sProperty+" Property with value "+sValue);
		logger.info("Updating "+sProperty+" Property with value "+sValue);
		fileOut.close();
		logger.info("===========setProperyValue End=================");
	}
	
	
	
	public static int getTestCasePositionBasedOnScriptName(String SheetName, String TestScriptName)
	{
		logger.info("===getTestCasePositionBasedOnScriptName Started====");	
		int TestScriptPresentInt = 0; 
		for(int r=1; r < datatable.getRowCount(SheetName)+1;r++)
		{
			for(int c=0; c< datatable.getColumnCount(SheetName);c++)
			{
				//System.out.println("Values of datatable: "+datatable.getCellData(SheetName, c, r)); Commented on 04Sept2020JIOGIT

				if(datatable.getCellData(SheetName, c, r).equalsIgnoreCase(TestScriptName))
				{
					logger.info(datatable.getCellData(SheetName, c, r)+" Test Case is present to execute.");
					TestScriptPresentInt = r;
					break;
				}
				else
				{
					//logger.info(datatable.getCellData("TestCases", c, r)+" Test Case is NOT present to execute.");
					continue;
				}
			}
		}
		return TestScriptPresentInt;
	}
	
	public static String getGeneratedEmailId() 
	{
		return generatedEmail;
		
	}
	public static String getCurrentLoanApplicationId() 
	{
		return applicationID;
		
	}
	
	public static String FinalgeneratedFirstName() 
	{
		return FinalgeneratedFirstName;
		
	}
	
	public static String getGeneratedPhoneNumber() 
	{
		return generatedPhoneNum;
		
	}
	public static String getEnvironment() 
	{
		return env;
	}
	
}
