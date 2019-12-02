package example.micronaut;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class PrimeFinderResponse {

    private List<Integer> listOfPrimes;
    private String message;

    public PrimeFinderResponse() {
    }

    public PrimeFinderResponse(List<Integer> listOfPrimes, String message) {
        this.listOfPrimes = listOfPrimes;
        this.message = message;
    }

    public List<Integer> getListOfPrimes() {
        return listOfPrimes;
    }

    public void setListOfPrimes(List<Integer> listOfPrimes) {
        this.listOfPrimes = listOfPrimes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
