package products.carvaan.details;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class CarvaanHindi {

	private WebDriver driver;

	private String color;

	@Test
	public void TestProductIDForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = "53";
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = "https://s.saregama.com/image/s/fh_120/2/6e/c8/carvaanframe_10_1672652416.png";
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = "https://s.saregama.com/image/s/fh_1000/2/6e/c8/carvaanframe_10_1672652416.png";
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String notifyButtonId = actualProductId + "Notify";
		boolean actualNotifyButtonPresent = false;
		try {
			WebElement notifyButtonContainer = colorSelectorContainer
					.findElement(By.xpath("//button[@id=\"" + notifyButtonId + "\"]"));
			actualNotifyButtonPresent = true;
		} catch (Exception ex) {
			actualNotifyButtonPresent = false;
		}
		boolean expectedNotifyButtonPresent = false;
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		anchorContainer.click();
		String actualTitle = "";
		try {
			actualTitle = driver
					.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/div/h1")).getText();
		} catch (Exception ex) {
			actualTitle = "";
		}

		String expectedTitle = "Carvaan Hindi - Porcelain White";
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		anchorContainer.click();
		String actualMrp = "";
		boolean offerpriceavailable=false;
		
		try
		{
			WebElement offerPriceSpanNode = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]"));
			offerpriceavailable = true;
		}
		catch(Exception ex)
		{
			offerpriceavailable = false;
		}
		
		if (offerpriceavailable)
		{
			actualMrp =  driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]/strike")).getText();
			actualMrp = actualMrp.replace("&nbsp;", "").replace(" ", "").trim();
		}
		else
		{
			try {
				String webRupeeText = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"webRupee\"]")).getText();
				String taxesClassText  = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"taxesClass\"]")).getText();
				String priceCarGiftText = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[@class=\"priceCarGift\"]")).getText();
				actualMrp = priceCarGiftText.replace(webRupeeText, "").replace(taxesClassText, "").replace(" ", "").trim();
			}
			catch(Exception ex)
			{
				actualMrp = "";
			}
		}
		
		String expectedMrp =  "6490";
		WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForPorcelainWhite() {
		color = "Porcelain White";
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		anchorContainer.click();
		String actualMop = "";
		boolean offerpriceavailable=false;
		
		try
		{
			WebElement offerPriceSpanNode = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]"));
			offerpriceavailable = true;
		}
		catch(Exception ex)
		{
			offerpriceavailable = false;
		}
		
		if (offerpriceavailable)
		{
			String Mrp = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]/strike")).getText();
			String emText = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]/em")).getText();
			actualMop = driver.findElement(By.xpath("//div[@id=\"giftSection1\"]/div/div/div[3]/div/p/span[2]/span[@class=\"offerPrice\"]")).getText();
			actualMop = actualMop.replace(Mrp, "").replace(emText, "").replace(" ", "").trim();
		}
		else
		{
			actualMop = "not applicable";
		}
		
		String expectedMop = (offerpriceavailable)?"6290":"not applicable";
		WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForPorcelainWhite)", "is not applicable!");
	}

	@BeforeTest
	public void beforeTest() {
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--disable-extensions");
		chromeoptions.addArguments("--headless");
		chromeoptions.addArguments("--disable-gpu");
		chromeoptions.addArguments("--no-sandbox");
		chromeoptions.addArguments("--remote-allow-origins=*");
		chromeoptions.addArguments("--start-maximized");

		WebDriverManager.chromedriver().setup();
		// WebDriverManager.chromedriver().browserVersion("111.0.5563.65").setup();

		driver = new ChromeDriver(chromeoptions);

		driver.get("https://www.saregama.com/carvaan/hindi/buy-now");

		// ReadDetailsFromThePage();

		WebElement closepopup = null;
		try {
			closepopup = driver.findElement(By.xpath("/html/body/div[11]/div/div/button"));
		} catch (Exception ex) {
		}

		if (closepopup != null)
			closepopup.click();
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

	private void WriteLine(String head, String value) {
		System.out.println(head + ": " + value);
	}

	public void ReadDetailsFromThePage() {
		WebElement e1 = driver.findElement(By.xpath("//*[@id=\"53CarvThmb\"]/span[2]"));
		System.out.println("Color: " + e1.getText());

		WebElement e2 = driver.findElement(By.xpath("//a[@data-prodid=\"53\"]"));
		System.out.println("data-image: " + e2.getAttribute("data-image"));
	}

	private WebElement getListItemForSelectedColor(String selectedColor) {
		WebElement result = null;
		List<WebElement> ColorSelectoryListItems = driver.findElements(By.xpath("//div[@id=\"selectColor\"]/ul/li"));

		for (int i = 0; i < ColorSelectoryListItems.size(); i++) {
			WebElement ColorSelectoryListItem = ColorSelectoryListItems.get(i);
			String currentColor = ColorSelectoryListItem.findElement(By.xpath("./a/span[@class=\"srgm_wrap_n\"]"))
					.getText();
			if (currentColor.equals(selectedColor)) {
				result = ColorSelectoryListItem;
				break;
			}
		}

		return result;
	}
}
