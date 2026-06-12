package com.company.enroller.e2e.playwright.authentication;

import com.company.enroller.e2e.Const;
import com.company.enroller.e2e.playwright.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class LoginPage extends BasePage {

    @Getter
    private final Locator loginBtn;
    private final Locator loginInput;
    @Getter
    private final Locator loginLabel;
    @Getter
    private final Locator welcomeLabel;

    public LoginPage(Page page) {
        super(page);

        this.loginBtn = this.page.locator("div > input + button");
        this.loginInput = this.page.locator("div > input");
        this.loginLabel = this.page.locator("h1 + div > label");
        this.welcomeLabel = this.page.locator("h1 + div > h2");

    }

    public void loginAs(String username) {
        loginInput.fill(username);
        loginBtn.click();
    }

}
