package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInforPO getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}
	
	public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPO(driver);
	}
	public static UserComputersPO getUserComputersPage(WebDriver driver) {
		return new UserComputersPO(driver);
	}
	
	public  static UserComputersDetailPO getUserComputersDetailPage(WebDriver driver) {
		return new UserComputersDetailPO(driver);
	}
	
	public  static UserProductReviewsPO getUserProductReviewsPage(WebDriver driver) {
		return new UserProductReviewsPO(driver);
	}
	
	public static UserSearchPO getSearchPage(WebDriver driver) {
		return new UserSearchPO(driver);
	}
	
	public static UserWishlistPO getWishlistPage(WebDriver driver) {
		return new UserWishlistPO(driver);
	}
	
	public static UserShoppingCardPO getShoppingCardPage(WebDriver driver) {
		return new UserShoppingCardPO(driver);
	}
	
	public static UserCompareProductsPO getUserCompareProductsPage(WebDriver driver) {
		return new UserCompareProductsPO(driver);
	}
	
	public static UserRecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
		return new UserRecentlyViewedProductsPO(driver);
	}
	
	public static UserCheckoutPO getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPO(driver);
	}
}
