package ItBusinessBook_pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    //string locators
    private String email="#lemail";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    private String password="#lpassword";
    private String login="#ilogin";
    private String forgetPassword="//a[.='Forgot Password?']";
    private String MyprofileName="//a[normalize-space()='Tony Stark']";

    public LoginPage(Page page) {
        this.page=page;
    }


    // 2nd actions to preform
    public boolean isForgetPassword_Present(){
        boolean visible = page.locator(forgetPassword).isVisible();
        return visible;
    }
   public void doLogin(String email1, String password1) throws InterruptedException {
       page.locator(email).fill(email1);
       page.locator(password).fill(password1);
       Thread.sleep(2000);
       page.locator(login).click();
       Thread.sleep(2000);

   }


}
