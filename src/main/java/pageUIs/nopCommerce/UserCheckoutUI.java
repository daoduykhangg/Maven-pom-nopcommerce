package pageUIs.nopCommerce;

public class UserCheckoutUI {
	public static final String BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";
	public static final String BILLING_FIRSTNAME_TEXTBOX = "//input[@id='BillingNewAddress_FirstName']";
	public static final String BILLING_LASTNAME_TEXTBOX = "//input[@id='BillingNewAddress_LastName']";
	public static final String BILLING_EMAIL_TEXTBOX = "//input[@id='BillingNewAddress_Email']";
	public static final String BILLING_COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
	public static final String STATE_LOADING_ICON = "//span[@id='states-loading-progress']";
	public static final String BILLING_STATE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
	public static final String BILLING_CITY_TEXTBOX = "//input[@id='BillingNewAddress_City']";
	public static final String BILLING_ADDRESS1_TEXTBOX = "//input[@id='BillingNewAddress_Address1']";
	public static final String BILLING_ZIPCODE_TEXTBOX = "//input[@id='BillingNewAddress_ZipPostalCode']";
	public static final String BILLING_PHONE_NUMBER_TEXTBOX = "//input[@id='BillingNewAddress_PhoneNumber']";
	
	public static final String DYNAMIC_COUNTINUE_BUTTON = "//div[@id='%s']/input[@value='Continue']";
	public static final String DYNAMIC_LOADING_NEXT_STEP_TEXT = "//span[@id='%s' and text()=' Loading next step...']";
	
	public static final String SHIPPING_ADDRESS_DROPDOWN = "//select[@id='shipping-address-select']";
	public static final String BILLING_ADDRESS_DROPDOWN = "//select[@id='billing-address-select']";
	public static final String SHIPPING_COUNTRY_DROPDOWN = "//select[@id='ShippingNewAddress_CountryId']";
	public static final String SHIPPING_STATE_DROPDOWN = "//select[@id='ShippingNewAddress_StateProvinceId']";
	public static final String SHIPPING_CITY_TEXTBOX = "//input[@id='ShippingNewAddress_City']";
	public static final String SHIPPING_ADDRESS1_TEXTBOX = "//input[@id='ShippingNewAddress_Address1']";
	public static final String SHIPPING_ZIPCODE_TEXTBOX = "//input[@id='ShippingNewAddress_ZipPostalCode']";
	public static final String SHIPPING_PHONE_NUMBER_TEXTBOX = "//input[@id='ShippingNewAddress_PhoneNumber']";
	
	public static final String SHIPPING_METHOD_GROUND_RADIO_BUTTON = "//input[@id='shippingoption_0']";
	public static final String SHIPPING_METHOD_NEXT_DAY_AIR_RADIO_BUTTON = "//input[@id='shippingoption_1']";
	public static final String PAYMENT_METHOD_CHECK_MONEY_ORDER_RADIO_BUTTON = "//input[@id='paymentmethod_0']";
	public static final String DYNAMIC_PAYMENT_INFOR_TEXT = "//div[contains(@class,'section payment-info')]//tr/td/p[%s]";
	
	public static final String DYNAMIC_ORDER_INFOR_TEXT = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
	public static final String DYNAMIC_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td/span[text()='%s']/parent::td/following-sibling::td/span[text()='%s']";
	public static final String GIFT_WRAPPING_TEXT = "//div[@class='selected-checkout-attributes']";	
	public static final String DYNAMIC_CARD_TOTAL_TEXT = "//tr[@class='%s']//span[@class='value-summary']";
	
	public static final String CONFIRM_BUTTON = "//input[@value='Confirm']";
	
	public static final String SUCCESS_MESSAGE_ORDER_COMPLETE = "//div[contains(@class,'section order-completed')]/div[@class='title']//strong";
	public static final String ORDER_NUMBER = "//div[contains(@class,'section order-completed')]/div[@class='details']//strong";
	
	public static final String CREDIT_CARD_RADIO_BUTTON = "//input[@id='paymentmethod_1']";
	public static final String CARDHOLDER_NAME_TEXTBOX = "//input[@id='CardholderName']";
	public static final String CARD_NUMBER_TEXTBOX = "//input[@id='CardNumber']";
	public static final String EXPIRATION_MONTH_DROPDOWN = "//select[@id='ExpireMonth']";
	public static final String EXPIRATION_YEAR_DROPDOWN = "//select[@id='ExpireYear']";
	public static final String CARD_CODE_TEXTBOX = "//input[@id='CardCode']";
	
}
