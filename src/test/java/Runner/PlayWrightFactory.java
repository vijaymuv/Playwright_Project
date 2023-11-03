package Runner;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;


public class PlayWrightFactory {
//    Playwright playwright;
//    Browser browser;
//    BrowserContext context;
//    Page page;
    Properties prop;
    private static ThreadLocal<Playwright> tlPlaywright=new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext=new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage=new ThreadLocal<>();
    private static ThreadLocal<Browser> tlBrowser=new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return tlPlaywright.get();
    }
    public static Browser getBrowser(){
        return tlBrowser.get();
    }
    public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }
    public static Page getPage(){
        return tlPage.get();
    }
    public Page broswserLaunch(String browserName){
        tlPlaywright.set(Playwright.create());
//        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
//                browser=  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
//                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
//                browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
//                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
                break;

            default:
                System.out.println("please enter valid browsername");
                break;
        }

//       context = browser.newContext();
        tlBrowserContext.set(getBrowser().newContext());
//        page = context.newPage();
        tlPage.set(getBrowserContext().newPage());

        return getPage();
    }
      public Page navigate_To(String url){
    getPage().navigate(url,new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    return getPage();
}
    /*
    * initializing properties
    * */
  public Properties init_Properties() throws IOException {
      FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
      prop = new Properties();
      prop.load(fis);
        return prop;
    }
    public void close_Playwright(){
      getPage().close();
      getBrowser().close();
      getPlaywright().close();    }
    public String getTitle(){
        return getPage().title();
    }
    public String getUrl(){
        return getPage().url();
    }
    public static String takesScreenshot(){
        String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
        getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }
}
