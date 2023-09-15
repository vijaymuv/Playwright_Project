package Playwright;

import com.microsoft.playwright.*;

public class MultipleElements
{
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser launch = playwright.chromium().launch(new BrowserType.LaunchOptions().
                setHeadless(false).setChannel("chrome"));
        //msedge
        Page page = launch.newPage();
        page.navigate("https://letcode.in/elements");
        page.getByPlaceholder("Enter your git user name eg., ortonikc").type("vijaymuv");
        page.click("id=search");

        Locator list = page.locator("ol li a");
        list.last().waitFor();
        System.out.println(list.count());
        for (int i = 0; i <list.count() ; i++) {
            System.out.println(list.nth(i).textContent());
        }

        }
    }

