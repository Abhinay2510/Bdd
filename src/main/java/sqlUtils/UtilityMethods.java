package sqlUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import driver.TestBase;
import excelutils.Excel_Reader;
import excelutils.Xls_Reader;


public class UtilityMethods extends TestBase

{
	static WebDriver driver;
	public static String rootpath = System.getProperty("user.dir");
	
	public static File outputFile; 
	public static String sourcePath; 
	public static String destPath; 
	
	public UtilityMethods(WebDriver driver)
	{
		this.driver = driver;
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
	
	
	
	public static void addNumberOfDaystoDateMMddyyyy(int NumberOfDays)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, NumberOfDays); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
	}
	
	public static String getDateDD()
	{
		  Format f = new SimpleDateFormat("dd");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);
	      return strDate;
	}
	
	public static void getDateMM()
	{
		  Format f = new SimpleDateFormat("MM");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);
	      
	}
	
	public static void getDateYYYY()
	{
		  Format f = new SimpleDateFormat("yyyy");
	      String strDate = f.format(new Date());
	      System.out.println("Current Date = "+strDate);
	      
	}
	
	// Write list of data into file
			public static void PBufferWriter(String FilePath, List<String> records) throws IOException
			{
				try
				{
					File FileName = new File (FilePath);	
					FileWriter fileWriter = new FileWriter(FileName, true);
					BufferedWriter buffer = new BufferedWriter(fileWriter);
					PrintWriter printWriter = new PrintWriter(buffer);
					if(FileName.exists() == false)
					{
						try
						{
							FileName.createNewFile();
							System.out.println("File has been created"); //Commented on 12Dec2019 - ConsolePrintNotNeeded	
						}
						catch(Exception e)
						{
							logger.info("Issue while writing/creating log file. due to "+e.getMessage());
							logger.error(e);
							e.printStackTrace(); //Added on 25Sept2019
						}
					}
					{
						//System.out.println("File Already exists.");
						for (String record: records) {
							printWriter.println(record);
						}
						printWriter.flush();
					}
					printWriter.close();
				}
				catch(FileNotFoundException e)
				{
					logger.info("Issue while writing log file. due to "+e.getMessage());
					logger.error(e);	
					e.printStackTrace(); //Added on 25Sept2019
				}
				catch(Exception e1)
				{
					logger.info("Issue while writing log file. due to "+e1.getMessage());
					logger.error(e1);
					e1.printStackTrace(); //Added on 25Sept2019
				}
			}
	
	
	public static void getFeaturesTobeExecutedAndBackup() throws IOException, InterruptedException
	{
		backupFeatures();
		clearFeaturesDirectory();
		getFeaturesToBeExecuted();

	}
	
	public static void backupFeatures() throws InterruptedException
	{
		String source = rootpath+"\\features";
		File srcDir = new File(source);
		String destination = rootpath+"\\featuresBkp";
		File destDir = new File(destination);
		try {
		    FileUtils.copyDirectory(srcDir, destDir);
		    System.out.println("Backup of the featurs done successfully");
		    Thread.sleep(2000);
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void clearFeaturesDirectory() throws IOException, InterruptedException
	{
		
		String directory = rootpath+"\\features";
		File srcDir = new File(directory);
		FileUtils.cleanDirectory(srcDir);
		 Thread.sleep(2000);
		 System.out.println("Clean up of the featurs done successfully");
	}
	
	public static void getFeaturesToBeExecuted() throws InterruptedException
	{
		//Xls_Reader datatable = null;
		//datatable = new Xls_Reader(rootpath+"\\ExcelData\\TestCases.xlsx", rootpath+"\\ExcelData\\TestData.xlsx" ); 
		
		ArrayList<String> fromExcelFlags = new ArrayList<String>();

		// This is to read from Excel file and generating list
		System.out.println("%%%%%%%%%Reading TestCase Data%%%%%%%%%%%");
		String excellocation = rootpath + "\\ExcelData\\TestCases.xlsx";
		String TestDataLoc = rootpath + "\\ExcelData\\TestData.xlsx";
		String sheetName = "TestCases";
		String dataSets[][];
		Xls_Reader xlsR = new Xls_Reader(excellocation, TestDataLoc);
		int colCount = xlsR.getColumnCount(sheetName);
		int rowCount = xlsR.getRowCount(sheetName);
		System.out.println("colCount " + colCount);
		System.out.println("rowCount " + rowCount);
		Excel_Reader obj_Exc_Read = new Excel_Reader();
		dataSets = obj_Exc_Read.getExcelData(excellocation, sheetName);
		for (int i = 0; i < rowCount - 1; i++) {
			fromExcelFlags.add(dataSets[i][0] + "#" + dataSets[i][5]);
		}
		System.out.println("=====================TestCase Data from EXCEL with Flag==========");
		System.out.println(fromExcelFlags);
		
		File folder = new File(rootpath +"\\featuresAll");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
			    System.out.println("File " + listOfFiles[i].getName());
			    System.out.println("==========================");
			    System.out.println(fromExcelFlags.contains(listOfFiles[i].getName()+"#Yes"));
			    System.out.println("==========================");
			    if(fromExcelFlags.contains(listOfFiles[i].getName()+"#Yes"))
			    {
			    	// Using Apache Commons FileUtils class
					File srcFile = new File(rootpath+"\\featuresAll\\"+listOfFiles[i].getName());
					File destFile = new File(rootpath+"\\features\\"+listOfFiles[i].getName());
					try 
					{
						FileUtils.copyFile(srcFile, destFile);
						 Thread.sleep(1000);
						System.out.println("Feature successfully copied in feature folder");
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
			    }
			    else
			    {
			    	continue;
			    }
			  } else if (listOfFiles[i].isDirectory()) {
			    System.out.println("Directory Will not be copied" + listOfFiles[i].getName());
			  }
		}
	}
	
	
	public static String getOnlyNumbersFromString(String ApplicationID)
	{
		String numberOnly= ApplicationID.replaceAll("[^0-9]", "");
    	System.out.println(numberOnly);
		return numberOnly;
	}
	
	public static String getNumbersWithDecimalFromString(String numberTobegetAsDecimal)
	{
		String numberOnly= numberTobegetAsDecimal.replaceAll("[^0-9?!\\.]","");
    	System.out.println(numberOnly);
		return numberOnly;
	}
	
	public static String getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public static String getDateAndTime_dd_MM_yyyy_HHmmss() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public static String getDate_ddMMyyyy() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		 getFeaturesTobeExecutedAndBackup();		
	}
	
	
	public static void createReportFolderStructure() {
		outputFile = new File(rootPath + "\\logger\\" +getDate_ddMMyyyy()); 
																									
		if (!outputFile.exists()) {
			outputFile.mkdirs();
			System.out.println("Report folder structure created : " + outputFile);
			logger.info("Report folder structure created : " + outputFile);
		} else {
			System.out.println("Report folder structure already available : " + outputFile);
			logger.info("Report folder structure already available : " + outputFile);
		}
	}

	public static void copyExcelReportToSharedLocation() {
		sourcePath = rootpath + "\\target\\cucumber-report";
		//destPath = rootPath + "\\reports\\cucumber-report_"+ UtilityMethods.getDateAndTime_dd_MM_yyyy_HHmmss_TimeWithHyphan();
		destPath = rootPath + "\\reports";
		System.out.println("Move directory from " + sourcePath + " to " + destPath);
		logger.info("Move directory from " + sourcePath + " to " + destPath);
		File source = new File(sourcePath);
		File dest = new File(destPath);

		try {
			//FileUtils.copyFileToDirectory(source, dest);
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void killBrowserInstances(String browserType)
	{
		try 
		{
			System.out.println("Closing all the opened instance of : "+browserType);
			Runtime.getRuntime().exec("taskkill /F /IM "+browserType+".exe");
			System.out.println("Closing of "+browserType+" instances is done..!!");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}