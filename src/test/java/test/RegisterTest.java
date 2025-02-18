package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import utils.CommonUtils;

public class RegisterTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplicationURL();
		headerOption = new HeaderOptions(driver);
		headerOption.clickOnMyAccount();
		registerAccountPage = headerOption.selectRegisterOption();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
		
	}

	@Test(priority = 1)
	public void verifyRegisteringUsingMandatoryFields() {
		registerAccountPage.eneterFirstName(prop.getProperty("firstname"));
		registerAccountPage.enterLastName(prop.getProperty("lastname"));
		registerAccountPage.eneterEmail(CommonUtils.generateNewEmail());
		registerAccountPage.enterTelephone(prop.getProperty("telephoneNumber"));
		registerAccountPage.enterPassword(prop.getProperty("validPassword"));
		registerAccountPage.enterConfirmationPassword(prop.getProperty("validPassword"));
		registerAccountPage.selectPrivacyPolicy();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		rightColumnOptions = accountSuccessPage.getRightColumnOption();

		Assert.assertTrue(rightColumnOptions.isUserLoggedIn());

		accountSuccessPage = rightColumnOptions.getAccountSuccessPage();
		Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());
		myAccountPage = accountSuccessPage.clickOnContinueButton();
		Assert.assertTrue(myAccountPage.didWeNavigateToMyAccountPage());
	}

	@Test(priority = 2)
	public void verifyRegisteringUsingAllFields() {

		registerAccountPage.eneterFirstName(prop.getProperty("firstname"));
		registerAccountPage.enterLastName(prop.getProperty("lastname"));
		registerAccountPage.eneterEmail(CommonUtils.generateNewEmail());
		registerAccountPage.enterTelephone(prop.getProperty("telephoneNumber"));
		registerAccountPage.enterPassword(prop.getProperty("validPassword"));
		registerAccountPage.enterConfirmationPassword(prop.getProperty("validPassword"));
		registerAccountPage.selectYesNewsletterOption();
		registerAccountPage.selectPrivacyPolicy();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		rightColumnOptions = accountSuccessPage.getRightColumnOption();
		Assert.assertTrue(rightColumnOptions.isUserLoggedIn());
		accountSuccessPage = rightColumnOptions.getAccountSuccessPage();
		Assert.assertTrue(accountSuccessPage.didWeNavigateToAccountSuccessPage());
		myAccountPage = accountSuccessPage.clickOnContinueButton();
		Assert.assertTrue(myAccountPage.didWeNavigateToMyAccountPage());

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountByUsingYesNewsletterOption() {

		registerAccountPage.eneterFirstName(prop.getProperty("firstname"));
		registerAccountPage.enterLastName(prop.getProperty("lastname"));
		registerAccountPage.eneterEmail(CommonUtils.generateNewEmail());
		registerAccountPage.enterTelephone(prop.getProperty("telephoneNumber"));
		registerAccountPage.enterPassword(prop.getProperty("validPassword"));
		registerAccountPage.enterConfirmationPassword(prop.getProperty("validPassword"));
		registerAccountPage.selectYesNewsletterOption();
		registerAccountPage.selectPrivacyPolicy();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		myAccountPage = accountSuccessPage.clickOnContinueButton();
		newsletterSubscriptionPage = myAccountPage.clickOnSubscribeOrUnsubscribeNewsletterOption();

		Assert.assertTrue(newsletterSubscriptionPage.isYesNewsletterOptionSelected());
	}

	@Test(priority = 4)
	public void verifyRegisteringAccountByUsingNoNewsletterOption() {
		registerAccountPage.eneterFirstName(prop.getProperty("firstname"));
		registerAccountPage.enterLastName(prop.getProperty("lastname"));
		registerAccountPage.eneterEmail(CommonUtils.generateNewEmail());
		registerAccountPage.enterTelephone(prop.getProperty("telephoneNumber"));
		registerAccountPage.enterPassword(prop.getProperty("validPassword"));
		registerAccountPage.enterConfirmationPassword(prop.getProperty("validPassword"));
		registerAccountPage.selectNoNewsletterOption();
		registerAccountPage.selectPrivacyPolicy();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		myAccountPage = accountSuccessPage.clickOnContinueButton();
		newsletterSubscriptionPage = myAccountPage.clickOnSubscribeOrUnsubscribeNewsletterOption();
		Assert.assertTrue(newsletterSubscriptionPage.isNoNewsletterOptionSelected());
	}

	@Test(priority = 5)
	public void verifyPrivacyPolicySelectionStatusInRegisteringAccountPage() {

		Assert.assertTrue(registerAccountPage.isPrivacyPolicyFieldSelected());
	}

}
