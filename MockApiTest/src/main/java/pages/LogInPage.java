package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {


	static WebDriver driver;

	@FindBy(xpath = "//*[@class='Button IconButton Secondary']")
	WebElement userMenuButton;

	@FindBy(xpath = "//*[text()='Logout']")
	WebElement logOut;

	@FindBy(xpath = "//*/a[text()='Login']")
	WebElement logIn;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*/button[text()='Login']")
	WebElement loginButton;

	public LogInPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void userMenuButton() {

		userMenuButton.click();

	}

	public void logOutFunction() {

		logOut.click();

	}

	public void logInFunction( )   {

		logIn.click();

	}

	public void insertEmail(String emailValue)   {

		email.sendKeys(emailValue);

	}

	public void insertPassword(String pass) {

		password.sendKeys(pass);

	}
	
	public void loginButtonConfirm() {

		loginButton.click();

	}

}
