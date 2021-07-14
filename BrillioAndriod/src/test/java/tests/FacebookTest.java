package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FacebookTest {

	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM M115F");
		capabilities.setCapability("udid", "R9ZN611AAQL");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("browserName", "chrome"); 
		capabilities.setCapability("noReset", "true");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void testFb() throws InterruptedException {
		driver.get("https://m.facebook.com/");
		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("abc@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(3000);
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
