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
	CarvaanExpectedValues CEV = new CarvaanExpectedValues();

	
	/*
	 * Test for Carvaan Hindi - Porcelain White - Start Here
	 */
	
	@Test
	public void TestProductIDForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForPorcelainWhite() {
		color = "Porcelain White";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForPorcelainWhite)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Porcelain White - Ends Here
	 */


	/*
	 * Test for Carvaan Hindi - Walnut Brown - Start Here
	 */
	
	@Test
	public void TestProductIDForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForWalnutBrown() {
		color = "Walnut Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForWalnutBrown)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Walnut Brown - Ends Here
	 */


	/*
	 * Test for Carvaan Hindi - Electric Blue - Start Here
	 */
	
	@Test
	public void TestProductIDForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForElectricBlue() {
		color = "Electric Blue";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForElectricBlue)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Electric Blue - Ends Here
	 */

	/*
	 * Test for Carvaan Hindi - Camouflage Green - Start Here
	 */
	
	@Test
	public void TestProductIDForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForCamouflageGreen() {
		color = "Camouflage Green";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForCamouflageGreen)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Camouflage Green - Ends Here
	 */


	/*
	 * Test for Carvaan Hindi - Cherrywood Red - Start Here
	 */
	
	@Test
	public void TestProductIDForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForCherrywoodRed() {
		color = "Cherrywood Red";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForCherrywoodRed)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Cherrywood Red - Ends Here
	 */

	/*
	 * Test for Carvaan Hindi - Oakwood Brown - Start Here
	 */
	
	@Test
	public void TestProductIDForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForOakwoodBrown() {
		color = "Oakwood Brown";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForOakwoodBrown)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Oakwood Brown - Ends Here
	 */


	/*
	 * Test for Carvaan Hindi - Charcoal Grey - Start Here
	 */
	
	@Test
	public void TestProductIDForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement productIdContainer = colorSelectorContainer.findElement(By.xpath("./input[1]"));
		String actualProductId = productIdContainer.getAttribute("id");
		String expectedProductId = record.getID();
		// WriteLine("Product Id: ", actualProductId);
		assertEquals(actualProductId, expectedProductId);
	}

	@Test
	public void TestDataImageForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualDataImage = anchorContainer.getAttribute("data-image");
		String expectedDataImage = record.getImage();
		// WriteLine("Data Image: ", actualDataImage);
		assertEquals(actualDataImage, expectedDataImage);
	}

	@Test
	public void TestDataZoomImageForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
		WebElement colorSelectorContainer = getListItemForSelectedColor(color);
		WebElement anchorContainer = colorSelectorContainer.findElement(By.xpath("./a[1]"));
		String actualZoomDataImage = anchorContainer.getAttribute("data-zoom-image");
		String expectedZoomDataImage = record.getZoomImage();
		// WriteLine("Data Zoom Image: ", actualZoomDataImage);
		assertEquals(actualZoomDataImage, expectedZoomDataImage);
	}

	@Test
	public void TestNotifyForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		boolean expectedNotifyButtonPresent = record.getNotify();
		// WriteLine("Notify Me Present: ", (actualNotifyButtonPresent?"True":"False"));
		assertEquals(actualNotifyButtonPresent, expectedNotifyButtonPresent);
	}

	@Test
	public void TestTitleForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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

		String expectedTitle = record.getTitle();
		// WriteLine("Product Title: ", actualTitle);
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void TestMRPForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMrp =  record.getMRP();
		//WriteLine("Product MRP: ", actualMrp);
		assertEquals(actualMrp, expectedMrp);
	}

	@Test
	public void TestMOPForCharcoalGrey() {
		color = "Charcoal Grey";
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(color);
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
		
		String expectedMop = (offerpriceavailable)?record.getMOP():"not applicable";
		//WriteLine("Product MOP: ", actualMop);
		
		if (offerpriceavailable)
			assertEquals(actualMop, expectedMop);
		else
			WriteLine("TEST(TestMOPForCharcoalGrey)", "is not applicable!");
	}

	/*
	 * Test for Carvaan Hindi - Charcoal Grey - Ends Here
	 */



	
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
