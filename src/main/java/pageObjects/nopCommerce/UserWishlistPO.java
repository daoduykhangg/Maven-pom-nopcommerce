package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.NopcommerceAbstractPageUI;
import pageUIs.nopCommerce.UserWishlistUI;

public class UserWishlistPO extends AbstractPage {
	WebDriver driver;

	public UserWishlistPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToYourWishlistURLLink() {
		waitForElementClickable(driver, UserWishlistUI.WISHLIST_SHARE_LINK);
		clickToElement(driver, UserWishlistUI.WISHLIST_SHARE_LINK);
	}

	public String isTitleWishlistOfdisplayed() {
		waitForAllElementVisible(driver, UserWishlistUI.TITLE_WISHLIST_OF);
		return getTextElement(driver, UserWishlistUI.TITLE_WISHLIST_OF);
	}

	public void clickToAddToCardCheckbox(String skuValue, String imageValue, String productName, String price, String qtyValue, String total) {
		waitForElementClickable(driver, UserWishlistUI.DYNAMIC_ADD_TO_CART_CHECKBOX_PRODUCT_DETAIL_IN_TABLE, skuValue, imageValue, productName, price, qtyValue, total);
		checkTheCheckbox(driver, UserWishlistUI.DYNAMIC_ADD_TO_CART_CHECKBOX_PRODUCT_DETAIL_IN_TABLE, skuValue, imageValue, productName, price, qtyValue, total);
	}
	
	public UserShoppingCardPO clickToAddToCardButton() {
		waitForElementClickable(driver, UserWishlistUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, UserWishlistUI.ADD_TO_CARD_BUTTON);
		return PageGeneratorManager.getShoppingCardPage(driver);
	}

	public void clickToUpdateWishlistButton() {
		waitForElementClickable(driver, UserWishlistUI.UPDATE_WISHLIST_BUTTON);
		clickToElement(driver, UserWishlistUI.UPDATE_WISHLIST_BUTTON);
	}


}
