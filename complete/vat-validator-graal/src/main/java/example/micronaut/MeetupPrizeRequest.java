package example.micronaut;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;

@Introspected // <1>
public class MeetupPrizeRequest implements Serializable {
    private String meetupName;
    private String eventId;

    public MeetupPrizeRequest() {
    }

    public MeetupPrizeRequest(String meetupName, String eventId) {
        this.meetupName = meetupName;
        this.eventId = eventId;
    }

    public String getMeetupName() {
        return meetupName;
    }

    public void setMeetupName(String meetupName) {
        this.meetupName = meetupName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
