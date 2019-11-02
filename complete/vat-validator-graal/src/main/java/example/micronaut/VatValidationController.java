package example.micronaut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;


@Controller("/") // <1>
public class VatValidationController {
    private static final Logger LOG = LoggerFactory.getLogger(VatValidationController.class); // <2>

    private VatService vatService;

    public VatValidationController(VatService vatService) { // <3>
        this.vatService = vatService;
    }

    @Post("/validate-vat")
    public VatValidation validate(@Body VatValidationRequest request) {
        final String memberStateCode = request.getMemberStateCode();
        final String vatNumber = request.getVatNumber();
        if (LOG.isDebugEnabled()) {
            LOG.debug("validate country: {} vat number: {}", memberStateCode, vatNumber);
        }
        return vatService.validateVat(memberStateCode, vatNumber)
                .map(valid -> new VatValidation(memberStateCode, vatNumber, valid))
                .blockingGet(); // <4>
    }
}
