package com.company.enroller.e2e.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Playwright;
import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@ActiveProfiles("test")
class PlaywrightSmokeTest {

    @Test
    void shouldOpenApplication() {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false));

            Page page = browser.newPage();


            page.navigate("https://www.saucedemo.com/");
            page.locator("#user-name").fill("performance_glitch_user");
            page.locator("#password").fill("secret_sauce");
            page.locator("#login-button").click();
            page.locator("#add-to-cart-sauce-labs-bolt-t-shirt").click();
            page.locator("#react-burger-menu-btn").click();
            page.locator("#logout_sidebar_link").click();



            page.waitForTimeout(100000);
            browser.close();
        }
    }
}
