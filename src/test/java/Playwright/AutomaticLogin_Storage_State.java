package Playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutomaticLogin_Storage_State {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
        page.navigate("https://www.itbusinessbook.com/");
        page.fill("id=lemail","Vickymurugan@gmail.com");
        Locator password = page.locator("id=lpassword");
        password.fill("Vicky@12345");
        Locator signIn = page.locator("id=ilogin");
        Thread.sleep(2000);
        signIn.press("Enter");
        signIn.press("Enter");
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ItLogin.json")));
        playwright.close();
    }
}
