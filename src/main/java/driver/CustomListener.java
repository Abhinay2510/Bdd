package driver;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import utils.UtilityMethods;

public class CustomListener extends RunListener
{
	public static final Logger logger = Logger.getLogger(CustomListener.class.getName());
	public static long startTime;
	public static long endTime;
	
	@Override
    public void testRunStarted(Description description) {
        startTime = new Date().getTime();
        
                
        logger.info("Tests started! Number of Test case: "+description.testCount()+ "\n");
        logger.info("Tests Run started! : "+description.testCount());
    }
    @Override
    public void testRunFinished(Result result) throws Exception 
    {
     	if(result.wasSuccessful())
    	{
    		endTime = new Date().getTime();
            logger.info("Tests finished! Number of test Steps: "+result.getRunCount());
            
            //Added on 28-May-2022 Start
    		TestBase.logLoanDetails.add("Tests finished! Number of test Steps: "+result.getRunCount());
    		//Added on 28-May-2022 End

    		//Added on 28-May-2022 Start
    		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
    		TestBase.logLoanDetails.clear();
    		//Added on 28-May-2022 End
            
            //long elapsedSeconds = (endTime - startTime) / 1000;
            //logger.info("Elapsed time of tests execution: "+elapsedSeconds +" seconds");
    	}
    	else
    	{
    		endTime = new Date().getTime();
            logger.info("Tests finished! Number of test Steps : "+result.getRunCount());
            
          //Added on 28-May-2022 Start
    		TestBase.logLoanDetails.add("Tests finished! Number of test Steps : "+result.getRunCount());
    		//Added on 28-May-2022 End

    		//Added on 28-May-2022 Start
    		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
    		TestBase.logLoanDetails.clear();
    		//Added on 28-May-2022 End
            
            
            long elapsedSeconds = (endTime - startTime) / 1000;
            //logger.info("Elapsed time of tests execution: "+elapsedSeconds +" seconds");
    	}
    }
    @Override
    public void testStarted(Description description) throws IOException 
    {
        
    	if(!(description.getMethodName() == null))
    	{
    		logger.info("Test Started : "+description.getMethodName());
    		//Added on 28-May-2022 Start
    		TestBase.logLoanDetails.add("Test Started : "+description.getMethodName());
    		//Added on 28-May-2022 End

    		//Added on 28-May-2022 Start
    		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
    		TestBase.logLoanDetails.clear();
    		//Added on 28-May-2022 End
    	}
    }
    @Override
    public void testFinished(Description description) throws IOException 
    {
    	if(!(description.getMethodName() == null))
    	{
    		logger.info("Test Finished : "+description.getMethodName());
    		//Added on 28-May-2022 Start
    		TestBase.logLoanDetails.add("Test Finished : "+description.getMethodName());
    		//Added on 28-May-2022 End

    		//Added on 28-May-2022 Start
    		UtilityMethods.PBufferWriter(TestBase.logLoanDetailsPath, TestBase.logLoanDetails);;
    		TestBase.logLoanDetails.clear();
    		//Added on 28-May-2022 End
    		
      }
    }
    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void testFailure(Failure failure) 
    {
        if(failure.equals(true))
        {
        	logger.error(failure.getDescription().getMethodName()+" test FAILED!!!");	
        }
    }
    @Override
    public void testIgnored(Description description) throws Exception {
        super.testIgnored(description);
        Ignore ignore = description.getAnnotation(Ignore.class);
        String ignoreMessage = String.format(
            "@Ignore test method '%s()': '%s'",
            description.getMethodName(), ignore.value());
        logger.info(ignoreMessage + "\\n");
    }
}
