package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ItBusiness_InteractionWith_Inputs {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.
                LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page = browser.newPage();
        page.navigate("https://www.itbusinessbook.com/");

       assertThat(page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Sign in")));
//       page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Sign up")).click();
//        page.getByText(Pattern.compile("Sign 2UP",Pattern.CASE_INSENSITIVE)).isVisible();
        Thread.sleep(2000);
        page.goBack();
//        assertThat(page
//                .getByText("Sign up", new Page.GetByTextOptions().setExact(true)))
//                .isVisible();


        page.getByPlaceholder("First Name").fill("Vickymurugan@gmail.com");
        playwright.close();
//        page.locator("id=lemail").type("Vickymurugan@gmail.com");
//        Locator password = page.locator("id=lpassword");
//        password.fill("Vicky@12345");
//        password.clear();
//        String value = page.locator("id=ilogin").getAttribute("value");
//        System.out.println(value);
//        Locator locator = page.locator("id=ilogin");
//        locator.press("Tab");

    }
}
