package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;

public class SearchTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void steup() {

		driver = openBrowserAndApplicationURL();
		headerOptions = new HeaderOptions(driver);
	}

	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}

	@Test(priority = 1)
	public void verifySearchingWithExistingProduct() {
		headerOptions.enterSearchProduct(prop.getProperty("existingProduct"));
		searchPage = headerOptions.clickOnSearchButton();
		Assert.assertTrue(searchPage.isProductDisplayedInSearchResults());

	}

	@Test(priority = 2)
	public void verifySearchingWithNonExistingProduct() {
		headerOptions.enterSearchProduct(prop.getProperty("nonExistingProduct"));
		searchPage = headerOptions.clickOnSearchButton();
		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), expectedMessage);
	}

	@Test(priority = 3)
	public void verifySearchingWithoutProvidingProduct() {
		searchPage = headerOptions.clickOnSearchButton();

		String expectedMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductMessage(), expectedMessage);

	}
}
