package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserCompareProductsUI;

public class UserCompareProductsPO extends AbstractPage {
	WebDriver driver;

	public UserCompareProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductInforDisplayed(String imgValue, String productName, String price) {
		waitForAllElementVisible(driver, UserCompareProductsUI.DYNAMIC_PRODUCT_INFO_IN_TABLE, imgValue, productName, price);
		return isElementDisplayed(driver, UserCompareProductsUI.DYNAMIC_PRODUCT_INFO_IN_TABLE, imgValue, productName, price);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, UserCompareProductsUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductsUI.CLEAR_LIST_BUTTON);
	}

	public boolean areProductInforUnDisplayed(String imgValue, String productName, String price) {
		waitForElementInvisible(driver, UserCompareProductsUI.DYNAMIC_PRODUCT_INFO_IN_TABLE, imgValue, productName, price);
		return isElementUndisplayed(driver, UserCompareProductsUI.DYNAMIC_PRODUCT_INFO_IN_TABLE, imgValue, productName, price);
	}
}
