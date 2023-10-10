package ItBusinessBook_pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    private String MyprofileName="//a[normalize-space()='Tony Stark']";

    public HomePage(Page page) {
        this.page=page;
    }
}
