package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload_Download_ {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height =screenSize.getHeight();
        double width=screenSize.getWidth();
        System.out.println(height+" "+width);
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext browserContext = browser.newContext( new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
        Page page = browserContext.newPage();
//        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
//        //single file upload
//        page.setInputFiles("input#filesToUpload",Paths.get("C:/Users/Friday/Downloads/white.png"));
//        //to remove the uploaded file
//        page.setInputFiles("input#filesToUpload",new Path[0]);
        //multiple files
//        page.setInputFiles("input#filesToUpload",new Path[]{Paths.get("C:/Users/Friday/Downloads/white.png"),Paths.get("C:/Users/Friday/Downloads/black.png")});
        //runtime file upload
//        page.setInputFiles("input#filesToUpload",
//                  new FilePayload("Demo.text","text/plain","hello".getBytes(StandardCharsets.UTF_8)));
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
        Download download = page.waitForDownload(() -> {
//      page.locator("//a[.='chromedriver_win32.zip']").click();
            page.getByText("chromedriver_win32.zip").click();
        });
        download.cancel();
        System.out.println(download.failure());

        System.out.println(download.url());
        //to get where it  stored  in our system
        String string = download.path().toString();
        System.out.println(string);
        //to save in a particular path
        download.saveAs(Paths.get("Driver.Zip"));
        // it will fetc the downloaded file name
        System.out.println(download.suggestedFilename());
        playwright.close();
    }
}
