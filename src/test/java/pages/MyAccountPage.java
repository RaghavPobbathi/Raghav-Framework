package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class MyAccountPage extends RootPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationOption;

	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement subscribeOrUnsubscribeToNewsletterOption;

	public NewsletterSubscriptionPage clickOnSubscribeOrUnsubscribeNewsletterOption() {
		elementUtilities.clickOnElement(subscribeOrUnsubscribeToNewsletterOption);
		return new NewsletterSubscriptionPage(driver);
	}

	public boolean didWeNavigateToMyAccountPage() {
		return elementUtilities.isElementDisplayed(editYourAccountInformationOption);

	}

	public RightColumnOptions getRightColumnOption() {
		return new RightColumnOptions(driver);
	}

}
