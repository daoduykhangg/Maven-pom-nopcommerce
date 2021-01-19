package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserProductReviewsPageUI;

public class UserProductReviewsPO extends AbstractPage {
	WebDriver driver;

	public UserProductReviewsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToReviewTitleTextbox(String reviewTitle) {
		waitForAllElementVisible(driver, UserProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void enterToReviewTextTextbox(String reviewText) {
		waitForAllElementVisible(driver, UserProductReviewsPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, UserProductReviewsPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}

	public void clickToRatingRadioButton(String ratingValue) {
		waitForElementClickable(driver, UserProductReviewsPageUI.DYNAMIC_RATING_RADIO_BUTTON, ratingValue);
		checkTheCheckbox(driver, UserProductReviewsPageUI.DYNAMIC_RATING_RADIO_BUTTON, ratingValue);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public Object getSuccessMessageofProductReview() {
		waitForAllElementVisible(driver, UserProductReviewsPageUI.SUCCESS_MESSAGE_PRODUCT_REVIEW);
		return getTextElement(driver, UserProductReviewsPageUI.SUCCESS_MESSAGE_PRODUCT_REVIEW);
	}
}
