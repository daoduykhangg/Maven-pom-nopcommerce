package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.AdminCustomersUI;

public class AdminCustomersPO extends AbstractPage {
	WebDriver driver;

	public AdminCustomersPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AdminCustomersUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomersUI.ADD_NEW_BUTTON);
	}

	public void enterToEmailTextboxAtCustomerDetail(String email) {
		waitForElementVisible(driver, AdminCustomersUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextboxAtCustomerDetail(String password) {
		waitForElementVisible(driver, AdminCustomersUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToFirstNameTextboxAtCustomerDetail(String firstName) {
		waitForElementVisible(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextboxAtCustomerDetail(String lastName) {
		waitForElementVisible(driver, AdminCustomersUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.LASTNAME_TEXTBOX, lastName);
	}

	public void clickToGenderMaleRadioButtonAtCustomerDetail() {
		waitForElementClickable(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
	}

	public void enterToDateOfBirthTextboxAtCustomerDetail(String dateOfBirth) {
		waitForElementVisible(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void enterToCompanyNameTextboxAtCustomerDetail(String companyName) {
		waitForElementVisible(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX, companyName);
	}

	public void clickToDeleteButtonInCustomerRolesTextbox() {
		waitForElementClickable(driver, AdminCustomersUI.DELETE_BUTTON_ATCUSTOMER_ROLES);
		clickToElement(driver, AdminCustomersUI.DELETE_BUTTON_ATCUSTOMER_ROLES);
	}

	public void selectToCustomerRolesDropdown() {
		waitForElementClickable(driver, AdminCustomersUI.CUSTOMER_ROLES_DROPDOWN);
		clickToElement(driver, AdminCustomersUI.CUSTOMER_ROLES_DROPDOWN);
		waitForElementClickable(driver, AdminCustomersUI.GUEST_OPTION);
		clickToElement(driver, AdminCustomersUI.GUEST_OPTION);
	}

	public void enterToAdminCommentTextboxAtCustomerDetail(String adminComment) {
		waitForElementVisible(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX, adminComment);
	}

	public void clickToSaveAndContinueEditAtCustomerDetail() {
		waitForElementClickable(driver, AdminCustomersUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(driver, AdminCustomersUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, AdminCustomersUI.SUCCESS_MESSAGE_TEXT);
		return getTextElement(driver, AdminCustomersUI.SUCCESS_MESSAGE_TEXT);
	}

	public String getEmailValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.EMAIL_TEXTBOX, "value");
	}

	public String getFirstNameValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.LASTNAME_TEXTBOX, "value");
	}

	public boolean isGenderMaleCheckedAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
		return isElementSelected(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
	}

	public String getDateOfBirthValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX, "value");
	}

	public String getCompanyNameValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX, "value");
	}

	public String getCustomerRolesValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.GUEST_TEXT);
		return getTextElement(driver, AdminCustomersUI.GUEST_TEXT);
	}

	public String getAdminCommentValueAtCustomerDetail() {
		waitForElementVisible(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX, "value");
	}

	public void clickToBackToCustomerListAtCustomerDetail() {
		waitForElementClickable(driver, AdminCustomersUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomersUI.BACK_TO_CUSTOMER_LIST);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomersUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomersUI.SEARCH_BUTTON);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public boolean areInforCustomerDisplayedInTable(String email, String fullname, String customerRole, String companyName, String activeStatus) {
		waitForElementVisible(driver, AdminCustomersUI.INFOR_CUSTOMER_IN_TABLE, email, fullname, customerRole, companyName, activeStatus);
		return isElementDisplayed(driver, AdminCustomersUI.INFOR_CUSTOMER_IN_TABLE, email, fullname, customerRole, companyName, activeStatus);
	}

	public void enterToEmailTextboxInSearchSection(String email) {
		waitForElementVisible(driver, AdminCustomersUI.EMAIL_TEXTBOX_IN_SEARCH_SECTION);
		sendkeyToElement(driver, AdminCustomersUI.EMAIL_TEXTBOX_IN_SEARCH_SECTION, email);
	}

	public void enterToFirstNameTextboxInSearchSection(String firstName) {
		waitForElementVisible(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX_IN_SEARCH_SECTION);
		sendkeyToElement(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX_IN_SEARCH_SECTION, firstName);
	}

	public void enterToLastNameTextboxInSearchSection(String lastName) {
		waitForElementVisible(driver, AdminCustomersUI.LASTNAME_TEXTBOX_IN_SEARCH_SECTION);
		sendkeyToElement(driver, AdminCustomersUI.LASTNAME_TEXTBOX_IN_SEARCH_SECTION, lastName);
	}

	public void enterToCompanyTextboxInSearchSection(String companyName) {
		waitForElementVisible(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX_IN_SEARCH_SECTION);
		sendkeyToElement(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX_IN_SEARCH_SECTION, companyName);
	}

	public void selectToMonthDropdownInSearchSection(String month) {
		waitForElementClickable(driver, AdminCustomersUI.MONTH_DROPDOWN_IN_SEARCH_SECTION);
		selectItemInDropdown(driver, AdminCustomersUI.MONTH_DROPDOWN_IN_SEARCH_SECTION, month);
	}

	public void selectToDayDropdownInSearchSection(String day) {
		waitForElementClickable(driver, AdminCustomersUI.DAY_DROPDOWN_IN_SEARCH_SECTION);
		selectItemInDropdown(driver, AdminCustomersUI.DAY_DROPDOWN_IN_SEARCH_SECTION, day);
	}

	public void clickToEditCustomerButtonAtCustomers(String email, String fullname, String customerRole, String companyName, String activeStatus) {
		waitForElementClickable(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_AT_CUSTOMERS, email, fullname, customerRole, companyName, activeStatus);
		clickToElement(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_AT_CUSTOMERS, email, fullname, customerRole, companyName, activeStatus);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminCustomersUI.SAVE_BUTTON);
		clickToElement(driver, AdminCustomersUI.SAVE_BUTTON);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public void clickToAddNewAddressButtonAtCustomerDetail() {
		waitForElementClickable(driver, AdminCustomersUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomersUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void enterToFirstNameTextboxAtAddANewAddress(String firstname) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_FIRSTNAME_TEXTBOX, firstname);
	}

	public void enterToLastNameTextboxAtAddANewAddress(String lastname) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_LASTNAME_TEXTBOX, lastname);
	}

	public void enterToEmailTextboxAtAddANewAddress(String email) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void enterToCompanyTextboxAtAddANewAddress(String company) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_COMPANY_TEXTBOX, company);
	}

	public void enterToCityTextboxAtAddANewAddress(String city) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_CITY_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void enterToAddress1TextboxAtAddANewAddress(String address1) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_ADDRESS1_TEXTBOX, address1);
	}

	public void enterToAddress2TextboxAtAddANewAddress(String address2) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_ADDRESS2_TEXTBOX, address2);
	}

	public void enterToZipCodeTextboxAtAddANewAddress(String zipCode) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_ZIPCODE_TEXTBOX, zipCode);
	}

	public void enterToPhoneNumberTextboxAtAddANewAddress(String phoneNumber) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_PHONE_NUMER_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_PHONE_NUMER_TEXTBOX, phoneNumber);
	}

	public void enterToFaxNumberTextboxAtAddANewAddress(String faxNumber) {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADDRESS_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void selectToCountryDropdownAtAddANewAddress(String country) {
		waitForElementClickable(driver, AdminCustomersUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, AdminCustomersUI.ADDRESS_COUNTRY_DROPDOWN, country);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public void selectToStateDropdownAtAddANewAddress(String state) {
		waitForElementClickable(driver, AdminCustomersUI.ADDRESS_STATE_DROPDOWN);
		selectItemInDropdown(driver, AdminCustomersUI.ADDRESS_STATE_DROPDOWN, state);
	}

	public void clickToSaveButtonAtAddANewAddress() {
		waitForElementClickable(driver, AdminCustomersUI.SAVE_BUTTON_AT_ADD_A_NEW_ADDRESS);
		clickToElement(driver, AdminCustomersUI.SAVE_BUTTON_AT_ADD_A_NEW_ADDRESS);
	}

	public String getFirstNameValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_LASTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_LASTNAME_TEXTBOX, "value");
	}

	public String getEmailValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_EMAIL_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_EMAIL_TEXTBOX, "value");
	}

	public String getCompanyValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_COMPANY_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_COMPANY_TEXTBOX, "value");
	}

	public String getCityValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_CITY_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_CITY_TEXTBOX, "value");
	}

	public String getAddress1ValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ADDRESS1_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_ADDRESS1_TEXTBOX, "value");
	}

	public String getAddress2ValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ADDRESS2_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_ADDRESS2_TEXTBOX, "value");
	}

	public String getZipCodeValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_ZIPCODE_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_ZIPCODE_TEXTBOX, "value");
	}

	public String getPhoneNumberValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_PHONE_NUMER_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_PHONE_NUMER_TEXTBOX, "value");
	}

	public String getFaxNumberValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADDRESS_FAX_NUMBER_TEXTBOX, "value");
	}

	public String getCountryValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_COUNTRY_DROPDOWN);
		return getFirstSelectedText(driver, AdminCustomersUI.ADDRESS_COUNTRY_DROPDOWN);
	}

	public String getStateValueAtAddANewAddress() {
		waitForElementVisible(driver, AdminCustomersUI.ADDRESS_STATE_DROPDOWN);
		return getFirstSelectedText(driver, AdminCustomersUI.ADDRESS_STATE_DROPDOWN);
	}

	public void clickToBackToCustomerDetails() {
		waitForElementClickable(driver, AdminCustomersUI.BACK_TO_CUSTOMER_DETAILS);
		clickToElement(driver, AdminCustomersUI.BACK_TO_CUSTOMER_DETAILS);
	}

	public boolean areInforNewAddressDisplayedInTable(String firstname, String lastname, String email, String phoneNumber, String faxNumber, String company, String address1, String address2, String city, String zipcode, String country) {
		waitForElementVisible(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_IN_TABLE, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, zipcode, country);
		return isElementDisplayed(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_IN_TABLE, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, zipcode, country);
	}

	public void clickToEditAddressAtCustomerDetails(String firstname, String lastname, String email, String phoneNumber, String faxNumber, String company, String address1, String address2, String city, String zipcode, String country) {
		waitForElementClickable(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_AT_CUSTOMER_DETAILS, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, zipcode, country);
		clickToElement(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_AT_CUSTOMER_DETAILS, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, zipcode, country);
	}

	public boolean areInforNewAddressHasStateDisplayedInTable(String firstname, String lastname, String email, String phoneNumber, String faxNumber, String company, String address1, String address2, String city, String state, String zipcode, String country) {
		waitForElementVisible(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_HAS_STATEATIN_TABLE, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, state, zipcode, country);
		return isElementDisplayed(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_HAS_STATEATIN_TABLE, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, state, zipcode, country);
	}

	public void clickToEditAddressHasStateAtCustomerDetails(String firstname, String lastname, String email, String phoneNumber, String faxNumber, String company, String address1, String address2, String city, String state, String zipcode, String country) {
		waitForElementClickable(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_HAS_STATEAT_CUSTOMER_DETAILS, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, state, zipcode, country);
		clickToElement(driver, AdminCustomersUI.DYNAMIC_EDIT_BUTTON_HAS_STATEAT_CUSTOMER_DETAILS, firstname, lastname, email, phoneNumber, faxNumber, company, address1, address2, city, state, zipcode, country);
	}

	public void clickToDeleteAddressHasStateAtCustomerDetails(String editFirstname, String editLastname, String editEmail, String editPhoneNumber, String editFaxNumber, String editCompanyName, String editAddress1, String editAddress2, String editCity, String editState, String editZipCode, String editCounTry) {
		waitForElementClickable(driver, AdminCustomersUI.DYNAMIC_DELETE_BUTTON_HAS_STATEAT_CUSTOMER_DETAILS, editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry);
		clickToElement(driver, AdminCustomersUI.DYNAMIC_DELETE_BUTTON_HAS_STATEAT_CUSTOMER_DETAILS, editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry);
	}

	public boolean areInforNewAddressHasStateUndisplayedInTable(String editFirstname, String editLastname, String editEmail, String editPhoneNumber, String editFaxNumber, String editCompanyName, String editAddress1, String editAddress2, String editCity, String editState, String editZipCode,
			String editCounTry) {
		waitForElementInvisible(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_HAS_STATEATIN_TABLE, editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry);
		return isElementUndisplayed(driver, AdminCustomersUI.INFOR_NEW_ADDRESS_HAS_STATEATIN_TABLE, editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry);
	}

	public String getNoDataAvailableInTable() {
		waitForElementVisible(driver, AdminCustomersUI.NO_DATA_AVAILABLE_IN_TABLE);
		return getTextElement(driver, AdminCustomersUI.NO_DATA_AVAILABLE_IN_TABLE);
	}
}
