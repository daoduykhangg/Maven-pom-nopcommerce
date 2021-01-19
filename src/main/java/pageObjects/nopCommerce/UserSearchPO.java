package pageObjects.nopCommerce;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserSearchPageUI;

public class UserSearchPO extends AbstractPage {
	WebDriver driver;

	public UserSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getWarningMessageAtSearchPage() {
		waitForAllElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE_AT_SEARCH_PAGE);
		return getTextElement(driver, UserSearchPageUI.WARNING_MESSAGE_AT_SEARCH_PAGE);
	}

	public void enterToSearchTextbox(String keyWordValue) {
		waitForAllElementVisible(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyWordValue);
	}

	public Boolean isProductsDisplayedAtSearchPage(String productName) {
		waitForAllElementVisible(driver, UserSearchPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(driver, UserSearchPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void clickToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkTheCheckbox(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectToCategoryDropdown(String categoryValue) {
		waitForAllElementVisible(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, categoryValue);
	}

	public void clickToAutomaticallySearchSubCategoriesCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkTheCheckbox(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	public void selectToManufacturerDropdown(String manufacturerValue) {
		waitForAllElementVisible(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, manufacturerValue);
	}

	public void enterToPriceFromTextbox(String priceFromValue) {
		waitForAllElementVisible(driver, UserSearchPageUI.PRICE_FROM_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.PRICE_FROM_TEXTBOX, priceFromValue);
	}

	public void enterToPriceToTextbox(String priceToValue) {
		waitForAllElementVisible(driver, UserSearchPageUI.PRICE_TO_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.PRICE_TO_TEXTBOX, priceToValue);
	}
}
