package Api_Playwright;

import PojoClass_Api.UserClass;
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

public class User_Test {
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
        emailid ="captain"+System.currentTimeMillis()+"@gmail.com";
        return emailid;
    }

    @Test
     void post_With_Pojo() throws JsonProcessingException {
        UserClass user = new UserClass("Steve",randomEmail(),"male","active");
        apiResponse=apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json; charset=utf-8")
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(user));
        System.out.println(apiResponse.status());
        String text = apiResponse.text();
        System.out.println(text);

         // convert response to pojo

        ObjectMapper objectMapper = new ObjectMapper();
        UserClass userClass = objectMapper.readValue(text, UserClass.class);

        System.out.println("actual user: "+userClass);
        System.out.println(userClass.getEmail());
        System.out.println(userClass.getName());
        Assert.assertNotNull(userClass.getId());
        Assert.assertEquals(userClass.getEmail(),user.getEmail());
    }
}
