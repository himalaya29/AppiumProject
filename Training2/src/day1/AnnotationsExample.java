package day1;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsExample {

	//public static void main(String[] args) {}
		
		@Test
		public void tc1() {
			System.out.println("TestCase1");
		}

		@Test(priority=1)
		public void tc2() {
			System.out.println("Test Case 2");
		}
		
		@Test(priority=0)
		public void tc3() {
			System.out.println("TestCase3");
		}
		
		@BeforeTest
		public void open() {
			System.out.println("Open");
		}
		
		@AfterTest
		public void close() {
		    System.out.println("close");
		}
		
		@AfterMethod
		public void closeBrowser() {
			
			System.out.println("close Browser");
		}
		
		@BeforeMethod
		public void openBrowser() {
			
			System.out.println("Open Browser");
		}
		
		
}


