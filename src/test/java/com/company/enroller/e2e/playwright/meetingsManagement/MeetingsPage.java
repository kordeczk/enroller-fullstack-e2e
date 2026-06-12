package com.company.enroller.e2e.playwright.meetingsManagement;

import com.company.enroller.e2e.playwright.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MeetingsPage extends BasePage {

    private final Locator addNewMeetingBtn;
    private final Locator meetingTitleInput;
    private final Locator meetingDescInput;
    private final Locator confirmMeetingBtn;
    private final Locator meeitngRow;


    protected MeetingsPage(Page page) {
        super(page);

        this.addNewMeetingBtn = this.page.locator("div > h2 + button:has(+table)");
        this.meetingTitleInput = this.page.locator("form > label + input[type='text']");
        this.meetingDescInput = this.page.locator("form > label + textarea");
        this.confirmMeetingBtn = this.page.locator("form > textarea + button");
        this.meeitngRow = this.page.locator("div > table > tbody > tr");
    }

    public void addNewMeeting(String title, String desc) {
        this.addNewMeetingBtn.click();
        this.meetingTitleInput.fill(title);
        this.meetingDescInput.fill(desc);
        this.confirmMeetingBtn.click();
    }

    public Locator getMeetings() {
        return this.meeitngRow;
    }

    public Locator getMeetingByTitle(String title) {
        Locator meetings = this.getMeetings();
        int count = meetings.count();
        for (int i = 0; i < count; i++) {
            Locator meeting = meetings.nth(i);
            Locator titleCol = meeting.locator("td").nth(0);
            if (title.equals(titleCol.textContent())) {
                return meeting;
            }
        }

        return null;
    }

    public Locator getMeetingDescCell(String meetingTitle) {
        Locator meeting = this.getMeetingByTitle(meetingTitle);
        if (meeting != null) {
            return meeting.locator("td").nth(1);
        }
        return null;

    }

}
