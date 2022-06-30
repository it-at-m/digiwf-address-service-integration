package io.muenchendigital.digiwf.address.service.integration.repository;

import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationClientErrorException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationException;
import io.muenchendigital.digiwf.address.service.integration.exception.AddressServiceIntegrationServerErrorException;
import io.muenchendigital.digiwf.address.service.integration.gen.api.AdressenMnchenApi;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AdressenMuenchenRepositoryTest {

    @Mock
    private AdressenMnchenApi adressenMnchenApi;

    private AdressenMuenchenRepository adressenMuenchenRepository;

    @BeforeEach
    public void beforeEach() {
        this.adressenMuenchenRepository = new AdressenMuenchenRepository(this.adressenMnchenApi);
        Mockito.reset(this.adressenMnchenApi);
    }

    @Test
    void checkAdresse() throws AddressServiceIntegrationServerErrorException, AddressServiceIntegrationException, AddressServiceIntegrationClientErrorException {
        final String adresse = "adresse";
        final String strassenname = "strassenname";
        final Integer strasseId = 1;
        final String hausnummer = "hausnummer";
        final String zusatz = "zusatz";
        final String plz = "plz";
        final String ortsname = "ortsname";
        final String gemeindeschluessel = "gemeindeschluessel";


        Mockito.when(this.adressenMnchenApi.checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel
        )).thenReturn(new MuenchenAdresse());

        final MuenchenAdresse result = this.adressenMuenchenRepository.checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel
        );

        assertThat(result, is(new MuenchenAdresse()));

        Mockito.verify(this.adressenMnchenApi, Mockito.times(1)).checkAdresse(adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel
        );
    }

    @Test
    void checkAdresseException() {
        final String adresse = "adresse";
        final String strassenname = "strassenname";
        final Integer strasseId = 1;
        final String hausnummer = "hausnummer";
        final String zusatz = "zusatz";
        final String plz = "plz";
        final String ortsname = "ortsname";
        final String gemeindeschluessel = "gemeindeschluessel";

        Mockito.doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST)).when(this.adressenMnchenApi).checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Assertions.assertThrows(AddressServiceIntegrationClientErrorException.class, () -> this.adressenMuenchenRepository.checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel)
        );
        Mockito.verify(this.adressenMnchenApi, Mockito.times(1)).checkAdresse(adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Mockito.reset(this.adressenMnchenApi);

        Mockito.doThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR)).when(this.adressenMnchenApi).checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Assertions.assertThrows(AddressServiceIntegrationServerErrorException.class, () -> this.adressenMuenchenRepository.checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel)
        );
        Mockito.verify(this.adressenMnchenApi, Mockito.times(1)).checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Mockito.reset(this.adressenMnchenApi);

        Mockito.doThrow(new RestClientException("Something happened")).when(this.adressenMnchenApi).checkAdresse(adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Assertions.assertThrows(AddressServiceIntegrationException.class, () -> this.adressenMuenchenRepository.checkAdresse(
                adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel)
        );
        Mockito.verify(this.adressenMnchenApi, Mockito.times(1)).checkAdresse(adresse,
                strassenname,
                strasseId,
                hausnummer,
                zusatz,
                plz,
                ortsname,
                gemeindeschluessel);
        Mockito.reset(this.adressenMnchenApi);
    }

}