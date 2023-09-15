package Playwright;

import com.microsoft.playwright.*;

public class OtherLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://letcode.in/test");
        //page.click("text=Click");
        //or
        page.click("'Click'");
        page.locator("button:has-text('Goto Home')").click();
//        page.locator("nav :text('Product')").click();
//        page.locator("nav :text('Product'):visible").click();
//        page.locator("xpath >> visilbe").click();

    }
}
