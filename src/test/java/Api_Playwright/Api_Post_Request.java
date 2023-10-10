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
import java.util.HashMap;
import java.util.Map;

public class Api_Post_Request {
    Playwright playwright;
    APIRequest request;
    APIRequestContext apiRequestContext;
    APIResponse apiResponse;
    static String emailid;
    @BeforeClass
    void setUp(){
      playwright=Playwright.create();
        request= playwright.request();
        apiRequestContext= request.newContext();
    }
    @AfterClass
    void close_(){
       playwright.close();
    }
    public static String randomEmail(){
        emailid ="Hawkey"+System.currentTimeMillis()+"@gmail.com";
        return emailid;
    }
    @Test
    void post_Request() throws IOException {
        Map<String,Object> data=new HashMap<>();
        data.put("name","Hawkey");
        data.put("email",randomEmail());
        data.put("gender","male");
        data.put("status","active");
        // token 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21
        apiResponse=apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json; charset=utf-8")
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(data));
        int status = apiResponse.status();
        System.out.println(status);
        System.out.println(apiResponse.url());
        System.out.println("text "+apiResponse.text());
        System.out.println(apiResponse.statusText());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());

        //capture id from the post json response
        System.out.println(jsonNode.get("id").asText());

        APIResponse id = apiRequestContext.get("https://gorest.co.in/public/v2/users/" + jsonNode.get("id").asText(),RequestOptions.create()
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21"));
        System.out.println(id.status());
        Assert.assertEquals(id.status(),200);
        Assert.assertEquals(id.statusText(),"OK");
        Assert.assertTrue(id.text().contains(emailid));
        System.out.println(id.text());
    }

}
