package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.*;

public class TestPage {

	public static WebDriver driver;
	public static WebElement webElement;
	public static WebDriverWait wait;
	private static String PAGE_URL = "https://www.mockapi.io/signup";
	private static String user = "Test123";
	private static String pass = "1234";
	private static String confPass = "1234";
	static String email = "thisismyaddress+" + System.nanoTime() + "@gmail.com";
	public static SignUpPage signUpPage;
	public static LogInPage logInPage;

	@BeforeSuite
	public void setExtent() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(PAGE_URL);

		driver.manage().window().maximize();

		signUpPage = new SignUpPage(driver);
		logInPage = new LogInPage(driver);

		
	}

	@BeforeMethod
	public static void implicitWait() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	

	@Test(priority = 0)
	public void signUpPageTest() {
	
		signUpPage.insertUsername(user);
		signUpPage.insertEmail(email);
		signUpPage.insertPassword(pass);
		signUpPage.insertConfirmPassword(confPass);
		signUpPage.confirmSignUpButton();

	}

	@Test(priority = 1)
	public void loginPageTest() {

		logInPage.userMenuButton();
		logInPage.logOutFunction();
		logInPage.logInFunction();
		logInPage.insertEmail(email);
		logInPage.insertPassword(pass);
		logInPage.loginButtonConfirm();
	}


	@AfterSuite
	public void closePDFAndXML() throws IOException {

		// driver.close();
		// driver.quit();
	}

}
