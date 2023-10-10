package Api_Playwright;

import PojoClass_Api.UserClass;
import PojoClass_Api.Users_lombo;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Api_PostRequestWith_JsonString {
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
        emailid ="tony"+System.currentTimeMillis()+"@gmail.com";
        return emailid;
    }
    @Test
    void post_RequestWith_JsonString() throws IOException {

        //string body
//        String body ="{\n" +
//                "    \"name\":\"Tony3\",\n" +
//                "    \"email\":\"tony3@gmail.com1\",\n" +
//                "    \"gender\":\"male\",\n" +
//                "    \"status\":\"active\"\n" +
//                "}";

        //using json file

        File file = new File("C:\\Users\\Friday\\IdeaProjects\\Playwright_Project\\user.json");
        byte[] bytes = Files.readAllBytes(file.toPath());

        // token 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21
        apiResponse=apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json; charset=utf-8")
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                .setData(bytes));
        int status = apiResponse.status();
        System.out.println(status);
        System.out.println(apiResponse.url());
        System.out.println("text "+apiResponse.text());
        System.out.println(apiResponse.statusText());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println(jsonNode.toPrettyString());
        Assert.assertEquals(apiResponse.status(),201);
        Assert.assertEquals(apiResponse.statusText(),"Created");
        //capture id from the post json response
        System.out.println(jsonNode.get("id").asText());

        APIResponse id = apiRequestContext.get("https://gorest.co.in/public/v2/users/" + jsonNode.get("id").asText(),RequestOptions.create()
                .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21"));
        System.out.println(id.status());
        Assert.assertEquals(id.status(),200);
        Assert.assertEquals(id.statusText(),"OK");
        Assert.assertTrue(id.text().contains("Superior"));
        System.out.println(id.text());
    }

    public static class User_lombokTest {
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
            emailid ="stark"+System.currentTimeMillis()+"@gmail.com";
            return emailid;
        }

        @Test
        void post_With_Pojo() throws JsonProcessingException {

            // create object for user_lombok class
            Users_lombo users_lombo = Users_lombo.builder().name("Stark")
                    .email(randomEmail())
                    .gender("male")
                    .status("active").build();
            apiResponse=apiRequestContext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                    .setHeader("Content-Type","application/json; charset=utf-8")
                    .setHeader("Authorization","Bearer 7a0c69b74e7c13d735c42ff39524d93436ba5260ffd26e60680c1334bf938d21")
                    .setData(users_lombo));
            System.out.println(apiResponse.status());
            String text = apiResponse.text();
            System.out.println(text);

            // convert response to pojo - deserilization

            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            UserClass userClass = objectMapper.readValue(text, UserClass.class);

            System.out.println("actual user: "+userClass);
            System.out.println(userClass.getEmail());
            System.out.println(userClass.getName());
            Assert.assertNotNull(userClass.getId());
            Assert.assertEquals(userClass.getEmail(),users_lombo.getEmail());
        }

    }
}
