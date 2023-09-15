package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;

public class WindowHandling_ {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser launch = playwright.chromium().launch(new BrowserType.LaunchOptions().
                setHeadless(false).setChannel("chrome"));
        //msedge
        Page page = launch.newPage();
        page.navigate("https://letcode.in/windows");

        Page popoup = page.waitForPopup(() -> {
            page.locator("id=home").click();
        });
        popoup.waitForLoadState();
        System.out.println(page.url());
        System.out.println(page.title());
        if(true){
            page.close();
        }

       /* page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p -> p.context().pages().size()==3)
        ,()->{page.locator("id=multi").click();});

        List<Page> pages = page.context().pages();
        for (Page page1: pages) {
            page1.waitForLoadState();
            System.out.println(page1.url());
        }
        Page alert = pages.get(1);
        alert.bringToFront();
        alert.locator("//button[.='Simple Alert']").click();

        System.out.println("home page ");*/
    }
}
