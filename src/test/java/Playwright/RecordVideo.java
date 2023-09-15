package Playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RecordVideo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(1280, 720);
        BrowserContext browserContext = browser.newContext(newContextOptions);
        Page page = browserContext.newPage();
        page.navigate("https://www.itbusinessbook.com/");
        String title = page.title();
        System.out.println(title);
        assertThat(page).hasTitle(title);

        page.fill("id=lemail","Vickymurugan@gmail.com");
//      page.locator("id=lemail").type("Vickymurugan@gmail.com");
        Locator password = page.locator("id=lpassword");
        password.fill("Vicky@12345");
        page.click("id=ilogin");
        page.click("id=ilogin");
        page.click("id=ilogin");
        String s = page.locator("//h3[.='Careers Redefined']").textContent();
        System.out.println(s);
        browserContext.close();
        playwright.close();
    }
}
