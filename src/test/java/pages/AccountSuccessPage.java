package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class AccountSuccessPage extends RootPage {

	public AccountSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountSuccessPageBreadcrumb;

	@FindBy(xpath = "//a[@class='btn btn-primary'][text()='Continue']")
	private WebElement continueButton;

	public MyAccountPage clickOnContinueButton() {
		elementUtilities.clickOnElement(continueButton);
		return new MyAccountPage(driver);
	}

	public boolean didWeNavigateToAccountSuccessPage() {
		return elementUtilities.isElementDisplayed(accountSuccessPageBreadcrumb);

	}

	public RightColumnOptions getRightColumnOption() {
		return new RightColumnOptions(driver);
	}

}
