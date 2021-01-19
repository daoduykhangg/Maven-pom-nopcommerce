package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserMyProductReviewPageUI;

public class UserMyProductReviewPO extends AbstractPage {
	WebDriver driver;

	public UserMyProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductReviewDisplayed(String ReviewTitle) {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, ReviewTitle);
		return isElementDisplayed(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT, ReviewTitle);
	}
}
