package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserRegisterPO;
import pageObjects.nopCommerce.UserSearchPO;
import utilities.FakerConfig;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_04_Search_Advanced_Search extends AbstractTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		fakeData = FakerConfig.getFakeData();
		firstName = fakeData.getFirstname();
		lastName = fakeData.getLastname();
		date = "21";
		month = "August";
		year = "1996";
		email = fakeData.getEmailAddress();
		company = fakeData.getCompanyName();
		password = fakeData.getPassword();
		productName = "Apple MacBook Pro";
		
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

		log.info("Pre-condition - Step 14: Click to 'Log out' link and navigate to Home Page");
		registerPage.clickToLinkByClass(driver, "ico-logout");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 15: Click to 'Log in' link");
		homePage.clickToLinkByClass(driver, "ico-login");
		loginPage = PageGeneratorManager.getUserLoginPage(driver);

		log.info("Pre-condition - Step 16: Enter to 'Email' Textbox with value '" + email + "'");
		loginPage.enterToEmailTextbox(email);

		log.info("Pre-condition - Step 17: Enter to 'Password' Textbox with value '" + password + "'");
		loginPage.enterToPasswordTextbox(password);

		log.info("Pre-condition - Step 18: Click to 'Log in' Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-condition - Step 19: Click to 'Search' Link in Footer");
		homePage.clickToLinkByNameInFooter(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		log.info("Search [Empty Data] - Step 01: Click to 'Search' Button");
		searchPage.clickToSearchButton();

		log.info("Search [Empty Data] - Step 02: Veirify Warning Message is displayed with value 'Search term minimum length is 3 characters'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_With_Data_Not_Exist() {
		log.info("Search [Data Not Exist] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);

		log.info("Search [Data Not Exist] - Step 02: Enter to 'Search keyword' Textbox with value 'MacBook Pro 2050'");
		searchPage.enterToSearchTextbox("MacBook Pro 2050");

		log.info("Search [Data Not Exist] - Step 03: Click to 'Search' Buton");
		searchPage.clickToSearchButton();

		log.info("Search [Data Not Exist] - Step 04: Verify Warning Message is displayed with value 'No products were found that matched your criteria.'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_With_Relative_Product_Name() {
		log.info("Search [Relative Product Name] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);

		log.info("Search [Relative Product Name] - Step 02: Enter to 'Search keyword' Textbox with value 'Lenovo'");
		searchPage.enterToSearchTextbox("Lenovo");

		log.info("Search [Relative Product Name] - Step 03: Click to 'Search' Buton");
		searchPage.clickToSearchButton();

		log.info("Search [Relative Product Name] - Step 04: Verify product is displayed correctly");
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void TC_04_Search_With_absolute_Product_Name() {
		log.info("Search [absolute Product Name] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);

		log.info("Search [absolute Product Name] - Step 02: Enter to 'Search keyword' Textbox with value 'Thinkpad X1 Carbon Laptop'");
		searchPage.enterToSearchTextbox("Thinkpad X1 Carbon Laptop");

		log.info("Search [absolute Product Name] - Step 03: Click to 'Search' Buton");
		searchPage.clickToSearchButton();

		log.info("Search [absolute Product Name] - Step 04: Verify product is displayed correctly");
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories() {
		log.info("Advanced Search [Parent Categories] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Parent Categories] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Parent Categories] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Parent Categories] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Parent Categories] - Step 05: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Parent Categories] - Step 06: Verify Warning Message is displayed with value 'No products were found that matched your criteria.'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories() {
		log.info("Advanced Search [Parent Categories] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Parent Categories] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Parent Categories] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Parent Categories] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Parent Categories] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Parent Categories] - Step 06: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Parent Categories] - Step 07: Verify product is displayed correctly");
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer() {
		log.info("Advanced Search [Incorrect Manufacturer] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 06: Select to 'Manufacturer' Dropdown with value 'HP'");
		searchPage.selectToManufacturerDropdown("HP");
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 07: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Incorrect Manufacturer] - Step 08: Verify Warning Message is displayed with value 'No products were found that matched your criteria.'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer() {
		log.info("Advanced Search [Correct Manufacturer] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Correct Manufacturer] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Correct Manufacturer] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Correct Manufacturer] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Correct Manufacturer] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Correct Manufacturer] - Step 06: Select to 'Manufacturer' Dropdown with value 'Apple'");
		searchPage.selectToManufacturerDropdown("Apple");
		
		log.info("Advanced Search [Correct Manufacturer] - Step 07: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Correct Manufacturer] - Step 08: Verify product is displayed correctly");
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_09_Advanced_Search_With_Price_Range() {
		log.info("Advanced Search [Price Range] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Price Range] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Price Range] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Price Range] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Price Range] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Price Range] - Step 06: Select to 'Manufacturer' Dropdown with value 'Apple'");
		searchPage.selectToManufacturerDropdown("Apple");
		
		log.info("Advanced Search [Price Range] - Step 07: Enter to 'price-from' Textbox with value '1000'");
		searchPage.enterToPriceFromTextbox("1000");
		
		log.info("Advanced Search [Price Range] - Step 08: Enter to 'price-from' Textbox with value '2000'");
		searchPage.enterToPriceToTextbox("2000");
		
		log.info("Advanced Search [Price Range] - Step 09: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Price Range] - Step 10: Verify product is displayed correctly");
		verifyTrue(searchPage.isProductsDisplayedAtSearchPage("Apple MacBook Pro 13-inch"));
	}

	@Test
	public void TC_10_Advanced_Search_With_Price_Range_Less_Than_Product_Price() {
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 06: Select to 'Manufacturer' Dropdown with value 'Apple'");
		searchPage.selectToManufacturerDropdown("Apple");
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 07: Enter to 'price-from' Textbox with value '1000'");
		searchPage.enterToPriceFromTextbox("1000");
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 08: Enter to 'price-from' Textbox with value '1700'");
		searchPage.enterToPriceToTextbox("1700");
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 09: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Price Range Less Than Product Price] - Step 10: Verify Warning Message is displayed with value 'No products were found that matched your criteria.'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_11_Advanced_Search_With_Price_Range_Greater_Than_Product_Price() {
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 01: Refresh current page");
		searchPage.refreshCurrentPage(driver);
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 02: Enter to 'Search keyword' Textbox with value '"+ productName +"'");
		searchPage.enterToSearchTextbox(productName);
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 03: Check to 'Advanced search' Checkbox");
		searchPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 04: Select to 'Category' Dropdown with value 'Computers'");
		searchPage.selectToCategoryDropdown("Computers");
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 05: Check to 'Automatically search sub categories' Checkbox");
		searchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 06: Select to 'Manufacturer' Dropdown with value 'Apple'");
		searchPage.selectToManufacturerDropdown("Apple");
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 07: Enter to 'price-from' Textbox with value '1900'");
		searchPage.enterToPriceFromTextbox("1900");
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 08: Enter to 'price-from' Textbox with value '5000'");
		searchPage.enterToPriceToTextbox("5000");
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 09: Click to 'Search' Buton");
		searchPage.clickToSearchButton();
		
		log.info("Advanced Search [Price Range Greater Than Product Price] - Step 08: Verify Warning Message is displayed with value 'No products were found that matched your criteria.'");
		verifyEquals(searchPage.getWarningMessageAtSearchPage(), "No products were found that matched your criteria.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	FakerConfig fakeData;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserSearchPO searchPage;

	String firstName, lastName, date, month, year, email, company, password;
	String productName;
}
