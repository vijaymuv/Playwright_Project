package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Locators_ {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.itbusinessbook.com/");
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Sign in")).last().click();
        page.getByPlaceholder("Your Email",new Page.GetByPlaceholderOptions().setExact(true)).type("Nagm@gmail.com");
//        playwright.close();5
        System.out.println(page.url());
    }
}

