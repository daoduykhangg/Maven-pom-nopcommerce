package pageUIs.nopCommerce;

public class UserWishlistUI {
	public static final String WISHLIST_SHARE_LINK = "//a[@class='share-link']";
	public static final String TITLE_WISHLIST_OF = "//div[@class='page wishlist-page']//h1";
	public static final String ADD_TO_CARD_BUTTON = "//input[@name='addtocartbutton']";
	public static final String DYNAMIC_ADD_TO_CART_CHECKBOX_PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td/following-sibling::td//img[contains(@title,'%s')]/parent::a/parent::td/following-sibling::td/a[text()='%s']/parent::td/following-sibling::td//span[text()='%s']/parent::td/following-sibling::td/input[@value='%s']/parent::td/following-sibling::td/span[text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']//input[@name='addtocart']";
	public static final String UPDATE_WISHLIST_BUTTON = "//input[@name='updatecart']";
	
	
}
