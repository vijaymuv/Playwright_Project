package ItBusinessBook_pages;
import com.microsoft.playwright.Page;
import org.testng.annotations.DataProvider;

public class SignUpPage {
    Page page;
    //String locator

//    public void setPage(Page page) {
//        this.page = page;
//    }

//    public Page getPage() {
//        return page;
//    }
//
//
//
//    public String getSignUp() {
//        return SignUp;
//    }
//
//    public void setSignUp(String signUp) {
//        SignUp = signUp;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
private String SignUp="//a[.='Sign up']";
    private String firstName="#firstname";
    private String lastname="#lastname";
    private String email="#email";
    private String password="#password";
    private String GetStartSignUp="#iregister";

    //page constructor
    public SignUpPage(Page page){
        this.page=page;
    }


public void setFirstname(String firstNm){
        page.fill(firstName,firstNm);
}
    public void setLastname(String lstname){
        page.fill(lastname,lstname);
    }
    public void setEmail(String emailq){
        page.fill(email,emailq);
    }
    public void setPassword(String pass){
        page.fill(password,pass);
    }
public void createAccount(String fname,String lname,String email,String password){
        page.click(SignUp);
        setFirstname(fname);
        setLastname(lname);
        setEmail(email);
        setPassword(password);
        page.click(GetStartSignUp);
}


}
