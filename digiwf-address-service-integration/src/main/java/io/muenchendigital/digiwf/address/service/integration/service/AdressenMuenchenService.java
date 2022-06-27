package io.muenchendigital.digiwf.address.service.integration.service;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import io.muenchendigital.digiwf.address.service.integration.model.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.repository.AdressenMuenchenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdressenMuenchenService {

    private final AdressenMuenchenRepository adressenMuenchenRepository;

    public MuenchenAdresse checkAdresse(final CheckAdresseMuenchenModel checkAdresseMuenchenModel) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        return this.adressenMuenchenRepository.checkAdresse(
                checkAdresseMuenchenModel.getAdresse(),
                checkAdresseMuenchenModel.getStrassenname(),
                checkAdresseMuenchenModel.getStrasseId(),
                checkAdresseMuenchenModel.getHausnummer(),
                checkAdresseMuenchenModel.getZusatz(),
                checkAdresseMuenchenModel.getPlz(),
                checkAdresseMuenchenModel.getOrtsname(),
                checkAdresseMuenchenModel.getGemeindeschluessel()
        );
    }

}
