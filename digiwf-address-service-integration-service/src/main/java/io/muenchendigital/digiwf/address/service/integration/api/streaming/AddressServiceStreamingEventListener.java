package io.muenchendigital.digiwf.address.service.integration.api.streaming;

import io.muenchendigital.digiwf.address.service.integration.api.dto.request.AddressServiceEventDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.CheckAdresseMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenBundesweitDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.response.AddressServiceErrorDto;
import io.muenchendigital.digiwf.address.service.integration.api.mapper.AddressServiceMapper;
import io.muenchendigital.digiwf.address.service.integration.gen.model.BundesweiteAdresseResponse;
import io.muenchendigital.digiwf.address.service.integration.gen.model.MuenchenAdresse;
import io.muenchendigital.digiwf.address.service.integration.model.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.SearchAdressenBundesweitModel;
import io.muenchendigital.digiwf.address.service.integration.service.AddressenBundesweitService;
import io.muenchendigital.digiwf.address.service.integration.service.AdressenMuenchenService;
import io.muenchendigital.digiwf.spring.cloudstream.utils.api.streaming.service.CorrelateMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.Map;
import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AddressServiceStreamingEventListener {

    private static final String RESPONSE = "response";

    private final AddressServiceMapper addressServiceMapper;

    private final CorrelateMessageService correlateMessageService;

    private final AddressenBundesweitService addressenBundesweitService;

    private final AdressenMuenchenService adressenMuenchenService;

    /**
     * The Consumer expects an {@link AddressServiceEventDto} which represents an {@link SearchAdressenBundesweitDto}.
     * <p>
     * After successfully requesting the address service a JSON representing a {@link BundesweiteAdresseResponse} is returned.
     * <p>
     * In case of an error the error message is returned as a JSON representing {@link AddressServiceErrorDto}.
     */
    @Bean
    public Consumer<Message<AddressServiceEventDto>> searchAdressenBundesweit() {
        return message -> {
            log.debug(message.toString());

            final var searchAdressenBundesweit = (SearchAdressenBundesweitDto) message.getPayload().getRequest();

            Object addressServiceResult;
            try {
                final SearchAdressenBundesweitModel model = this.addressServiceMapper.dto2Model(searchAdressenBundesweit);
                addressServiceResult = this.addressenBundesweitService.searchAdressen(model);
            } catch (final Exception exception) {
                addressServiceResult = new AddressServiceErrorDto(exception.getMessage());
            }

            this.correlateMessageService.sendCorrelateMessage(
                    message.getHeaders(),
                    Map.of(RESPONSE, addressServiceResult)
            );
        };
    }

    /**
     * The Consumer expects an {@link AddressServiceEventDto} which represents an {@link CheckAdresseMuenchenDto}.
     * <p>
     * After successfully requesting the address service a JSON representing a {@link MuenchenAdresse} is returned.
     * <p>
     * In case of an error the error message is returned as a JSON representing {@link AddressServiceErrorDto}.
     */
    @Bean
    public Consumer<Message<AddressServiceEventDto>> checkAdresseMuenchen() {
        return message -> {
            log.debug(message.toString());

            final var checkAdresseMuenchen = (CheckAdresseMuenchenDto) message.getPayload().getRequest();

            Object addressServiceResult;
            try {
                final CheckAdresseMuenchenModel model = this.addressServiceMapper.dto2Model(checkAdresseMuenchen);
                addressServiceResult = this.adressenMuenchenService.checkAdresse(model);
            } catch (final Exception exception) {
                addressServiceResult = new AddressServiceErrorDto(exception.getMessage());
            }

            this.correlateMessageService.sendCorrelateMessage(
                    message.getHeaders(),
                    Map.of(RESPONSE, addressServiceResult)
            );
        };
    }

}
