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
	Playwright playwright=Playwright.create();
        Browser browser= playwright.chromium().launch(new LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        Login_po login_po=new Login_po();
		
        // Navigate to amazon login page 
        page.navigate("https://www.amazon.in/");
        Locator myAccount=page.locator("//a[@id='nav-link-accountList']");
        myAccount.hover();
        page.click("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']");
        
        //enter login details
        page.fill("#ap_email", "7020801623");
        page.click("#continue");
        
        page.fill("#ap_password", "sanket1808");
        page.click("#signInSubmit");
        
        //search product and add to cart
        page.fill("#twotabsearchtextbox", "playstation 5");
        page.click("//input[@id='nav-search-submit-button']");
        page.click("#a-autoid-1-announce");
       
        //go to cart
        page.click("//span[@id='nav-cart-count']");
        page.click("//input[@value='Proceed to checkout']");
        
	}

}
