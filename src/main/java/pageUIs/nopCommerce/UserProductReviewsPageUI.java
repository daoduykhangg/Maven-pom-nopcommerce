package pageUIs.nopCommerce;

public class UserProductReviewsPageUI {
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTBOX = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String DYNAMIC_RATING_RADIO_BUTTON = "//div[@class='rating-options']//input[@value='%s']";
	public static final String SUBMIT_REVIEW_BUTTON = "//input[@name='add-review']";
	public static final String SUCCESS_MESSAGE_PRODUCT_REVIEW = "//div[@class='result' and contains(text(),'Product review is successfully added.')]";
}
