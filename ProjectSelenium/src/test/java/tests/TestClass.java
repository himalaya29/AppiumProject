package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AccountDetails;
import pageObject.AccountHistory;
import pageObject.LandingPage;
import pageObject.LoginPage;




public class TestClass{

	
WebDriver driver;



@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Software\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Software\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(br.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Software\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://demo.testfire.net");
}


	@Test(dataProvider="inputdata",priority=1)
	public void enter_UserDetails(String userName, String password) throws Exception {
		
		LandingPage l = new LandingPage(driver);
		l.getLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail(userName);
		lp.getPassword(password);
		lp.clickLogin();
		
		
		AccountDetails a = new AccountDetails(driver);
		a.accountDetails();
		a.go();
		
		AccountHistory ah = new AccountHistory(driver);
		ah.availableBalance();
		ah.electricBill();
		ah.user_logout();
		
		}
	

	@DataProvider(name="inputdata")
	public Object [][] getCellData() throws IOException {
		
		// locate excel file
		FileInputStream file = new FileInputStream("./sampledoc.xlsx");
		//create workbook instance
		XSSFWorkbook wb=new XSSFWorkbook(file);
		//go to desired sheet
		XSSFSheet s=wb.getSheet("sheet1");
		int rowcount = s.getLastRowNum()+1;
		int cellcount=s.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rowcount][cellcount];
		
		for(int i=0;i<rowcount;i++) {
			Row r = s.getRow(i);
			 
		    for(int j=0;j<cellcount;j++) {
		    	Cell c=r.getCell(j);
		    	data[i][j]=c.getStringCellValue();
		    }
		}
		wb.close();
		return data;
	}

	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
