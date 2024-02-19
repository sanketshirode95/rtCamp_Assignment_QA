package amazon;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import pageObject.*;

public class CheckoutProduct {

	public static void main(String[] args) 
	{
	        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		// Navigate to amazon login page
		page.navigate("https://www.amazon.in/");
		Locator myAccount = page.locator("//a[@id='nav-link-accountList']");
		myAccount.hover();
		page.click("//*[@id="nav-flyout-ya-signin"]/a/span");

		// enter login details
		page.fill("//*[@name="email"]", "7020801623");
		page.click("//*[@type="submit"]");

		page.fill("//*[@name="password"]", "sanket1808");
		page.click("//*[@id="auth-signin-button-announce"]");
        
                 //search product and add to cart
                 page.fill("//*[@placeholder="Search Amazon.in"]", "playstation 5");
                 page.click("//*[@id='nav-search-submit-button']");
                 page.click("//*[@type="submit"]");
       
                //go to cart
                 page.click("//span[@id='nav-cart-count']");
                 page.click("//input[@value='Proceed to checkout']");
        
	}

}
