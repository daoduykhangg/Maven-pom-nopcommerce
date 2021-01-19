package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserRegisterPO;
import utilities.FakerConfig;

public class User_02_Login_User extends AbstractTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		fakeData = FakerConfig.getFakeData();
		firstName = fakeData.getFirstname();
        lastName = fakeData.getLastname();
        date = "21";
        month = "August";
        year = "1996";
        email = fakeData.getEmailAddress();
        company = fakeData.getCompanyName();
		invaidEmail = "duykhangqa";
		unregisteredEmail = fakeData.getEmailAddress();
		invalidPassword = "123456";
		password = "123123";
		
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

        log.info("Pre-condition - Step 08: Enter to 'Email' textbox with value '"+ email +"'");
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
        
        log.info("Pre-condition - Step 14: Click to 'Log out' link and navigate to Home Page");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		log.info("Login [Empty Data] - Step 01: Click to 'Log in' link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login [Empty Data] - Step 02: Click to 'Log in' button");
		loginPage.clickToLoginButton();

		log.info("Login [Empty Data] - Step 03: Verify Error Message is displayed successfully with value 'Please enter your email'");
		verifyEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		log.info("Login [Invalid Email] - Step 01: Refresh current page");
		loginPage.refreshCurrentPageNopcommerce(driver);
		
		log.info("Login [Invalid Email] - Step 02: Enter to 'Email' Textbox");
		loginPage.enterToEmailTextbox(invaidEmail);
		
		log.info("Login [Invalid Email] - Step 03: Enter to 'Password' Textbox");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login [Invalid Email] - Step 04: Click to 'Login' button");
		loginPage.clickToLoginButton();

		log.info("Login [Invalid Email] - Step 05: Verify Error Message is displayed successfully with value 'Wrong email'");
		verifyEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_Unregistered_Email() {
		log.info("Login [Unregistered Email] - Step 01: Refresh current page");
		loginPage.refreshCurrentPageNopcommerce(driver);
		
		log.info("Login [Unregistered Email] - Step 02: Enter to 'Email' Textbox");
		loginPage.enterToEmailTextbox(unregisteredEmail);
		
		log.info("Login [Unregistered Email] - Step 03: Enter to 'Password' Textbox");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login [Unregistered Email] - Step 04: Click to 'Login' button");
		loginPage.clickToLoginButton();

		log.info("Login [Unregistered Email] - Step 05: Verify Error Message is displayed successfully with value 'Login was unsuccessful. Please correct the errors and try again. No customer account found'");
		verifyEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_Valid_Email_Empty_Password() {
		log.info("Login [Empty Password] - Step 01: Refresh current page");
		loginPage.refreshCurrentPageNopcommerce(driver);
		
		log.info("Login [Empty Password] - Step 02: Enter to 'Email' Textbox");
		loginPage.enterToEmailTextbox(email);
		
		log.info("Login [Empty Password] - Step 03: Click to 'Login' button");
		loginPage.clickToLoginButton();

		log.info("Login [Empty Password] - Step 04: Verify Error Message is displayed successfully with value 'Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect'");

		verifyEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Valid_Email_invalid_Password() {
		log.info("Login [InValid Password] - Step 01: Refresh current page");
		loginPage.refreshCurrentPageNopcommerce(driver);
		
		log.info("Login [InValid Password] - Step 02: Enter to 'Email' Textbox");
		loginPage.enterToEmailTextbox(email);
		
		log.info("Login [InValid Password] - Step 03: Enter to 'Password' Textbox");
		loginPage.enterToPasswordTextbox(invalidPassword);
		
		log.info("Login [InValid Password] - Step 04: Click to 'Login' button");
		loginPage.clickToLoginButton();
		
		log.info("Login [InValid Password] - Step 05: Verify Error Message is displayed successfully with value 'Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect'");
		verifyEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Valid_Email_And_Password() {
		log.info("Login [Valid Data] - Step 01: Refresh current page");
		loginPage.refreshCurrentPageNopcommerce(driver);
		
		
		log.info("Login [Valid Data] - Step 02: Enter to 'Email' Textbox");
		loginPage.enterToEmailTextbox(email);
		
		log.info("Login [Valid Data] - Step 03: Enter to 'Password' Textbox");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login [Valid Data] - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login [Valid Data] - Step 05: Verify 'Log out' link is displayed successfully");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login [Valid Data] - Step 06: Verify 'My Account' link is displayed successfully");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	FakerConfig fakeData;
	UserRegisterPO registerPage;
	
	String firstName, lastName, email, company, password, date, month, year;
	String invaidEmail, unregisteredEmail, invalidPassword;

}
