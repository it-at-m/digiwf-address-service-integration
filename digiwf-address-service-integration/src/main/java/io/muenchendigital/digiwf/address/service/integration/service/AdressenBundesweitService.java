package io.muenchendigital.digiwf.address.service.integration.service;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.model.BundesweiteAdresseResponse;
import io.muenchendigital.digiwf.address.service.integration.model.request.SearchAdressenBundesweitModel;
import io.muenchendigital.digiwf.address.service.integration.repository.AdressenBundesweitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdressenBundesweitService {

    private final AdressenBundesweitRepository adressenBundesweitRepository;

    /**
     * Gets a {@link BundesweiteAdresseResponse}.
     *
     * @param searchAdressenBundesweitModel the request params. For meaning of params see {@link io.muenchendigital.digiwf.address.service.integration.gen.api.AdressenBundesweitApi#searchAdressen}.
     * @throws AddressServiceIntegrationClientErrorException if the problem is with the client.
     * @throws AddressServiceIntegrationServerErrorException if the problem is with OK.EWO.
     * @throws AddressServiceIntegrationException            if the problem cannot be assigned directly to OK.EWO or client.
     */
    public BundesweiteAdresseResponse searchAdressen(final SearchAdressenBundesweitModel searchAdressenBundesweitModel) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        return this.adressenBundesweitRepository.searchAdressen(
                searchAdressenBundesweitModel.getQuery(),
                searchAdressenBundesweitModel.getPlz(),
                searchAdressenBundesweitModel.getOrtsname(),
                searchAdressenBundesweitModel.getGemeindeschluessel(),
                searchAdressenBundesweitModel.getHausnummerfilter(),
                searchAdressenBundesweitModel.getBuchstabefilter(),
                searchAdressenBundesweitModel.getSort(),
                searchAdressenBundesweitModel.getSortdir(),
                searchAdressenBundesweitModel.getPage(),
                searchAdressenBundesweitModel.getPagesize()
        );
    }

}
