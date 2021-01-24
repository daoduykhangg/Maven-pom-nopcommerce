package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminCustomersPO;
import pageObjects.nopCommerce.AdminDashBoardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductsPO;
import pageObjects.nopCommerce.PageGeneratorManager;
import utilities.FakerConfig;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Admin_02_Create_Edit_Search_Customer extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";

		fakeData = FakerConfig.getFakeData();
		email = fakeData.getEmailAddress();
		emailGuest = "Guest";
		password = fakeData.getPassword();
		firstname = fakeData.getFirstname();
		lastname = fakeData.getLastname();
		fullname = firstname + " " + lastname;
		dateOfBirth = "8/21/1996";
		companyName = fakeData.getCompanyName();
		customerRole = "Guests";
		adminComment = "Add new Customer (Guest)";
		activeStatus = "true";
		month = "8";
		day = "21";

		editEmail = "Edit_" + email;
		editFirstname = "Edit " + firstname;
		editLastname = "Edit " + lastname;
		editDateOfBirth = "9/22/1996";
		editCompanyName = "Edit " + companyName;
		editAdminComment = "Edit Customer(Guests)";
		editFullname = editFirstname + " " + editLastname;
		editMonth = "9";
		editDay = "22";

		counTry = "Viet Nam";
		state = "Other";
		city = "Hồ Chí Minh";
		zipCode = fakeData.getZipCode();
		address1 = "Đặng Minh Trứ";
		address2 = "Mầm non 10";
		phoneNumber = fakeData.getPhoneNumber();
		faxNumber = "+84933998999";

		editCounTry = "United States";
		editState = "California";
		editCity = "Albany";
		editZipCode = fakeData.getZipCode();
		editAddress1 = fakeData.getAddress();
		editAddress2 = fakeData.getAddress();
		editPhoneNumber = fakeData.getPhoneNumber();
		editFaxNumber = "+84908192322";
		
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		log.info("Pre-condition - Step 01: Enter To 'Email' Textbox at 'Login' Page");
		loginPage.enterToEmailTextbox(emailAdmin);

		log.info("Pre-condition - Step 02: Enter To 'Password' Textbox at 'Login' Page");
		loginPage.enterToPasswordTextbox(passwordAdmin);

		log.info("Pre-condition - Step 03: Click To 'Log in' Button at 'Login' Page");
		dashBoardPage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 04: Open 'Products' Page");
		customersPage = dashBoardPage.openCustomersPage();
	}

	@Test
	public void TC_01_Create_New_Customer() {
		log.info("Create New Customer - Step 01: Click to 'Add new' Button  At Customer Detail");
		customersPage.clickToAddNewButton();

		log.info("Create New Customer - Step 02: Enter to 'Email' Textbox with value '" + email + "' At Customer Detail");
		customersPage.enterToEmailTextboxAtCustomerDetail(email);

		log.info("Create New Customer - Step 03: Enter to 'Password' Textbox with value '" + password + "' At Customer Detail");
		customersPage.enterToPasswordTextboxAtCustomerDetail(password);

		log.info("Create New Customer - Step 04: Enter to 'First name' Textbox with value '" + firstname + "' At Customer Detail");
		customersPage.enterToFirstNameTextboxAtCustomerDetail(firstname);

		log.info("Create New Customer - Step 05: Enter to 'Last name' Textbox with value '" + lastname + "' At Customer Detail");
		customersPage.enterToLastNameTextboxAtCustomerDetail(lastname);

		log.info("Create New Customer - Step 06: Click to 'GenderMale' Radio Button At Customer Detail");
		customersPage.clickToGenderMaleRadioButtonAtCustomerDetail();

		log.info("Create New Customer - Step 07: Enter to 'Date of birth' Textbox with value '" + dateOfBirth + "' At Customer Detail");
		customersPage.enterToDateOfBirthTextboxAtCustomerDetail(dateOfBirth);

		log.info("Create New Customer - Step 08: Enter to 'Company name' Textbox with value '" + companyName + "' At Customer Detail");
		customersPage.enterToCompanyNameTextboxAtCustomerDetail(companyName);

		log.info("Create New Customer - Step 09: Click to 'X' Button at 'Customer roles' Textbox At Customer Detail");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Create New Customer - Step 10: Select 'Customer roles' Dropdown with value 'Guests' At Customer Detail");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Create New Customer - Step 11: Enter to 'Admin comment' Textbox with value '" + adminComment + "' At Customer Detail");
		customersPage.enterToAdminCommentTextboxAtCustomerDetail(adminComment);

		log.info("Create New Customer - Step 12: Click to 'Save and Continue Edit' At Customer Detail");
		customersPage.clickToSaveAndContinueEditAtCustomerDetail();

		log.info("Create New Customer - Step 13: Verify Success Message is displayed with value 'The new customer has been added successfully.'");
		verifyEquals(customersPage.getSuccessMessage(), "×" + "\n" + "The new customer has been added successfully.");

		log.info("Create New Customer - Step 14: Verify Infomation Customer Details are displayed correctly At Customer Detail");
		verifyEquals(customersPage.getEmailValueAtCustomerDetail(), email);
		verifyEquals(customersPage.getFirstNameValueAtCustomerDetail(), firstname);
		verifyEquals(customersPage.getLastNameValueAtCustomerDetail(), lastname);
		verifyTrue(customersPage.isGenderMaleCheckedAtCustomerDetail());
		verifyEquals(customersPage.getDateOfBirthValueAtCustomerDetail(), dateOfBirth);
		verifyEquals(customersPage.getCompanyNameValueAtCustomerDetail(), companyName);
		verifyEquals(customersPage.getCustomerRolesValueAtCustomerDetail(), customerRole);
		verifyEquals(customersPage.getAdminCommentValueAtCustomerDetail(), adminComment);

		log.info("Create New Customer - Step 15: Click to 'back to customer list' Link At Customer Detail");
		customersPage.clickToBackToCustomerListAtCustomerDetail();

		log.info("Create New Customer - Step 16: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Create New Customer - Step 17: Select 'Customer roles' Dropdown");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Create New Customer - Step 18: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Create New Customer - Step 19: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));
	}

	@Test(dependsOnMethods = "TC_01_Create_New_Customer")
	public void TC_02_Search_Customer_With_Email() {
		log.info("Search Customer [Email] - Step 01: Refresh Current Page");
		customersPage.refreshCurrentPage(driver);
		customersPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search Customer [Email] - Step 02: Enter to 'Email' Textbox in 'Search' section with value '" + email + "'");
		customersPage.enterToEmailTextboxInSearchSection(email);

		log.info("Search Customer [Email] - Step 03: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Email] - Step 04: Select 'Customer roles' Dropdown with value 'Guests'");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Search Customer [Email] - Step 05: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Search Customer [Email] - Step 06: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));
	}

	@Test(dependsOnMethods = "TC_01_Create_New_Customer")
	public void TC_03_Search_Customer_With_FirstName_And_LastName() {
		log.info("Search Customer [FirstName and LastName] - Step 01: Refresh Current Page");
		customersPage.refreshCurrentPage(driver);
		customersPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search Customer [FirstName and LastName] - Step 02: Enter to 'Firstname' Textbox in 'Search' section with value '" + firstname + "'");
		customersPage.enterToFirstNameTextboxInSearchSection(firstname);

		log.info("Search Customer [FirstName and LastName] - Step 03: Enter to 'Lastname' Textbox in 'Search' section with value '" + lastname + "'");
		customersPage.enterToLastNameTextboxInSearchSection(lastname);

		log.info("Search Customer [FirstName and LastName] - Step 04: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [FirstName and LastName] - Step 05: Select 'Customer roles' Dropdown with value 'Guests'");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Search Customer [FirstName and LastName] - Step 06: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Search Customer [FirstName and LastName] - Step 07: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));
	}

	@Test(dependsOnMethods = "TC_01_Create_New_Customer")
	public void TC_04_Search_Customer_With_Company() {
		log.info("Search Customer [Company] - Step 01: Refresh Current Page");
		customersPage.refreshCurrentPage(driver);
		customersPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search Customer [Company] - Step 02: Enter to 'Company' Textbox in 'Search' section with value '" + companyName + "'");
		customersPage.enterToCompanyTextboxInSearchSection(companyName);

		log.info("Search Customer [Company] - Step 03: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Company] - Step 04: Select 'Customer roles' Dropdown with value 'Guests'");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Search Customer [Company] - Step 05: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Search Customer [Company] - Step 06: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));
	}

	@Test(dependsOnMethods = "TC_01_Create_New_Customer")
	public void TC_05_Search_Customer_With_Full_Data() {
		log.info("Search Customer [Full Data] - Step 01: Refresh Current Page");
		customersPage.refreshCurrentPage(driver);
		customersPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search Customer [Full Data] - Step 02: Enter to 'Email' Textbox in 'Search' section with value '" + email + "'");
		customersPage.enterToEmailTextboxInSearchSection(email);

		log.info("Search Customer [Full Data] - Step 03: Enter to 'Firstname' Textbox in 'Search' section with value '" + firstname + "'");
		customersPage.enterToFirstNameTextboxInSearchSection(firstname);

		log.info("Search Customer [Full Data] - Step 04: Enter to 'Lastname' Textbox in 'Search' section with value '" + lastname + "'");
		customersPage.enterToLastNameTextboxInSearchSection(lastname);

		log.info("Search Customer [Full Data] - Step 05: Select 'Month' Dropdown with value '" + month + "'");
		customersPage.selectToMonthDropdownInSearchSection(month);

		log.info("Search Customer [Full Data] - Step 06: Select 'Day' Dropdown with value '" + day + "'");
		customersPage.selectToDayDropdownInSearchSection(day);

		log.info("Search Customer [Full Data] - Step 07: Enter to 'Company' Textbox in 'Search' section with value '" + companyName + "'");
		customersPage.enterToCompanyTextboxInSearchSection(companyName);

		log.info("Search Customer [Full Data] - Step 08: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Full Data] - Step 09: Select 'Customer roles' Dropdown with value 'Guests'");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Search Customer [Full Data] - Step 10: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Search Customer [Full Data] - Step 11: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));

	}

	@Test(dependsOnMethods = { "TC_01_Create_New_Customer", "TC_05_Search_Customer_With_Full_Data" })
	public void TC_06_Edit_Customer() {
		log.info("Edit Customer - Step 01: Click to 'Edit' Button");
		customersPage.clickToEditCustomerButtonAtCustomers(emailGuest, fullname, customerRole, companyName, activeStatus);

		log.info("Edit Customer - Step 02: Enter to 'Email' Textbox with value '" + editEmail + "' At Customer Detail");
		customersPage.enterToEmailTextboxAtCustomerDetail(editEmail);

		log.info("Edit Customer - Step 04: Enter to 'First name' Textbox with value '" + editFirstname + "' At Customer Detail");
		customersPage.enterToFirstNameTextboxAtCustomerDetail(editFirstname);

		log.info("Edit Customer - Step 03: Enter to 'Last name' Textbox with value '" + editLastname + "' At Customer Detail");
		customersPage.enterToLastNameTextboxAtCustomerDetail(editLastname);

		log.info("Edit Customer - Step 05: Enter to 'Date of birth' Textbox with value '" + editDateOfBirth + "' At Customer Detail");
		customersPage.enterToDateOfBirthTextboxAtCustomerDetail(editDateOfBirth);

		log.info("Edit Customer - Step 06: Enter to 'Company name' Textbox with value '" + editCompanyName + "' At Customer Detail");
		customersPage.enterToCompanyNameTextboxAtCustomerDetail(editCompanyName);

		log.info("Edit Customer - Step 07: Enter to 'Admin comment' Textbox with value '" + editAdminComment + "' At Customer Detail");
		customersPage.enterToAdminCommentTextboxAtCustomerDetail(editAdminComment);

		log.info("Edit Customer - Step 08: Click to 'Save' Button At Customer Detail");
		customersPage.clickToSaveButton();

		log.info("Edit Customer - Step 09: Verify Success Messsage is displayed with valye 'The customer has been updated successfully.'");
		verifyEquals(customersPage.getSuccessMessage(), "×" + "\n" + "The customer has been updated successfully.");

		log.info("Edit Customer - Step 10: Enter to 'Email' Textbox with value '" + editEmail + "' in Search Section");
		customersPage.enterToEmailTextboxInSearchSection(editEmail);

		log.info("Edit Customer - Step 11: Enter to 'First name' Textbox with value '" + editFirstname + "' in Search Section");
		customersPage.enterToFirstNameTextboxInSearchSection(editFirstname);

		log.info("Edit Customer - Step 12: Enter to 'Last name' Textbox with value '" + editLastname + "' in Search Section");
		customersPage.enterToLastNameTextboxInSearchSection(editLastname);

		log.info("Edit Customer - Step 13: Select to 'Month' Dropdown with value '" + editMonth + "' in Search Section");
		customersPage.selectToMonthDropdownInSearchSection(editMonth);

		log.info("Edit Customer - Step 14: Select to 'Day' Dropdown with value '" + editDay + "' in Search Section");
		customersPage.selectToDayDropdownInSearchSection(editDay);

		log.info("Edit Customer - Step 15: Enter to 'Company' Textbox with value '" + editCompanyName + "' in Search Section");
		customersPage.enterToCompanyTextboxInSearchSection(editCompanyName);

		log.info("Edit Customer - Step 16: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Edit Customer - Step 17: Select 'Customer roles' Dropdown with value 'Guests'");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Edit Customer - Step 18: Click to 'Search' Button in Search Section");
		customersPage.clickToSearchButton();

		log.info("Edit Customer - Step 19: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, editFullname, customerRole, editCompanyName, activeStatus));
	}

	@Test(dependsOnMethods = { "TC_01_Create_New_Customer", "TC_05_Search_Customer_With_Full_Data", "TC_06_Edit_Customer" })
	public void TC_07_Add_New_Address_At_Customer_Detail() {
		log.info("Add New Address - Step 01: Click to 'Edit' Button");
		customersPage.clickToEditCustomerButtonAtCustomers(emailGuest, editFullname, customerRole, editCompanyName, activeStatus);

		log.info("Add New Address - Step 02: Click to 'Addresses' Panel At Customer Detail");
		customersPage.openToPanelByPanelID(driver, "customer-address");

		log.info("Add New Address - Step 03: Click to 'Add new address' Button At Customer Detail");
		customersPage.clickToAddNewAddressButtonAtCustomerDetail();

		log.info("Add New Address - Step 04: Enter to 'First name' Textbox with value '" + firstname + "' At Add a new address");
		customersPage.enterToFirstNameTextboxAtAddANewAddress(firstname);

		log.info("Add New Address - Step 05: Enter to 'Last name' Textbox with value '" + lastname + "' At Add a new address");
		customersPage.enterToLastNameTextboxAtAddANewAddress(lastname);

		log.info("Add New Address - Step 06: Enter to 'Email' Textbox with value '" + email + "' At Add a new address");
		customersPage.enterToEmailTextboxAtAddANewAddress(email);

		log.info("Add New Address - Step 07: Enter to 'Company' Textbox with value '" + companyName + "' At Add a new address");
		customersPage.enterToCompanyTextboxAtAddANewAddress(companyName);

		log.info("Add New Address - Step 08: Select to 'Country' Dropdown with value '" + counTry + "' At Add a new address");
		customersPage.selectToCountryDropdownAtAddANewAddress(counTry);

		log.info("Add New Address - Step 09: Select to 'State / province' Dropdown with value '" + state + "' At Add a new address");
		customersPage.selectToStateDropdownAtAddANewAddress(state);

		log.info("Add New Address - Step 10: Enter to 'City' Textbox with value '" + city + "' At Add a new address");
		customersPage.enterToCityTextboxAtAddANewAddress(city);

		log.info("Add New Address - Step 11: Enter to 'Address 1' Textbox with value '" + address1 + "' At Add a new address");
		customersPage.enterToAddress1TextboxAtAddANewAddress(address1);

		log.info("Add New Address - Step 12: Enter to 'Address 2' Textbox with value '" + address2 + "' At Add a new address");
		customersPage.enterToAddress2TextboxAtAddANewAddress(address2);

		log.info("Add New Address - Step 13: Enter to 'Zip / postal code' Textbox with value '" + zipCode + "' At Add a new address");
		customersPage.enterToZipCodeTextboxAtAddANewAddress(zipCode);

		log.info("Add New Address - Step 14: Enter to 'Phone number' Textbox with value '" + phoneNumber + "' At Add a new address");
		customersPage.enterToPhoneNumberTextboxAtAddANewAddress(phoneNumber);

		log.info("Add New Address - Step 15: Enter to 'Fax number' Textbox with value '" + faxNumber + "' At Add a new address");
		customersPage.enterToFaxNumberTextboxAtAddANewAddress(faxNumber);

		log.info("Add New Address - Step 16: Click to 'Save' Button At Add a new address");
		customersPage.clickToSaveButtonAtAddANewAddress();

		log.info("Add New Address - Step 17: Verify Success Message is displayed with value 'The new address has been added successfully.'");
		verifyEquals(customersPage.getSuccessMessage(), "×" + "\n" + "The new address has been added successfully.");

		log.info("Add New Address - Step 18: Verify Infor New Address is displayed correctly At Add a new address");
		verifyEquals(customersPage.getFirstNameValueAtAddANewAddress(), firstname);
		verifyEquals(customersPage.getLastNameValueAtAddANewAddress(), lastname);
		verifyEquals(customersPage.getEmailValueAtAddANewAddress(), email);
		verifyEquals(customersPage.getCompanyValueAtAddANewAddress(), companyName);
		verifyEquals(customersPage.getCountryValueAtAddANewAddress(), counTry);
		verifyEquals(customersPage.getStateValueAtAddANewAddress(), state);
		verifyEquals(customersPage.getCityValueAtAddANewAddress(), city);
		verifyEquals(customersPage.getAddress1ValueAtAddANewAddress(), address1);
		verifyEquals(customersPage.getAddress2ValueAtAddANewAddress(), address2);
		verifyEquals(customersPage.getZipCodeValueAtAddANewAddress(), zipCode);
		verifyEquals(customersPage.getPhoneNumberValueAtAddANewAddress(), phoneNumber);
		verifyEquals(customersPage.getFaxNumberValueAtAddANewAddress(), faxNumber);

		log.info("Add New Address - Step 19: Click to 'back to customer details' Button At Add a new address");
		customersPage.clickToBackToCustomerDetails();

		log.info("Add New Address - Step 20: Click to 'Addresses' Panel At Customer Detail");
		customersPage.openToPanelByPanelID(driver, "customer-address");

		log.info("Add New Address - Step 21: Verify Info New Address is displayed correctly in table");
		verifyTrue(customersPage.areInforNewAddressDisplayedInTable(firstname, lastname, email, phoneNumber, faxNumber, companyName, address1, address2, city, zipCode, counTry));
	}

	@Test(dependsOnMethods = { "TC_01_Create_New_Customer", "TC_05_Search_Customer_With_Full_Data", "TC_06_Edit_Customer", "TC_07_Add_New_Address_At_Customer_Detail" })
	public void TC_08_Edit_Address_At_Customer_Detail() {
		log.info("Edit Address - Step 01: Click to 'Edit' Button in Table");
		customersPage.clickToEditAddressAtCustomerDetails(firstname, lastname, email, phoneNumber, faxNumber, companyName, address1, address2, city, zipCode, counTry);

		log.info("Edit Address - Step 02: Enter to 'First name' Textbox with value '" + editFirstname + "' At Add a new address");
		customersPage.enterToFirstNameTextboxAtAddANewAddress(editFirstname);

		log.info("Edit Address - Step 03: Enter to 'Last name' Textbox with value '" + editLastname + "' At Add a new address");
		customersPage.enterToLastNameTextboxAtAddANewAddress(editLastname);

		log.info("Edit Address - Step 04: Enter to 'Email' Textbox with value '" + editEmail + "' At Add a new address");
		customersPage.enterToEmailTextboxAtAddANewAddress(editEmail);

		log.info("Edit Address - Step 05: Enter to 'Company' Textbox with value '" + editCompanyName + "' At Add a new address");
		customersPage.enterToCompanyTextboxAtAddANewAddress(editCompanyName);

		log.info("Edit Address - Step 06: Select to 'Country' Dropdown with value '" + editCounTry + "' At Add a new address");
		customersPage.selectToCountryDropdownAtAddANewAddress(editCounTry);

		log.info("Edit Address - Step 07: Select to 'State / province' Dropdown with value '" + editState + "' At Add a new address");
		customersPage.selectToStateDropdownAtAddANewAddress(editState);

		log.info("Edit Address - Step 08: Enter to 'City' Textbox with value '" + editCity + "' At Add a new address");
		customersPage.enterToCityTextboxAtAddANewAddress(editCity);

		log.info("Edit Address - Step 09: Enter to 'Address 1' Textbox with value '" + editAddress1 + "' At Add a new address");
		customersPage.enterToAddress1TextboxAtAddANewAddress(editAddress1);

		log.info("Edit Address - Step 10: Enter to 'Address 2' Textbox with value '" + editAddress2 + "' At Add a new address");
		customersPage.enterToAddress2TextboxAtAddANewAddress(editAddress2);

		log.info("Edit Address - Step 11: Enter to 'Zip / postal code' Textbox with value '" + editZipCode + "' At Add a new address");
		customersPage.enterToZipCodeTextboxAtAddANewAddress(editZipCode);

		log.info("Edit Address - Step 12: Enter to 'Phone number' Textbox with value '" + editPhoneNumber + "' At Add a new address");
		customersPage.enterToPhoneNumberTextboxAtAddANewAddress(editPhoneNumber);

		log.info("Edit Address - Step 13: Enter to 'Fax number' Textbox with value '" + editFaxNumber + "' At Add a new address");
		customersPage.enterToFaxNumberTextboxAtAddANewAddress(editFaxNumber);

		log.info("Edit Address - Step 14: Click to 'Save' Button At Add a new address");
		customersPage.clickToSaveButton();

		log.info("Edit Address - Step 15: Verify Success Message is displayed with value 'The address has been updated successfully.'");
		verifyEquals(customersPage.getSuccessMessage(), "×" + "\n" + "The address has been updated successfully.");

		log.info("Edit Address - Step 16: Verify Infor New Address is edited correctly At Add a new address");
		verifyEquals(customersPage.getFirstNameValueAtAddANewAddress(), editFirstname);
		verifyEquals(customersPage.getLastNameValueAtAddANewAddress(), editLastname);
		verifyEquals(customersPage.getEmailValueAtAddANewAddress(), editEmail);
		verifyEquals(customersPage.getCompanyValueAtAddANewAddress(), editCompanyName);
		verifyEquals(customersPage.getCountryValueAtAddANewAddress(), editCounTry);
		verifyEquals(customersPage.getStateValueAtAddANewAddress(), editState);
		verifyEquals(customersPage.getCityValueAtAddANewAddress(), editCity);
		verifyEquals(customersPage.getAddress1ValueAtAddANewAddress(), editAddress1);
		verifyEquals(customersPage.getAddress2ValueAtAddANewAddress(), editAddress2);
		verifyEquals(customersPage.getZipCodeValueAtAddANewAddress(), editZipCode);
		verifyEquals(customersPage.getPhoneNumberValueAtAddANewAddress(), editPhoneNumber);
		verifyEquals(customersPage.getFaxNumberValueAtAddANewAddress(), editFaxNumber);

		log.info("Edit Address - Step 17: Click to 'back to customer details' Button At Add a new address");
		customersPage.clickToBackToCustomerDetails();

		log.info("Edit Address - Step 18: Click to 'Addresses' Panel At Customer Detail");
		customersPage.openToPanelByPanelID(driver, "customer-address");

		log.info("Edit Address - Step 19: Verify Info New Address is displayed correctly in table");
		verifyTrue(customersPage.areInforNewAddressHasStateDisplayedInTable(editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry));
	}

	@Test(dependsOnMethods = { "TC_01_Create_New_Customer", "TC_05_Search_Customer_With_Full_Data", "TC_06_Edit_Customer", "TC_07_Add_New_Address_At_Customer_Detail","TC_08_Edit_Address_At_Customer_Detail"})
	public void TC_09_Delete_Address_At_Customer_Detail() {
		log.info("Delete Address - Step 01: Click to 'Delete' Button");
		customersPage.clickToDeleteAddressHasStateAtCustomerDetails(editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry);
		
		log.info("Delete Address - Step 02: Click to 'OK' in Popup Alert");
		customersPage.acceptAlert(driver);
		customersPage.WaitForLoadingIconInvisibleAtAdmin(driver);
		
		log.info("Delete Address - Step 03: Verify Info Address are Undisplayed");
		verifyTrue(customersPage.areInforNewAddressHasStateUndisplayedInTable(editFirstname, editLastname, editEmail, editPhoneNumber, editFaxNumber, editCompanyName, editAddress1, editAddress2, editCity, editState, editZipCode, editCounTry));
		
		log.info("Delete Address - Step 04: Verify 'No data available in table' Text is Displayed");
		verifyEquals(customersPage.getNoDataAvailableInTable(), "No data available in table");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductsPO productsPage;
	AdminCustomersPO customersPage;
	FakerConfig fakeData;

	String emailAdmin, passwordAdmin;
	String email, password, firstname, lastname, dateOfBirth, companyName, customerRole, adminComment;
	String editEmail, editFirstname, editLastname, editDateOfBirth, editCompanyName, editAdminComment, editFullname, editMonth, editDay;
	String emailGuest, activeStatus, fullname, month, day;
	String counTry, state, city, zipCode, address1, address2, phoneNumber, faxNumber;
	String editCounTry, editState, editCity, editZipCode, editAddress1, editAddress2, editPhoneNumber, editFaxNumber;
}
