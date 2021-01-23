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
		log.info("Create New Customer - Step 01: Click to 'Add new' Button ");
		customersPage.clickToAddNewButton();

		log.info("Create New Customer - Step 02: Enter to 'Email' Textbox");
		customersPage.enterToEmailTextbox(email);

		log.info("Create New Customer - Step 03: Enter to 'Password' Textbox");
		customersPage.enterToPasswordTextbox(password);

		log.info("Create New Customer - Step 04: Enter to 'First name' Textbox");
		customersPage.enterToFirstNameTextbox(firstname);

		log.info("Create New Customer - Step 05: Enter to 'Last name' Textbox");
		customersPage.enterToLastNameTextbox(lastname);

		log.info("Create New Customer - Step 06: Click to 'GenderMale' Radio Button");
		customersPage.clickToGenderMaleRadioButton();

		log.info("Create New Customer - Step 07: Enter to 'Date of birth' Textbox");
		customersPage.enterToDateOfBirthTextbox(dateOfBirth);

		log.info("Create New Customer - Step 08: Enter to 'Company name' Textbox");
		customersPage.enterToCompanyNameTextbox(companyName);

		log.info("Create New Customer - Step 09: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Create New Customer - Step 10: Select 'Customer roles' Dropdown");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Create New Customer - Step 11: Enter to 'Admin comment' Textbox");
		customersPage.enterToAdminCommentTextbox(adminComment);

		log.info("Create New Customer - Step 12: Click to 'Save and Continue Edit'");
		customersPage.clickToSaveAndContinueEdit();

		log.info("Create New Customer - Step 13: Verify Success Message is displayed with value 'The new customer has been added successfully.'");
		verifyEquals(customersPage.getSuccessMessage(), "×" + "\n" + "The new customer has been added successfully.");

		log.info("Create New Customer - Step 14: Verify Infomation Customer Details are displayed correctly");
		verifyEquals(customersPage.getEmailValue(), email);
		verifyEquals(customersPage.getFirstNameValue(), firstname);
		verifyEquals(customersPage.getLastNameValue(), lastname);
		verifyTrue(customersPage.isGenderMaleChecked());
		verifyEquals(customersPage.getDateOfBirthValue(), dateOfBirth);
		verifyEquals(customersPage.getCompanyNameValue(), companyName);
		verifyEquals(customersPage.getCustomerRolesValue(), customerRole);
		verifyEquals(customersPage.getAdminCommentValue(), adminComment);

		log.info("Create New Customer - Step 15: Click to 'back to customer list' Link");
		customersPage.clickToBackToCustomerList();

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

		log.info("Search Customer [Email] - Step 02: Enter to 'Email' Textbox in 'Search' section");
		customersPage.enterToEmailTextboxInSearchSection(email);

		log.info("Search Customer [Email] - Step 03: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Email] - Step 04: Select 'Customer roles' Dropdown");
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

		log.info("Search Customer [FirstName and LastName] - Step 02: Enter to 'Firstname' Textbox in 'Search' section");
		customersPage.enterToFirstNameTextboxInSearchSection(firstname);

		log.info("Search Customer [FirstName and LastName] - Step 03: Enter to 'Lastname' Textbox in 'Search' section");
		customersPage.enterToLastNameTextboxInSearchSection(lastname);

		log.info("Search Customer [FirstName and LastName] - Step 04: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [FirstName and LastName] - Step 05: Select 'Customer roles' Dropdown");
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

		log.info("Search Customer [Company] - Step 02: Enter to 'Company' Textbox in 'Search' section");
		customersPage.enterToCompanyTextboxInSearchSection(companyName);

		log.info("Search Customer [Company] - Step 03: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Company] - Step 04: Select 'Customer roles' Dropdown");
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

		log.info("Search Customer [Full Data] - Step 02: Enter to 'Email' Textbox in 'Search' section");
		customersPage.enterToEmailTextboxInSearchSection(email);

		log.info("Search Customer [Full Data] - Step 03: Enter to 'Firstname' Textbox in 'Search' section");
		customersPage.enterToFirstNameTextboxInSearchSection(firstname);

		log.info("Search Customer [Full Data] - Step 04: Enter to 'Lastname' Textbox in 'Search' section");
		customersPage.enterToLastNameTextboxInSearchSection(lastname);

		log.info("Search Customer [Full Data] - Step 05: Select 'Month' Dropdown with value ''");
		customersPage.selectToMonthDropdownInSearchSection(month);

		log.info("Search Customer [Full Data] - Step 06: Select 'Day' Dropdown with value ''");
		customersPage.selectToDayDropdownInSearchSection(day);

		log.info("Search Customer [Full Data] - Step 07: Enter to 'Company' Textbox in 'Search' section");
		customersPage.enterToCompanyTextboxInSearchSection(companyName);

		log.info("Search Customer [Full Data] - Step 08: Click to 'X' Button at 'Customer roles' Textbox");
		customersPage.clickToDeleteButtonInCustomerRolesTextbox();

		log.info("Search Customer [Full Data] - Step 09: Select 'Customer roles' Dropdown");
		customersPage.selectToCustomerRolesDropdown();

		log.info("Search Customer [Full Data] - Step 10: Click to 'Search' Button");
		customersPage.clickToSearchButton();

		log.info("Search Customer [Full Data] - Step 11: Verify Infomation Customer is displayed in table");
		verifyTrue(customersPage.areInforCustomerDisplayedInTable(emailGuest, fullname, customerRole, companyName, activeStatus));

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
	String emailGuest, activeStatus, fullname, month, day;
}
