package com.company.enroller.e2e.selenium.authentication;

import com.company.enroller.e2e.BaseTests;
import com.company.enroller.e2e.Const;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends BaseTests {

    WebDriver driver;
    LoginPage page;

    @BeforeEach
    void setup() {
        this.dbInit();
        this.driver = WebDriverManager.chromedriver().create();
        this.page = new LoginPage(driver);
        this.page.get(Const.HOME_PAGE);
    }


    @Test
    @DisplayName("[LOGOWANIE.1] No login, system should not confirm the user")
    void emptyLoginName() {
        this.page.loginAs("");
        // Asserts
        assertThat(this.page.getLoginLabelText()).isEqualTo("Zaloguj się e-mailem");
        assertThat(this.page.loginBtnIsPresent()).isTrue();

    }

    @Test
    @DisplayName("[LOGOWANIE.2] The system should accept the login and display the meetings view. " +
            "The user should be able to see all meetings")
    void correctLoginName() {
        this.page.loginAs(Const.USER_I_NAME);
        // Asserts
        List<String> participants = this.page.getParticipantsListForMeeting(Const.MEETING_I_TITLE);
        assertThat(this.page.getWelcomeLabelText()).isEqualTo("Witaj" + Const.USER_I_NAME + "!");
        assertThat(this.page.logoutBtnIsPresent()).isTrue();
        assertThat(this.page.addNewMeetingBtnIsPresent()).isTrue();
        assertThat(participants).hasSize(2);
        assertThat(participants).contains(Const.USER_I_NAME, Const.USER_II_NAME);
    }

    @AfterEach
    void exit() {
        this.page.quit();
        this.removeAllMeeting();
    }

}
