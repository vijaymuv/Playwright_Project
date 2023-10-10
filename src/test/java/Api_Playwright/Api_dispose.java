package Api_Playwright;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.HttpHeader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Api_dispose {
    Playwright playwright;
    APIRequest request;
    APIRequestContext apiRequestContext;
    APIResponse apiResponse;
    @BeforeClass
    void setUp(){
        playwright = Playwright.create();
        request = playwright.request();
        apiRequestContext = request.newContext();
    }
    @AfterClass
    void close_(){
        playwright.close();
    }
    @Test
    void dispose_Api(){
        apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users?id=5224334");
        System.out.println(apiResponse.status());
        System.out.println("status message: "+apiResponse.statusText());
        System.out.println("url: "+apiResponse.url());
        System.out.println("plain text: "+apiResponse.text());
        System.out.println("<-----status code before dispose method----->");
        System.out.println(apiResponse.status());
        apiResponse.dispose();
        // dispose method - will only dispose the method body but the status code, url, status text
//        System.out.println("plain text: "+apiResponse.text());
        System.out.println("<-----status code after dispose method----->");
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.url());
        System.out.println(apiResponse.statusText());
        // second request
        List<HttpHeader> httpHeaders = apiResponse.headersArray();
        for (HttpHeader head:httpHeaders
             ) {
            System.out.println(head.name +":"+head.value);
        }

//        APIResponse apiResponse1 = apiRequestContext.get("https://gorest.co.in/public/v2/users");
//        System.out.println(apiResponse1.status());
//
//       apiRequestContext.dispose();
////after request context disposed
//        System.out.println("status message: "+apiResponse1.text());
//        System.out.println("status message: "+apiResponse.text());
    }
}
