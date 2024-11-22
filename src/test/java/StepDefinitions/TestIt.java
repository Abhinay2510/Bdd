package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import sqlUtils.MsSqlUtility;
import cucumber.runtime.Runtime;

public class TestIt {

    public String[] tagsToExecute = {"@SmokeUtilizationData, @SmokeSummaryData, @SmokeCompliance, @FunctionalEndToEnd"};
    
    //public String[] featureToExecute = {"D:/MoneyMart/WS/MavenwithCucumber/Feature/VRLogin2Test.feature", "D:/MoneyMart/WS/MavenwithCucumber/Feature/VRLoginTest.feature"};
    public String[] featureToExecute = {"D:/MoneyMart/WS/MavenwithCucumber1/features/VRLogin2Test.feature"};
    
    public String html = "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html";
    
    public String jsond = "json:target/cucumber-reports/Cucumber.json";
    
    public String junit = "junit:target/cukes/junit.xml";
    
    
    public String pretty = "pretty";
    
    
    /*
    plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"junit:target/cukes/junit.xml" }, monochrome = true)
     */
    
    public String gluePackage = "centz.StepDefinitions";
    public String[] argv = null;
    
    public void defaultRun() {
        List<String> arguments = new ArrayList<String>();
        //arguments.add("D:/MoneyMart/WS/MavenwithCucumber/Feature/");
        
        String[] features = featureToExecute;
        for (String feature : features) {
            arguments.add(feature);
        }
        
        
        String[] tags = tagsToExecute;
        for (String tag : tags) {
            arguments.add("--tags");
            arguments.add(tag);
        }
        arguments.add("--plugin");
        arguments.add(pretty);
        arguments.add("--plugin");
        arguments.add(html);
        arguments.add("--plugin");
        arguments.add(jsond);
        arguments.add("--plugin");
        arguments.add(junit);
        arguments.add("--glue");
        arguments.add(gluePackage);
        argv = arguments.toArray(new String[arguments.size()]);
        
        System.out.println(arguments);
        System.out.println(argv);
        
        
        try {
            executeTests(argv);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }


    public byte executeTests(final String[] argv) throws InterruptedException, IOException {
        RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList(Arrays.asList(argv)));
        MultiLoader resourceLoader = new MultiLoader(this.getClass().getClassLoader());
        ResourceLoaderClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, this.getClass().getClassLoader());
        Runtime runtime = new Runtime(resourceLoader, classFinder, this.getClass().getClassLoader(), runtimeOptions);
        runtime.run();
        System.out.println(runtime.exitStatus());
        return runtime.exitStatus();
    }

    public static void main(String[] args) {
        
    	/*
    	System.out.println("Testing MyRunnerTest");
        TestIt myRun = new TestIt();
        myRun.defaultRun();
        */
    	
    	/*
    	String str="154412 (Add Note)";
    	String numberOnly= str.replaceAll("[^0-9]", "");
    	System.out.println(numberOnly);
    	*/
    	String str1="$(123.23)";
    	//str1.replaceAll("[^0-9?!\\.]","");
    	
    	System.out.println(str1.replaceAll("[^0-9?!\\.]",""));
    	
    	
    	
    }
}