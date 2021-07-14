package com.pageobject.data;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class AddToCart {
AppiumDriver driver;

      By add =By.xpath("//android.widget.TextView[contains(@text,'ADD TO CART')]");
      By skip =By.xpath("//android.widget.TextView[contains(@text,'SKIP & GO TO CART')]");
	
	public AddToCart(AppiumDriver driver)
	{
		this.driver=driver;
	}
	
	public void addingToCart() {
		driver.findElement(add).click();
	}
	
	public void skip_and_place() {
		driver.findElement(skip).click();
	}

}
