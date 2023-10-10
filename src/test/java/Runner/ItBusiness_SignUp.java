package Runner;

import ItBusinessBook_pages.All_Page_Object;
import Utilities.App_Constants;
import Utilities.PlayWrightFactory;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ItBusiness_SignUp   {
    protected PlayWrightFactory playwright=new PlayWrightFactory();
    public Page page= playwright.broswserLaunch("chrome");
    protected All_Page_Object obj=new All_Page_Object(page);;
    @DataProvider(name="RegisterData")
    public Object [][] datas(){
        String data [][]={{"tony","stark","stark@gmail.com","password"},
                {"steve","rogers","rogers@gmail.com","password"}};
        return data;
    }
    @Test(dataProvider = "RegisterData",dataProviderClass = ItBusiness_SignUp.class)
    public void fillDetails(String fname,String lname,String email,String password) throws InterruptedException, IOException {
        page.navigate("https://www.itbusinessbook.com/");
//        playwright.Navigate_To(prop.getProperty("url"));
       obj.getSignUp().createAccount(fname,lname,email,password);
        Thread.sleep(2000);
//
//        page.click(s.getSignUp());
//        page.locator(s.getFirstName()).fill("name");
//        page.locator(s.getLastname()).fill("lastname");
//        page.locator(s.getEmail()).fill("email");
//        page.locator(s.getPassword()).fill("password");
//        System.out.println(playwright.getUrl());
//        System.out.println(playwright.getTitle());

    }

}