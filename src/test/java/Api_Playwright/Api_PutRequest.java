package Api_Playwright;

import PojoClass_Api.UserClass;
import PojoClass_Api.Users_lombo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Api_PutRequest {
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
    void post_With_Pojo() throws JsonProcessingException {

        // 1. post call
        Users_lombo userLombok = Users_lombo.builder().name("Hawkey").email(randomEmail()).gender("male").status("active").build();
        apiResponse=apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json; charset=utf-8")
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(userLombok));
        System.out.println(apiResponse.status());
        String text = apiResponse.text();
        System.out.println(text);

        // convert response to pojo - deserilizaion

        ObjectMapper objectMapper = new ObjectMapper();
        UserClass userClass = objectMapper.readValue(text, UserClass.class);

        System.out.println("actual user: "+userClass);
        System.out.println(userClass.getEmail());
        System.out.println(userClass.getName());

        Assert.assertNotNull(userClass.getId());
        Assert.assertEquals(userClass.getEmail(),userLombok.getEmail());

        String id = userClass.getId();
        System.out.println(id);

        // update status inactive
        userLombok.setStatus("inactive");
        userLombok.setName("Hawkeye_season");

        // 2. put the api request
        APIResponse response = apiRequestContext.put("https://gorest.co.in/public/v2/users/" + id, RequestOptions.create()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setHeader("Authorization", "Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(userLombok));
        System.out.println(response.status());

        ObjectMapper objectMapper1 = new ObjectMapper();
        UserClass userClass1 = objectMapper.readValue(response.text(), UserClass.class);
        Assert.assertEquals(userClass1.getId(),id);
        Assert.assertEquals(userClass1.getStatus(),userLombok.getStatus());
    }
}
