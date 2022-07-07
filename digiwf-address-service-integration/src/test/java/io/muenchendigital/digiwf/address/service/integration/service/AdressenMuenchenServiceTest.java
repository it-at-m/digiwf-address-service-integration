package io.muenchendigital.digiwf.address.service.integration.service;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import io.muenchendigital.digiwf.address.service.integration.model.request.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.repository.AdressenMuenchenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AdressenMuenchenServiceTest {

    @Mock
    private AdressenMuenchenRepository adressenMuenchenRepository;

    private AdressenMuenchenService adressenMuenchenService;

    @BeforeEach
    public void beforeEach() {
        this.adressenMuenchenService = new AdressenMuenchenService(this.adressenMuenchenRepository);
        Mockito.reset(this.adressenMuenchenRepository);
    }

    @Test
    void checkAdresse() throws AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException, AddressServiceIntegrationClientErrorException {
        final CheckAdresseMuenchenModel checkAdresseMuenchenModel = new CheckAdresseMuenchenModel();
        checkAdresseMuenchenModel.setAdresse("adresse");
        checkAdresseMuenchenModel.setStrassenname("strassenname");
        checkAdresseMuenchenModel.setStrasseId(1);
        checkAdresseMuenchenModel.setHausnummer("hausnummer");
        checkAdresseMuenchenModel.setZusatz("zusatz");
        checkAdresseMuenchenModel.setPlz("plz");
        checkAdresseMuenchenModel.setOrtsname("ortsname");
        checkAdresseMuenchenModel.setGemeindeschluessel("gemeindeschluessel");

        Mockito.when(this.adressenMuenchenRepository.checkAdresse(
                checkAdresseMuenchenModel.getAdresse(),
                checkAdresseMuenchenModel.getStrassenname(),
                checkAdresseMuenchenModel.getStrasseId(),
                checkAdresseMuenchenModel.getHausnummer(),
                checkAdresseMuenchenModel.getZusatz(),
                checkAdresseMuenchenModel.getPlz(),
                checkAdresseMuenchenModel.getOrtsname(),
                checkAdresseMuenchenModel.getGemeindeschluessel()
        )).thenReturn(new MuenchenAdresse());

        final MuenchenAdresse result = this.adressenMuenchenService.checkAdresse(checkAdresseMuenchenModel);

        assertThat(result, is(new MuenchenAdresse()));

        Mockito.verify(this.adressenMuenchenRepository, Mockito.times(1)).checkAdresse(
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