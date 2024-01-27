package com.snl.basicproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_LoginTest {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://Google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}
	@Test(groups="sanity")
	public void verifyTitle()
	{
		String actualtitle=driver.getTitle();
        String expecttitle="Google";
        Assert.assertEquals(actualtitle,  expecttitle);
	}
	@Test(groups="sanity")
	public void verifylogoimg()
	{
	  boolean b= driver.findElement(By.xpath("//img[@class=\"lnXdpd\"]")).isDisplayed();
	  Assert.assertTrue(b);
		
	}
	@Test(groups="sanity")
	public void verifygmaiLink()
	{
		boolean b=driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isEnabled();
		Assert.assertTrue(b);
		System.out.println("Gmail Link is enabled");
	}
	@Test(groups="retesting")
	public void TotalLink()
	{
		List<WebElement>elements=driver.findElements(By.linkText("a"));
		for(WebElement ele:elements)
		{
			System.out.println(ele);
		}
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
