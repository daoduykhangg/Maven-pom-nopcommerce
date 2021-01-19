package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserRecentlyViewedProductsPO extends AbstractPage{
	WebDriver driver;

	public UserRecentlyViewedProductsPO(WebDriver driver) {
		this.driver = driver;
	}

}
