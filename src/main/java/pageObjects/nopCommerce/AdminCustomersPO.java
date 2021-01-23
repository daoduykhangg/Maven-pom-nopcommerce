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

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminCustomersUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminCustomersUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AdminCustomersUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.LASTNAME_TEXTBOX, lastName);
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
	}

	public void enterToDateOfBirthTextbox(String dateOfBirth) {
		waitForElementVisible(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void enterToCompanyNameTextbox(String companyName) {
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

	public void enterToAdminCommentTextbox(String adminComment) {
		waitForElementVisible(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX);
		sendkeyToElement(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX, adminComment);
	}

	public void clickToSaveAndContinueEdit() {
		waitForElementClickable(driver, AdminCustomersUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(driver, AdminCustomersUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, AdminCustomersUI.SUCCESS_MESSAGE_TEXT);
		return getTextElement(driver, AdminCustomersUI.SUCCESS_MESSAGE_TEXT);
	}

	public String getEmailValue() {
		waitForElementVisible(driver, AdminCustomersUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.EMAIL_TEXTBOX, "value");
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, AdminCustomersUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.LASTNAME_TEXTBOX, "value");
	}

	public boolean isGenderMaleChecked() {
		waitForElementVisible(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
		return isElementSelected(driver, AdminCustomersUI.GENDER_MALE_RADIO_BUTTON);
	}

	public String getDateOfBirthValue() {
		waitForElementVisible(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.DATE_OF_BIRTH_TEXTBOX, "value");
	}

	public String getCompanyNameValue() {
		waitForElementVisible(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.COMPANYNAME_TEXTBOX, "value");
	}

	public String getCustomerRolesValue() {
		waitForElementVisible(driver, AdminCustomersUI.GUEST_TEXT);
		return getTextElement(driver, AdminCustomersUI.GUEST_TEXT);
	}

	public String getAdminCommentValue() {
		waitForElementVisible(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX);
		return getElementAttribute(driver, AdminCustomersUI.ADMIN_COMMENT_TEXTBOX, "value");
	}

	public void clickToBackToCustomerList() {
		waitForElementClickable(driver, AdminCustomersUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomersUI.BACK_TO_CUSTOMER_LIST);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomersUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomersUI.SEARCH_BUTTON);
		WaitForLoadingIconInvisibleAtAdmin(driver);
	}

	public boolean areInforCustomerDisplayedInTable(String email, String fullname, String customerRoles, String companyName, String activeStatus) {
		waitForElementVisible(driver, AdminCustomersUI.INFOR_CUSTOMER_IN_TABLE, email, fullname, customerRoles, companyName, activeStatus);
		return isElementDisplayed(driver, AdminCustomersUI.INFOR_CUSTOMER_IN_TABLE, email, fullname, customerRoles, companyName, activeStatus);
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
}
