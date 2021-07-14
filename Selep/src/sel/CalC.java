package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;





public class CalC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.get("https://demoqa.com/select-menu");
		driver.get("https://www.calculator.net/mortgage-calculator.html");
		
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().to();
		//driver.manage().window().maximize();
		// driver.navigate().refresh();
		
		//Checkboxx & radio button 
		
		driver.findElement(By.xpath("//input[contains(@id,'caddoptional')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'caddoptional')]")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'caddoptional')]")).isEnabled());
		
		//dropdownw
		
		Select dropdown = new Select(driver.findElement(By.id("compound")));
		
		//select by visble text
		dropdown.selectByVisibleText("continue");
		
		//select by value
		dropdown.selectByValue("weekly");
		
		//select by index
		dropdown.selectByIndex(2);
		
		
		
		
		

	}

}
