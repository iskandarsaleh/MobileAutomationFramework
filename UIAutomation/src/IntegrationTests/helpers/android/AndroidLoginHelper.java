package IntegrationTests.helpers.android;
import java.util.List;

import logger.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import IntegrationTests.screens.android.AndroidLoginScreen;
import IntegrationTests.helpers.base.LoginHelper;




/**
 * contains all methods to login on android app
 */
public class AndroidLoginHelper extends LoginHelper{
	AndroidLoginScreen androidLoginScreen;


	public AndroidLoginHelper(WebDriver driver){
		androidLoginScreen = new AndroidLoginScreen(driver);
	}

	/**
	 * method to login to android app
	 * @param userName emailId to be used for login
	 * @param password - valid password
	 */
	@Override
	public void verifyLoginScenario(String userName, String password ) throws InterruptedException {
		androidLoginScreen.waitForVisibility(androidLoginScreen.loginViaSlideShare);
		androidLoginScreen.findElement(androidLoginScreen.loginViaSlideShare).click();
		androidLoginScreen.waitForVisibility(androidLoginScreen.userName);
		androidLoginScreen.findElement(androidLoginScreen.userName).sendKeys(userName);
		androidLoginScreen.findElement(androidLoginScreen.password).sendKeys(password);
		androidLoginScreen.findElement(androidLoginScreen.signInButton).click();

		// verify if "Get Started" button is displayed
		androidLoginScreen.waitForVisibility(androidLoginScreen.startedButton);
		Log.info("Login Successful");

	}





}

