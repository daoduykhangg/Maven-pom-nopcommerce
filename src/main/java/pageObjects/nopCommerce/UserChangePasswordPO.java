package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserChangePasswordPageUI;

public class UserChangePasswordPO extends AbstractPage {
	WebDriver driver;

	public UserChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void enterToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public UserHomePO ClickToLogoutLink() {
		waitForElementClickable(driver, UserChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, UserChangePasswordPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getSuccessMessageOfChangePassword() {
		waitForElementVisible(driver, UserChangePasswordPageUI.RESULT_CHANGE_PASSWORD_TEXT);
		return getTextElement(driver, UserChangePasswordPageUI.RESULT_CHANGE_PASSWORD_TEXT);
	}
}
