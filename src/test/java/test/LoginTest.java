package test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import utils.CommonUtils;
import utils.MyXLSReader;

public class LoginTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplicationURL();
		headerOptions = new HeaderOptions(driver);
		headerOptions.clickOnMyAccount();
		loginPage = headerOptions.selectLoginOption();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}

	@Test(priority = 1,dataProvider = "validCredentialsSupplier")
	public void verifyLoggingIntoApplicationUsingValidCredentials(HashMap<String, String>map) {
		loginPage.enterEmail(map.get("Email"));
		loginPage.enterPassword(map.get("Password"));
		myAccountPage = loginPage.clickOnLoginButton();
		rightColumnOptions = myAccountPage.getRightColumnOption();

		Assert.assertTrue(rightColumnOptions.isUserLoggedIn());
		myAccountPage = rightColumnOptions.getMyAccountPage();
		Assert.assertTrue(myAccountPage.didWeNavigateToMyAccountPage());

	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] testDataForLogin() {
		MyXLSReader myXLSReader = new MyXLSReader("\\src\\test\\resources\\LoginData.xlsx");
		
		Object[][] data = CommonUtils.getTestData(myXLSReader, "loginWithValidCredentials", "login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoggingIntoApplicationUsingInValidCredentials() {
		loginPage.enterEmail(CommonUtils.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarningMessage);

	}

	@Test(priority = 3)
	public void verifyLoggingIntoApplicationUsingInValidEmailAndValidPassword() {
		loginPage.enterEmail(CommonUtils.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarningMessage);

	}

	@Test(priority = 4)
	public void verifyLoggingIntoApplicationUsingValidEmailAndInvalidPassword() {
		loginPage.enterEmail(prop.getProperty("existingEamil"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarningMessage);

	}

	@Test(priority = 5)
	public void verifyLoggingIntoApplicationUsingWithoutEnteringCredentials() {

		loginPage.clickOnLoginButton();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginPage.getWarningMessage(), expectedWarningMessage);

	}

}
