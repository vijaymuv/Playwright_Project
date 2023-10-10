package Runner;

import ItBusinessBook_pages.All_Page_Object;
import Utilities.App_Constants;
import Utilities.PlayWrightFactory;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginIntoIt{
    protected PlayWrightFactory playwright=new PlayWrightFactory();
    public Page  page= playwright.broswserLaunch("chrome");
    protected All_Page_Object obj=new All_Page_Object(page);
    @Test(priority = 1,dataProvider = "LoginDatas")
    void loginIntoIt(String email,String password) throws InterruptedException {
       playwright.navigate_To("https://www.itbusinessbook.com/");
        obj.getLogin().doLogin(email,password);
        Assert.assertEquals(playwright.getTitle(), App_Constants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    void forgetPasswordTest(){
//        playwright.Navigate_To("https://www.itbusinessbook.com/");
        obj.getLogin().isForgetPassword_Present();
        playwright.close_Playwright();
    }
    @DataProvider(name="LoginDatas")
    public Object [][] datas(){
        String data [][]={{"stark@gmail.com","starkpassword"},
                {"rogers@gmail.com","password"}};
        return data;
    }
}


