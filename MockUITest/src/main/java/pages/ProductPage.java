package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	static WebDriver driver;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartOneItem;

	@FindBy(xpath = "//*[text()='Sauce Labs Backpack']/../../../..//*[@class='inventory_item_price']")
	WebElement getPrice;

	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement shoppingCart;

	@FindBy(name = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "first-name")
	WebElement firstNameField;

	@FindBy(id = "last-name")
	WebElement lastNameField;

	@FindBy(id = "postal-code")
	WebElement zipCodeField;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(name = "finish")
	WebElement finishButton;

	@FindBy(name = "back-to-products")
	WebElement backHome;
	
	@FindBy(name = "remove-sauce-labs-backpack")
	WebElement removeItem;
	
	boolean isClicked = false;

	public ProductPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void addToCartOneItem() {

		addToCartOneItem.click();
		
		isClicked = true;

	}

	public void shoppingCartFunction() {

		shoppingCart.click();

	}

	public void checkoutFunction() {

		checkoutButton.click();

	}

	public void firstName(String firstName) {

		firstNameField.sendKeys(firstName);

	}

	public void lastName(String lastName) {

		lastNameField.sendKeys(lastName);

	}

	public void zipCode(String zipCode) {

		zipCodeField.sendKeys(zipCode);

	}

	public void continueButton() {

		continueButton.click();

	}

	public void finishButton() {

		finishButton.click();

	}

	public void backHome() {

		backHome.click();

	}
	
	public void removeItem() {
		
	
		if(isClicked && removeItem.isDisplayed()) {
			System.out.println("button works correctly");
		}else {
			System.out.println("button does not work correctly");
		}

		removeItem.click();

	}


}
