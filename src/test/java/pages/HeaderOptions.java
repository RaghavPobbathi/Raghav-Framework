package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class HeaderOptions extends RootPage {

	public HeaderOptions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Register")
	private WebElement RegisterOption;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public SearchPage clickOnSearchButton() {
		elementUtilities.clickOnElement(searchButton);
		return new SearchPage(driver);
	}

	public void enterSearchProduct(String productText) {
		elementUtilities.enterTextIntoElement(searchBoxField, productText);

	}

	public LoginPage selectLoginOption() {
		elementUtilities.clickOnElement(loginOption);
		return new LoginPage(driver);
	}

	public void clickOnMyAccount() {
		elementUtilities.clickOnElement(myAccountDropMenu);

	}

	public RegisterAccountPage selectRegisterOption() {
		elementUtilities.clickOnElement(RegisterOption);
		return new RegisterAccountPage(driver);
	}

}
