package pageUIs.nopCommerce;

public class AdminCustomersUI {
	public static final String ADD_NEW_BUTTON = "//div[@class='pull-right']//a";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
 	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String GENDER_MALE_RADIO_BUTTON = "//input[@id='Gender_Male']";
	public static final String DATE_OF_BIRTH_TEXTBOX = "//input[@id='DateOfBirth']";
	public static final String COMPANYNAME_TEXTBOX = "//input[@id='Company']";
	public static final String DELETE_BUTTON_ATCUSTOMER_ROLES = "//span[@aria-label='delete']";
	public static final String CUSTOMER_ROLES_DROPDOWN = "//label[@id='SelectedCustomerRoleIds_label']/parent::div/parent::div/following-sibling::div//div[@role='listbox']";
	public static final String GUEST_OPTION = "//li[text()='Guests']";
	public static final String GUEST_TEXT = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='Guests']";
	public static final String ADMIN_COMMENT_TEXTBOX = "//textarea[@id='AdminComment']";
	public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "//button[@name='save-continue']";
	public static final String SUCCESS_MESSAGE_TEXT = "//div[contains(@class,'alert alert-success alert-dismissable')]";
	public static final String BACK_TO_CUSTOMER_LIST = "//a[text()='back to customer list']";
	public static final String SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String INFOR_CUSTOMER_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[@class=' text-center']//i[contains(@class,'%s-icon')]";
	public static final String EMAIL_TEXTBOX_IN_SEARCH_SECTION = "//input[@id='SearchEmail']";
	public static final String FIRSTNAME_TEXTBOX_IN_SEARCH_SECTION = "//input[@id='SearchFirstName']";
	public static final String LASTNAME_TEXTBOX_IN_SEARCH_SECTION = "//input[@id='SearchLastName']";
	public static final String COMPANYNAME_TEXTBOX_IN_SEARCH_SECTION = "//input[@id='SearchCompany']";
	public static final String MONTH_DROPDOWN_IN_SEARCH_SECTION = "//select[@id='SearchMonthOfBirth']";
	public static final String DAY_DROPDOWN_IN_SEARCH_SECTION = "//select[@id='SearchDayOfBirth']";
}
