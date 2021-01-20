package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserCheckoutPO;
import pageObjects.nopCommerce.UserComputersDetailPO;
import pageObjects.nopCommerce.UserComputersPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;
import pageObjects.nopCommerce.UserShoppingCardPO;
import utilities.FakerConfig;

public class User_07_Order_Products extends AbstractTest {
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

		counTry = "Viet Nam";
		state = "Other";
		city = "Hồ Chí Minh";
		zip = fakeData.getZipCode();
		billAddress1 = "Đặng Minh Trứ";
		billPhoneNumber = fakeData.getPhoneNumber();

		shipAddress1 = "Mầm non 10";
		shipPhoneNumber = fakeData.getPhoneNumber();

		cardNumber = "3529481880626708";
		expirationMonth = "08";
		expirationYear = "2022";
		cardCode = "2108";

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
	public void TC_01_Add_Product_To_Shopping_Card() {
		log.info("Order [Add Product to Card] - Step 01: Click to 'Desktops' Link");
		homePage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Desktops");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Order [Add Product to Card] - Step 02: Click to 'Build your own computer' Text");
		computersPage.clickToItemLinkByProductName(driver, UserData.BuildYourOwnComputer.PRODUCT_NAME);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Order [Add Product to Card] - Step 03: Select to ' Processor ' Dropdown with value '" + UserData.BuildYourOwnComputer.PROCESSOR + "'");
		computersDetailPage.SelectToProcessorDropdown(UserData.BuildYourOwnComputer.PROCESSOR);

		log.info("Order [Add Product to Card] - Step 04: Select to ' RAM ' Dropdown with value '" + UserData.BuildYourOwnComputer.RAM + "'");
		computersDetailPage.SelectToRamDropdown(UserData.BuildYourOwnComputer.RAM);

		log.info("Order [Add Product to Card] - Step 05: Click to '" + UserData.BuildYourOwnComputer.HDD + "' Radio Button");
		computersDetailPage.ClickToHDD400GBRadioButton();

		log.info("Order [Add Product to Card] - Step 06: Click to '" + UserData.BuildYourOwnComputer.OS + "' Radio Button");
		computersDetailPage.ClickToVistaPremiumRadioButton();

		log.info("Order [Add Product to Card] - Step 07: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_1 + "' Checkbox");
		computersDetailPage.clickToMicrosoftOfficeCheckbox();

		log.info("Order [Add Product to Card] - Step 08: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_2 + "' Checkbox");
		computersDetailPage.checkToAcrobatReaderCheckbox();

		log.info("Order [Add Product to Card] - Step 09: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_3 + "' Checkbox");
		computersDetailPage.checkToTotalCommanderCheckbox();

		log.info("Order [Add Product to Card] - Step 10: Click to 'Add to cart' Button");
		computersDetailPage.checkToAddToCardButton();

		log.info("Order [Add Product to Card] - Step 11: Wait For 'Loading Icon' is invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Add Product to Card] - Step 12: Verify Success Message is Displayed with value 'The product has been added to your shopping cart'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your shopping cart");

		log.info("Order [Add Product to Card] - Step 13: Wait For Text Content is invisible");
		computersDetailPage.waitForTextContentInvisible(driver);

		log.info("Order [Add Product to Card] - Step 14: Hover to 'ShoppingCard' Link");
		computersDetailPage.hoverToShoppingCardLink(driver, "ico-cart");

		log.info("Order [Add Product to Card] - Step 15: Verify Product is added to 'Card' successfully");
		verifyEquals(computersDetailPage.getCountItemInYourCardText(), "There are " + UserData.BuildYourOwnComputer.PRODUCT_QUANTITY + " item(s) in your cart.");
		verifyTrue(computersDetailPage.isPictureProductDisplayed());
		verifyEquals(computersDetailPage.getNameProduct(), UserData.BuildYourOwnComputer.PRODUCT_NAME);
		verifyEquals(computersDetailPage.getAttributeProductText(), "Processor: " + UserData.BuildYourOwnComputer.PROCESSOR + "\n" + "RAM: " + UserData.BuildYourOwnComputer.RAM + "\n" + "HDD: " + UserData.BuildYourOwnComputer.HDD + "\n" + "OS: " + UserData.BuildYourOwnComputer.OS + "\n"
				+ "Software: " + UserData.BuildYourOwnComputer.SOFTWARE_1 + "\n" + "Software: " + UserData.BuildYourOwnComputer.SOFTWARE_2 + "\n" + "Software: " + UserData.BuildYourOwnComputer.SOFTWARE_3);
		verifyEquals(computersDetailPage.getPriceProductText(), "Unit price: " + UserData.BuildYourOwnComputer.PRICE + "");
		verifyEquals(computersDetailPage.getQuantityProductText(), "Quantity: " + UserData.BuildYourOwnComputer.PRODUCT_QUANTITY + "");
		verifyEquals(computersDetailPage.getSubTotalsText(), "Sub-Total: " + UserData.BuildYourOwnComputer.SUB_TOTALS + "");
	}

	@Test(dependsOnMethods = "TC_01_Add_Product_To_Shopping_Card")
	public void TC_02_Edit_Product_In_Shopping_Card() {
		log.info("Order [Edit Product In Card] - Step 01: Open 'Shopping cart' Page");
		computersDetailPage.clickToLinkByClass(driver, "ico-cart");
		shoppingCardPage = PageGeneratorManager.getShoppingCardPage(driver);

		log.info("Order [Edit Product In Card] - Step 02: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Edit Product In Card] - Step 03: Click to 'Edit' Link");
		shoppingCardPage.clickToEditLink(driver, UserData.BuildYourOwnComputer.SKU, UserData.BuildYourOwnComputer.IMAGE, UserData.BuildYourOwnComputer.PRODUCT_NAME, UserData.BuildYourOwnComputer.PRICE);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Order [Edit Product In Card] - Step 04: Select to ' Processor ' Dropdown with value '" + UserData.EditBuildYourOwnComputer.EDIT_PROCESSOR + "'");
		computersDetailPage.SelectToProcessorDropdown(UserData.EditBuildYourOwnComputer.EDIT_PROCESSOR);

		log.info("Order [Edit Product In Card] - Step 05: Select to ' RAM ' Dropdown with value '" + UserData.EditBuildYourOwnComputer.EDIT_RAM + "'");
		computersDetailPage.SelectToRamDropdown(UserData.EditBuildYourOwnComputer.EDIT_RAM);

		log.info("Order [Edit Product In Card] - Step 06: Click to '" + UserData.EditBuildYourOwnComputer.EDIT_HDD + "' Radio Button");
		computersDetailPage.ClickTo320GBRadioButton();

		log.info("Order [Edit Product In Card] - Step 07: Click to '" + UserData.EditBuildYourOwnComputer.EDIT_OS + "' Radio Button");
		computersDetailPage.clickToVistaHomeRadioButton();

		log.info("Order [Edit Product In Card] - Step 08: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_1 + "' Checkbox");
		computersDetailPage.clickToMicrosoftOfficeCheckbox();

		log.info("Order [Edit Product In Card] - Step 09: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_2 + "' Checkbox");
		computersDetailPage.uncheckToAcrobatReaderCheckbox();

		log.info("Order [Edit Product In Card] - Step 10: Click to '" + UserData.BuildYourOwnComputer.SOFTWARE_3 + "' Checkbox");
		computersDetailPage.uncheckToTotalCommanderCheckbox();

		log.info("Order [Edit Product In Card] - Step 11: Enter to 'Product Quantity' Textbox");
		computersDetailPage.enterToProductQuantityTextbox(UserData.EditBuildYourOwnComputer.EDIT_PRODUCT_QUANTITY);

		log.info("Order [Edit Product In Card] - Step 12: Click to 'Update' Button");
		computersDetailPage.clickToUpdateButton();

		log.info("Order [Edit Product In Card] - Step 13: Wait For 'Loading Icon' Invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Edit Product In Card] - Step 14: Verify Success Message is Displayed with value 'The product has been added to your shopping cart'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your shopping cart");

		log.info("Order [Edit Product In Card] - Step 15: Wait For Text Content is invisible");
		computersDetailPage.waitForTextContentInvisible(driver);

		log.info("Order [Edit Product In Card] - Step 16: Hover to 'ShoppingCard' Link");
		computersDetailPage.hoverToShoppingCardLink(driver, "ico-cart");

		log.info("Order [Add Product to Card] - Step 15: Verify Product is added to 'Card' successfully");
		verifyEquals(computersDetailPage.getCountItemInYourCardText(), "There are " + UserData.EditBuildYourOwnComputer.EDIT_PRODUCT_QUANTITY + " item(s) in your cart.");
		verifyTrue(computersDetailPage.isPictureProductDisplayed());
		verifyEquals(computersDetailPage.getNameProduct(), UserData.BuildYourOwnComputer.PRODUCT_NAME);
		verifyEquals(computersDetailPage.getAttributeProductText(), "Processor: " + UserData.EditBuildYourOwnComputer.EDIT_PROCESSOR + "\n" + "RAM: " + UserData.EditBuildYourOwnComputer.EDIT_RAM + "\n" + "HDD: " + UserData.EditBuildYourOwnComputer.EDIT_HDD + "\n" + "OS: "
				+ UserData.EditBuildYourOwnComputer.EDIT_OS + "\n" + "Software: " + UserData.BuildYourOwnComputer.SOFTWARE_1);
		verifyEquals(computersDetailPage.getPriceProductText(), "Unit price: " + UserData.EditBuildYourOwnComputer.EDIT_PRICE + "");
		verifyEquals(computersDetailPage.getQuantityProductText(), "Quantity: " + UserData.EditBuildYourOwnComputer.EDIT_PRODUCT_QUANTITY + "");
		verifyEquals(computersDetailPage.getSubTotalsText(), "Sub-Total: " + UserData.EditBuildYourOwnComputer.EDIT_SUB_TOTALS + "");
	}

	@Test(dependsOnMethods = { "TC_01_Add_Product_To_Shopping_Card", "TC_02_Edit_Product_In_Shopping_Card" })
	public void TC_03_Remove_Product_From_Shopping_Card() {
		log.info("Order [Remove Product From Card] - Step 01: Open 'Shopping cart' Page");
		computersDetailPage.clickToLinkByClass(driver, "ico-cart");
		shoppingCardPage = PageGeneratorManager.getShoppingCardPage(driver);

		log.info("Order [Remove Product From Card] - Step 02: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Remove Product From Card] - Step 03: Check to 'Remove' Checkbox");
		shoppingCardPage.clickToRemoveCheckbox(driver, UserData.BuildYourOwnComputer.SKU, UserData.BuildYourOwnComputer.IMAGE, UserData.BuildYourOwnComputer.PRODUCT_NAME, UserData.EditBuildYourOwnComputer.EDIT_PRICE, UserData.EditBuildYourOwnComputer.EDIT_PRODUCT_QUANTITY,
				UserData.EditBuildYourOwnComputer.EDIT_SUB_TOTALS);

		log.info("Order [Remove Product From Card] - Step 04: Click to 'Update shopping cart' Button");
		shoppingCardPage.clickToUpdateShoppingCartButton();

		log.info("Order [Remove Product From Card] - Step 05: Verify 'Your Shopping Cart is empty!' is displayed successfully");
		verifyEquals(shoppingCardPage.getTextNoticeMessage(driver), "Your Shopping Cart is empty!");

		log.info("Order [Remove Product From Card] - Step 05: Verify Product is Undisplayed at 'Shopping Card' Page");
		verifyTrue(shoppingCardPage.areProductDetailUnDisplayed(driver, UserData.BuildYourOwnComputer.SKU, UserData.BuildYourOwnComputer.IMAGE, UserData.BuildYourOwnComputer.PRODUCT_NAME, UserData.EditBuildYourOwnComputer.EDIT_PRICE, UserData.EditBuildYourOwnComputer.EDIT_PRODUCT_QUANTITY,
				UserData.EditBuildYourOwnComputer.EDIT_SUB_TOTALS));
	}

	@Test(dependsOnMethods = { "TC_01_Add_Product_To_Shopping_Card", "TC_02_Edit_Product_In_Shopping_Card", "TC_03_Remove_Product_From_Shopping_Card" })
	public void TC_04_Update_Shopping_Card() {
		log.info("Order [Update Card] - Step 01: Click to 'Desktops' Link");
		homePage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Desktops");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Order [Update Card] - Step 02: Click to '" + UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME + "' Text");
		computersPage.clickToItemLinkByProductName(driver, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Order [Update Card] - Step 03: Click to 'Add to cart' Button");
		computersDetailPage.checkToAddToCardButton();

		log.info("Order [Update Card] - Step 04: Wait For 'Loading Icon' is invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Update Card] - Step 05: Verify Success Message is Displayed with value 'The product has been added to your shopping cart'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your shopping cart");

		log.info("Order [Update Card] - Step 06: Wait For Text Content is invisible");
		computersDetailPage.waitForTextContentInvisible(driver);

		log.info("Order [Update Card] - Step 07: Open 'Shopping cart' Page");
		computersDetailPage.clickToLinkByClass(driver, "ico-cart");
		shoppingCardPage = PageGeneratorManager.getShoppingCardPage(driver);

		log.info("Order [Update Card] - Step 08: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Update Card] - Step 09: Verify Product is added to Card successfully");
		verifyTrue(shoppingCardPage.areProductDetailDisplayed(driver, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.PRICE,
				UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_QUANTITY, UserData.LenovoIdeaCentre600AllinOnePC.SUB_TOTALS));

		log.info("Order [Update Card] - Step 10: Enter to 'Qty' Texbox");
		shoppingCardPage.enterToQtyTextboxInTable(driver, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.PRICE,
				UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_PRODUCT_QUANTITY);

		log.info("Order [Update Card] - Step 11: Click to 'Update shopping cart' Button");
		shoppingCardPage.clickToUpdateShoppingCartButton();

		log.info("Order [Update Card] - Step 12: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Update Card] - Step 13: Verify Product is updated to Card successfully");
		verifyTrue(shoppingCardPage.areProductDetailDisplayed(driver, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.PRICE,
				UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_PRODUCT_QUANTITY, UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_SUB_TOTALS));

		log.info("Order [Update Card] - Step 14: Check to 'Remove' Checkbox");
		shoppingCardPage.clickToRemoveCheckbox(driver, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.PRICE,
				UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_PRODUCT_QUANTITY, UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_SUB_TOTALS);

		log.info("Order [Update Card] - Step 15: Click to 'Update shopping cart' Button");
		shoppingCardPage.clickToUpdateShoppingCartButton();

		log.info("Order [Update Card] - Step 16: Verify 'Your Shopping Cart is empty!' is displayed successfully");
		verifyEquals(shoppingCardPage.getTextNoticeMessage(driver), "Your Shopping Cart is empty!");

		log.info("Order [Update Card] - Step 17: Verify Product is Undisplayed at 'Shopping Card' Page");
		verifyTrue(shoppingCardPage.areProductDetailUnDisplayed(driver, UserData.LenovoIdeaCentre600AllinOnePC.SKU, UserData.LenovoIdeaCentre600AllinOnePC.IMAGE, UserData.LenovoIdeaCentre600AllinOnePC.PRODUCT_NAME, UserData.LenovoIdeaCentre600AllinOnePC.PRICE,
				UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_PRODUCT_QUANTITY, UserData.EditLenovoIdeaCentre600AllinOnePC.EDIT_SUB_TOTALS));
	}

	@Test(dependsOnMethods = { "TC_01_Add_Product_To_Shopping_Card", "TC_02_Edit_Product_In_Shopping_Card", "TC_03_Remove_Product_From_Shopping_Card", "TC_04_Update_Shopping_Card"})
	public void TC_05_Order_Checkout_Products_Payment_By_Cheque() {
		log.info("Order [Payment By Cheque] - Step 01: Click to 'Notebooks' Link");
		shoppingCardPage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Notebooks");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Order [Payment By Cheque] - Step 02: Click to '" + UserData.AppleMacBookPro13inch.PRODUCT_NAME + "' Text");
		computersPage.clickToItemLinkByProductName(driver, UserData.AppleMacBookPro13inch.PRODUCT_NAME);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Order [Payment By Cheque] - Step 03: Click to 'Add to cart' Button");
		computersDetailPage.checkToAddToCardButton();

		log.info("Order [Payment By Cheque] - Step 04: Wait For 'Loading Icon' is invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Cheque] - Step 05: Verify Success Message is Displayed with value 'The product has been added to your shopping cart'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your shopping cart");

		log.info("Order [Payment By Cheque] - Step 06: Wait For Text Content is invisible");
		computersDetailPage.waitForTextContentInvisible(driver);

		log.info("Order [Payment By Cheque] - Step 07: Open 'Shopping cart' Page");
		computersDetailPage.clickToLinkByClass(driver, "ico-cart");
		shoppingCardPage = PageGeneratorManager.getShoppingCardPage(driver);

		log.info("Order [Payment By Cheque] - Step 08: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Cheque] - Step 09: Verify Product is added to Card successfully");
		verifyTrue(shoppingCardPage.areProductDetailDisplayed(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY,
				UserData.AppleMacBookPro13inch.SUB_TOTALS));

		log.info("Order [Payment By Cheque] - Step 10: Click to ' Estimate shipping ' Button");
		shoppingCardPage.clickToEstimateShippingButton();

		log.info("Order [Payment By Cheque] - Step 11: Select to 'Country' Dropdown with value '" + counTry + "'");
		shoppingCardPage.selectToCountryDropdown(counTry);

		log.info("Order [Payment By Cheque] - Step 12: Select to 'State' Dropdown with value '" + state + "'");
		shoppingCardPage.selectToStateDropdown(state);

		log.info("Order [Payment By Cheque] - Step 13: Enter to 'Zip Code' Textbox with value '" + zip + "'");
		shoppingCardPage.enterToZipCodeTextbox(zip);

		log.info("Order [Payment By Cheque] - Step 14: Click to 'Apply' Button");
		shoppingCardPage.clickToApplyButton();

		log.info("Order [Payment By Cheque] - Step 15: wait For 'Loading Icon' is Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Cheque] - Step 16: Check to 'terms of service' Checkbox");
		shoppingCardPage.checkToTermsOfServiceCheckbox();

		log.info("Order [Payment By Cheque] - Step 17: Click to 'checkout' Button");
		checkoutPage = shoppingCardPage.clickToCheckoutButton();

		log.info("Order [Payment By Cheque] - Step 18: Uncheck to 'Ship to the same address' Checkbox At Billing Step");
		checkoutPage.uncheckToShipToTheSameAddressCheckboxAtBillingStep();

		log.info("Order [Payment By Cheque] - Step 19: Enter to 'Firstname' Textbox with value '" + firstName + "' At Billing Step");
		checkoutPage.enterToFirstnameTextboxAtBillingStep(firstName);

		log.info("Order [Payment By Cheque] - Step 20: Enter to 'Lastname' Textbox with value '" + lastName + "' At Billing Step");
		checkoutPage.enterToLastnameTextboxAtBillingStep(lastName);

		log.info("Order [Payment By Cheque] - Step 21: Enter to 'Email' Textbox At Billing Step");
		checkoutPage.enterToEmailTextboxAtBillingStep(email);

		log.info("Order [Payment By Cheque] - Step 22: Select to 'Country' Dropdown with value '" + counTry + "' At Billing Step");
		checkoutPage.selectToCountryDropdownAtBillingStep(counTry);

		log.info("Order [Payment By Cheque] - Step 23: Select to 'State' Dropdown with value '" + state + "' At Billing Step");
		checkoutPage.selectToStateDropdownAtBillingStep(state);

		log.info("Order [Payment By Cheque] - Step 24: Enter to 'City' Textbox with value '" + city + "' At Billing Step");
		checkoutPage.enterToCityTextboxAtBillingStep(city);

		log.info("Order [Payment By Cheque] - Step 25: Enter to 'Address 1' Textbox with value '" + billAddress1 + "' At Billing Step");
		checkoutPage.enterToAddress1TextboxAtBillingStep(billAddress1);

		log.info("Order [Payment By Cheque] - Step 26: Enter to 'Zip code' Textbox with value '" + zip + "' At Billing Step");
		checkoutPage.enterToZipCodeTextboxAtBillingStep(zip);

		log.info("Order [Payment By Cheque] - Step 27: Enter to 'Phone number' Textbox with value '" + billPhoneNumber + "' At Billing Step");
		checkoutPage.enterToPhoneNumberTextboxAtBillingStep(billPhoneNumber);

		log.info("Order [Payment By Cheque] - Step 28: Click to 'Countinue' Button");
		checkoutPage.clickToCountinueButton("billing-buttons-container", "billing-please-wait At Billing Step");

		log.info("Order [Payment By Cheque] - Step 29: Select to 'shipping address' Dropdown At Shipping Step");
		checkoutPage.SelectToShippingAddressDropdownAtShippingStep("New Address");

		log.info("Order [Payment By Cheque] - Step 30: Select to 'Country' Dropdown with value '" + counTry + "' At Shipping Step");
		checkoutPage.SelectToCountryDropdownAtShippingStep(counTry);

		log.info("Order [Payment By Cheque] - Step 31: Select to 'State' Dropdown with value '" + state + "' At Shipping Step");
		checkoutPage.SelectToStateDropdownAtShippingStep(state);

		log.info("Order [Payment By Cheque] - Step 32: Enter to 'City' Textbox with value '" + city + "' At Shipping Step");
		checkoutPage.enterToCityTextboxAtShippingStep(city);

		log.info("Order [Payment By Cheque] - Step 33: Enter to 'Address 1' Textbox with value '" + shipAddress1 + "' At Shipping Step");
		checkoutPage.enterToAddress1TextboxAtShippingStep(shipAddress1);

		log.info("Order [Payment By Cheque] - Step 34: Enter to 'Zip code' Textbox with value '" + zip + "' At Shipping Step");
		checkoutPage.enterToZipCodeTextboxAtShippingStep(zip);

		log.info("Order [Payment By Cheque] - Step 35: Enter to 'Phone number' Textbox with value '" + shipPhoneNumber + "' At Shipping Step");
		checkoutPage.enterToPhoneNumberTextboxAtShippingStep(shipPhoneNumber);

		log.info("Order [Payment By Cheque] - Step 36: Click to 'Countinue' Button At Shipping Step");
		checkoutPage.clickToCountinueButton("shipping-buttons-container", "shipping-please-wait At Shipping Method Step");

		log.info("Order [Payment By Cheque] - Step 37: Click to 'Ground ($0.00)' Radio Button At Shipping Method Step");
		checkoutPage.clickToGroundRadioButtonAtShippingMethodStep();

		log.info("Order [Payment By Cheque] - Step 38: Click to 'Countinue' Button At Shipping Method Step");
		checkoutPage.clickToCountinueButton("shipping-method-buttons-container", "shipping-method-please-wait");

		log.info("Order [Payment By Cheque] - Step 39: Click to 'Check / Money Order' Radio Button At Payment method Step");
		checkoutPage.clickToCheckMoneyOrderRadioButtonAtPaymentMethodStep();

		log.info("Order [Payment By Cheque] - Step 40: Click to 'Countinue' Button At Payment method Step");
		checkoutPage.clickToCountinueButton("payment-method-buttons-container", "payment-method-please-wait");

		log.info("Order [Payment By Cheque] - Step 41: Verify Payment Information is displayed At Payment information Step");
		verifyEquals(checkoutPage.getTextPaymentInforAtPaymentInforStep("1"), "Mail Personal or Business Check, Cashier's Check or money order to:");
		verifyEquals(checkoutPage.getTextPaymentInforAtPaymentInforStep("2"), "NOP SOLUTIONS" + "\n" + "your address here," + "\n" + "New York, NY 10001" + "\n" + "USA");
		verifyEquals(checkoutPage.getTextPaymentInforAtPaymentInforStep("3"),
				"Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check.");
		verifyEquals(checkoutPage.getTextPaymentInforAtPaymentInforStep("4"), "P.S. You can edit this text from admin panel.");

		log.info("Order [Payment By Cheque] - Step 42: Click to 'Countinue' Button At Payment information Step");
		checkoutPage.clickToCountinueButton("payment-info-buttons-container", "payment-info-please-wait");

		log.info("Order [Payment By Cheque] - Step 43: Verify Order Information is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "address1"), billAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "country"), counTry);

		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "address1"), shipAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "country"), counTry);

		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Payment", "payment-method"), "Payment Method: Check / Money Order");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping", "shipping-method"), "Shipping Method: Ground");

		log.info("Order [Payment By Cheque] - Step 44: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");

		log.info("Order [Payment By Cheque] - Step 45: Verify Product is displayed At Confirm Order Step");
		verifyTrue(checkoutPage.areProductDetailDisplayedAtConfirmOrderStep(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY,
				UserData.AppleMacBookPro13inch.SUB_TOTALS));
		
		log.info("Order [Payment By Cheque] - Step 46: Verify 'card-totals' is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-subtotal"), UserData.cartTotal.ORDER_SUBTOTAL);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("shipping-cost"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("tax-value"), UserData.cartTotal.TAX);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-total"), UserData.cartTotal.ORDER_TOTAL);

		log.info("Order [Payment By Cheque] - Step 47: Click to 'Confirm' Button At Comfirm Order Step");
		checkoutPage.clickToConfirmButtonAtConfirmOrderStep();

		log.info("Order [Payment By Cheque] - Step 48: Verify Success Message 'Your order has been successfully processed!' is displayed");
		verifyEquals(checkoutPage.getSuccessMessageOrderCompleted(), "Your order has been successfully processed!");

		log.info("Order [Payment By Cheque] - Step 49: Verify 'Order Number' Text is displayed");
		orderNumber = checkoutPage.getTextOrderNumber().replace("ORDER NUMBER: ", "");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());

		log.info("Order [Payment By Cheque] - Step 50: click to 'My Account' Link");
		checkoutPage.clickToLinkByClass(driver, "ico-account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Order [Payment By Cheque] - Step 51: click to 'Orders' Link");
		customerInforPage.clickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);

		log.info("Order [Payment By Cheque] - Step 52: Verify 'Order Number' Text is displayed with value '" + orderNumber + "'");
		verifyEquals(ordersPage.getTextOrderNumber(), "Order Number: " + orderNumber);

		log.info("Order [Payment By Cheque] - Step 53: Click to 'Details' Link at 'Orders' Page");
		ordersPage.clickToDetalsButton(orderNumber);

		log.info("Order [Payment By Cheque] - Step 54: Verify 'OrderNumber' is displayed");
		verifyEquals(ordersPage.getTextOrderNumberAtOrdersdetail(), "ORDER #" + orderNumber);

//		log.info("Order [Payment By Cheque] - Step 55: Verify 'OrderDate' is displayed");
//		verifyEquals(ordersPage.getTextOrderDate(), "");

		log.info("Order [Payment By Cheque] - Step 56: Verify 'OrderSatus' is displayed");
		verifyEquals(ordersPage.getTextOrderStatus(), "Order Status: Pending");

		log.info("Order [Payment By Cheque] - Step 57: Verify 'OrderTotal' is displayed");
		verifyEquals(ordersPage.getTextOrderTotal(), "Order Total: "+ UserData.cartTotal.ORDER_TOTAL +"");

		log.info("Order [Payment By Cheque] - Step 58: Verify Order Information is displayed correctly at 'Orders' Page");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "address1"), billAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "country"), counTry);

		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "address1"), shipAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "country"), counTry);

		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method"), "Payment Method: Check / Money Order");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method-status"), "Payment Status: Pending");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-method"), "Shipping Method: Ground");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-status"), "Shipping Status: Not yet shipped");

		log.info("Order [Payment By Cheque] - Step 59: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");

		log.info("Order [Payment By Cheque] - Step 60: Verify Product is displayed at 'Orders' Page");
		verifyTrue(ordersPage.areProductDetailDisplayedAtordersPage(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY, UserData.AppleMacBookPro13inch.SUB_TOTALS));
		
		log.info("Order [Payment By Cheque] - Step 61: Verify Verify 'card-totals' is displayed at 'Orders' Page");
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("1"), UserData.cartTotal.ORDER_SUBTOTAL);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("2"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("3"), UserData.cartTotal.TAX);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("4"), UserData.cartTotal.ORDER_TOTAL);

	}

	@Test(dependsOnMethods = { "TC_01_Add_Product_To_Shopping_Card", "TC_02_Edit_Product_In_Shopping_Card", "TC_03_Remove_Product_From_Shopping_Card", "TC_04_Update_Shopping_Card", "TC_05_Order_Checkout_Products_Payment_By_Cheque"})
	public void TC_06_Order_Checkout_Products_Payment_By_Card() {
		log.info("Order [Payment By Card] - Step 01: Click to 'Notebooks' Link");
		ordersPage.openSubMenuPageByNameAtHeaderMenu(driver, "Computers", "Notebooks");
		computersPage = PageGeneratorManager.getUserComputersPage(driver);

		log.info("Order [Payment By Card] - Step 02: Click to '" + UserData.AppleMacBookPro13inch.PRODUCT_NAME + "' Text");
		computersPage.clickToItemLinkByProductName(driver, UserData.AppleMacBookPro13inch.PRODUCT_NAME);
		computersDetailPage = PageGeneratorManager.getUserComputersDetailPage(driver);

		log.info("Order [Payment By Card] - Step 03: Click to 'Add to cart' Button");
		computersDetailPage.checkToAddToCardButton();

		log.info("Order [Payment By Card] - Step 04: Wait For 'Loading Icon' is invisible");
		computersDetailPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Card] - Step 05: Verify Success Message is Displayed with value 'The product has been added to your shopping cart'");
		verifyEquals(computersDetailPage.getTextContentDialog(driver), "The product has been added to your shopping cart");

		log.info("Order [Payment By Card] - Step 06: Wait For Text Content is invisible");
		computersDetailPage.waitForTextContentInvisible(driver);

		log.info("Order [Payment By Card] - Step 07: Open 'Shopping cart' Page");
		computersDetailPage.clickToLinkByClass(driver, "ico-cart");
		shoppingCardPage = PageGeneratorManager.getShoppingCardPage(driver);

		log.info("Order [Payment By Card] - Step 08: Wait For 'Loading Icon' Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Card] - Step 09: Verify Product is added to Card successfully");
		verifyTrue(shoppingCardPage.areProductDetailDisplayed(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY,
				UserData.AppleMacBookPro13inch.SUB_TOTALS));

		log.info("Order [Payment By Card] - Step 10: Click to ' Estimate shipping ' Button");
		shoppingCardPage.clickToEstimateShippingButton();

		log.info("Order [Payment By Card] - Step 11: Select to 'Country' Dropdown with value '" + counTry + "'");
		shoppingCardPage.selectToCountryDropdown(counTry);

		log.info("Order [Payment By Card] - Step 12: Select to 'State' Dropdown with value '" + state + "'");
		shoppingCardPage.selectToStateDropdown(state);

		log.info("Order [Payment By Card] - Step 13: Enter to 'Zip Code' Textbox with value '" + zip + "'");
		shoppingCardPage.enterToZipCodeTextbox(zip);

		log.info("Order [Payment By Card] - Step 14: Click to 'Apply' Button");
		shoppingCardPage.clickToApplyButton();

		log.info("Order [Payment By Card] - Step 15: wait For 'Loading Icon' is Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Payment By Card] - Step 16: Check to 'terms of service' Checkbox");
		shoppingCardPage.checkToTermsOfServiceCheckbox();

		log.info("Order [Payment By Card] - Step 17: Click to 'checkout' Button");
		checkoutPage = shoppingCardPage.clickToCheckoutButton();

		log.info("Order [Payment By Card] - Step 18: Uncheck to 'Ship to the same address' Checkbox At Billing Step");
		checkoutPage.uncheckToShipToTheSameAddressCheckboxAtBillingStep();

		log.info("Order [Payment By Card] - Step 19: Select to 'Billing address' Dropdown At Billing Step");
		checkoutPage.SelectToShippingAddressDropdownAtBillingStep("New Address");

		log.info("Order [Payment By Card] - Step 20: Enter to 'Firstname' Textbox with value '" + firstName + "' At Billing Step");
		checkoutPage.enterToFirstnameTextboxAtBillingStep(firstName);

		log.info("Order [Payment By Card] - Step 21: Enter to 'Lastname' Textbox with value '" + lastName + "' At Billing Step");
		checkoutPage.enterToLastnameTextboxAtBillingStep(lastName);

		log.info("Order [Payment By Card] - Step 22: Enter to 'Email' Textbox At Billing Step");
		checkoutPage.enterToEmailTextboxAtBillingStep(email);

		log.info("Order [Payment By Card] - Step 23: Select to 'Country' Dropdown with value '" + counTry + "' At Billing Step");
		checkoutPage.selectToCountryDropdownAtBillingStep(counTry);

		log.info("Order [Payment By Card] - Step 24: Select to 'State' Dropdown with value '" + state + "' At Billing Step");
		checkoutPage.selectToStateDropdownAtBillingStep(state);

		log.info("Order [Payment By Card] - Step 25: Enter to 'City' Textbox with value '" + city + "' At Billing Step");
		checkoutPage.enterToCityTextboxAtBillingStep(city);

		log.info("Order [Payment By Card] - Step 26: Enter to 'Address 1' Textbox with value '" + billAddress1 + "' At Billing Step");
		checkoutPage.enterToAddress1TextboxAtBillingStep(billAddress1);

		log.info("Order [Payment By Card] - Step 27: Enter to 'Zip code' Textbox with value '" + zip + "' At Billing Step");
		checkoutPage.enterToZipCodeTextboxAtBillingStep(zip);

		log.info("Order [Payment By Card] - Step 28: Enter to 'Phone number' Textbox with value '" + billPhoneNumber + "' At Billing Step");
		checkoutPage.enterToPhoneNumberTextboxAtBillingStep(billPhoneNumber);

		log.info("Order [Payment By Card] - Step 29: Click to 'Countinue' Button");
		checkoutPage.clickToCountinueButton("billing-buttons-container", "billing-please-wait At Billing Step");

		log.info("Order [Payment By Card] - Step 30: Select to 'shipping address' Dropdown At Shipping Step");
		checkoutPage.SelectToShippingAddressDropdownAtShippingStep("New Address");

		log.info("Order [Payment By Card] - Step 31: Select to 'Country' Dropdown with value '" + counTry + "' At Shipping Step");
		checkoutPage.SelectToCountryDropdownAtShippingStep(counTry);

		log.info("Order [Payment By Card] - Step 32: Select to 'State' Dropdown with value '" + state + "' At Shipping Step");
		checkoutPage.SelectToStateDropdownAtShippingStep(state);

		log.info("Order [Payment By Card] - Step 33: Enter to 'City' Textbox with value '" + city + "' At Shipping Step");
		checkoutPage.enterToCityTextboxAtShippingStep(city);

		log.info("Order [Payment By Card] - Step 34: Enter to 'Address 1' Textbox with value '" + shipAddress1 + "' At Shipping Step");
		checkoutPage.enterToAddress1TextboxAtShippingStep(shipAddress1);

		log.info("Order [Payment By Card] - Step 35: Enter to 'Zip code' Textbox with value '" + zip + "' At Shipping Step");
		checkoutPage.enterToZipCodeTextboxAtShippingStep(zip);

		log.info("Order [Payment By Card] - Step 36: Enter to 'Phone number' Textbox with value '" + shipPhoneNumber + "' At Shipping Step");
		checkoutPage.enterToPhoneNumberTextboxAtShippingStep(shipPhoneNumber);

		log.info("Order [Payment By Card] - Step 37: Click to 'Countinue' Button At Shipping Step");
		checkoutPage.clickToCountinueButton("shipping-buttons-container", "shipping-please-wait At Shipping Method Step");

		log.info("Order [Payment By Card] - Step 38: Click to 'Ground ($0.00)' Radio Button At Shipping Method Step");
		checkoutPage.clickToGroundRadioButtonAtShippingMethodStep();

		log.info("Order [Payment By Card] - Step 39: Click to 'Countinue' Button At Shipping Method Step");
		checkoutPage.clickToCountinueButton("shipping-method-buttons-container", "shipping-method-please-wait");

		log.info("Order [Payment By Card] - Step 40: Click to 'Credit Card' Radio Button At Payment method Step");
		checkoutPage.clickToCreditCardRadioButtonAtPaymentMethodStep();

		log.info("Order [Payment By Card] - Step 41: Click to 'Countinue' Button At Payment method Step");
		checkoutPage.clickToCountinueButton("payment-method-buttons-container", "payment-method-please-wait");

		log.info("Order [Payment By Card] - Step 42: Enter to 'Cardholder name' Textbox At Payment Information Step");
		checkoutPage.enterToCardholderNameAtPaymentInforStep(firstName + " " + lastName);

		log.info("Order [Payment By Card] - Step 43: Enter to 'Card number' Textbox At Payment Information Step");
		checkoutPage.enterToCardNumberAtPaymentInforStep(cardNumber);

		log.info("Order [Payment By Card] - Step 44: Select 'Expiration month' Dropdown At Payment Information Step");
		checkoutPage.selectToExpirationMonthAtPaymentInforStep(expirationMonth);

		log.info("Order [Payment By Card] - Step 45: Select 'Expiration year' Dropdown At Payment Information Step");
		checkoutPage.selectToExpirationYearAtPaymentInforStep(expirationYear);

		log.info("Order [Payment By Card] - Step 46: Enter to 'Card code' Textbox At Payment Information Step");
		checkoutPage.enterToCardCodeAtPaymentInforStep(cardCode);

		log.info("Order [Payment By Card] - Step 47: Click to 'Countinue' Button At Payment information Step");
		checkoutPage.clickToCountinueButton("payment-info-buttons-container", "payment-info-please-wait");
		
		log.info("Order [Payment By Card] - Step 48: Verify Order Information is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "address1"), billAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "country"), counTry);
		
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "address1"), shipAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "country"), counTry);
		
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Payment", "payment-method"), "Payment Method: Credit Card");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping", "shipping-method"), "Shipping Method: Ground");
		
		log.info("Order [Payment By Card] - Step 49: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");
		
		log.info("Order [Payment By Card] - Step 50: Verify Product is displayed At Confirm Order Step");
		verifyTrue(checkoutPage.areProductDetailDisplayedAtConfirmOrderStep(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY, UserData.AppleMacBookPro13inch.SUB_TOTALS));
		
		log.info("Order [Payment By Card] - Step 51: Verify 'card-totals' is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-subtotal"), UserData.cartTotal.ORDER_SUBTOTAL);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("shipping-cost"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("tax-value"), UserData.cartTotal.TAX);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-total"), UserData.cartTotal.ORDER_TOTAL);
		
		log.info("Order [Payment By Card] - Step 52: Click to 'Confirm' Button At Comfirm Order Step");
		checkoutPage.clickToConfirmButtonAtConfirmOrderStep();
		
		log.info("Order [Payment By Card] - Step 53: Verify Success Message 'Your order has been successfully processed!' is displayed");
		verifyEquals(checkoutPage.getSuccessMessageOrderCompleted(), "Your order has been successfully processed!");
		
		log.info("Order [Payment By Card] - Step 54: Verify 'Order Number' Text is displayed");
		orderNumber = checkoutPage.getTextOrderNumber().replace("ORDER NUMBER: ", "");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());
		
		log.info("Order [Payment By Card] - Step 55: click to 'My Account' Link");
		checkoutPage.clickToLinkByClass(driver, "ico-account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Order [Payment By Card] - Step 56: click to 'Orders' Link");
		customerInforPage.clickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		log.info("Order [Payment By Card] - Step 57: Verify 'Order Number' Text is displayed with value '"+ orderNumber +"'");
		verifyEquals(ordersPage.getTextOrderNumber(), "Order Number: " + orderNumber);
		
		log.info("Order [Payment By Card] - Step 58: Click to 'Details' Link at 'Orders' Page");
		ordersPage.clickToDetalsButton(orderNumber);
		
		log.info("Order [Payment By Card] - Step 59: Verify 'OrderNumber' is displayed");
		verifyEquals(ordersPage.getTextOrderNumberAtOrdersdetail(), "ORDER #"+ orderNumber);
		
//		log.info("Order [Payment By Card] - Step 60: Verify 'OrderDate' is displayed");
//		verifyEquals(ordersPage.getTextOrderDate(), "");
		
		log.info("Order [Payment By Card] - Step 61: Verify 'OrderSatus' is displayed");
		verifyEquals(ordersPage.getTextOrderStatus(), "Order Status: Pending");
		
		log.info("Order [Payment By Card] - Step 62: Verify 'OrderTotal' is displayed");
		verifyEquals(ordersPage.getTextOrderTotal(), "Order Total: "+ UserData.cartTotal.ORDER_TOTAL +"");
		
		log.info("Order [Payment By Card] - Step 63: Verify Order Information is displayed correctly at 'Orders' Page");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "address1"), billAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "country"), counTry);
		
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "address1"), shipAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "country"), counTry);
		
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method"), "Payment Method: Credit Card");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method-status"), "Payment Status: Pending");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-method"), "Shipping Method: Ground");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-status"), "Shipping Status: Not yet shipped");
		
		log.info("Order [Payment By Card] - Step 64: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");
		
		log.info("Order [Payment By Card] - Step 65: Verify Product is displayed at 'Orders' Page");
		verifyTrue(ordersPage.areProductDetailDisplayedAtordersPage(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.PRODUCT_QUANTITY, UserData.AppleMacBookPro13inch.SUB_TOTALS));
		
		log.info("Order [Payment By Card] - Step 66: Verify Verify 'card-totals' is displayed at 'Orders' Page");
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("1"), UserData.cartTotal.ORDER_SUBTOTAL);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("2"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("3"), UserData.cartTotal.TAX);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("4"), UserData.cartTotal.ORDER_TOTAL);
	}

	@Test(dependsOnMethods = { "TC_01_Add_Product_To_Shopping_Card", "TC_02_Edit_Product_In_Shopping_Card", "TC_03_Remove_Product_From_Shopping_Card", "TC_04_Update_Shopping_Card", "TC_05_Order_Checkout_Products_Payment_By_Cheque", "TC_06_Order_Checkout_Products_Payment_By_Card"})
	public void TC_07_Order_Checkout_Products_Payment_By_Card() {
		log.info("Order [Re-Order] - Step 01: click to 'My Account' Link");
		ordersPage.clickToLinkByClass(driver, "ico-account");
		
		log.info("Order [Re-Order] - Step 02: click to 'Orders' Link");
		customerInforPage.clickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);
				
		log.info("Order [Re-Order] - Step 03: Click to 'Details' Link at 'Orders' Page");
		ordersPage.clickToDetalsButton(orderNumber);
		
		log.info("Order [Re-Order] - Step 04: Click to 'Re-Order' Button at 'Orders' Page");
		shoppingCardPage = ordersPage.clickToReOrderButton();
		
		log.info("Order [Re-Order] - Step 05: Enter to 'Qty' Textbox");
		shoppingCardPage.enterToQtyTextboxInTable(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, "10");

		log.info("Order [Re-Order] - Step 06: Click to 'Update shopping cart' Button");
		shoppingCardPage.clickToUpdateShoppingCartButton();

		log.info("Order [Re-Order] - Step 07: Verify Product is added to Card successfully");
		verifyTrue(shoppingCardPage.areProductDetailDisplayed(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.EDIT_PRODUCT_QUANTITY,
				UserData.AppleMacBookPro13inch.EDIT_SUB_TOTALS));
		
		log.info("Order [Re-Order] - Step 08: Click to ' Estimate shipping ' Button");
		shoppingCardPage.clickToEstimateShippingButton();
		
		log.info("Order [Re-Order] - Step 09: Select to 'Country' Dropdown with value '" + counTry + "'");
		shoppingCardPage.selectToCountryDropdown(counTry);

		log.info("Order [Re-Order] - Step 10: Select to 'State' Dropdown with value '" + state + "'");
		shoppingCardPage.selectToStateDropdown(state);

		log.info("Order [Re-Order] - Step 11: Enter to 'Zip Code' Textbox with value '" + zip + "'");
		shoppingCardPage.enterToZipCodeTextbox(zip);

		log.info("Order [Re-Order] - Step 12: Click to 'Apply' Button");
		shoppingCardPage.clickToApplyButton();

		log.info("Order [Re-Order] - Step 13: wait For 'Loading Icon' is Invisible");
		shoppingCardPage.WaitForLoadingIconInvisibleAtUser(driver);

		log.info("Order [Re-Order] - Step 14: Check to 'terms of service' Checkbox");
		shoppingCardPage.checkToTermsOfServiceCheckbox();

		log.info("Order [Re-Order] - Step 15: Click to 'checkout' Button");
		checkoutPage = shoppingCardPage.clickToCheckoutButton();

		log.info("Order [Re-Order] - Step 16: Uncheck to 'Ship to the same address' Checkbox At Billing Step");
		checkoutPage.uncheckToShipToTheSameAddressCheckboxAtBillingStep();

		log.info("Order [Re-Order] - Step 17: Select to 'Billing address' Dropdown At Billing Step");
		checkoutPage.SelectToShippingAddressDropdownAtBillingStep("New Address");

		log.info("Order [Re-Order] - Step 18: Enter to 'Firstname' Textbox with value '" + firstName + "' At Billing Step");
		checkoutPage.enterToFirstnameTextboxAtBillingStep(firstName);

		log.info("Order [Re-Order] - Step 19: Enter to 'Lastname' Textbox with value '" + lastName + "' At Billing Step");
		checkoutPage.enterToLastnameTextboxAtBillingStep(lastName);

		log.info("Order [Re-Order] - Step 20: Enter to 'Email' Textbox At Billing Step");
		checkoutPage.enterToEmailTextboxAtBillingStep(email);

		log.info("Order [Re-Order] - Step 21 Select to 'Country' Dropdown with value '" + counTry + "' At Billing Step");
		checkoutPage.selectToCountryDropdownAtBillingStep(counTry);

		log.info("Order [Re-Order] - Step 22: Select to 'State' Dropdown with value '" + state + "' At Billing Step");
		checkoutPage.selectToStateDropdownAtBillingStep(state);

		log.info("Order [Re-Order] - Step 23: Enter to 'City' Textbox with value '" + city + "' At Billing Step");
		checkoutPage.enterToCityTextboxAtBillingStep(city);

		log.info("Order [Re-Order] - Step 24: Enter to 'Address 1' Textbox with value '" + billAddress1 + "' At Billing Step");
		checkoutPage.enterToAddress1TextboxAtBillingStep(billAddress1);

		log.info("Order [Re-Order] - Step 25: Enter to 'Zip code' Textbox with value '" + zip + "' At Billing Step");
		checkoutPage.enterToZipCodeTextboxAtBillingStep(zip);

		log.info("Order [Re-Order] - Step 26: Enter to 'Phone number' Textbox with value '" + billPhoneNumber + "' At Billing Step");
		checkoutPage.enterToPhoneNumberTextboxAtBillingStep(billPhoneNumber);

		log.info("Order [Re-Order] - Step 27: Click to 'Countinue' Button");
		checkoutPage.clickToCountinueButton("billing-buttons-container", "billing-please-wait At Billing Step");

		log.info("Order [Re-Order] - Step 28: Select to 'shipping address' Dropdown At Shipping Step");
		checkoutPage.SelectToShippingAddressDropdownAtShippingStep("New Address");

		log.info("Order [Re-Order] - Step 29: Select to 'Country' Dropdown with value '" + counTry + "' At Shipping Step");
		checkoutPage.SelectToCountryDropdownAtShippingStep(counTry);

		log.info("Order [Re-Order] - Step 30: Select to 'State' Dropdown with value '" + state + "' At Shipping Step");
		checkoutPage.SelectToStateDropdownAtShippingStep(state);

		log.info("Order [Re-Order] - Step 31: Enter to 'City' Textbox with value '" + city + "' At Shipping Step");
		checkoutPage.enterToCityTextboxAtShippingStep(city);

		log.info("Order [Re-Order] - Step 32: Enter to 'Address 1' Textbox with value '" + shipAddress1 + "' At Shipping Step");
		checkoutPage.enterToAddress1TextboxAtShippingStep(shipAddress1);

		log.info("Order [Re-Order] - Step 33: Enter to 'Zip code' Textbox with value '" + zip + "' At Shipping Step");
		checkoutPage.enterToZipCodeTextboxAtShippingStep(zip);

		log.info("Order [Re-Order] - Step 34: Enter to 'Phone number' Textbox with value '" + shipPhoneNumber + "' At Shipping Step");
		checkoutPage.enterToPhoneNumberTextboxAtShippingStep(shipPhoneNumber);

		log.info("Order [Re-Order] - Step 35: Click to 'Countinue' Button At Shipping Step");
		checkoutPage.clickToCountinueButton("shipping-buttons-container", "shipping-please-wait At Shipping Method Step");

		log.info("Order [Re-Order] - Step 36: Click to 'Next Day Air ($0.00)' Radio Button At Shipping Method Step");
		checkoutPage.clickToNextDayAirRadioButtonAtShippingMethodStep();

		log.info("Order [Re-Order] - Step 37: Click to 'Countinue' Button At Shipping Method Step");
		checkoutPage.clickToCountinueButton("shipping-method-buttons-container", "shipping-method-please-wait");

		log.info("Order [Re-Order] - Step 38: Click to 'Credit Card' Radio Button At Payment method Step");
		checkoutPage.clickToCreditCardRadioButtonAtPaymentMethodStep();

		log.info("Order [Re-Order] - Step 39: Click to 'Countinue' Button At Payment method Step");
		checkoutPage.clickToCountinueButton("payment-method-buttons-container", "payment-method-please-wait");

		log.info("Order [Re-Order] - Step 40: Enter to 'Cardholder name' Textbox At Payment Information Step");
		checkoutPage.enterToCardholderNameAtPaymentInforStep(firstName + " " + lastName);

		log.info("Order [Re-Order] - Step 41: Enter to 'Card number' Textbox At Payment Information Step");
		checkoutPage.enterToCardNumberAtPaymentInforStep(cardNumber);

		log.info("Order [Re-Order] - Step 42: Select 'Expiration month' Dropdown At Payment Information Step");
		checkoutPage.selectToExpirationMonthAtPaymentInforStep(expirationMonth);

		log.info("Order [Re-Order] - Step 43: Select 'Expiration year' Dropdown At Payment Information Step");
		checkoutPage.selectToExpirationYearAtPaymentInforStep(expirationYear);

		log.info("Order [Re-Order] - Step 44: Enter to 'Card code' Textbox At Payment Information Step");
		checkoutPage.enterToCardCodeAtPaymentInforStep(cardCode);

		log.info("Order [Re-Order] - Step 45: Click to 'Countinue' Button At Payment information Step");
		checkoutPage.clickToCountinueButton("payment-info-buttons-container", "payment-info-please-wait");
		
		log.info("Order [Re-Order] - Step 46: Verify Order Information is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "address1"), billAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Billing Address", "country"), counTry);
		
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "email"), "Email: " + email);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "fax"), "Fax:");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "address1"), shipAddress1);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping Address", "country"), counTry);
		
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Payment", "payment-method"), "Payment Method: Credit Card");
		verifyEquals(checkoutPage.getTextOrderInforAtConfirmOrderStep("Shipping", "shipping-method"), "Shipping Method: Next Day Air");
		
		log.info("Order [Re-Order] - Step 47: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");
		
		log.info("Order [Re-Order] - Step 48: Verify Product is displayed At Confirm Order Step");
		verifyTrue(checkoutPage.areProductDetailDisplayedAtConfirmOrderStep(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.IMAGE, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.EDIT_PRODUCT_QUANTITY, UserData.AppleMacBookPro13inch.EDIT_SUB_TOTALS));
		
		log.info("Order [Re-Order] - Step 49: Verify 'card-totals' is displayed At Confirm Order Step");
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-subtotal"), UserData.cartTotal.EDIT_ORDER_SUBTOTAL);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("shipping-cost"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("tax-value"), UserData.cartTotal.TAX);
		verifyEquals(checkoutPage.getTextCartTotalAtConfirmOrderStep("order-total"), UserData.cartTotal.EDIT_ORDER_TOTAL);
		
		log.info("Order [Re-Order] - Step 49: Click to 'Confirm' Button At Comfirm Order Step");
		checkoutPage.clickToConfirmButtonAtConfirmOrderStep();
		
		log.info("Order [Re-Order] - Step 50: Verify Success Message 'Your order has been successfully processed!' is displayed");
		verifyEquals(checkoutPage.getSuccessMessageOrderCompleted(), "Your order has been successfully processed!");
		
		log.info("Order [Re-Order] - Step 51: Verify 'Order Number' Text is displayed");
		orderNumber = checkoutPage.getTextOrderNumber().replace("ORDER NUMBER: ", "");
		verifyTrue(checkoutPage.isOrderNumberDisplayed());
		
		log.info("Order [Re-Order] - Step 52: click to 'My Account' Link");
		checkoutPage.clickToLinkByClass(driver, "ico-account");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("Order [Re-Order] - Step 53: click to 'Orders' Link");
		customerInforPage.clickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPage(driver);
		
		log.info("Order [Re-Order] - Step 54: Verify 'Order Number' Text is displayed with value '"+ orderNumber +"'");
		verifyEquals(ordersPage.getTextOrderNumber(), "Order Number: " + orderNumber);
		
		log.info("Order [Re-Order] - Step 55: Click to 'Details' Link at 'Orders' Page");
		ordersPage.clickToDetalsButton(orderNumber);
		
		log.info("Order [Re-Order] - Step 56: Verify 'OrderNumber' is displayed");
		verifyEquals(ordersPage.getTextOrderNumberAtOrdersdetail(), "ORDER #"+ orderNumber);
		
//		log.info("Order [Re-Order] - Step 57: Verify 'OrderDate' is displayed");
//		verifyEquals(ordersPage.getTextOrderDate(), "");
		
		log.info("Order [Re-Order] - Step 58: Verify 'OrderSatus' is displayed");
		verifyEquals(ordersPage.getTextOrderStatus(), "Order Status: Pending");
		
		log.info("Order [Re-Order] - Step 59: Verify 'OrderTotal' is displayed");
		verifyEquals(ordersPage.getTextOrderTotal(), "Order Total: "+ UserData.cartTotal.EDIT_ORDER_TOTAL +"");
		
		log.info("Order [Re-Order] - Step 60: Verify Order Information is displayed correctly at 'Orders' Page");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "phone"), "Phone: " + billPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "address1"), billAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Billing Address", "country"), counTry);
		
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "name"), firstName + " " + lastName);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "email"), "Email: " + email);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "phone"), "Phone: " + shipPhoneNumber);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "fax"), "Fax:");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "address1"), shipAddress1);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "city-state-zip"), city + "," + zip);
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping Address", "country"), counTry);
		
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method"), "Payment Method: Credit Card");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Payment", "payment-method-status"), "Payment Status: Pending");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-method"), "Shipping Method: Next Day Air");
		verifyEquals(ordersPage.getTextOrderInforAtordersPage("Shipping", "shipping-status"), "Shipping Status: Not yet shipped");
		
		log.info("Order [Re-Order] - Step 61: Verify 'Gift Wrapping: No' Text is displayed");
		verifyEquals(checkoutPage.getTextGiftWarppingAtConfirmOrderStep(), "Gift wrapping: No");
		
		log.info("Order [Re-Order] - Step 62: Verify Verify 'card-totals' is displayed at 'Orders' Page");
		verifyTrue(ordersPage.areProductDetailDisplayedAtordersPage(driver, UserData.AppleMacBookPro13inch.SKU, UserData.AppleMacBookPro13inch.PRODUCT_NAME, UserData.AppleMacBookPro13inch.PRICE, UserData.AppleMacBookPro13inch.EDIT_PRODUCT_QUANTITY, UserData.AppleMacBookPro13inch.EDIT_SUB_TOTALS));
		
		log.info("Order [Re-Order] - Step 62: Verify Verify 'card-totals' is displayed at 'Orders' Page");
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("1"), UserData.cartTotal.EDIT_ORDER_SUBTOTAL);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("2"), UserData.cartTotal.SHIPPING_COST);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("3"), UserData.cartTotal.TAX);
		verifyEquals(ordersPage.getTextCartTotalAtordersPage("4"), UserData.cartTotal.EDIT_ORDER_TOTAL);
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
	UserShoppingCardPO shoppingCardPage;
	UserCheckoutPO checkoutPage;
	UserOrdersPO ordersPage;
	UserCustomerInforPO customerInforPage;

	String firstName, lastName, date, month, year, email, company, password;
	String counTry, state, city, billAddress1, zip, billPhoneNumber, shipAddress1, shipPhoneNumber;
	String orderNumber, cardNumber, expirationMonth, expirationYear, cardCode;
}
