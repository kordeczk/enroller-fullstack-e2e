package com.company.enroller.e2e.selenium.authentication;

import com.company.enroller.e2e.selenium.BasePage;
import com.company.enroller.e2e.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "div > input + button")
    @CacheLookup
    private WebElement loginBtn;

    @FindBy(css = "h1 + div > h2 + button")
    @CacheLookup
    private WebElement logoutBtn;

    @FindBy(css = "div > input")
    @CacheLookup
    private WebElement loginInput;

    @FindBy(css = "h1 + div > label")
    @CacheLookup
    private WebElement loginLabel;

    @FindBy(css = "h1 + div > h2")
    @CacheLookup
    private WebElement welcomeLabel;

    @FindBy(xpath = "//*[contains(text(), \"" + Const.NEW_MEETING_BTN_LABEL + "\")]")
    @CacheLookup
    private WebElement addNewMeetingBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAs(String login) {
        this.loginInput.sendKeys(login);
        this.click(this.loginBtn);
    }

    public Boolean loginBtnIsPresent() {
        return this.elementIsPresent(this.loginBtn);
    }

    public Boolean logoutBtnIsPresent() {
        return this.elementIsPresent(this.logoutBtn);
    }

    public Boolean addNewMeetingBtnIsPresent() {
        return this.elementIsPresent(this.addNewMeetingBtn);
    }

    public String getLoginLabelText() {
        return this.getElementText(this.loginLabel);
    }

    public String getWelcomeLabelText() {
        return this.getElementText(this.welcomeLabel).replaceAll("\\s", "");
    }
}
