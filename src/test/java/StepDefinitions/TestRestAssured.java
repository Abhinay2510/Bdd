package StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import driver.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.UtilityMethods;


public class TestRestAssured {
	public static String BASE_URL = TestBase.getPropertyValue("BASE_URL");
	public static String BASE_URL_LoanBook = TestBase.getPropertyValue("BASE_URL_LoanBook");
	public static String BASE_URL_ReFi = TestBase.getPropertyValue("BASE_URL_ReFi");
	public static String BASE_URL_ExpiredLoan = TestBase.getPropertyValue("BASE_URL_ExpiredLoan");
	
	public static final Logger logger = Logger.getLogger(TestRestAssured.class.getName());
	
	public static String token;
	public static Response response;
	public static String jsonString;
	
	public static void toGetPostRequestResponseToken() throws IOException {
		RestAssured.baseURI = BASE_URL;
		logger.info("RestAssured.baseURI");
		
     	//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body("{\r\n"
				+ "    \"user_id\" : \"AspenBatch\" ,\r\n"
				+ "    \"user_pass\" : \"Y@cE[(Cu\"\r\n"
				+ "}")
				.post("/Authenticate");
		String jsonString = response.asString();
		System.out.println("DONE");
		System.out.println(jsonString);
		System.out.println("DONE");
		token = JsonPath.from(jsonString).get("JwtToken");
		System.out.println("TOKEN");
		System.out.println(token);
		System.out.println("TOKEN");
		
	}
	public static void toExecuteCronJobForLanBook() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_LoanBook;
		
		System.out.println(RestAssured.baseURI);
		
	     	//Added on 28-May-2022 Start
			TestBase.logLoanDetails.add("###################################################");
			TestBase.logLoanDetails.add(RestAssured.baseURI);
			TestBase.logLoanDetails.add("###################################################");
			//Added on 28-May-2022 End

			//Added on 28-May-2022 Start
			UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
			TestBase.logLoanDetails.clear();
			//Added on 28-May-2022 End
		
			logger.info("RestAssured.baseURI");		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE LoanBook");
		System.out.println(jsonString);
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		
		System.out.println("DONE LoanBook");
	}
	
	public static void toExecuteCronJobForReFi() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_ReFi;
		System.out.println(RestAssured.baseURI);
		
     	//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End

		logger.info("RestAssured.baseURI");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE Refi");
		System.out.println(jsonString);
		
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		System.out.println("DONE Refi");
	}

	
	public static void toExecuteCronJobForExpiredLoan() throws IOException 
	{
		RestAssured.baseURI = BASE_URL_ExpiredLoan;
		System.out.println(RestAssured.baseURI);
    	
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(RestAssured.baseURI);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		
		logger.info("RestAssured.baseURI");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization",token);
		response = request.post(baseURI);
		String jsonString = response.asString();
		System.out.println("DONE Expired");
		System.out.println(jsonString);
		//Added on 28-May-2022 Start
		TestBase.logLoanDetails.add("###################################################");
		TestBase.logLoanDetails.add(jsonString);
		TestBase.logLoanDetails.add("###################################################");
		//Added on 28-May-2022 End

		//Added on 28-May-2022 Start
		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
		TestBase.logLoanDetails.clear();
		//Added on 28-May-2022 End
		System.out.println("DONE Expired");
	}
	
	public static void main(String[] args) throws IOException {
		
		
		toGetPostRequestResponseToken();
		//toExecuteCronJobForLanBook();
		toExecuteCronJobForReFi();
	}
	}
