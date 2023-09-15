package Playwright;

import com.microsoft.playwright.*;

public class Browser_Context {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.itbusinessbook.com/");

        page.fill("id=lemail","Vickymurugan@gmail.com");
//      page.locator("id=lemail").type("Vickymurugan@gmail.com");
        Locator password = page.locator("id=lpassword");
        password.fill("Vicky@12345");
        page.click("id=ilogin");
        page.click("id=ilogin");
        page.click("id=ilogin");
        String s = page.locator("//h3[.='Careers Redefined']").textContent();
        System.out.println(s);

        /*Page page1 = browserContext.newPage();
        page1.navigate("https://www.itbusinessbook.com/");
        String sq = page.locator("//h3[.='Careers Redefined']").textContent();
        System.out.println(sq);*/
        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://www.itbusinessbook.com/");
//        String sq = page1.locator("//h3[.='Careers Redefined']").textContent();
//        System.out.println(sq);

        //to interact with the any tab use the instance of that page
        page.bringToFront();
        page.locator("id=findall").type("Software Developer");

    }
}
