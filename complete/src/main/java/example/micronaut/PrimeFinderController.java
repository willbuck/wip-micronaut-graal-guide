package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/") // <1>
public class PrimeFinderController {
    private static final Logger LOG = LoggerFactory.getLogger(PrimeFinderController.class); // <2>

    private final PrimeFinderService primeFinderService;

    public PrimeFinderController(PrimeFinderService primeFinderService) { // <3>
        this.primeFinderService = primeFinderService;
    }

    @Get("/find-primes-below/{number}")
    public PrimeFinderResponse findPrimesBelow(int number) {
        PrimeFinderResponse resp = new PrimeFinderResponse();
        if (number >= primeFinderService.MAX_SIZE) {
            if (LOG.isInfoEnabled()) {
                LOG.info("This number is too big, you can't possibly want to know all the primes below a number this big.");
            }
            resp.setMessage("This service only returns lists for numbers below " + primeFinderService.MAX_SIZE);
            return resp;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Computing all the primes smaller than {} ...", number);
        }
        resp.setMessage("Success!");
        resp.setPrimes(primeFinderService.findPrimesLessThan(number));
        return resp;
    }
}
