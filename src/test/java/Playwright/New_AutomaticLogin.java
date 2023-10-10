package Playwright;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class New_AutomaticLogin {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().
                setStorageStatePath(Paths.get("ItLogin.json")));
        Page page = browserContext.newPage();
        page.navigate("https://www.itbusinessbook.com/");
        playwright.close();
    }
}
