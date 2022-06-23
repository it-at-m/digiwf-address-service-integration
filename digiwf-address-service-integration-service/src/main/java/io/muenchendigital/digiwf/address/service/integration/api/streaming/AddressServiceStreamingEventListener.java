package io.muenchendigital.digiwf.address.service.integration.api.streaming;

import io.muenchendigital.digiwf.address.service.integration.service.AddressenBundesweitService;
import io.muenchendigital.digiwf.spring.cloudstream.utils.api.streaming.service.CorrelateMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AddressServiceStreamingEventListener {

    private static final String RESPONSE = "response";

    private final CorrelateMessageService correlateMessageService;

    private final AddressenBundesweitService addressenBundesweitService;

}
