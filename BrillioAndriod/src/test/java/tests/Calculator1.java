package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Calculator1 {

	
	
			
			AppiumDriver<MobileElement> driver;
			
			@BeforeClass
			public void setup() throws MalformedURLException {
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", "SM M115F");
				capabilities.setCapability("udid", "R9ZN611AAQL");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "11");
				capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator/com.sec.android.app.popupcalculator"); 
				capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator/com.sec.android.app.popupcalculator.Calculator");
				capabilities.setCapability("noReset", "true");
				
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver<MobileElement>(url,capabilities);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
			
			@Test
			public void testCalculator() {
				System.out.println("Launched the Calculator Application");
				driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")).click();
				driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_addd")).click();
				driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
				driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();
			}
}
			


		
			
			
	 
			
			
			

	
