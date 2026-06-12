package com.company.enroller.e2e.selenium.meetingsManagement;

import com.company.enroller.e2e.BaseTests;
import com.company.enroller.e2e.Const;
import com.company.enroller.e2e.selenium.authentication.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MeetingsTests extends BaseTests {

    WebDriver driver;
    MeetingsPage page;
    LoginPage loginPage;

    @BeforeEach
    void setup() {
        this.dbInit();
        this.driver = WebDriverManager.chromedriver().create();
        this.page = new MeetingsPage(driver);
        this.loginPage = new LoginPage(driver);
        this.page.get(Const.HOME_PAGE);
    }


    @Test
    @DisplayName("[SPOTKANIA.1] The meeting should be added to your meeting list. It should contain a title and description.")
    void addNewMeeting() {
        this.loginPage.loginAs(Const.USER_I_NAME);
        this.page.addNewMeeting(Const.MEETING_III_TITLE, Const.MEETING_DESC);
        // Asserts
        assertThat(this.page.getMeetings().size()).isEqualTo(3);
        assertThat(this.page.getMeetingByTitle(Const.MEETING_III_TITLE)).isNotNull();
        assertThat(this.page.getMeetingDesc(Const.MEETING_III_TITLE)).isEqualTo(Const.MEETING_DESC);
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
        this.page.quit();
        this.removeAllMeeting();
    }

}
