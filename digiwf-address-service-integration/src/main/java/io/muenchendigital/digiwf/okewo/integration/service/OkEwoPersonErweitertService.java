package io.muenchendigital.digiwf.okewo.integration.service;

import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.okewo.integration.gen.model.PersonErweitert;
import io.muenchendigital.digiwf.okewo.integration.gen.model.SuchePersonerweitertAnfrage;
import io.muenchendigital.digiwf.okewo.integration.gen.model.SuchePersonerweitertAntwort;
import io.muenchendigital.digiwf.okewo.integration.repository.OkEwoPersonErweitertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OkEwoPersonErweitertService {

    private final OkEwoPersonErweitertRepository okEwoPersonErweitertRepository;

    private final PropertiesService propertiesService;

    /**
     * Gets a {@link PersonErweitert} by Ordnungsmerkmal.
     *
     * @param om as Ordnungsmerkmal which identifies a {@link PersonErweitert}.
     * @return the {@link PersonErweitert} identified by Ordnungsmerkmal.
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with OK.EWO.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to OK.EWO or client.
     */
    public PersonErweitert getPerson(final String om) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        return this.okEwoPersonErweitertRepository.getPerson(
                om,
                this.propertiesService.getBenutzerId()
        );
    }

    /**
     * Searches for {@link PersonErweitert}s identified by {@link SuchePersonerweitertAnfrage}.
     *
     * @param suchePersonerweitertAnfrage to identify {@link PersonErweitert}s.
     * @return the {@link SuchePersonerweitertAntwort} with the identified {@link PersonErweitert}s.
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with OK.EWO.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to OK.EWO or client.
     */
    public SuchePersonerweitertAntwort searchPerson(final SuchePersonerweitertAnfrage suchePersonerweitertAnfrage) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        suchePersonerweitertAnfrage.setBenutzer(this.propertiesService.getBenutzerTypeWithBenutzerId());
        return this.okEwoPersonErweitertRepository.searchPerson(suchePersonerweitertAnfrage);
    }

}
