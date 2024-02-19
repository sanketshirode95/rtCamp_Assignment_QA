package amazon;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class Login 
{

	public static void main(String[] args) throws InterruptedException 
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

	}

}
