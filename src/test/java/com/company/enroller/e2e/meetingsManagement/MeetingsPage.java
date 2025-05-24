package com.company.enroller.e2e.meetingsManagement;

import com.company.enroller.e2e.BasePage;
import com.company.enroller.e2e.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MeetingsPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), \"" + Const.NEW_MEETING_BTN_LABEL + "\")]")
    @CacheLookup
    private WebElement addNewMeetingBtn;

    public MeetingsPage(WebDriver driver) {
        super(driver);
    }


    public void addNewMeeting(String title, String desc) {
        //        TODO

    }


}
