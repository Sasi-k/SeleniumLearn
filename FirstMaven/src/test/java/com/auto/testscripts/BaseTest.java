package com.auto.testscripts;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;   
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.auto.utilities.CaptureScreen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;  
 
public class BaseTest {
	 
	public String baseUrl = "https://www.javatpoint.com/";  
	String driverPath = "C:\\Users\\Remote PC\\Downloads\\Drivers\\msedgedriver.exe";  
	public static WebDriver driver ;  
	private static String tcName;
	//public static String tcNames;
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;
	
	@BeforeTest
	public void verifyTest() {
	
		System.setProperty("webdriver.edge.driver", driverPath);   
		driver = new EdgeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		driver.get(baseUrl);   
		//String URL= driver.getCurrentUrl();  
		//System.out.print(URL);  
		//String title = driver.getTitle();                  
		//System.out.println(title); 
		extentReports=new ExtentReports("C:\\Users\\Remote PC\\OneDrive\\Desktop\\SeleniumTest\\Screens\\report.html");
	
	}  
		
	@BeforeMethod 
	public void beforeMethod(Method method) { 
		String tcName=method.getName();
	    System.out.println("Current test is : "+tcName);  
	    extentTest=extentReports.startTest(tcName);
	}    
	
	@AfterMethod
	public void afterMethod(ITestResult res) throws Exception {
		String tcName=res.getName();
		if(res.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS,"TC is Passed : "+tcName);
		   System.out.println("Passed test is : "+tcName);
		   //String imgPath=CaptureScreen.takeSnapshot(tcName);
		   //String imgPath=takeSnapshots(tcName);
		   //getExtentTest().addScreenCapture("C:\\Users\\Remote PC\\OneDrive\\Desktop\\SeleniumTest\\Screens\\hit.png");
		}
		else if (res.getStatus()==ITestResult.FAILURE) {
			
			   System.out.println("Failed test is : "+tcName);
			   String imgPath=CaptureScreen.takeSnapshot(tcName);
			   String pth=extentTest.addScreenCapture(imgPath);
			   extentTest.log(LogStatus.FAIL,"TC is Failed : "+pth);
		}
		extentReports.endTest(extentTest);
		
	}
	@AfterTest
	public void afterTest() {
		
		extentReports.flush();
		//extentReports.close();
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	//public static void setTcName(String tcName)
	//{
		//BaseTest.tcName = tcName;
	//}

	public static String getTcName() {
		return tcName;
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static String takeSnapshots(String ts) throws Exception {
		 TakesScreenshot takesScreenshot=(TakesScreenshot) BaseTest.getDriver();
	     File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);     		    
   	 String imgPath="C:\\Users\\Remote PC\\OneDrive\\Desktop\\SeleniumTest\\Screens\\"+ts+".png";
        FileHandler.copy(screenshot, new File(imgPath));
        return imgPath;
	 }
}
