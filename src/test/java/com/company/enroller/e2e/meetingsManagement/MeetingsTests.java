package com.company.enroller.e2e.meetingsManagement;

import com.company.enroller.e2e.BaseTests;
import com.company.enroller.e2e.Const;
import com.company.enroller.e2e.authentication.LoginPage;
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
//        TODO
    }


    @Test
    @DisplayName("[SPOTKANIA.1] The meeting should be added to your meeting list.")
    void addNewMeeting() {
//        TODO
    }


}
