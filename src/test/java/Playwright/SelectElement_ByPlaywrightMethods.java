package Playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class SelectElement_ByPlaywrightMethods {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.facebook.com/");
        page.getByText("Create new account").click();
        page.locator("select#day:has(option[value='26'])").click();

//        page.navigate("https://www.flipkart.com/");
//        List<String> strings = page.locator("a:has-text('flipkart')").allInnerTexts();
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }

    }
}
