package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserComputersDetailPageUI;

public class UserComputersDetailPO extends AbstractPage {
	WebDriver driver;

	public UserComputersDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewsPO clickToAddYourReviewButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserComputersDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewsPage(driver);
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, UserComputersDetailPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public void SelectToProcessorDropdown(String processorValue) {
		waitForElementClickable(driver, UserComputersDetailPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdown(driver, UserComputersDetailPageUI.PROCESSOR_DROPDOWN, processorValue);
	}

	public void SelectToRamDropdown(String ramValue) {
		waitForElementClickable(driver, UserComputersDetailPageUI.RAM_DROPDOWN);
		selectItemInDropdown(driver, UserComputersDetailPageUI.RAM_DROPDOWN, ramValue);
	}

	public void ClickToHDD400GBRadioButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.HDD_400GB_RADIO_BUTTON);
		checkTheCheckbox(driver, UserComputersDetailPageUI.HDD_400GB_RADIO_BUTTON);
	}

	public void ClickToVistaPremiumRadioButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.VISTA_PREMIUM_RADIO_BUTTON);
		checkTheCheckbox(driver, UserComputersDetailPageUI.VISTA_PREMIUM_RADIO_BUTTON);
	}

	public void clickToMicrosoftOfficeCheckbox() {
		waitForElementClickable(driver, UserComputersDetailPageUI.MICROSOFT_OFFICE_CHECKBOX);
		checkTheCheckbox(driver, UserComputersDetailPageUI.MICROSOFT_OFFICE_CHECKBOX);
	}

	public void checkToAcrobatReaderCheckbox() {
		waitForElementClickable(driver, UserComputersDetailPageUI.ACROBAT_READER_CHECKBOX);
		checkTheCheckbox(driver, UserComputersDetailPageUI.ACROBAT_READER_CHECKBOX);
	}

	public void checkToTotalCommanderCheckbox() {
		waitForElementClickable(driver, UserComputersDetailPageUI.TOTAL_COMMANDER_CHECKBOX);
		checkTheCheckbox(driver, UserComputersDetailPageUI.TOTAL_COMMANDER_CHECKBOX);
	}

	public void checkToAddToCardButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, UserComputersDetailPageUI.ADD_TO_CARD_BUTTON);
	}

	public String getCountItemInYourCardText() {
		waitForElementVisible(driver, UserComputersDetailPageUI.COUNT_ITEM_IN_YOUR_CARD);
		return getTextElement(driver, UserComputersDetailPageUI.COUNT_ITEM_IN_YOUR_CARD);
	}

	public boolean isPictureProductDisplayed() {
		waitForElementVisible(driver, UserComputersDetailPageUI.PICTURE_PRODUCT_LINK);
		return isElementDisplayed(driver, UserComputersDetailPageUI.PICTURE_PRODUCT_LINK);
	}

	public String getNameProduct() {
		waitForElementVisible(driver, UserComputersDetailPageUI.NAME_PRODUCT_TEXT);
		return getTextElement(driver, UserComputersDetailPageUI.NAME_PRODUCT_TEXT);
	}

	public String getAttributeProductText() {
		waitForElementVisible(driver, UserComputersDetailPageUI.ATTRIBUTE_PRODUCT_TEXT);
		return getTextElement(driver, UserComputersDetailPageUI.ATTRIBUTE_PRODUCT_TEXT);
	}

	public String getPriceProductText() {
		waitForElementVisible(driver, UserComputersDetailPageUI.PRICE_PRODUCT_TEXT);
		return getTextElement(driver, UserComputersDetailPageUI.PRICE_PRODUCT_TEXT);
	}

	public String getQuantityProductText() {
		waitForElementVisible(driver, UserComputersDetailPageUI.QUANTITY_PRODUCT_TEXT);
		return getTextElement(driver, UserComputersDetailPageUI.QUANTITY_PRODUCT_TEXT);
	}

	public String getSubTotalsText() {
		waitForElementVisible(driver, UserComputersDetailPageUI.SUB_TOTALS_TEXT);
		return getTextElement(driver, UserComputersDetailPageUI.SUB_TOTALS_TEXT);
	}

	public void ClickTo320GBRadioButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.HDD_320GB_RADIO_BUTTON);
		clickToElement(driver, UserComputersDetailPageUI.HDD_320GB_RADIO_BUTTON);
	}

	public void clickToVistaHomeRadioButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.VISTA_HOME_RADIO_BUTTON);
		clickToElement(driver, UserComputersDetailPageUI.VISTA_HOME_RADIO_BUTTON);
	}

	public void enterToProductQuantityTextbox(String quantityValue) {
		waitForElementVisible(driver, UserComputersDetailPageUI.PRODUCT1_QUANTITY_TEXTBOX);
		sendkeyToElement(driver, UserComputersDetailPageUI.PRODUCT1_QUANTITY_TEXTBOX, quantityValue);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, UserComputersDetailPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserComputersDetailPageUI.UPDATE_BUTTON);
	}

	public void uncheckToAcrobatReaderCheckbox() {
		waitForElementClickable(driver, UserComputersDetailPageUI.ACROBAT_READER_CHECKBOX);
		uncheckTheCheckbox(driver, UserComputersDetailPageUI.ACROBAT_READER_CHECKBOX);
	}

	public void uncheckToTotalCommanderCheckbox() {
		waitForElementClickable(driver, UserComputersDetailPageUI.TOTAL_COMMANDER_CHECKBOX);
		uncheckTheCheckbox(driver, UserComputersDetailPageUI.TOTAL_COMMANDER_CHECKBOX);
	}

}
