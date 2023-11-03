package Runner;

import ItBusinessBook_pages.HomePage;
import ItBusinessBook_pages.LoginPage;
import ItBusinessBook_pages.SignUpPage;
import com.microsoft.playwright.Page;

public class All_Page_Object {
    protected Page page;
    private LoginPage login;
    private HomePage home;
    private SignUpPage signUp;

    public All_Page_Object(Page page) {
        this.page=page;
    }
    public SignUpPage getSignUp() {
        if(signUp==null) {
            signUp = new SignUpPage(page);
        }
        return signUp;
    }

    public LoginPage getLogin() {
        if(login==null) {
            login = new LoginPage(page);
        }
            return login;
    }

    public HomePage getHome() {
            if(home==null){
                home =new HomePage(page);
            }
            return home;
    }


}

