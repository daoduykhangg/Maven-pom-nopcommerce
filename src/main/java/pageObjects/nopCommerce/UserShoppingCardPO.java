package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserShoppingCardUI;

public class UserShoppingCardPO extends AbstractPage{
	WebDriver driver;

	public UserShoppingCardPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, UserShoppingCardUI.UPDATE_SHOPPING_CARD_BUTTON);
		clickToElement(driver, UserShoppingCardUI.UPDATE_SHOPPING_CARD_BUTTON);
	}

	public void clickToEstimateShippingButton() {
		waitForElementClickable(driver, UserShoppingCardUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, UserShoppingCardUI.ESTIMATE_SHIPPING_BUTTON);
	}

	public void selectToCountryDropdown(String country) {
		waitForElementClickable(driver, UserShoppingCardUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserShoppingCardUI.COUNTRY_DROPDOWN, country);
	}

	public void selectToStateDropdown(String state) {
		waitForElementClickable(driver, UserShoppingCardUI.STATE_DROPDOWN);
		selectItemInDropdown(driver, UserShoppingCardUI.STATE_DROPDOWN, state);
	}

	public void enterToZipCodeTextbox(String zipcodeValue) {
		waitForElementVisible(driver, UserShoppingCardUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserShoppingCardUI.ZIPCODE_TEXTBOX, zipcodeValue);
		waitForElementInvisible(driver, UserShoppingCardUI.SHIPPING_LOADING_ICON);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, UserShoppingCardUI.APPLY_BUTTON);
		clickToElement(driver, UserShoppingCardUI.APPLY_BUTTON);
	}

	public void checkToTermsOfServiceCheckbox() {
		waitForElementClickable(driver, UserShoppingCardUI.TERMS_OF_SERVICE_CHECKBOX);
		checkTheCheckbox(driver, UserShoppingCardUI.TERMS_OF_SERVICE_CHECKBOX);
	}

	public UserCheckoutPO clickToCheckoutButton() {
		waitForElementClickable(driver, UserShoppingCardUI.CHECKOUT_BUTTON);
		clickToElement(driver, UserShoppingCardUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getUserCheckoutPage(driver);
	}
	
}
