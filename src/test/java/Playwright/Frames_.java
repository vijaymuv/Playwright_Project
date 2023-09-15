package Playwright;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.regex.Pattern;

public class Frames_ {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/iframe");
        FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");
        String s = page.locator("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[4]/span").textContent();
        System.out.println(s);
        page.locator("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[2]/span").click();
        page.locator("//div[.='Select all']").click();
        page.locator("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[2]/span").click();
        page.locator("//div[.='Cut']").click();
        frameLocator.locator("//*[@id=\"tinymce\"]/p").fill("Hello");

//        frame.getByPlaceholder("Enter name").type("name");
//        frame.getByPlaceholder("Enter email").type("email@gmail.com");
//        List<Frame> frames = frame.childFrames();
//
//        for(Frame frame1: frames) {
//            System.out.println(frame1.url());
//        }

//        Frame frame1 = page.frameByUrl("https://letcode.in/innerFrame");
//        frame1.getByPlaceholder("Enter email").type("email@gmail.com");
        //Frame innerFrame = page.frameByUrl(Pattern.compile("innerFrame"));
//        innerFrame.getByPlaceholder("Enter email").type("email@gmail.com");

        //way 2 direct finding frame and perform actions
//        FrameLocator frameLocator = page.frameLocator("id=firstFr");
//        frameLocator.getByPlaceholder("Enter email").type("email@gmail.com");

    }
}
