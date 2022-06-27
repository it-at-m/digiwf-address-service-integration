package io.muenchendigital.digiwf.address.service.integration.repository;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.api.AdressenMnchenApi;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AdressenMuenchenRepository {

    private final AdressenMnchenApi adressenMnchenApi;

    /**
     * Gets a {@link MuenchenAdresse}.
     * <p>
     * For params and return value see {@link AdressenMnchenApi#checkAdresse}.
     *
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with address service.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to address service or client.
     */
    public MuenchenAdresse checkAdresse(final String adresse,
                                        final String strassenname,
                                        final Integer strasseId,
                                        final String hausnummer,
                                        final String zusatz,
                                        final String plz,
                                        final String ortsname,
                                        final String gemeindeschluessel) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        try {
            return this.adressenMnchenApi.checkAdresse(
                    adresse,
                    strassenname,
                    strasseId,
                    hausnummer,
                    zusatz,
                    plz,
                    ortsname,
                    gemeindeschluessel
            );
        } catch (final HttpClientErrorException exception) {
            final String message = String.format("The request to get address bundesweit failed with %s.", exception.getStatusCode());
            log.error(exception.getMessage());
            log.error(message);
            throw new AddressServiceIntegrationClientErrorException(message, exception);
        } catch (final HttpServerErrorException exception) {
            final String message = String.format("The request to get address bundesweit failed with %s.", exception.getStatusCode());
            log.error(exception.getMessage());
            log.error(message);
            throw new AddressServiceIntegrationServerErrorException(message, exception);
        } catch (final RestClientException exception) {
            final String message = String.format("The request to get address bundesweit failed.");
            log.error(exception.getMessage());
            log.error(message);
            throw new AddressServiceIntegrationException(message, exception);
        }
    }
    
}
