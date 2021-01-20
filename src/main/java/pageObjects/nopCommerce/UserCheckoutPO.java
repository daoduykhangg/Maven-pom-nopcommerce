package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserCheckoutUI;

public class UserCheckoutPO extends AbstractPage {
	WebDriver driver;
	public boolean isOrderNumberDisplayed;

	public UserCheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void uncheckToShipToTheSameAddressCheckboxAtBillingStep() {
		waitForElementClickable(driver, UserCheckoutUI.BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
		uncheckTheCheckbox(driver, UserCheckoutUI.BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
	}

	public void enterToFirstnameTextboxAtBillingStep(String firstname) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_FIRSTNAME_TEXTBOX, firstname);
	}

	public void enterToLastnameTextboxAtBillingStep(String lastname) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_LASTNAME_TEXTBOX, lastname);
	}

	public void enterToEmailTextboxAtBillingStep(String email) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_EMAIL_TEXTBOX, email);
	}

	public void selectToCountryDropdownAtBillingStep(String country) {
		waitForElementClickable(driver, UserCheckoutUI.BILLING_COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.BILLING_COUNTRY_DROPDOWN, country);
		waitForElementInvisible(driver, UserCheckoutUI.STATE_LOADING_ICON);
	}

	public void selectToStateDropdownAtBillingStep(String state) {
		waitForElementClickable(driver, UserCheckoutUI.BILLING_STATE_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.BILLING_STATE_DROPDOWN, state);
	}

	public void enterToCityTextboxAtBillingStep(String city) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_CITY_TEXTBOX, city);
	}

	public void enterToAddress1TextboxAtBillingStep(String address1) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_ADDRESS1_TEXTBOX, address1);
	}

	public void enterToZipCodeTextboxAtBillingStep(String zipCode) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_ZIPCODE_TEXTBOX, zipCode);
	}

	public void enterToPhoneNumberTextboxAtBillingStep(String phoneNumber) {
		waitForElementVisible(driver, UserCheckoutUI.BILLING_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.BILLING_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void clickToCountinueButton(String idValue, String idLoadlingIcon) {
		waitForElementClickable(driver, UserCheckoutUI.DYNAMIC_COUNTINUE_BUTTON, idValue);
		clickToElement(driver, UserCheckoutUI.DYNAMIC_COUNTINUE_BUTTON, idValue);
//		waitForElementInvisible(driver, UserCheckoutUI.DYNAMIC_LOADING_NEXT_STEP_TEXT, idLoadlingIcon);
	}
	
	public void SelectToShippingAddressDropdownAtShippingStep(String shippingAddress) {
		waitForElementClickable(driver, UserCheckoutUI.SHIPPING_ADDRESS_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.SHIPPING_ADDRESS_DROPDOWN, shippingAddress);
	}

	public void SelectToShippingAddressDropdownAtBillingStep(String BillingAddress) {
		waitForElementClickable(driver, UserCheckoutUI.BILLING_ADDRESS_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.BILLING_ADDRESS_DROPDOWN, BillingAddress);
	}

	public void SelectToCountryDropdownAtShippingStep(String country) {
		waitForElementClickable(driver, UserCheckoutUI.SHIPPING_COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.SHIPPING_COUNTRY_DROPDOWN, country);
	}

	public void SelectToStateDropdownAtShippingStep(String State) {
		waitForElementClickable(driver, UserCheckoutUI.SHIPPING_STATE_DROPDOWN);
		sleepInMiliSecond(1000);
		selectItemInDropdown(driver, UserCheckoutUI.SHIPPING_STATE_DROPDOWN, State);
	}

	public void enterToCityTextboxAtShippingStep(String city) {
		waitForElementVisible(driver, UserCheckoutUI.SHIPPING_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.SHIPPING_CITY_TEXTBOX, city);
	}

	public void enterToAddress1TextboxAtShippingStep(String address1) {
		waitForElementVisible(driver, UserCheckoutUI.SHIPPING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.SHIPPING_ADDRESS1_TEXTBOX, address1);
	}

	public void enterToZipCodeTextboxAtShippingStep(String zipCode) {
		waitForElementVisible(driver, UserCheckoutUI.SHIPPING_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.SHIPPING_ZIPCODE_TEXTBOX, zipCode);
	}

	public void enterToPhoneNumberTextboxAtShippingStep(String phoneNumber) {
		waitForElementVisible(driver, UserCheckoutUI.SHIPPING_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.SHIPPING_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void clickToGroundRadioButtonAtShippingMethodStep() {
		waitForElementClickable(driver, UserCheckoutUI.SHIPPING_METHOD_GROUND_RADIO_BUTTON);
		checkTheCheckbox(driver, UserCheckoutUI.SHIPPING_METHOD_GROUND_RADIO_BUTTON);
	}

	public void clickToCheckMoneyOrderRadioButtonAtPaymentMethodStep() {
		waitForElementClickable(driver, UserCheckoutUI.PAYMENT_METHOD_CHECK_MONEY_ORDER_RADIO_BUTTON);
		checkTheCheckbox(driver, UserCheckoutUI.PAYMENT_METHOD_CHECK_MONEY_ORDER_RADIO_BUTTON);
	}

	public String getTextPaymentInforAtPaymentInforStep(String indexValue) {
		waitForElementVisible(driver, UserCheckoutUI.DYNAMIC_PAYMENT_INFOR_TEXT, indexValue);
		return getTextElement(driver, UserCheckoutUI.DYNAMIC_PAYMENT_INFOR_TEXT, indexValue);
	}

	public String getTextOrderInforAtConfirmOrderStep(String orderInfor, String classname) {
		waitForElementVisible(driver, UserCheckoutUI.DYNAMIC_ORDER_INFOR_TEXT, orderInfor, classname);
		return getTextElement(driver, UserCheckoutUI.DYNAMIC_ORDER_INFOR_TEXT, orderInfor, classname);
	}

	public String getTextCartTotalAtConfirmOrderStep(String totalInfor) {
		waitForElementVisible(driver, UserCheckoutUI.DYNAMIC_CARD_TOTAL_TEXT, totalInfor);
		return getTextElement(driver, UserCheckoutUI.DYNAMIC_CARD_TOTAL_TEXT, totalInfor);
	}

	public void clickToConfirmButtonAtConfirmOrderStep() {
		waitForElementClickable(driver, UserCheckoutUI.CONFIRM_BUTTON);
		clickToElement(driver, UserCheckoutUI.CONFIRM_BUTTON);
	}

	public boolean areProductDetailDisplayedAtConfirmOrderStep(WebDriver driver, String sku, String image, String productName, String price, String productQuantity, String subTotals) {
		waitForElementVisible(driver, UserCheckoutUI.DYNAMIC_PRODUCT_DETAIL_IN_TABLE, sku, image, productName, price, productQuantity, subTotals);
		return isElementDisplayed(driver, UserCheckoutUI.DYNAMIC_PRODUCT_DETAIL_IN_TABLE, sku, image, productName, price, productQuantity, subTotals);
	}

	public String getTextGiftWarppingAtConfirmOrderStep() {
		waitForElementVisible(driver, UserCheckoutUI.GIFT_WRAPPING_TEXT);
		return getTextElement(driver, UserCheckoutUI.GIFT_WRAPPING_TEXT);
	}

	public String getSuccessMessageOrderCompleted() {
		waitForElementVisible(driver, UserCheckoutUI.SUCCESS_MESSAGE_ORDER_COMPLETE);
		return getTextElement(driver, UserCheckoutUI.SUCCESS_MESSAGE_ORDER_COMPLETE);
	}

	public String getTextOrderNumber() {
		waitForElementVisible(driver, UserCheckoutUI.ORDER_NUMBER);
		return getTextElement(driver, UserCheckoutUI.ORDER_NUMBER);
	}

	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, UserCheckoutUI.ORDER_NUMBER);
		return isElementDisplayed(driver, UserCheckoutUI.ORDER_NUMBER);
	}

	public void clickToCreditCardRadioButtonAtPaymentMethodStep() {
		waitForElementClickable(driver, UserCheckoutUI.CREDIT_CARD_RADIO_BUTTON);
		clickToElement(driver, UserCheckoutUI.CREDIT_CARD_RADIO_BUTTON);
	}

	public void enterToCardholderNameAtPaymentInforStep(String cardholderName) {
		waitForElementVisible(driver, UserCheckoutUI.CARDHOLDER_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.CARDHOLDER_NAME_TEXTBOX, cardholderName);
	}

	public void enterToCardNumberAtPaymentInforStep(String cardNumber) {
		waitForElementVisible(driver, UserCheckoutUI.CARD_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.CARD_NUMBER_TEXTBOX, cardNumber);
	}

	public void selectToExpirationMonthAtPaymentInforStep(String expirationMonth) {
		waitForElementClickable(driver, UserCheckoutUI.EXPIRATION_MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.EXPIRATION_MONTH_DROPDOWN, expirationMonth);
	}

	public void selectToExpirationYearAtPaymentInforStep(String expirationYear) {
		waitForElementClickable(driver, UserCheckoutUI.EXPIRATION_YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCheckoutUI.EXPIRATION_YEAR_DROPDOWN, expirationYear);
	}

	public void enterToCardCodeAtPaymentInforStep(String cardCode) {
		waitForElementVisible(driver, UserCheckoutUI.CARD_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutUI.CARD_CODE_TEXTBOX, cardCode);
	}

	public void clickToNextDayAirRadioButtonAtShippingMethodStep() {
		waitForElementClickable(driver, UserCheckoutUI.SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON);
		clickToElement(driver, UserCheckoutUI.SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON);
	}
}
