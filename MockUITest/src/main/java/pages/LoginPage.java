package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	static WebDriver driver;
	
	@FindBy(id = "user-name")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement signInClick;
	

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	

	public void insertUsername(String username) {

		usernameField.sendKeys(username);
			
	}

	public void insertPassword(String pass) {

		passwordField.sendKeys(pass);

	}


	public void confirmSignUpButton() {

		signInClick.click();

	}

}
