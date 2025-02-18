package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class NewsletterSubscriptionPage extends RootPage {

	public NewsletterSubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@class='radio-inline']//input[@value='1']")
	private WebElement yesNewsletterOption;

	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption;

	public boolean isNoNewsletterOptionSelected() {
		return elementUtilities.isElementSelected(noNewsletterOption);

	}

	public boolean isYesNewsletterOptionSelected() {
		return elementUtilities.isElementSelected(yesNewsletterOption);

	}

}
