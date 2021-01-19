package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;

public class Level_08_Register_Login_Dynamic_Locator extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Khang";
		lastName = "Dao";
		email = "duykhangkma" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);

		registerPage.selectDayDropdown("21");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1996");

		registerPage.enterToEmailextbox(email);
		registerPage.enterToCompanyTextbox(company);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "21");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1996");

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());

	}

	@Test
	public void TC_04_Switch_Page() {
//		addressesPage = customerInforPage.clickToAddressesLink(driver);
//		
//		myProductReviewPage = addressesPage.clickToMyProductReviewLink(driver);
//		
//		ordersPage = myProductReviewPage.clickToOrdersLink(driver);
//		
//		myProductReviewPage = ordersPage.clickToMyProductReviewLink(driver);
//		
//		addressesPage = myProductReviewPage.clickToAddressesLink(driver);
//		
//		customerInforPage = addressesPage.clickToCustomerInforLink(driver);	
	}
	
	@Test
	public void TC_05_Switch_Page_Dynamic_Locator_Solution_01() {

//		addressesPage = (UserAddressesPO) customerInforPage.ClickToLinkByPageName(driver, "Addresses");
//		
//		myProductReviewPage = (UserMyProductReviewPO) addressesPage.ClickToLinkByPageName(driver, "My product reviews");
//		
//		ordersPage = (UserOrdersPO) myProductReviewPage.ClickToLinkByPageName(driver, "Orders");
//		
//		myProductReviewPage = (UserMyProductReviewPO) ordersPage.ClickToLinkByPageName(driver, "My product reviews");
//		
//		addressesPage = (UserAddressesPO) myProductReviewPage.ClickToLinkByPageName(driver, "Addresses");
//		
//		customerInforPage = (UserCustomerInforPO) addressesPage.ClickToLinkByPageName(driver, "Customer info");
//		
	}

	@Test
	public void TC_06_Switch_Page_Dynamic_Locator_Solution_02() {
		customerInforPage.clickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		addressesPage.clickToLinkWithPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.clickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		ordersPage.clickToLinkWithPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.clickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		addressesPage.clickToLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserMyProductReviewPO myProductReviewPage;
}
