package example.micronaut;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/") // <1>
public class PrimeFinderController {
    private static final Logger LOG = LoggerFactory.getLogger(PrimeFinderController.class); // <2>

    private PrimeFinderService primeFinderService;

    @Inject // <3>
    PrimeFinderController(PrimeFinderService service) {
        primeFinderService = service;
    }

    @Get("/find-primes-below/{number}")
    public PrimeFinderResponse findPrimesBelow(int number) {
        if(number >= primeFinderService.MAX_SIZE) {
            LOG.info("This number is too big, you can't possibly want to know all the primes below a number this big.");
            return new PrimeFinderResponse(
                    new ArrayList(),
                    "This service only returns lists for numbers below " + primeFinderService.MAX_SIZE
            );
        }
        LOG.debug("Computing all the primes smaller than " + number + "...");
        return new PrimeFinderResponse(primeFinderService.findPrimesLessThan(number), "Success");
    }
}
