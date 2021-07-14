package sel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Pstore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		//driver.get("https://demoqa.com/select-menu");
		driver.get("https://petstore.octoperf.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver.findElement(By.xpath("//a[contains(text(),'Enter the Store')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.name("username")).sendKeys("j2ee");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("j2ee");
		driver.findElement(By.name("signon")).click();
		driver.close();
		
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
		
		//Checkbox
		
		
		
		
		
		

	}

}
