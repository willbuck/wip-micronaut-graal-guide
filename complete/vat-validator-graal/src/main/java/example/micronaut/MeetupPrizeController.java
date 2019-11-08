package example.micronaut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;

import java.util.Random;


@Controller("/") // <1>
public class MeetupPrizeController {
    private static final Logger LOG = LoggerFactory.getLogger(MeetupPrizeController.class); // <2>

    private MeetupRsvpService meetupRsvpService;

    public MeetupPrizeController(MeetupRsvpService meetupRsvpService) { // <3>
        this.meetupRsvpService = meetupRsvpService;
    }

    @Post("/winner")
    public Rsvp selectAWinner(@Body MeetupPrizeRequest request) {
        final String meetupName = request.getMeetupName();
        final String eventId = request.getEventId();
        if (LOG.isDebugEnabled()) {
            LOG.debug("select an RSVP for a prize from meetup {} and event {}", meetupName, eventId);
        }
        return meetupRsvpService.retrieveRsvps(meetupName, eventId)
                .map( rsvps -> {
                    int numRsvps = rsvps.size();
                    int selectedWinnerIndex = new Random().nextInt(numRsvps);
                    return rsvps.get(selectedWinnerIndex);
                })
                .blockingGet(); // <4>
    }
}
