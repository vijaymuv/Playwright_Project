package Playwright;

import com.microsoft.playwright.*;

import java.util.function.Consumer;

class Mydialog implements Consumer<Dialog>{

    @Override
    public void accept(Dialog alert) {
        System.out.println(alert.message());
        alert.accept("Jva");
        System.out.println("alerts handling");
    }
}
public class Alerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setChannel("chrome"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://letcode.in/alert");
//            page.onDialog(dialog -> {
//                System.out.println(dialog.message());
//                dialog.accept();
//            });
//            page.locator("//button[.='Simple Alert']").click();
            Consumer<Dialog> d = new Mydialog();
            page.onDialog(d);
            page.locator("#prompt").click();
            System.out.println(page.locator("#myName").textContent());
    }
}
