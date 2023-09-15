package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;


public class Dropdown_ {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions chrome = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
        Browser browser = playwright.chromium().launch(chrome);
        Page page = browser.newPage();
        page.navigate("https://letcode.in/dropdowns");
//      page.selectOption("id=fruits","1");
        /*Locator fruits = page.locator("id=fruits");
        fruits.selectOption(new SelectOption().setLabel("Apple"));

        String texgt = page.locator("//p[.='You have selected Apple']").textContent();
        System.out.println(texgt);*/

        // select by multiple
       /* Locator heros = page.locator("id=superheros");
        String [] s ={"bt","bw","gx","ff"};
        heros.selectOption(s);*/
//      using for loop iterate the dropdown values
        Locator locator = page.locator("#lang");
        Locator options = locator.locator("option");
        int count = options.count();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(locator.selectOption(new SelectOption().setIndex(i)));
        }

    }
}
