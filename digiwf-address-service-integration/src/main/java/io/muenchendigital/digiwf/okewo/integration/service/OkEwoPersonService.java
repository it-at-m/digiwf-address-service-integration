package io.muenchendigital.digiwf.okewo.integration.service;

import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.okewo.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.okewo.integration.gen.model.Person;
import io.muenchendigital.digiwf.okewo.integration.gen.model.SuchePersonAnfrage;
import io.muenchendigital.digiwf.okewo.integration.gen.model.SuchePersonAntwort;
import io.muenchendigital.digiwf.okewo.integration.repository.OkEwoPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OkEwoPersonService {

    private final OkEwoPersonRepository okEwoPersonRepository;

    private final PropertiesService propertiesService;

    /**
     * Gets a {@link Person} by Ordnungsmerkmal.
     *
     * @param om as Ordnungsmerkmal which identifies a {@link Person}.
     * @return the {@link Person} identified by Ordnungsmerkmal.
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with OK.EWO.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to OK.EWO or client.
     */
    public Person getPerson(final String om) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        return this.okEwoPersonRepository.getPerson(
                om,
                this.propertiesService.getBenutzerId()
        );
    }

    /**
     * Searches for {@link Person}s identified by {@link SuchePersonAnfrage}.
     *
     * @param suchePersonAnfrage to identify {@link Person}s.
     * @return the {@link SuchePersonAntwort} with the identified {@link Person}s.
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with OK.EWO.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to OK.EWO or client.
     */
    public SuchePersonAntwort searchPerson(final SuchePersonAnfrage suchePersonAnfrage) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        suchePersonAnfrage.setBenutzer(this.propertiesService.getBenutzerTypeWithBenutzerId());
        return this.okEwoPersonRepository.searchPerson(suchePersonAnfrage);
    }

}
