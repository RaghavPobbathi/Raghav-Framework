package root;

import org.openqa.selenium.WebDriver;

import utils.ElementUtilities;

public class RootPage {
	
	public WebDriver driver;
	public ElementUtilities elementUtilities;
	
	public RootPage(WebDriver driver) {
		this.driver = driver;
		elementUtilities = new ElementUtilities(driver);
	}


}
