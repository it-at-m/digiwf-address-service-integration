package io.muenchendigital.digiwf.address.service.integration.service;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.model.AenderungResponse;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresseResponse;
import io.muenchendigital.digiwf.address.service.integration.model.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.ListAdressenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.ListAenderungenMuenchenModel;
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

    public MuenchenAdresseResponse listAdressen(final ListAdressenMuenchenModel listAdressenMuenchenModel) throws AddressServiceIntegrationClientErrorException, AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException {
        return this.adressenMuenchenRepository.listAdressen(
                listAdressenMuenchenModel.getBaublock(),
                listAdressenMuenchenModel.getErhaltungssatzung(),
                listAdressenMuenchenModel.getGemarkung(),
                listAdressenMuenchenModel.getKaminkehrerbezirk(),
                listAdressenMuenchenModel.getPlz(),
                listAdressenMuenchenModel.getMittelschule(),
                listAdressenMuenchenModel.getGrundschule(),
                listAdressenMuenchenModel.getPolizeiinspektion(),
                listAdressenMuenchenModel.getStimmbezirk(),
                listAdressenMuenchenModel.getStimmkreis(),
                listAdressenMuenchenModel.getWahlbezirk(),
                listAdressenMuenchenModel.getWahlkreis(),
                listAdressenMuenchenModel.getStadtbezirk(),
                listAdressenMuenchenModel.getStadtbezirksteil(),
                listAdressenMuenchenModel.getStadtbezirksviertel(),
                listAdressenMuenchenModel.getSort(),
                listAdressenMuenchenModel.getSortdir(),
                listAdressenMuenchenModel.getPage(),
                listAdressenMuenchenModel.getPagesize()
        );
    }

    public AenderungResponse listAenderungen(final ListAenderungenMuenchenModel listAenderungenMuenchenModel) throws AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException, AddressServiceIntegrationClientErrorException {
        return this.adressenMuenchenRepository.listAenderungen(
                listAenderungenMuenchenModel.getWirkungsdatumvon(),
                listAenderungenMuenchenModel.getWirkungsdatumbis(),
                listAenderungenMuenchenModel.getStrassenname(),
                listAenderungenMuenchenModel.getHausnummer(),
                listAenderungenMuenchenModel.getPlz(),
                listAenderungenMuenchenModel.getZusatz(),
                listAenderungenMuenchenModel.getSort(),
                listAenderungenMuenchenModel.getSortdir(),
                listAenderungenMuenchenModel.getPage(),
                listAenderungenMuenchenModel.getPagesize()
        );
    }

}
