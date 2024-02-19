package amazon;

import javax.lang.model.element.Element;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;

public class WishlistFunctionality {

	public static void main(String[] args) throws InterruptedException {
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

		// Search for a product
		page.fill("input[id='twotabsearchtextbox']", "playstation 5");
		page.keyboard().press("Enter");
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);

		// Click on the first product in the search results
		page.click("//span[normalize-space()='Sony PS5 Console']");
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);		

		// Click on the 'Add to WIsh List' button to add the product to wishlist
		page.click("//a[@title='Add to Wish List']");
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);

		// Verify if the product has been added to the wishlist successfully
		boolean isProductAddedToWishlist = page.isVisible("//span[@class='huc-atwl-header-small' and contains(text(), 'Apple iPhone 13 (128GB) - Midnight')]");
		if (isProductAddedToWishlist) {
			System.out.println("Product successfully added to wishlist!");
		} else {
			System.out.println("Failed to add product to wishlist!");
		}

		browser.close();
	}
}
