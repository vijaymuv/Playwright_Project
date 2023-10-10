package Playwright;

import Utilities.App_Constants;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PageAssertions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.setDefaultAssertionTimeout;

public class Assertions_{
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page = browser.newPage();
        page.navigate("https://www.itbusinessbook.com/");
        page.fill("id=lemail","Vickymurugan@gmail.com");
        Locator locator = page.locator("//h3[.='Sign in']");
        assertThat(locator).hasText("Sign in");
        setDefaultAssertionTimeout(5000);
        assertThat(page).hasTitle(App_Constants.LOGIN_PAGE_TITLE, new PageAssertions.HasTitleOptions().setTimeout(3000));
        playwright.close();

    }
}
