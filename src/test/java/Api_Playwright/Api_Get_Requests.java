package Api_Playwright;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class Api_Get_Requests {
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
    void getApiRequest() throws IOException {
        apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");
        System.out.println(apiResponse.status());
        System.out.println("status message: "+apiResponse.statusText());
        System.out.println("url: "+apiResponse.url());
        System.out.println("plain text: "+apiResponse.text());
        Map<String, String> headers = apiResponse.headers();
        System.out.println(headers);
        Assert.assertEquals(apiResponse.ok(),true);
        Assert.assertEquals(headers.get("content-type"),"application/json; charset=utf-8");

        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    void getSpecific_User() throws IOException {
        apiResponse=apiRequestContext.get("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setQueryParam("id","5223938"));
        System.out.println(apiResponse.status());
        System.out.println("status message: "+apiResponse.statusText());
        System.out.println("url: "+apiResponse.url());
        System.out.println("plain text: "+apiResponse.text());
        Map<String, String> headers = apiResponse.headers();
        System.out.println(headers);
        Assert.assertEquals(apiResponse.ok(),true);
        Assert.assertEquals(headers.get("content-type"),"application/json; charset=utf-8");

        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());
    }


}
