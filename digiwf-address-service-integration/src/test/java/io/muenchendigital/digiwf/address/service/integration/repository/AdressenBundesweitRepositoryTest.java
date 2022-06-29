package io.muenchendigital.digiwf.address.service.integration.repository;

import io.muenchendigital.digiwf.address.service.integration.gen.api.AdressenBundesweitApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AdressenBundesweitRepositoryTest {

    @Mock
    private AdressenBundesweitApi adressenBundesweitApi;

    private AdressenBundesweitRepository adressenBundesweitRepository;

    @BeforeEach
    public void beforeEach() {
        this.adressenBundesweitRepository = new AdressenBundesweitRepository(this.adressenBundesweitApi);
        Mockito.reset(this.adressenBundesweitApi);
    }

    @Test
    void searchAdressen() {

    }

}