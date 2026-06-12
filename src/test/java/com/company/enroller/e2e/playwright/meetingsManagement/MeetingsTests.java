package com.company.enroller.e2e.playwright.meetingsManagement;

import com.company.enroller.e2e.BaseTests;
import com.company.enroller.e2e.Const;
import com.company.enroller.e2e.playwright.authentication.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MeetingsTests extends BaseTests {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private MeetingsPage meetingPage;


    @BeforeEach
    void setup() {
        dbInit();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();

        loginPage = new LoginPage(page);
        meetingPage = new MeetingsPage(page);
        meetingPage.get(Const.HOME_PAGE);
    }

    @Test
    @DisplayName("[SPOTKANIA.1] The meeting should be added to your meeting list. It should contain a title and description.")
    void addNewMeeting() {
        this.loginPage.loginAs(Const.USER_I_NAME);
        this.meetingPage.addNewMeeting(Const.MEETING_III_TITLE, Const.MEETING_DESC);
        assertThat(this.meetingPage.getMeetings()).hasCount(3);
        assertThat(this.meetingPage.getMeetingByTitle(Const.MEETING_III_TITLE)).isVisible();
        assertThat(this.meetingPage.getMeetingDescCell(Const.MEETING_III_TITLE)).hasText(Const.MEETING_DESC);
    }

    // @Test
    // TODO: Sprawdź czy użytkownik może dodać spotkanie bez nazwy. Załóż że nie ma takiej możliwości a warunkiem
    //  jest nieaktywny przycisk "Dodaj".

    // @Test
    // TODO: Sprawdź czy użytkownik może poprawnie zapisać się do spotkania.

    // @Test
    // TODO: Sprawdź czy użytkownik może usunąć puste spotkanie.


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
