package example.micronaut;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton // <1>
public class MeetupRsvpService {
    private static final String SERVER = "https://api.meetup.com";
    private static final UriBuilder RSVP_PATH_TEMPLATE = UriBuilder.of("/{meetupName}/events/{eventId}/rsvps");

    protected final RxHttpClient client;

    public MeetupRsvpService(@Client(SERVER) RxHttpClient client) { // <2>
        this.client = client;
    }

    public Single<List<Rsvp>> retrieveRsvps(String meetupName, String eventId) {
        Map<String, Object> pathArgs = new HashMap<>();
        pathArgs.put("meetupName", meetupName);
        pathArgs.put("eventId", eventId);
        HttpRequest request = HttpRequest.GET(RSVP_PATH_TEMPLATE.expand(pathArgs));

        Flowable<List<Rsvp>> response = client.retrieve(request, Argument.listOf(Rsvp.class));
        return response.firstOrError();
    }
}