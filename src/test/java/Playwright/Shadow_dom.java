package Playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Shadow_dom {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        //Page --> DOM--> ShadowDom--> Elements
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Books of Python");
        //select element by visibility option
        //page.locator("button:visible").textContent();
        //filter options
        //page.locator("button >> visible=true").textContent();

    }
}
