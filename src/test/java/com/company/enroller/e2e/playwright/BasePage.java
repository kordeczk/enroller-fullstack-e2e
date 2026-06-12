package com.company.enroller.e2e.playwright;


import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    protected BasePage(Page page) {
        this.page = page;
    }

    public void get(String url) {
        page.navigate(url);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}
