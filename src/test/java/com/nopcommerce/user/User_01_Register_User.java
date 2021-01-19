package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserRegisterPO;
import utilities.FakerConfig;

public class User_01_Register_User extends AbstractTest {
 
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeTest(String browserName, String urlValue) {
        driver = getBrowserDriver(browserName, urlValue);

        fakeData = FakerConfig.getFakeData();
        firstName = fakeData.getFirstname();
        lastName = fakeData.getLastname();
        date = "21";
        month = "August";
        year = "1996";
        email = fakeData.getEmailAddress();
        company = fakeData.getCompanyName();
        password = fakeData.getPassword();

        invaidEmail = "duykhangqa";
        existEmail = fakeData.getEmailAddress();
        invalidPassword = "123";

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

        log.info("Pre-condition - Step 08: Enter to 'Email' textbox with value '"+ existEmail +"'");
        registerPage.enterToEmailextbox(existEmail);

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
    public void TC_01_Register_Empty_Data() {
        log.info("Register [Empty Data] - Step 01: Click to 'Register' link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register [Empty Data] - Step 02: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        log.info("Register [Empty Data] - Step 03: Verify 'First name' Error Message is displayed successfully");
        verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

        log.info("Register [Empty Data] - Step 04: Verify 'Last name' Error Message is displayed successfully");
        verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

        log.info("Register [Empty Data] - Step 05: Verify 'Email' Error Message is displayed successfully");
        verifyEquals(registerPage.getEmailErrorMessage(), "Email is required.");

        log.info("Register [Empty Data] - Step 06: Verify 'Password' Error Message is displayed successfully");
        verifyEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

        log.info("Register [Empty Data] - Step 07: Verify 'Confirm Password' Error Message is displayed successfully");
        verifyEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        log.info("Register [Invalid Email] - Step 01: Refresh current page");
        registerPage.refreshCurrentPage(driver);

        log.info("Register [Invalid Email] - Step 02: Click to 'Gender Male' Radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("Register [Invalid Email] - Step 03: Enter to 'FirstName' textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register [Invalid Email] - Step 04: Enter to 'LastName' textbox");
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register [Invalid Email] - Step 05: Select 'date' dropdown");
        registerPage.selectDayDropdown(date);

        log.info("Register [Invalid Email] - Step 06: Select 'month' dropdown");
        registerPage.selectMonthDropdown(month);

        log.info("Register [Invalid Email] - Step 07: Select 'year' dropdown");
        registerPage.selectYearDropdown(year);

        log.info("Register [Invalid Email] - Step 08: Enter to 'Email' textbox with value '" + invaidEmail + "'");
        registerPage.enterToEmailextbox(invaidEmail);

        log.info("Register [Invalid Email] - Step 09: Enter to 'Company' textbox");
        registerPage.enterToCompanyTextbox(company);

        log.info("Register [Invalid Email] - Step 10: Enter to 'Password' textbox");
        registerPage.enterToPasswordTextbox(password);

        log.info("Register [Invalid Email] - Step 11: Enter to 'ConfirmPassword' textbox");
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("Register [Invalid Email] - Step 12: Verify 'Wrong email' Error message is displayed successfully with value 'Wrong email'");
        verifyEquals(registerPage.getEmailErrorMessage(), "Wrong email");

    }

    @Test
    public void TC_03_Register_Exist_Email() {
    	log.info("Register [Exist Email] - Step 01: Refresh current page");
        registerPage.refreshCurrentPage(driver);
        
        log.info("Register [Exist Email] - Step 02: Click to 'Gender Male' Radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("Register [Exist Email] - Step 03: Enter to 'FirstName' textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register [Exist Email] - Step 04: Enter to 'LastName' textbox");
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register [Exist Email] - Step 05: Select 'date' dropdown");
        registerPage.selectDayDropdown(date);

        log.info("Register [Exist Email] - Step 06: Select 'month' dropdown");
        registerPage.selectMonthDropdown(month);

        log.info("Register [Exist Email] - Step 07: Select 'year' dropdown");
        registerPage.selectYearDropdown(year);

        log.info("Register [Exist Email] - Step 08: Enter to 'Email' textbox with value '"+ existEmail +"'");
        registerPage.enterToEmailextbox(existEmail);

        log.info("Register [Exist Email] - Step 09: Enter to 'Company' textbox");
        registerPage.enterToCompanyTextbox(company);

        log.info("Register [Exist Email] - Step 10: Enter to 'Password' textbox with value '" + password + "'");
        registerPage.enterToPasswordTextbox(password);

        log.info("Register [Exist Email] - Step 11: Enter to 'ConfirmPassword' textbox with value '" + password + "'");
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("Register [Exist Email] - Step 12: Click to 'Register' button");
        registerPage.clickToRegisterButton();
        
        log.info("Register [Exist Email] - Step 13: Verify Error Message is displayed successfully with value 'The specified email already exists'");
        verifyEquals(registerPage.getExistEmailMessage(), "The specified email already exists");
    }
    
    @Test
    public void TC_04_Register_Password_Less_than_6_Characters() {
        log.info("Register [Password less than 6 Chars] - Step 01: Refresh current page");
        registerPage.refreshCurrentPageNopcommerce(driver);
        
        log.info("Register [Password less than 6 Chars] - Step 02: Click to 'Gender Male' Radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("Register [Password less than 6 Chars] - Step 03: Enter to 'FirstName' textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register [Password less than 6 Chars] - Step 04: Enter to 'LastName' textbox");
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register [Password less than 6 Chars] - Step 05: Select 'date' dropdown");
        registerPage.selectDayDropdown(date);

        log.info("Register [Password less than 6 Chars] - Step 06: Select 'month' dropdown");
        registerPage.selectMonthDropdown(month);

        log.info("Register [Password less than 6 Chars] - Step 07: Select 'year' dropdown");
        registerPage.selectYearDropdown(year);

        log.info("Register [Password less than 6 Chars] - Step 08: Enter to 'Email' textbox");
        registerPage.enterToEmailextbox(email);

        log.info("Register [Password less than 6 Chars] - Step 09: Enter to 'Company' textbox");
        registerPage.enterToCompanyTextbox(company);

        log.info("Register [Password less than 6 Chars] - Step 10: Enter to 'Password' textbox with value '" + invalidPassword + "'");
        registerPage.enterToPasswordTextbox(invalidPassword);

        log.info("Register [Password less than 6 Chars] - Step 11: Enter to 'ConfirmPassword' textbox");
        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        log.info("Register [Password less than 6 Chars] - Step 12: Verify 'Password' Error Message is displayed successfully with value 'Password must meet the following rules: must have at least 6 characters'");
        verifyEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\n" + "must have at least 6 characters");
    }

    @Test
    public void TC_05_Register_Password_And_Confirm_Password_Not_Match() {
        log.info("Register [NOT Match Password and Confirm Password] - Step 01: Refresh current page");
        registerPage.refreshCurrentPageNopcommerce(driver);
        
        log.info("Register [NOT Match Password and Confirm Password] - Step 02: Click to 'Gender Male' Radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("Register [NOT Match Password and Confirm Password] - Step 03: Enter to 'FirstName' textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register [NOT Match Password and Confirm Password] - Step 04: Enter to 'LastName' textbox");
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register [NOT Match Password and Confirm Password] - Step 05: Select 'date' dropdown");
        registerPage.selectDayDropdown(date);

        log.info("Register [NOT Match Password and Confirm Password] - Step 06: Select 'month' dropdown");
        registerPage.selectMonthDropdown(month);

        log.info("Register [NOT Match Password and Confirm Password] - Step 07: Select 'year' dropdown");
        registerPage.selectYearDropdown(year);

        log.info("Register [NOT Match Password and Confirm Password] - Step 08: Enter to 'Email' textbox");
        registerPage.enterToEmailextbox(existEmail);

        log.info("Register [NOT Match Password and Confirm Password] - Step 09: Enter to 'Company' textbox");
        registerPage.enterToCompanyTextbox(company);

        log.info("Register [NOT Match Password and Confirm Password] - Step 10: Enter to 'Password' textbox with value '" + password + "'");
        registerPage.enterToPasswordTextbox(password);

        log.info("Register [NOT Match Password and Confirm Password] - Step 11: Enter to 'ConfirmPassword' textbox with value '" + invalidPassword + "'");
        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        log.info("Register [NOT Match Password and Confirm Password] - Step 12: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        log.info("Register [NOT Match Password and Confirm Password] - Step 13: Verify 'Confirm Password' Error Message is displayed successfully with value 'The password and confirmation password do not match.'");
        verifyEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");

    }

    @Test
    public void TC_06_Register_Valid_Data() {
        log.info("Register [Valid Data] - Step 01: Refresh current page");
        registerPage.refreshCurrentPageNopcommerce(driver);
        
        log.info("Register [Valid Data] - Step 02: Click to 'Gender Male' Radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("Register [Valid Data] - Step 03: Enter to 'FirstName' textbox");
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("Register [Valid Data] - Step 04: Enter to 'LastName' textbox");
        registerPage.enterToLastNameTextbox(lastName);

        log.info("Register [Valid Data] - Step 05: Select 'date' dropdown");
        registerPage.selectDayDropdown(date);

        log.info("Register [Valid Data] - Step 06: Select 'month' dropdown");
        registerPage.selectMonthDropdown(month);

        log.info("Register [Valid Data] - Step 07: Select 'year' dropdown");
        registerPage.selectYearDropdown(year);

        log.info("Register [Valid Data] - Step 08: Enter to 'Email' textbox");
        registerPage.enterToEmailextbox(email);

        log.info("Register [Valid Data] - Step 09: Enter to 'Company' textbox");
        registerPage.enterToCompanyTextbox(company);

        log.info("Register [Valid Data] - Step 10: Enter to 'Password' textbox with value '" + password + "'");
        registerPage.enterToPasswordTextbox(password);

        log.info("Register [Valid Data] - Step 11: Enter to 'ConfirmPassword' textbox with value '" + password + "'");
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("Register [Valid Data] - Step 12: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        log.info("Register [Valid Data] - Step 13: Verify 'Register' Success Message is displayed successfully with value 'Your registration completed");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @AfterClass(alwaysRun = true)
    public void afterTest() {
        closeBrowserAndDriver(driver);
    }
    
    WebDriver driver;
    private UserRegisterPO registerPage;
    private UserHomePO homePage;
    
    FakerConfig fakeData;
    
    String firstName, lastName, email, company, password, date, month, year;
    String invaidEmail, existEmail, invalidPassword;
}
