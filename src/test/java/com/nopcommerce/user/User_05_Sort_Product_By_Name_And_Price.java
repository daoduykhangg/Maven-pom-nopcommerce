package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserComputersPO;

public class User_05_Sort_Product_By_Name_And_Price extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 01: Click To 'Notebooks ' page sub menu");
		homePage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers ", "Notebooks ");
		userComputersPage = PageGeneratorManager.getUserComputersPage(driver);
	}
	
	@Test
	public void Product_01_Sort_By_Product_Name() {
		log.info("Product [Sort by Name] - Step 01: Select 'Sort by' dropdown with value 'Name: A to Z'");
		userComputersPage.selectItemInProductSortDropdown("Name: A to Z");

		log.info("Product [Sort by Name] - Step 02: Verify Sort by product name ascending successfully");
		verifyTrue(userComputersPage.areProductNameSortByAscending());

		log.info("Product [Sort by Name] - Step 03: Select 'Sort by' dropdown with value 'Name: Z to A'");
		userComputersPage.selectItemInProductSortDropdown("Name: Z to A");

		log.info("Product [Sort by Name] - Step 04: Verify Sort by product name Descending successfully");
		verifyTrue(userComputersPage.areProductNameSortByDescending());
	}

	@Test
	public void Product_02_Sort_By_Product_Price() {
		log.info("Product [Sort by Price] - Step 01: Select 'Sort by' dropdown with value 'Price: Low to High'");
		userComputersPage.selectItemInProductSortDropdown("Price: Low to High");

		log.info("Product [Sort by Price] - Step 02: Verify Sort by product price ascending successfully");
		verifyTrue(userComputersPage.areProductPriceSortByAscending());
		
		log.info("Product [Sort by Price] - Step 03: Select 'Sort by' dropdown with value 'Price: High to Low'");
		userComputersPage.selectItemInProductSortDropdown("Price: High to Low");
		
		log.info("Product [Sort by Price] - Step 04: Verify Sort by product price Descending successfully");
		verifyTrue(userComputersPage.areProductPriceSortByDescending());
	}
	
	@Test
	public void Product_03_03_Displayed_Product_In_Page() {
		log.info("Product [3 Displayed product] - Step 01: Select 'display' dropdown with value '3'");
		userComputersPage.selectPerPageDisplayedDropdown("3");
		
		log.info("Product [3 Displayed product] - Step 02: Verify products are displayed correctly");
		verifyTrue(userComputersPage.areThreeProductsDisplayed());
		
		log.info("Product [3 Displayed product] - Step 03: Verify 'Next Icon' link is displayed");
		verifyTrue(userComputersPage.isNextIconDisplayed());
		
		log.info("Product [3 Displayed product] - Step 04: Click To 'Next Icon' link");
		userComputersPage.clickToNextIconLink();
		
		log.info("Product [3 Displayed product] - Step 05: Verify 'Previous Icon' link is displayed");
		verifyTrue(userComputersPage.isPreviousIconDisplayed());
		
	}
	
	@Test
	public void Product_04_06_Displayed_Product_In_Page() {
		log.info("Product [6 Displayed product] - Step 01: Select 'display' dropdown with value '6'");
		userComputersPage.selectPerPageDisplayedDropdown("6");
		
		log.info("Product [6 Displayed product] - Step 02: Verify products are displayed correctly");
		verifyTrue(userComputersPage.areSixProductsDisplayed());
		
		log.info("Product [6 Displayed product] - Step 03: Verify 'Pager' is Undisplayed");
		verifyTrue(userComputersPage.isPagerUndisplayed());
	}

	@Test
	public void Product_05_09_Displayed_Product_In_Page() {
		log.info("Product [9 Displayed product] - Step 01: Select 'display' dropdown with value '9'");
		userComputersPage.selectPerPageDisplayedDropdown("9");
		
		log.info("Product [9 Displayed product] - Step 02: Verify products are displayed correctly");
		verifyTrue(userComputersPage.areNineProductsDisplayed());
		
		log.info("Product [9 Displayed product] - Step 03: Verify 'Pager' is Undisplayed");
		verifyTrue(userComputersPage.isPagerUndisplayed());
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}
	
	WebDriver driver;
	UserComputersPO userComputersPage;
	UserHomePO homePage;
}
