package com.testClass.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pageobject.data.AddToCart;
import com.pageobject.data.Product;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class FlipkartSearch {
	
AppiumDriver<MobileElement> driver;

	
	@BeforeClass
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM M115F");
		capabilities.setCapability("udid", "R9ZN611AAQL");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("appPackage", "com.flipkart.android"); 
		capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		capabilities.setCapability("noReset", "true");
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void product() throws InterruptedException {
		Product p = new Product(driver);
		
		
		p.product();
		
		p.product_select();
	
		
		p.product_select_finalize();
		
	}
	
	@Test(priority=2)
	public void cart() {
		AddToCart p = new AddToCart(driver);
		p.addingToCart();
		p.skip_and_place();
		
		//ExtentReport
		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports\\report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("FlipkartTest");
		logger.log(Status.INFO, "Launched the Flipkart Application");
		logger.log(Status.PASS, "Product added to cart");
		extent.flush();
		
	} 
	
    @AfterClass
	public void aftertest(){
		driver.quit();
	}
	
}
