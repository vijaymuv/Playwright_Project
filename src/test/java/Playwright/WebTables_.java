package Playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class WebTables_ {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
//        page.navigate("https://www.dezlearn.com/webtable-example/");
//        Locator row = page.locator("table.tg tr");
//        String s = row.locator(":scope", new Locator.LocatorOptions().setHasText("Tim Watson")).locator("td").nth(1).textContent();
//        int count = row.count();
//        System.out.println(count);
//        System.out.println(s);

        //complex webtable
        page.navigate("https://primeng.org/");
        Locator ro = page.locator("table#pn_id_454-table tr");
//        ro.locator(":scope",new Locator.LocatorOptions().setHasText("James Butt")).locator(".p-checkbox-box").click();
//        System.out.println("clicked");
        Locator locator = page.locator(":scope");
        List<String> strings = locator.allInnerTexts();
        System.out.println(strings.size());
        for (String text: strings) {
            System.out.println(text);
        }

        playwright.close();


    }
}
