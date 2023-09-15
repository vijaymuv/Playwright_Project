package Playwright;

import com.microsoft.playwright.*;

public class ItBusiness_InteractionWith_Inputs {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.
                LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page = browser.newPage();
        page.navigate("https://www.itbusinessbook.com/");

        page.fill("id=lemail","Vickymurugan@gmail.com");
//        page.locator("id=lemail").type("Vickymurugan@gmail.com");
        Locator password = page.locator("id=lpassword");
        password.fill("Vicky@12345");
        password.clear();
        String value = page.locator("id=ilogin").getAttribute("value");
        System.out.println(value);
        Locator locator = page.locator("id=ilogin");
        locator.press("Tab");
//        ;

    }
}
