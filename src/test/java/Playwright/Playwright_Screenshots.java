package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotCaret;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Playwright_Screenshots {
    public static void main(String[] args) {
            Playwright playwright = Playwright.create();
            Browser launch = playwright.chromium().launch(new BrowserType.LaunchOptions().
                    setHeadless(false).setChannel("chrome"));
            //msedge
            Page page = launch.newPage();
            page.navigate("https://www.google.com/");
           // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("googleScreenshot.png")));
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("FullscreensHot.png")).setFullPage(true));
        Locator locator = page.locator("//a[.='தமிழ்']");
        locator.hover();
//        locator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("CarpetScreensot.png"))
//                .setCaret(ScreenshotCaret.INITIAL));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Mask.png")).setCaret(ScreenshotCaret.INITIAL).setMask(Arrays.asList(locator)));

        //particular element screenshot
//      locator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("GoogleElement.png")));
        String title = page.title();
        System.out.println(title);
            System.out.println(page.url());
//            playwright.close();

    }
}
