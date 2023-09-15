package Playwright;

import com.microsoft.playwright.*;

public class Relative_Locators {
    static Page page;
    static void SelectorCheckBox(String sname){
        page.locator("input[type='checkbox']:left-of(:has-text('"+sname+"'))").first().click();
        String s = page.locator("td:right-of(:has-text('"+sname+"'))").first().textContent();
        System.out.println(s);
        String s1 = page.locator("a:above(:has-text('"+sname+"'))").first().textContent();
        System.out.println(s1);
        String s2 = page.locator("a:below(:has-text('"+sname+"'))").first().textContent();
        System.out.println(s2);
        page.locator("div a >> nth=2").click();

    }
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        SelectorCheckBox("John.Smith");
page.locator("input:near(:text('Help?'))").type("demo");

    }
}