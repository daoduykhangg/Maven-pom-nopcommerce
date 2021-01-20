package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminDashBoardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductsPO;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_10_Upload_File extends AbstractTest {
	WebDriver driver;
	String filename = "HoChiMinh.jpg";
	String productName = "Adobe Photoshop CS4";
	String pictureAlt = "Alt";
	String pictureTitle = "Title";
	String pictureOrder = "1";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productsPage = dashboardPage.openProductsPage();
	}

	@Test
	public void TC_01_Upload_File() {
		productsPage.enterProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		productsPage.clickToEditButtonByProductName(productName);
		productsPage.scrollToPanelByPanelID("product-pictures");
		productsPage.openToPanelByPanelID(driver, "product-pictures");
		
		productsPage.uploadMultipleFilesByPanelID(driver, "product-pictures", filename);
		Assert.assertTrue(productsPage.isNewPictureUploadSuccess(filename));
		productsPage.inputToAltTextbox(pictureAlt);
		productsPage.inputToTitleTextbox(pictureTitle);
		productsPage.clickToIconAtOrderTextbox("Increase");
		productsPage.clickToAddProductPictureButton();
		Assert.assertTrue(productsPage.areProductPictureDetailDisplayed(productName, pictureOrder, pictureAlt, pictureTitle));
		productsPage.clickToSaveButton();
		
		productsPage.enterProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		Assert.assertTrue(productsPage.areProductDetailDisplayed(productName, productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));
		productsPage.clickToEditButtonByProductName(productName);
		productsPage.scrollToPanelByPanelID("product-pictures");
		productsPage.openToPanelByPanelID(driver, "product-pictures");
		productsPage.clickToDeleteButtonByTitle(pictureTitle);
		productsPage.clickToSaveButton();
		
		productsPage.enterProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		Assert.assertTrue(productsPage.areProductDetailDisplayed("default-image", productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));
		
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	AdminLoginPO loginPage;
	AdminDashBoardPO dashboardPage;
	AdminProductsPO productsPage;
}
