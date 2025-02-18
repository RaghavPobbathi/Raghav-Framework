package utils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ElementUtilities {
	WebDriver driver;
	private String testName;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementSelected(WebElement element) {
		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isSelected();
		}
		return b;
	}

	public String getTextFromElement(WebElement element) {
		String t = "";
		try {
			t = element.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return t;
	}

	public void enterTextIntoElement(WebElement element, String text) {
		if (isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.clear();
			element.sendKeys(text);

		}

	}

	public void clickOnElement(WebElement element) {

		if (isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.click();

		}

	}

	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isElementInEnabledState(WebElement element) {
		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isEnabled();

		}
		return b;
	}

	public String captureScreenshot(WebDriver driver, String testName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);

		String filePath = System.getProperty("user.dir") + "\\ScreenShots\\" + testName + ".png";
		try {
			FileHandler.copy(srcScreenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

}
