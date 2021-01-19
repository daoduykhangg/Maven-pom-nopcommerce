package pageUIs.nopCommerce;

public class UserOrdersPageUI {
	public static final String ORDER_NUMBER = "//div[contains(@class,'section order-item')]//div[@class='title']//strong";
	public static final String DYNAMIC_DETAILS_BUTTON = "//strong[text()='Order Number: %s']/parent::div/following-sibling::div//input[@value='Details']";
	public static final String DYNAMIC_ORDER_INFOR_TEXT = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
	public static final String DYNAMIC_CARD_TOTAL_TEXT = "(//tr//td[@class='cart-total-right'])[%s]";
	public static final String DYNAMIC_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//a[text()='%s']/parent::em/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td//span[text()='%s']";
	public static final String GIFT_WRAPPING_TEXT = "//div[@class='selected-checkout-attributes']";	
	public static final String ORDER_NUMBER_AT_DETAIL = "//div[@class='order-number']";	
	public static final String ORDER_DATE = "//ul[@class='order-overview-content']//li[@class='order-date']";	
	public static final String ORDER_STATUS = "//ul[@class='order-overview-content']//li[@class='order-status']";	
	public static final String ORDER_TOTAL = "//ul[@class='order-overview-content']//li[@class='order-total']";	
}
