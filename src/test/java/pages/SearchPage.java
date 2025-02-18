package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class SearchPage extends RootPage {

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement existingProduct;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMessage;

	public String getNoProductMessage() {
		return elementUtilities.getTextFromElement(noProductMessage);

	}

	public boolean isProductDisplayedInSearchResults() {
		return elementUtilities.isElementDisplayed(existingProduct);

	}
}
