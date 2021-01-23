package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.AdminDashBoardPageUI;

public class AdminDashBoardPO extends AbstractPage {
	WebDriver driver;

	public AdminDashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductsPO openProductsPage() {
		waitForElementClickable(driver, AdminDashBoardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitForElementClickable(driver, AdminDashBoardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		WaitForLoadingIconInvisibleAtAdmin(driver);
		return PageGeneratorManager.getAdminProductsPage(driver);
	}

	public AdminCustomersPO openCustomersPage() {
		waitForElementVisible(driver, AdminDashBoardPageUI.CUSTOMERS_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.CUSTOMERS_TEXT_AT_SIDEBAR);
		waitForElementVisible(driver, AdminDashBoardPageUI.CUSTOMERS_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.CUSTOMERS_LINK_AT_SIDEBAR);
		WaitForLoadingIconInvisibleAtAdmin(driver);
		return PageGeneratorManager.getCustomersPage(driver);
	}
}
