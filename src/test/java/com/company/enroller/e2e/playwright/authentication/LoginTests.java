package com.company.enroller.e2e.playwright.authentication;

import com.company.enroller.e2e.BaseTests;
import com.company.enroller.e2e.Const;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class LoginTests extends BaseTests {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        dbInit();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        loginPage = new LoginPage(page);
        loginPage.get(Const.HOME_PAGE);
    }

    @Test
    @DisplayName("[LOGOWANIE.1] No login, system should not confirm the user")
    void emptyLoginName() {
        assertThat(this.loginPage.getLoginLabel()).hasText("Zaloguj się e-mailem");
        assertThat(this.loginPage.getLoginBtn()).isVisible();
    }

    @Test
    @DisplayName("[LOGOWANIE.2] The system should accept the login and display the meetings view. " +
            "The user should be able to see all meetings")
    void correctLoginName() {
        loginPage.loginAs(Const.USER_I_NAME);
        assertThat(this.loginPage.getWelcomeLabel()).hasText(
                Pattern.compile("Witaj\\s+" + Const.USER_I_NAME + "!"));
    }


    @AfterEach
    void exit() {
        if (browser != null) {
            browser.close();
        }
        if (page != null) {
            playwright.close();
        }
        this.removeAllMeeting();
    }

}
