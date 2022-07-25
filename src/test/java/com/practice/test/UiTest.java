package com.practice.test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.practice.pages.HomePageElements;
import com.practice.testbase.BaseClass;
import com.practice.utils.ConfigsReader;

public class UiTest {

	WebDriver driver = BaseClass.setUp();
	HomePageElements h = new HomePageElements(driver);

	@Test
	public void navigateToWebsite() throws Exception {
		h.validateTitle("My Store");

		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();

		driver.findElement(By.id("category")).click();

		// Element was hidden that why I used JavascriptExecutor
		By css = By.cssSelector("a[href='http://automationpractice.com/index.php?id_category=11&controller=category']");
		WebElement element = driver.findElement(css);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		System.out.println("passed0");
		// For make element visible I used hover over
		WebElement pic1 = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", pic1);
		Actions a = new Actions(driver);
		a.moveToElement(pic1).build().perform();

		// Again JavascriptExecutor
		WebElement element2 = driver.findElement(By.xpath("(//*[text()='Add to cart'])[2]"));
		element2.click();
		System.out.println("passed1");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		driver.findElement(By.id("email")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("passwd")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		Thread.sleep(4000);
		System.out.println("Order on the way!");

	}

	@After
	public void td() throws Exception {

		BaseClass.tearDown();
	}

}
