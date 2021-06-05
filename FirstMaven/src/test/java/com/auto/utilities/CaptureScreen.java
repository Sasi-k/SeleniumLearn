package com.auto.utilities;

import java.io.File;
//import java.io.IOException;
//import java.io.Exception;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.auto.testscripts.BaseTest;

//import java.io.File;

//import org.openqa.selenium.TakesScreenshot;

public class CaptureScreen {
	
	 public static String takeSnapshot(String ts) throws Exception {
		 TakesScreenshot takesScreenshot=(TakesScreenshot) BaseTest.getDriver();
	     File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);     		    
    	 String imgPath="C:\\Users\\Remote PC\\OneDrive\\Desktop\\SeleniumTest\\Screens\\"+ts+".png";
         FileHandler.copy(screenshot, new File(imgPath));
         return imgPath;
	 }
}
