package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserOrdersPageUI;

public class UserOrdersPO extends AbstractPage {
	WebDriver driver;

	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOrderNumber() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER);
		return getTextElement(driver, UserOrdersPageUI.ORDER_NUMBER);
	}

	public String getTextOrderInforAtordersPage(String orderInfor, String className) {
		waitForElementVisible(driver, UserOrdersPageUI.DYNAMIC_ORDER_INFOR_TEXT, orderInfor, className);
		return getTextElement(driver, UserOrdersPageUI.DYNAMIC_ORDER_INFOR_TEXT, orderInfor, className);
	}

	public boolean areProductDetailDisplayedAtordersPage(WebDriver driver, String sku, String productName, String price, String productQuantity, String subTotals) {
		waitForElementVisible(driver, UserOrdersPageUI.DYNAMIC_PRODUCT_DETAIL_IN_TABLE, sku, productName, price, productQuantity, subTotals);
		return isElementDisplayed(driver, UserOrdersPageUI.DYNAMIC_PRODUCT_DETAIL_IN_TABLE, sku, productName, price, productQuantity, subTotals);
	}

	public String getTextCartTotalAtordersPage(String indexValue) {
		waitForElementVisible(driver, UserOrdersPageUI.DYNAMIC_CARD_TOTAL_TEXT, indexValue);
		return getTextElement(driver, UserOrdersPageUI.DYNAMIC_CARD_TOTAL_TEXT, indexValue);
	}

	public void clickToDetalsButton(String orderNumber) {
		waitForElementClickable(driver, UserOrdersPageUI.DYNAMIC_DETAILS_BUTTON, orderNumber);
		clickToElement(driver, UserOrdersPageUI.DYNAMIC_DETAILS_BUTTON, orderNumber);
	}

	public String getTextOrderNumberAtOrdersdetail() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER_AT_DETAIL);
		return getTextElement(driver, UserOrdersPageUI.ORDER_NUMBER_AT_DETAIL);
	}

	public String getTextOrderStatus() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_STATUS);
		return getTextElement(driver, UserOrdersPageUI.ORDER_STATUS);
	}

	public String getTextOrderTotal() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_TOTAL);
		return getTextElement(driver, UserOrdersPageUI.ORDER_TOTAL);
	}

	public String getTextOrderDate() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_DATE);
		return getTextElement(driver, UserOrdersPageUI.ORDER_DATE);
	}
}
