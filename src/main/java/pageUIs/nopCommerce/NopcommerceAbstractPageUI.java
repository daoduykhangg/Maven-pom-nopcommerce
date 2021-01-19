package pageUIs.nopCommerce;

import org.openqa.selenium.WebDriver;

public class NopcommerceAbstractPageUI {
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String DYNAMIC_LINK_BY_CLASS = "//a[@class='%s']";
	
	public static final String LOADING_ICON_AT_ADMIN = "//div[@id='ajaxBusy']/span";
	public static final String PANEL_STATUS_BY_PANEL_ID = "//div[@id='%s']/div[contains(@class,'panel-heading')]";
	public static final String UPLOAD_FILE_BY_PANELID_BUTTON = "//div[@id='%s']//input[@type='file']";
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='gender-%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@class='field-validation-error']//span[@id='%s-error']";
	
	public static final String DYNAMIC_PRODUCT_NAME_MENU_PAGE = "//ul[@class='top-menu notmobile']//a[text()='%s']";

	public static final String DYNAMIC_LINK_BY_NAME_IN_FOOTER = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_MENU_PAGE_BY_NAME_AT_HEADER_MENU = "//ul[contains(@class,'top-menu notmobile')]//a[contains(text(),'%s')]";
	
	public static final String ITEM_LINK_BY_PRODUCT_NAME = "//h2[@class='product-title']//a[text()='%s']";
	public static final String LOADING_ICON_AT_USER = "//div[@class='ajax-loading-block-window']";
	public static final String CONTENT_DIALOG = "//p[@class='content']";
	public static final String DYNAMIC_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td/input[@value='%s']/parent::td/following-sibling::td/span[text()='%s']";
	public static final String DYNAMIC_REMOVE_CHECKBOX_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td/input[@value='%s']/parent::td/following-sibling::td/span[text()='%s']/parent::td/preceding-sibling::td[@class='remove-from-cart']//input[@name='removefromcart']";
	public static final String DYNAMIC_QTY_CHECKBOX_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td/input";
	public static final String THE_WISHLIST_IS_EMPTY_TEXT = "//div[@class='no-data']";
	public static final String DYNAMIC_ADD_TO_COMPARE_LIST_BY_PRODUCT_NAME = "//h2[@class='product-title' and string()='%s']/following-sibling::div[@class='add-info']//div//input[@value='Add to compare list']";
	public static final String DYNAMIC_EDIT_LINK_IN_PRODUCT_COL = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[@class='product-unit-price' and text()='%s']/parent::td/preceding-sibling::td[@class='product']//a[text()='Edit']";
}
