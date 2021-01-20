package com.nopcommerce.admin;

import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminDashBoardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductsPO;
import pageObjects.nopCommerce.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Admin_01_Search_Product extends AbstractTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";

		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		log.info("Pre-condition - Step 01: Enter To 'Email' Textbox at 'Login' Page");
		loginPage.enterToEmailTextbox(emailAdmin);

		log.info("Pre-condition - Step 02: Enter To 'Password' Textbox at 'Login' Page");
		loginPage.enterToPasswordTextbox(passwordAdmin);

		log.info("Pre-condition - Step 03: Click To 'Log in' Button at 'Login' Page");
		dashBoardPage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 04: Open 'Products' Page");
		productsPage = dashBoardPage.openProductsPage();

	}

	@Test
	public void TC_01_Search_With_Product_Name() {
		log.info("Search [Product Name] - Step 01: Enter to 'Product name' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"'");
		productsPage.enterProductNameTextbox(UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);

		log.info("Search [Product Name] - Step 02: Click to 'Search' Button");
		productsPage.clickToSearchButton();

		log.info("Search [Product Name] - Step 03: Verify Product is displayed successfully");
		verifyTrue(productsPage.areProductDetailDisplayed(UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.PRICE_AT_ADMIN,
				UserData.LenovoIdeaCentre600AllinOnePC.STOCK_QUANTITY, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_TYPE, UserData.LenovoIdeaCentre600AllinOnePC.PUBLISH_STATUS));
	}

	@Test
	public void TC_02_Search_With_Product_Name_And_Parent_Category() {
		log.info("Search [Product Name, Parent Category] - Step 01: Refresh Current Page");
		productsPage.refreshCurrentPage(driver);
		productsPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search [Product Name, Parent Category] - Step 02: Enter to 'Product name' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"'");
		productsPage.enterProductNameTextbox(UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);

		log.info("Search [Product Name, Parent Category] - Step 03: Select 'Category' Dropdown with value 'Computers'");
		productsPage.selectToCategoryDropdown("Computers");

		log.info("Search [Product Name, Parent Category] - Step 04: Click to 'Search' Button");
		productsPage.clickToSearchButton();

		log.info("Search [Product Name, Parent Category] - Step 05: Verify 'No data available in table' is displayed");
		verifyEquals(productsPage.getNoDataVailableInTable(), "No data available in table");
	}

	@Test
	public void TC_03_Search_With_Product_Name_And_Parent_Category_And_Check_Search_Subcategories() {
		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 01: Refresh Current Page");
		productsPage.refreshCurrentPage(driver);
		productsPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 02: Enter to 'Product name' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"'");
		productsPage.enterProductNameTextbox(UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);

		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 03: Select 'Category' Dropdown with value 'Computers'");
		productsPage.selectToCategoryDropdown("Computers");

		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 04: Check 'Search subcategories' Checkbox");
		productsPage.checkToSearchSubcategoriesCheckbox();

		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 05: Click to 'Search' Button");
		productsPage.clickToSearchButton();

		log.info("Search [Product Name, Parent Category, Check Subcategories] - Step 06: Verify Product is displayed successfully");
		verifyTrue(productsPage.areProductDetailDisplayed(UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.PRICE_AT_ADMIN,
				UserData.LenovoIdeaCentre600AllinOnePC.STOCK_QUANTITY, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_TYPE, UserData.LenovoIdeaCentre600AllinOnePC.PUBLISH_STATUS));
	}

	@Test
	public void TC_04_Search_With_Product_Name_And_Child_Category() {
		log.info("Search [Product Name, Chlid Category] - Step 01: Refresh Current Page");
		productsPage.refreshCurrentPage(driver);
		productsPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search [Product Name, Chlid Category] - Step 02: Enter to 'Product name' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"'");
		productsPage.enterProductNameTextbox(UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);

		log.info("Search [Product Name, Chlid Category] - Step 03: Select 'Category' Dropdown with value 'Computers >> Desktops'");
		productsPage.selectToCategoryDropdown("Computers >> Desktops");

		log.info("Search [Product Name, Chlid Category] - Step 04: Click to 'Search' Button");
		productsPage.clickToSearchButton();

		log.info("Search [Product Name, Chlid Category] - Step 05: Verify Product is displayed successfully");
		verifyTrue(productsPage.areProductDetailDisplayed(UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.PRICE_AT_ADMIN,
				UserData.LenovoIdeaCentre600AllinOnePC.STOCK_QUANTITY, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_TYPE, UserData.LenovoIdeaCentre600AllinOnePC.PUBLISH_STATUS));
	}


	@Test
	public void TC_05_Search_With_Product_Name_And_Manufacturer() {
		log.info("Search [Product Name, Manufacturer] - Step 01: Refresh Current Page");
		productsPage.refreshCurrentPage(driver);
		productsPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search [Product Name, Manufacturer] - Step 02: Enter to 'Product name' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"'");
		productsPage.enterProductNameTextbox(UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);

		log.info("Search [Product Name, Manufacturer] - Step 03: Select 'Manufacturer' Dropdown with value 'Apple'");
		productsPage.selectToManufacturerDropdown("Apple");

		log.info("Search [Product Name, Manufacturer] - Step 04: Click to 'Search' Button");
		productsPage.clickToSearchButton();

		log.info("Search [Product Name, Manufacturer] - Step 05: Verify 'No data available in table' is displayed");
		verifyEquals(productsPage.getNoDataVailableInTable(), "No data available in table");
	}
	
	@Test
	public void TC_06_Search_With_Go_Directly_To_Product_SKU() {
		log.info("Search [Product Name, Manufacturer] - Step 01: Refresh Current Page");
		productsPage.refreshCurrentPage(driver);
		productsPage.WaitForLoadingIconInvisibleAtAdmin(driver);

		log.info("Search [Product Name, Manufacturer] - Step 02: Enter to 'Go directly to product SKU' Textbox with value '"+ UserData.LenovoIdeaCentre600AllinOnePC.SKU +"'");
		productsPage.enterGoDirectlyToProductSKUTextbox(UserData.LenovoIdeaCentre600AllinOnePC.SKU);
		
		log.info("Search [Product Name, Manufacturer] - Step 04: Click to 'Go' Button");
		productsPage.clickToGoButton();
		
		log.info("Search [Product Name, Manufacturer] - Step 05: Verify Infomation of '"+ UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME +"' is displayed");
		verifyEquals(productsPage.getProductNameAtDetail(), UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductsPO productsPage;

	String emailAdmin, passwordAdmin;
}
