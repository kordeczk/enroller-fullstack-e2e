package com.company.enroller.e2e;

import com.company.enroller.controllers.MeetingRestController;
import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class BaseTests {

    @Autowired
    private MeetingRestController meetingRestController;


    protected void dbInit() {
        Participant userI = new Participant();
        userI.setLogin(Const.USER_I_NAME);

        Participant userII = new Participant();
        userII.setLogin(Const.USER_II_NAME);

        Meeting meetingI = new Meeting();
        meetingI.setTitle(Const.MEETING_I_TITLE);
        meetingI.setDescription(Const.MEETING_DESC);

        Meeting meetingII = new Meeting();
        meetingII.setTitle(Const.MEETING_II_TITLE);
        meetingII.setDescription(Const.MEETING_DESC);

        meetingI.addParticipant(userI);
        meetingI.addParticipant(userII);

        meetingII.addParticipant(userI);

        this.meetingRestController.addMeeting(meetingI);
        this.meetingRestController.addMeeting(meetingII);
    }


    protected void removeAllMeeting() {
        for (int i = 0; i < 10; i++) {
            try {
                this.meetingRestController.deleteMeeting(i);
            } catch (Exception e) {
                System.out.println("Removed " + i + " meetings");
                break;
            }
        }
    }

}
