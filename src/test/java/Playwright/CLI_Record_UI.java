package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CLI_Record_UI {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://letcode.in/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drop-Down")).click();
            page.locator("#fruits").selectOption("3");
            page.locator("#superheros").selectOption("aq");
            page.locator("#superheros").selectOption("ta");
            page.locator("#superheros").selectOption("bt");
            page.locator("#superheros").selectOption("ds");
            System.out.println("finished");
        }
    }
}
