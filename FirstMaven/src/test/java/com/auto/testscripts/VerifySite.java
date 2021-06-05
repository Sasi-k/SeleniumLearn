package com.auto.testscripts;

//import org.testng.Assert;

/*import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;*/

import org.testng.annotations.Test;
import com.auto.pageobjects.JavatHome;
import com.relevantcodes.extentreports.LogStatus;

public class VerifySite extends BaseTest{
	
	@Test(priority=1)
	public void testsele() {
	  
	  JavatHome gh=new JavatHome(driver);
	  gh.verifysel();
	  getExtentTest().log(LogStatus.PASS, "Selenium text is visible");
	  gh.verifydisa();
	  getExtentTest().log(LogStatus.PASS, "Selenium text is disabled");
	  gh.verifytitle();
      getExtentTest().log(LogStatus.PASS, "Selenium text is title");
	  
	}
	@Test(priority=2)
	public void testjst() {
		
		JavatHome gh=new JavatHome(driver);
		gh.verifyjst();
		getExtentTest().log(LogStatus.PASS, "JavaScript text is visible");
	}
	@Test(priority=3)
	public void testdbms() {
	
		JavatHome gh=new JavatHome(driver);
		gh.verifydbm();
		getExtentTest().log(LogStatus.PASS, "DBMS text is visible");
	}
	
	 /*public void takesnap(String fname) {
	       
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileHandler.copy(screenshot, new File("C:\\Users\\Remote PC\\OneDrive\\Desktop\\SeleniumTest\\Screens\\"+fname+".png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }            
	 }*/
	 
	}
