package com.proquest.qa.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.proquest.qa.base.TestBase;

public class TestUtil extends TestBase{
	Date d = new Date();
	//returning the actual date
	String currentDate = d.toString().replaceAll(":", "_");
	
	public void writeToFile(List<WebElement> allResults, String browserName) throws IOException {
		FileWriter fr = new FileWriter(".//Results//"+browserName+"_Task1_"+currentDate+".txt");
		BufferedWriter br = new BufferedWriter(fr);
		
		//iterate the above list to get all the search titles & links from that page
		for(WebElement eachResult : allResults) {
			if(!eachResult.getText().isEmpty()) {
				System.out.println("Title : "+eachResult.getText());
				br.write(eachResult.getText());
				br.newLine();
			}
		}
		br.close();
	}
	public void screenshotWithDate(String browserName) throws IOException {
		//Typecasting the driver object to TakesScreenshot interface type.
		TakesScreenshot ts = (TakesScreenshot) driver;
		//getting the source file and storing in a file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		/*Created a folder called "Screenshot" under the folder "Results" in the project directory
		Created another file by concatenating the date value  which has "_" in it
		(Underscore is the accepted character while creating a file in the project )*/
		File destFile = new File(".//Results//"+browserName+"_Task2_"+currentDate+".png");
		//storing the screenshot in the destination location
		FileUtils.copyFile(srcFile, destFile);
	}
}
