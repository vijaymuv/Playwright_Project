package Runner;

import ItBusinessBook_pages.All_Page_Object;
import ItBusinessBook_pages.LoginPage;
import ItBusinessBook_pages.SignUpPage;
import Utilities.App_Constants;
import Utilities.PlayWrightFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class step_loginIt {
    protected PlayWrightFactory playwright;
    Page page;
    protected All_Page_Object obj;

    @Given("user launches browser and navigates to it business book")
    public void userLaunchesBrowserAndNavigatesToItBusinessBook() {
        playwright = new PlayWrightFactory();
        page= playwright.broswserLaunch("chrome");
        obj=new All_Page_Object(page);
        page.navigate("https://www.itbusinessbook.com/");
    }
    @When("user enters email and password")
    public void userEntersEmailAndPassword() throws InterruptedException {

        page.locator(obj.getLogin().getEmail()).fill("vickymurugan@gmail.com");
        page.locator(obj.getLogin().getPassword()).fill("Vicky@12345");
    }
    @When("user clicks login button")
    public void userClicksLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        page.locator(obj.getLogin().getLogin()).click();
        System.out.println("user clicks login button");
        Thread.sleep(2000);
    }
    @Then("user validates the outcome")
    public void userValidatesTheOutcome() {
        Assert.assertEquals(page.title(), App_Constants.HOME_PAGE_TITLE);
        playwright.close_Playwright();
    }
}
