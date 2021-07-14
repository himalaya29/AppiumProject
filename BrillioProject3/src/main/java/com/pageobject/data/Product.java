package com.pageobject.data;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;

public class Product {
AppiumDriver driver;

    By prod =By.xpath("//android.widget.TextView[@text='Search for Products, Brands and More']");
    By prods =By.xpath("(//*[@resource-id=\"com.flipkart.android:id/txt_title\"])[1]");
    By prodf =By.xpath("(//android.view.ViewGroup)[1]");
	
	public Product(AppiumDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void product() {
		driver.findElement(prod).click();
		Actions action = new Actions(driver);
		action.sendKeys("iphone mobiles").perform();
		}
	
	
	public void product_select() {
		
		driver.findElement(prods).click();
		}
	
	
	
	public void product_select_finalize(){
		
		driver.findElement(prodf).click();
		}
	

}
