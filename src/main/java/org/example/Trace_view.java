package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Trace_view {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions headed = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
        BrowserType BroType = playwright.chromium();
        Browser browser = BroType.launch(headed);
        BrowserContext browserContext = browser.newContext();
        browserContext.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );
        Page page = browserContext.newPage();
        page.navigate("https://www.itbusinessbook.com/");

        page.fill("id=lemail","Vickymurugan@gmail.com");
//        page.locator("id=lemail").type("Vickymurugan@gmail.com");
        Locator password = page.locator("id=lpassword");
        password.fill("Vicky@12345");
        String value = page.locator("id=ilogin").getAttribute("value");
        System.out.println(value);
        Locator locator = page.locator("id=ilogin");
        locator.click();

        page.navigate("https://letcode.in/edit");
        page.fill("id=fullName","java");

        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
         browserContext.close();
         playwright.close();

    }
}
