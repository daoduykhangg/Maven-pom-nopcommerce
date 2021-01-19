package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserCompareProductsPO;
import pageObjects.nopCommerce.UserComputersDetailPO;
import pageObjects.nopCommerce.UserComputersPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserRecentlyViewedProductsPO;
import pageObjects.nopCommerce.UserRegisterPO;
import pageObjects.nopCommerce.UserShoppingCardPO;
import pageObjects.nopCommerce.UserWishlistPO;
import utilities.FakerConfig;

public class User_06_Wishlist_Compare_RecentView extends AbstractTest {
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

		sku = "LE_IC_600";
		image1 = "Lenovo IdeaCentre 600 All-in-One PC";
		image2 = "Build your own computer";
		productName1 = "Lenovo IdeaCentre 600 All-in-One PC";
		productName2 = "Build your own computer";
		price1 = "$500.00";
		price2 = "$1,200.00";
		qty1 = "1";
		total1 = "$500.00";
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
	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		log.info("Wishlist [Add] - Step 01: Open 'Desktops' Link");
		homePage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Desktops");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Wishlist [Add] - Step 02: Click to 'Lenovo IdeaCentre 600 All-in-One PC' Text");
		computersPage.clickToItemLinkByProductName(driver, productName1);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Wishlist [Add] - Step 03: Click to 'Add to wishlist' Button");
		computersDetailPage.clickToAddToWishlistButton();

		log.info("Wishlist [Add] - Step 04: Wait for 'Ajax Loading icon' invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Wishlist [Add] - Step 05: Verify Success Message is displayed with value 'The product has been added to your wishlist'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your wishlist");

		log.info("Wishlist [Add] - Step 06: Click to 'Wishlist' Link");
		computersDetailPage.clickToLinkByNameInFooter(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		log.info("Wishlist [Add] - Step 07: Verify product is added to 'Wishlist' successfully");
		verifyTrue(wishlistPage.areProductDetailDisplayed(driver, sku, image1, productName1, price1, qty1, total1));

		log.info("Wishlist [Add] - Step 08: Click to 'Your wishlist URL for sharing' Link");
		wishlistPage.clickToYourWishlistURLLink();

		log.info("Wishlist [Add] - Step 09: Verify 'Wishlist of " + firstName + " " + lastName + "'");
		verifyEquals(wishlistPage.isTitleWishlistOfdisplayed(), "Wishlist of " + firstName + " " + lastName);

	}

	@Test
	public void TC_02_Add_Product_To_Card_From_Wishlist() {
		log.info("Wishlist [Add Product To Wishlist] - Step 01: Back to 'Wishlist' Page");
		wishlistPage.backToPage(driver);

		log.info("Wishlist [Add Product To Wishlist] - Step 02: Check to 'Add to cart' Checkbox");
		wishlistPage.clickToAddToCardCheckbox(sku, image1, productName1, price1, qty1, total1);

		log.info("Wishlist [Add Product To Wishlist] - Step 03: Click to 'Add to cart' Button");
		shoppingCardPage = wishlistPage.clickToAddToCardButton();

		log.info("Wishlist [Add Product To Wishlist] - Step 04: Verify Product is added to 'Shopping Card' Page successfully");
		shoppingCardPage.areProductDetailDisplayed(driver, sku, image1, productName1, price1, qty1, total1);

		log.info("Wishlist [Add Product To Wishlist] - Step 05: Click to 'Wishlist' Link");
		shoppingCardPage.clickToLinkByClass(driver, "ico-wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		log.info("Wishlist [Add Product To Wishlist] - Step 06: Verify 'The wishlist is empty!' is displayed successfully");
		verifyEquals(wishlistPage.getTextNoticeMessage(driver), "The wishlist is empty!");

		log.info("Wishlist [Add Product To Wishlist] - Step 07: Verify Product is removed at 'Wishlist' Page successfully");
		verifyTrue(wishlistPage.areProductDetailUnDisplayed(driver, sku, image1, productName1, price1, qty1, total1));

	}

	@Test
	public void TC_03_Remove_Product_in_Wishlist_Page() {
		log.info("Wishlist [Remove from Product] - Step 01: Open 'Desktops' Link");
		wishlistPage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Desktops");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Wishlist [Remove from Product] - Step 02: Click to 'Lenovo IdeaCentre 600 All-in-One PC' Text");
		computersPage.clickToItemLinkByProductName(driver, productName1);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Wishlist [Remove from Product] - Step 03: Click to 'Add to wishlist' Button");
		computersDetailPage.clickToAddToWishlistButton();

		log.info("Wishlist [Remove from Product] - Step 04: Wait for 'Ajax Loading icon' invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Wishlist [Remove from Product] - Step 05: Verify Success Message is displayed with value 'The product has been added to your wishlist'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your wishlist");

		log.info("Wishlist [Remove from Product] - Step 06: Click to 'Wishlist' Link");
		computersDetailPage.clickToLinkByNameInFooter(driver, "Wishlist");
		;
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);

		log.info("Wishlist [Remove from Product] - Step 07: Verify product is added to 'Wishlist' successfully");
		verifyTrue(wishlistPage.areProductDetailDisplayed(driver, sku, image1, productName1, price1, qty1, total1));

		log.info("Wishlist [Remove from Product] - Step 08: Click to 'Remove' Checkbox");
		wishlistPage.clickToRemoveCheckbox(driver, sku, image1, productName1, price1, qty1, total1);

		log.info("Wishlist [Remove from Product] - Step 09: Click to 'Update wishlist' Button");
		wishlistPage.clickToUpdateWishlistButton();

		log.info("Wishlist [Remove from Product] - Step 10: Verify 'The wishlist is empty!' is displayed successfully");
		verifyEquals(wishlistPage.getTextNoticeMessage(driver), "The wishlist is empty!");
	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		log.info("Compare Products [Add Products] - Step 01: Open 'Desktop' Link");
		wishlistPage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Desktops");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Compare Products [Add Products] - Step 02: Click To 'Add to compare list' Button with value product name '" + productName2 + "'");
		computersPage.clickToAddToCompareListButton(driver, productName2);

		log.info("Compare Products [Add Products] - Step 03: Wait for 'Ajax Loading icon' invisible");
		computersPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Compare Products [Add Products] - Step 04: Verify Success Message is displayed with value 'The product has been added to your product comparison'");
		verifyEquals(computersPage.getTextContentDialog(driver), "The product has been added to your product comparison");

		log.info("Compare Products [Add Products] - Step 05: Click To 'Add to compare list' Button with value product name '" + productName1 + "'");
		computersPage.clickToAddToCompareListButton(driver, productName1);

		log.info("Compare Products [Add Products] - Step 06: Wait for 'Ajax Loading icon' invisible");
		computersPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Compare Products [Add Products] - Step 07: Verify Success Message is displayed with value 'The product has been added to your product comparison'");
		verifyEquals(computersPage.getTextContentDialog(driver), "The product has been added to your product comparison");

		log.info("Compare Products [Add Products] - Step 08: Click to 'Compare products list' Link");
		computersPage.clickToLinkByNameInFooter(driver, "Compare products list");
		compareProductsPage = PageGeneratorManager.getUserCompareProductsPage(driver);

		log.info("Compare Products [Add Products] - Step 09: Verify Infomation Product To Compare is displayed successfully");
		verifyTrue(compareProductsPage.areProductInforDisplayed(image1, productName1, price1));
		verifyTrue(compareProductsPage.areProductInforDisplayed(image2, productName2, price2));

		log.info("Compare Products [Add Products] - Step 10: Click To 'Clear list' Button");
		compareProductsPage.clickToClearListButton();

		log.info("Compare Products [Add Products] - Step 11: Verify 'You have no items to compare.'");
		verifyEquals(compareProductsPage.getTextNoticeMessage(driver), "You have no items to compare.");

		log.info("Compare Products [Add Products] - Step 12: Verify Products are Undisplayed at 'Compare Products list' Page");
		verifyTrue(compareProductsPage.areProductInforUnDisplayed(image1, productName1, price1));
		verifyTrue(compareProductsPage.areProductInforUnDisplayed(image2, productName2, price2));
	}

	@Test
	public void TC_05_Recently_Viewed_Products() {
		log.info("Recently Viewed Products [View] - Step 01: Open 'Notebooks' Link");
		compareProductsPage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Notebooks");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Recently Viewed Products [View] - Step 02: Click to 'Apple MacBook Pro 13-inch' Text");
		computersPage.clickToItemLinkByProductName(driver, "Apple MacBook Pro 13-inch");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Recently Viewed Products [View] - Step 03: Back to 'Notebooks' Page");
		computersDetailPage.backToPage(driver);
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Recently Viewed Products [View] - Step 03: Click to 'Asus N551JK-XO076H Laptop' Text");
		computersPage.clickToItemLinkByProductName(driver, "Asus N551JK-XO076H Laptop");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Recently Viewed Products [View] - Step 03: Back to 'Notebooks' Page");
		computersDetailPage.backToPage(driver);
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Recently Viewed Products [View] - Step 04: Click to 'HP Envy 6-1180ca 15.6-Inch Sleekbook' Text");
		computersPage.clickToItemLinkByProductName(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Recently Viewed Products [View] - Step 03: Back to 'Notebooks' Page");
		computersDetailPage.backToPage(driver);
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Recently Viewed Products [View] - Step 05: Click to 'HP Spectre XT Pro UltraBook' Text");
		computersPage.clickToItemLinkByProductName(driver, "HP Spectre XT Pro UltraBook");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Recently Viewed Products [View] - Step 03: Back to 'Notebooks' Page");
		computersDetailPage.backToPage(driver);
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Recently Viewed Products [View] - Step 06: Click to 'Lenovo Thinkpad X1 Carbon Laptop' Text");
		computersPage.clickToItemLinkByProductName(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Recently Viewed Products [View] - Step 07: Click to 'Recently viewed products' Link");
		computersDetailPage.clickToLinkByNameInFooter(driver, "Recently viewed products");
		recentlyViewedProductsPage = PageGeneratorManager.getRecentlyViewedProductsPage(driver);

		log.info("Recently Viewed Products [View] - Step 08: Verify the last 3 viewed products are displayed");
		verifyTrue(recentlyViewedProductsPage.areProductsDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
		verifyTrue(recentlyViewedProductsPage.areProductsDisplayed(driver, "HP Spectre XT Pro UltraBook"));
		verifyTrue(recentlyViewedProductsPage.areProductsDisplayed(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook"));

		log.info("Recently Viewed Products [View] - Step 09: Verify 2 viewed products are Undisplayed");
		verifyTrue(recentlyViewedProductsPage.areProductsUndisplayed(driver, "Asus N551JK-XO076H Laptop"));
		verifyTrue(recentlyViewedProductsPage.areProductsUndisplayed(driver, "Apple MacBook Pro 13-inch"));
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
	UserComputersPO computersPage;
	UserComputersDetailPO computersDetailPage;
	UserWishlistPO wishlistPage;
	UserShoppingCardPO shoppingCardPage;
	UserCompareProductsPO compareProductsPage;
	UserRecentlyViewedProductsPO recentlyViewedProductsPage;

	String firstName, lastName, date, month, year, email, company, password;
	String sku, image1, image2, productName1, productName2, price1, price2, qty1, total1;
}
