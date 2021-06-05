package com.auto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class JavatHome {

	 WebDriver driver;
	 public JavatHome(WebDriver driver)
	 {
		 this.driver=driver;
		// PageFactory.initElements(driver, this); 
	 }
	 By setl=By.xpath("//a[text()='Selenium']");
	 By jst=By.xpath("//a[text()='JavaScript']");
	 By dbm=By.xpath("//a[text()='DBMS']");
	 public void verifysel()
	 {	  
		 SoftAssert sa=new SoftAssert();
		 sa.assertFalse(driver.findElement(setl).isDisplayed());
		 
		 //driver.findElement(setl).isDisplayed();
		 //Assert.assertFalse(driver.findElement(setl).isDisplayed());
		// getExtentTest().log(LogStatus.PASS, "Selenium text is visible");
	 }
	 public void verifydisa()
	 {	  
		 SoftAssert sa=new SoftAssert();
		 sa.assertTrue(driver.findElement(setl).isEnabled());
		 //driver.findElement(setl).isEnabled();
	
	 }
	 public void verifytitle()
	 {	  		 
		 Assert.assertTrue(driver.getTitle().contains("sudhakar"));	 
	 }
	 
	 public void verifyjst()
	 {
		  
		 if(driver.findElement(jst).isDisplayed())
			 System.out.println("JavaScript is available");
		 else
			 System.out.println("JavaScript is not available");
	 }
	 
	 public void verifydbm()
	 {
		  
		 if(driver.findElement(dbm).isDisplayed())
			 System.out.println("DBMS is available");
		 else
			 System.out.println("DBMS is not available");
	 }
	 
}
