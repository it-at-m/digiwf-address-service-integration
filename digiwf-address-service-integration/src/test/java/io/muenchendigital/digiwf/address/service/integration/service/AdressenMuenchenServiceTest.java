package io.muenchendigital.digiwf.address.service.integration.service;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresseResponse;
import io.muenchendigital.digiwf.address.service.integration.model.request.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.ListAdressenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.repository.AdressenMuenchenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

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

    @Test
    void listAdressen() throws AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException, AddressServiceIntegrationClientErrorException {
        final ListAdressenMuenchenModel listAdressenMuenchenModel = new ListAdressenMuenchenModel();
        listAdressenMuenchenModel.setBaublock(List.of("baublock"));
        listAdressenMuenchenModel.setErhaltungssatzung(List.of("erhaltungssatzung"));
        listAdressenMuenchenModel.setGemarkung(List.of("gemarkung"));
        listAdressenMuenchenModel.setKaminkehrerbezirk(List.of("kaminkehrerbezirk"));
        listAdressenMuenchenModel.setPlz(List.of("plz"));
        listAdressenMuenchenModel.setMittelschule(List.of("mittelschule"));
        listAdressenMuenchenModel.setGrundschule(List.of("grundschule"));
        listAdressenMuenchenModel.setPolizeiinspektion(List.of("polizeiinspektion"));
        listAdressenMuenchenModel.setStimmbezirk(List.of(1L));
        listAdressenMuenchenModel.setStimmkreis(List.of(2L));
        listAdressenMuenchenModel.setWahlbezirk(List.of(3L));
        listAdressenMuenchenModel.setWahlkreis(List.of(4L));
        listAdressenMuenchenModel.setStadtbezirk(List.of("stadtbezirk"));
        listAdressenMuenchenModel.setStadtbezirksteil(List.of("stadtbezirksteil"));
        listAdressenMuenchenModel.setStadtbezirksviertel(List.of("stadtbezirksviertel"));
        listAdressenMuenchenModel.setSort("sort");
        listAdressenMuenchenModel.setSortdir("sortdir");
        listAdressenMuenchenModel.setPage(98);
        listAdressenMuenchenModel.setPagesize(99);


        Mockito.when(this.adressenMuenchenRepository.listAdressen(
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
        )).thenReturn(new MuenchenAdresseResponse());

        final MuenchenAdresseResponse result = this.adressenMuenchenService.listAdressen(listAdressenMuenchenModel);

        assertThat(result, is(new MuenchenAdresseResponse()));

        Mockito.verify(this.adressenMuenchenRepository, Mockito.times(1)).listAdressen(
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


}