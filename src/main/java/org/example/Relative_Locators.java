package org.example;

import com.microsoft.playwright.*;

public class Relative_Locators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://letcode.in/test");
        page.pause();
        page.locator("//a[.='Edit']").click();
        page.waitForTimeout(3000);
        page.fill("input:below(:text('Enter your full Name'))","java");
        page.fill("input:above(:text('What is inside the text box'))","nothing");
        page.fill("input:above(:text('What is inside the text box'))","nothing");
        page.navigate("https://github.com/login");
        page.click("a:near(:text('Password'))");
        playwright.close();
    }
}
