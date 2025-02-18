package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class RegisterAccountPage extends RootPage {

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;

	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public boolean isPrivacyPolicyFieldSelected() {
		return elementUtilities.isElementSelected(privacyPolicyField);
	}

	public void selectNoNewsletterOption() {
		elementUtilities.clickOnElement(noNewsletterOption);
	}

	public void selectYesNewsletterOption() {
		elementUtilities.clickOnElement(yesNewsletterOption);

	}

	public AccountSuccessPage clickOnContinueButton() {
		elementUtilities.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}

	public void selectPrivacyPolicy() {
		elementUtilities.clickOnElement(privacyPolicyField);
	}

	public void enterConfirmationPassword(String passwordText) {
		elementUtilities.enterTextIntoElement(passwordConfirmField, passwordText);

	}

	public void enterPassword(String passwordText) {
		elementUtilities.enterTextIntoElement(passwordField, passwordText);

	}

	public void enterTelephone(String telephoneText) {
		elementUtilities.enterTextIntoElement(telephoneField, telephoneText);

	}

	public void eneterEmail(String emailText) {
		elementUtilities.enterTextIntoElement(emailField, emailText);

	}

	public void enterLastName(String lastNameText) {
		elementUtilities.enterTextIntoElement(lastNameField, lastNameText);
		lastNameField.sendKeys(lastNameText);
	}

	public void eneterFirstName(String firstNameText) {
		elementUtilities.enterTextIntoElement(firstNameField, firstNameText);

	}

}
