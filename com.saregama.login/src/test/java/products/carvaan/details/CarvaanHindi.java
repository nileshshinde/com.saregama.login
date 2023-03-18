package products.carvaan.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class CarvaanHindi {
	
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-extensions");
		chromeoptions.addArguments("--headless");
		chromeoptions.addArguments("--disable-gpu");
		chromeoptions.addArguments("--no-sandbox");
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().browserVersion("111.0.5563.65").setup();
		
		driver = new ChromeDriver(chromeoptions);
		
		driver.get("https://www.saregama.com/carvaan/hindi/buy-now");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
