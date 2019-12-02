package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class PrimeFinderControllerTest {
    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testPrimesBelow3() {
        PrimeFinderResponse response = client.toBlocking()
                .retrieve(HttpRequest.GET("/find-primes-below/3"), PrimeFinderResponse.class);
        assertEquals(Collections.singletonList(2), response.getPrimes());
    }
}
