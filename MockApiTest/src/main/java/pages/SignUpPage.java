package pages;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	static String pass ;
	static WebDriver driver;

	static String userText;
	static String emailText;
	static String passwordText;
	static String confirmPasswordText;
	public static String randomEmail;

	@FindBy(name = "name")
	WebElement username;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[text()='Sugn up']")
	WebElement signUpClick;

	public SignUpPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void insertUsername(String user) {

		username.sendKeys(user);

		userText = username.getAttribute("value");

		System.out.println(userText);
		emailText = emailField.getAttribute("value");
		passwordText = password.getAttribute("value");
		confirmPasswordText = confirmPassword.getAttribute("value");

		if (!userText.isEmpty() && emailText.isEmpty() && passwordText.isEmpty() && confirmPasswordText.isEmpty()
				&& !signUpClick.isEnabled()) {
			System.out.println("correct: all fields are mandatory");

		} else {
			System.out.println("wrong: all fields must be mandatory");
		}

	}

	

	public void insertEmail(String email) {

		emailField.sendKeys(email);
		emailText = emailField.getAttribute("value");
		passwordText = password.getAttribute("value");
		confirmPasswordText = confirmPassword.getAttribute("value");

		if (!userText.isEmpty() && !emailText.isEmpty() && passwordText.isEmpty() && confirmPasswordText.isEmpty()
				&& !signUpClick.isEnabled()) {
			System.out.println("correct: all fields are mandatory");

		} else {
			System.out.println("wrong: all fields must be mandatory");
		}

	}

	public void insertPassword(String pass) {

		this.pass = pass;
		password.sendKeys(pass);

		emailText = emailField.getAttribute("value");
		passwordText = password.getAttribute("value");
		confirmPasswordText = confirmPassword.getAttribute("value");

		if (!userText.isEmpty() && !emailText.isEmpty() && !passwordText.isEmpty() && confirmPasswordText.isEmpty()
				&& !signUpClick.isEnabled()) {
			System.out.println("correct: all fields are mandatory");

		} else {
			System.out.println("wrong: all fields must be mandatory");

		}

	}

	public void insertConfirmPassword(String retypePass) {

		confirmPassword.sendKeys(retypePass);

		confirmPasswordText = confirmPassword.getAttribute("value");

		if (!userText.isEmpty() && !emailText.isEmpty() && !passwordText.isEmpty() && !confirmPasswordText.isEmpty()
				&& signUpClick.isEnabled()) {
			System.out.println("correct: all fields are mandatory");

		} else {
			System.out.println("wrong: all fields must be mandatory");

		}

		if (pass.equals(retypePass)) {
			System.out.println("password matching");
		} else {
			System.out.println("the retyped password do not match the password ");
		}

	}

	public void confirmSignUpButton() {

		signUpClick.click();

	}

}
