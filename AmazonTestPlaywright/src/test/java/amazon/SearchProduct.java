package amazon;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class SearchProduct 
{
       public static void main(String[] args)
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to amazon login page
		page.navigate("https://www.amazon.in/");
		Locator myAccount = page.locator("//a[@id='nav-link-accountList']");
		myAccount.hover();
		page.click("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']");

		// enter login details
		page.fill("#ap_email", "7020801623");
		page.click("#continue");

		page.fill("#ap_password", "sanket1808");
		page.click("#signInSubmit");
		
		// Validate search result
		String searchTerm = "sony ps5 console";
		page.fill("#twotabsearchtextbox", searchTerm);
		page.click("//input[@id='nav-search-submit-button']");
		//page.waitForNavigation();
		page.waitForTimeout(5000);
		
		boolean searchResultValidated = page.isVisible("//span[contains(text(), 'Sony PS5 Console')]");
	
		if (searchResultValidated) {
			System.out.println("Search result validated successfully for term: " + searchTerm);
		} else {
			System.out.println("Search result validation failed for term: " + searchTerm);
		}
	}

}
