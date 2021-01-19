package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserChangePasswordPO;
import pageObjects.nopCommerce.UserComputersDetailPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserProductReviewsPO;
import pageObjects.nopCommerce.UserRegisterPO;
import pageUIs.nopCommerce.NopcommerceAbstractPageUI;
import utilities.FakerConfig;

public class User_03_Add_Edit_Info_User extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		fakeData = FakerConfig.getFakeData();
		email = fakeData.getEmailAddress();
		password = fakeData.getPassword();
		newPassword = fakeData.getPassword();

		firstName = fakeData.getFirstname();
		lastName = fakeData.getLastname();
		date = "21";
		month = "August";
		year = "1996";
		company = fakeData.getCompanyName();

		editFirstName = fakeData.getFirstname();
		editLastName = fakeData.getLastname();
		editDate = "1";
		editMonth = "January";
		editYear = "1999";
		editCompany = fakeData.getCompanyName();
		editEmail = fakeData.getEmailAddress();

		counTry = "United States";
		state = "New York";
		city = fakeData.getCityName();
		address1 = fakeData.getAddress();
		address2 = fakeData.getAddress();
		zip = fakeData.getZipCode();
		phoneNumber = fakeData.getPhoneNumber();
		faxNumber = "1234567890";

		reviewTitle = "Some sample review";
		reviewText = "This sample review is for the Build your own computer. I've been waiting for this product to be available. It is priced just right.";
		
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Click to 'Register' click");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-condition - Step 02: Click to 'Gender Male' Radio button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Pre-condition - Step 03: Enter to 'FirstName' textbox");
		registerPage.enterToFirstNameTextbox(firstName);

		log.info("Pre-condition - Step 04: Enter to 'LastName' textbox");
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Pre-condition - Step 05: Select 'date' dropdown");
		registerPage.selectDayDropdown(date);

		log.info("Pre-condition - Step 06: Select 'month' dropdown");
		registerPage.selectMonthDropdown(month);

		log.info("Pre-condition - Step 07: Select 'year' dropdown");
		registerPage.selectYearDropdown(year);

		log.info("Pre-condition - Step 08: Enter to 'Email' textbox with value '" + email + "'");
		registerPage.enterToEmailextbox(email);

		log.info("Pre-condition - Step 09: Enter to 'Company' textbox");
		registerPage.enterToCompanyTextbox(company);

		log.info("Pre-condition - Step 10: Enter to 'Password' textbox with value '" + password + "'");
		registerPage.enterToPasswordTextbox(password);

		log.info("Pre-condition - Step 11: Enter to 'ConfirmPassword' textbox with value '" + password + "'");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 12: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 13: Verify 'Register' Success Message is displayed successfully with value 'Your registration completed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_01_Customer_Infor() {
		log.info("My Account [Customer Info] - Step 01: Click to 'My account' Button");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("My Account [Customer Info] - Step 02: Click to 'Gender Female' Radio Button");
		customerInforPage.clickToGenderFemaleRadioButton();

		log.info("My Account [Customer Info] - Step 03: Enter to 'FirstName' Textbox");
		customerInforPage.enterToFirstNameTextbox(editFirstName);

		log.info("My Account [Customer Info] - Step 04: Click to 'LastName' Textbox");
		customerInforPage.enterToLastNameTextbox(editLastName);

		log.info("My Account [Customer Info] - Step 05: Select 'Date' Dropdown");
		customerInforPage.selectDayDropdown(editDate);

		log.info("My Account [Customer Info] - Step 06: Select 'Month' Dropdown");
		customerInforPage.selectMonthDropdown(editMonth);

		log.info("My Account [Customer Info] - Step 07: Select 'Year' Dropdown");
		customerInforPage.selectYearDropdown(editYear);

		log.info("My Account [Customer Info] - Step 08: Enter to 'Email' Textbox");
		customerInforPage.enterToEmailTextbox(editEmail);

		log.info("My Account [Customer Info] - Step 09: Enter to 'Company' Textbox");
		customerInforPage.sendkeyToCompanyTextbox(editCompany);

		log.info("My Account [Customer Info] - Step 10: Click to 'Save' Button");
		customerInforPage.clickToSaveButton();

		log.info("My Account [Customer Info] - Step 11: Verify 'Gender FeMale' Radio Button edit successfully");
		verifyTrue(customerInforPage.isGenderFemaleRadioButtonSelected());

		log.info("My Account [Customer Info] - Step 12: Verify 'FirstName' Text Box edit successfully");
		verifyEquals(customerInforPage.getFirstNameTextboxValue(), editFirstName);

		log.info("My Account [Customer Info] - Step 13: Verify 'FirstName' Text Box edit successfully");
		verifyEquals(customerInforPage.getLastNameTextboxValue(), editLastName);

		log.info("My Account [Customer Info] - Step 14: Verify 'Date' Dropdown edit successfully");
		verifyEquals(customerInforPage.getSelectedTextInDayDropdown(), editDate);

		log.info("My Account [Customer Info] - Step 15: Verify 'Moth' Dropdown edit successfully");
		verifyEquals(customerInforPage.getSelectedTextInMonthDropdown(), editMonth);

		log.info("My Account [Customer Info] - Step 16: Verify 'Year' Dropdown edit successfully");
		verifyEquals(customerInforPage.getSelectedTextInYearDropdown(), editYear);

		log.info("My Account [Customer Info] - Step 17: Verify 'Email' Text Box edit successfully");
		verifyEquals(customerInforPage.getEmailTextboxValue(), editEmail);

		log.info("My Account [Customer Info] - Step 18: Verify 'Company' Text Box edit successfully");
		verifyEquals(customerInforPage.getCompanyTextboxValue(), editCompany);

		log.info("My Account [Customer Info] - Step 19: Verify 'Newsletter' Checkbox edit successfully");
		verifyTrue(customerInforPage.isNewsletterCheckboxSelected());

	}

	@Test
	public void TC_02_Addresses() {
		log.info("My Account [Address] - Step 01: Click to 'Address' link");
		customerInforPage.clickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		log.info("My Account [Address] - Step 02: Click to 'Add New' Button");
		addressesPage.ClickToAddNewButton();

		log.info("My Account [Address] - Step 03: Enter to 'FirstName' Textbox");
		addressesPage.enterToFirstNameTextbox(editFirstName);

		log.info("My Account [Address] - Step 04: Enter to 'LastName' Textbox");
		addressesPage.enterToLastNameTextbox(editLastName);

		log.info("My Account [Address] - Step 05: Enter to 'Email' Textbox");
		addressesPage.enterToEmailTextbox(editEmail);

		log.info("My Account [Address] - Step 06: Enter to 'Company' Textbox");
		addressesPage.enterToCompanyTextbox(editCompany);

		log.info("My Account [Address] - Step 07: Select 'Country' Dropdown");
		addressesPage.SelectCounTryDropdown(counTry);

		log.info("My Account [Address] - Step 08: Select 'State' Dropdown");
		addressesPage.SelectStateDropdown(state);

		log.info("My Account [Address] - Step 09: Enter to 'City' Textbox");
		addressesPage.enterToCityTextbox(city);

		log.info("My Account [Address] - Step 10: Enter to 'Address1' Textbox");
		addressesPage.enterToAddress1Textbox(address1);

		log.info("My Account [Address] - Step 11: Enter to 'Address2' Textbox");
		addressesPage.enterToAddress2Textbox(address2);

		log.info("My Account [Address] - Step 12:Enter to 'Zip' Textbox");
		addressesPage.enterToZipTextbox(zip);

		log.info("My Account [Address] - Enter to 'Phone number' Textbox");
		addressesPage.enterToPhoneNumberTextbox(phoneNumber);

		log.info("My Account [Address] - Step 14: Enter to 'Fax number' Textbox");
		addressesPage.enterToFaxNumberTextbox(faxNumber);

		log.info("My Account [Address] - Step 15: Click to 'Save' Button");
		addressesPage.ClickToSaveButton();

		log.info("My Account [Address] - Step 16: Verify 'FullName' is displayed correctly");
		verifyEquals(addressesPage.getNameValue(), editFirstName + " " + editLastName);
		
		log.info("My Account [Address] - Step 17: Verify 'Email' is displayed correctly");
		verifyEquals(addressesPage.getEmailValue(), "Email: " + editEmail);
		
		log.info("My Account [Address] - Step 18: Verify 'Phone number' is displayed correctly");
		verifyEquals(addressesPage.getPhoneNumberValue(), "Phone number: " + phoneNumber);
		
		log.info("My Account [Address] - Step 19: Verify 'Fax number' is displayed correctly");
		verifyEquals(addressesPage.getFaxNumberValue(), "Fax number: " + faxNumber);
		
		log.info("My Account [Address] - Step 20: Verify 'Company' is displayed correctly");
		verifyEquals(addressesPage.getCompanyValue(), editCompany);
		
		log.info("My Account [Address] - Step 21: Verify 'Address1' is displayed correctly");
		verifyEquals(addressesPage.getAddress1Value(), address1);
		
		log.info("My Account [Address] - Step 22: Verify 'Address2' is displayed correctly");
		verifyEquals(addressesPage.getAddress2Value(), address2);
		
		log.info("My Account [Address] - Step 23: Verify 'City' is displayed correctly");
		verifyEquals(addressesPage.getCityStateZipValue(), city + ", " + state + ", " + zip);
		
		log.info("My Account [Address] - Step 24: Verify 'Country' is displayed correctly");
		verifyEquals(addressesPage.getCounTryValue(), counTry);

	}

	@Test
	public void TC_03_Change_Password() {
		log.info("My Account [Change Password] - Step 01: Click to 'Change password' Link");
		addressesPage.clickToLinkWithPageName(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);
		
		log.info("My Account [Change Password] - Step 01: Enter to 'Old password' Textbox");
		changePasswordPage.enterToOldPasswordTextbox(password);
		
		log.info("My Account [Change Password] - Step 02: Enter to 'New password' Textbox");
		changePasswordPage.enterToNewPasswordTextbox(newPassword);
		
		log.info("My Account [Change Password] - Step 03: Enter to 'Confirm password' Textbox");
		changePasswordPage.enterToConfirmPasswordTextbox(newPassword);
		
		log.info("My Account [Change Password] - Step 04: Click to 'Change password' Button");
		changePasswordPage.clickToChangePasswordButton();
		
		log.info("My Account [Change Password] - Step 05: Verify Success Message is displayed with value 'Password was changed'");
		Assert.assertEquals(changePasswordPage.getSuccessMessageOfChangePassword(), "Password was changed");

		log.info("My Account [Change Password] - Step 06: Click to 'Log out' Link");
		homePage = changePasswordPage.ClickToLogoutLink();
		
		log.info("My Account [Change Password] - Step 07: Click to 'Log in' Link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("My Account [Change Password] - Step 08: Enter to 'Email' Textbox with value '"+ editEmail +"'");
		loginPage.enterToEmailTextbox(editEmail);
		
		log.info("My Account [Change Password] - Step 09: Enter to 'Password' Textbox with value '"+ password +"'");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("My Account [Change Password] - Step 10: Click to 'Login' Button");
		loginPage.clickToLoginButton();

		log.info("My Account [Change Password] - Verify Error Message is displayed with value 'Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect'");
		verifyEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
		loginPage.sleepInSecond(5);
		
		log.info("My Account [Change Password] - Step 12: Enter to 'Password' Textbox with value '"+ newPassword +"'");
		loginPage.enterToPasswordTextbox(newPassword);
		
		log.info("My Account [Change Password] - Step 13: Click to 'Login' Button");
		homePage = loginPage.clickToLoginButton();

		log.info("My Account [Change Password] - Step 14: Verify 'Log out' link is displayed successfully");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("My Account [Change Password] - Step 15: Verify 'My Account' link is displayed successfully");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_04_My_Product_Reviews() {
		log.info("My Account [Product Reviews] - Step 01: Scroll to 'Build your own computer' Text");
		homePage.scrollToElement(driver, NopcommerceAbstractPageUI.ITEM_LINK_BY_PRODUCT_NAME, "Build your own computer");
		
		log.info("My Account [Product Reviews] - Step 02: Click to 'Build your own computer' Text");
		homePage.clickToItemLinkByProductName(driver, "Build your own computer");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);
		
		log.info("My Account [Product Reviews] - Step 03: click to 'Add your review' Link");
		productReviewsPage = computersDetailPage.clickToAddYourReviewButton();
		
		log.info("My Account [Product Reviews] - Step 04: Enter to 'Review title' Textbox");
		productReviewsPage.enterToReviewTitleTextbox(reviewTitle);
		
		log.info("My Account [Product Reviews] - Step 05: Enter to 'Review text' Textbox");
		productReviewsPage.enterToReviewTextTextbox(reviewText);
		
		log.info("My Account [Product Reviews] - Step 06: click to 'Rating' Radio Button");
		productReviewsPage.clickToRatingRadioButton("3");
		
		log.info("My Account [Product Reviews] - Step 07: click to 'Submit review' Button");
		productReviewsPage.clickToSubmitReviewButton();
		
		log.info("My Account [Product Reviews] - Step 08: Verify Success Message is displayed with value 'Product review is successfully added.'");
		verifyEquals(productReviewsPage.getSuccessMessageofProductReview(), "Product review is successfully added.");
		
		log.info("My Account [Product Reviews] - Step 09: click to 'My Account' Link");
		productReviewsPage.clickToLinkByClass(driver, "ico-account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("My Account [Product Reviews] - Step 10: click to 'My product reviews' Link");
		customerInforPage.clickToLinkWithPageName(driver, "My product reviews");
		myProductReviewsPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		log.info("My Account [Product Reviews] - Step 11: Verify review is displayed successfully");
		verifyTrue(myProductReviewsPage.isProductReviewDisplayed(reviewTitle));
		loginPage.sleepInSecond(5);
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	UserRegisterPO registerPage;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserChangePasswordPO changePasswordPage;
	UserComputersDetailPO computersDetailPage;
	UserProductReviewsPO productReviewsPage;
	UserMyProductReviewPO myProductReviewsPage;
	
	FakerConfig fakeData;

	String email, password, newPassword;
	String firstName, lastName, date, month, year, company;
	String editEmail, editFirstName, editLastName, editDate, editMonth, editYear, editCompany;
	String counTry, state, city, address1, address2, zip, phoneNumber, faxNumber;
	String reviewTitle, reviewText;
}
