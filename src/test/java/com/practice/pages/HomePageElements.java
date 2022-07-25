package com.practice.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.CommonMethods;

public class HomePageElements extends CommonMethods {
	WebDriver driver;

	public HomePageElements(WebDriver driver) {
		this.driver = driver;

	}
	By txtUsername = By.id("txtUsername");
	
	
	public void validateTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals("Not matching", expectedTitle,actualTitle);
	}

}
