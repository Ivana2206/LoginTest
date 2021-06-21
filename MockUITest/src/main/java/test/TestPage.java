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
	private static String PAGE_URL = "https://www.saucedemo.com/";
	private static String user = "standard_user";
	private static String pass = "secret_sauce";
	private static String firstName = "test";
	private static String lastName = "test";
	private static String zipCode = "1111";
	public static LoginPage loginPage;
	public static ProductPage productPage;

	@BeforeSuite
	public void setExtent() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(PAGE_URL);

		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);

		
	}

	@BeforeMethod
	public static void implicitWait() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	

	@Test(priority = 0)
	public void signUpPageTest() {
	
		loginPage.insertUsername(user);
		loginPage.insertPassword(pass);
		loginPage.confirmSignUpButton();

	}

	@Test(priority = 1)
	public void loginPageTest() {

		productPage.addToCartOneItem();
		productPage.shoppingCartFunction();
		productPage.checkoutFunction();
		productPage.firstName(firstName);
		productPage.lastName(lastName);
		productPage.zipCode(zipCode);
		productPage.continueButton();
		productPage.finishButton();
		productPage.backHome();
		productPage.addToCartOneItem();
		productPage.removeItem();
	}


	@AfterSuite
	public void closeDriver(){

		 driver.close();
		 driver.quit();
	}

}
