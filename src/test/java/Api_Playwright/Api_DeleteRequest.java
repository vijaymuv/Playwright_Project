package Api_Playwright;

import PojoClass_Api.UserClass;
import PojoClass_Api.Users_lombo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.bs.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class Api_DeleteRequest {
    Playwright playwright;
    APIResponse apiResponse;
    APIRequest request;
    APIRequestContext apiRequestContext;

    static String emailid;
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
    public static String randomEmail(){
        emailid ="Hawkey"+System.currentTimeMillis()+"@gmail.com";
        return emailid;
    }

    @Test
    void deleteSpecific_User() throws IOException {

        // creating a request

        Users_lombo userLombok = Users_lombo.builder().name("Hawkey").email(randomEmail()).gender("male").status("active").build();
        apiResponse = apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setHeader("Authorization", "Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(userLombok));
        System.out.println(apiResponse.status());
        String text = apiResponse.text();
        System.out.println(text);
        Assert.assertEquals(apiResponse.status(), 201);

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new ObjectMapper();
        UserClass userClass = objectMapper.readValue(text, UserClass.class);
        String id = userClass.getId();
        Assert.assertNotNull(id);
        System.out.println(id);

        // delete the request

        APIResponse deleteResponse = apiRequestContext.delete("https://gorest.co.in/public/v2/users/" + id, RequestOptions.create()
                .setHeader("Authorization", "Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(userLombok));

        System.out.println(deleteResponse.status());
        Assert.assertEquals(deleteResponse.status(), 204);
        System.out.println("empty respose body " + deleteResponse.text());

        // get the request
    }}