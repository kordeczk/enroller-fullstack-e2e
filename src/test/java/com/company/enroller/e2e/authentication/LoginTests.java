package com.company.enroller.e2e.authentication;

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


    @Test
    @DisplayName("[LOGOWANIE.1] No login, system should not confirm the user")
    void emptyLoginName() {

    }

    @Test
    @DisplayName("[LOGOWANIE.2] The system should accept the login and display the meetings view. " +
            "The user should be able to see all meetings")
    void correctLoginName() {

    }


}
