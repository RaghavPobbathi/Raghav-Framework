package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class RightColumnOptions extends RootPage {

	public RightColumnOptions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='list-group-item' and text()='Logout']")
	private WebElement logoutOption;

	public boolean isUserLoggedIn() {
		return elementUtilities.isElementDisplayed(logoutOption);

	}

	public AccountSuccessPage getAccountSuccessPage() {
		return new AccountSuccessPage(driver);
	}

	public MyAccountPage getMyAccountPage() {
		return new MyAccountPage(driver);
	}
}
