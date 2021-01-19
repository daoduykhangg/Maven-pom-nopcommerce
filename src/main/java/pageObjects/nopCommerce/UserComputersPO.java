package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserComputersPageUI;

public class UserComputersPO extends AbstractPage {
	WebDriver driver;

	public UserComputersPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		waitForElementClickable(driver, UserComputersPageUI.SORT_BY_DROPDOWN);
		selectItemInDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN, itemValue);
	}

	public boolean areProductNameSortByAscending() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedAscending(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortByDescending() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedDescending(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductPriceSortByAscending() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatStringSortedAscending(driver, UserComputersPageUI.ALL_PRODUCT_PRICE);
	}

	public boolean areProductPriceSortByDescending() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatStringSortedDescending(driver, UserComputersPageUI.ALL_PRODUCT_PRICE);
	}

	public void selectPerPageDisplayedDropdown(String perPageValue) {
		waitForElementClickable(driver, UserComputersPageUI.DISPLAY_PERPAGE_DORPDOWN);
		selectItemInDropdown(driver, UserComputersPageUI.DISPLAY_PERPAGE_DORPDOWN, perPageValue);
	}

	public boolean areThreeProductsDisplayed() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 3) {
			return true;
			
		}else {
			return false;
		}
	}
	public boolean areSixProductsDisplayed() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 6) {
			return true;
			
		}else {
			return false;
		}
	}
	public boolean areNineProductsDisplayed() {
		waitForAllElementVisible(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserComputersPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 9) {
			return true;
			
		}else {
			return false;
		}
	}

	public boolean isNextIconDisplayed() {
		waitForElementClickable(driver, UserComputersPageUI.NEXT_ICON_LINK);
		return isElementDisplayed(driver, UserComputersPageUI.NEXT_ICON_LINK);
	}

	public void clickToNextIconLink() {
		waitForElementClickable(driver, UserComputersPageUI.NEXT_ICON_LINK);
		clickToElement(driver, UserComputersPageUI.NEXT_ICON_LINK);
	}

	public boolean isPreviousIconDisplayed() {
		waitForElementClickable(driver, UserComputersPageUI.PREVIOUS_ICON_LINK);
		return isElementDisplayed(driver, UserComputersPageUI.PREVIOUS_ICON_LINK);
	}

	public boolean isPagerUndisplayed() {
		return isElementUndisplayed(driver, UserComputersPageUI.PAGER);
	}
}
