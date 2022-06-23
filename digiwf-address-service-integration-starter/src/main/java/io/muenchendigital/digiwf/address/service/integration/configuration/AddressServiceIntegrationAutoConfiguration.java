package io.muenchendigital.digiwf.address.service.integration.configuration;

import io.muenchendigital.digiwf.address.service.integration.gen.ApiClient;
import io.muenchendigital.digiwf.address.service.integration.properties.AddressServiceIntegrationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;


@Configuration
@RequiredArgsConstructor
@ComponentScan(
        basePackages = "io.muenchendigital.digiwf.address.service.integration",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {
                                /**
                                 * Exclude to avoid multiple instantiation of beans with same name.
                                 * This class is instantiated in {@link AddressServiceIntegrationAutoConfiguration}
                                 * to give the bean another name.
                                 */
                                ApiClient.class
                        }
                )
        }
)
@EnableConfigurationProperties(AddressServiceIntegrationProperties.class)
public class AddressServiceIntegrationAutoConfiguration {

    public final AddressServiceIntegrationProperties addressServiceIntegrationProperties;

    /**
     * Provides a correct configured {@link ApiClient}.
     *
     * @param restTemplateBuilder to create a {@link RestTemplate}.
     * @return a configured {@link ApiClient}.
     */
    public ApiClient addressServiceApiClient(final RestTemplateBuilder restTemplateBuilder) {
        final RestTemplate restTemplate = restTemplateBuilder
                .basicAuthentication(
                        this.addressServiceIntegrationProperties.getUsername(),
                        this.addressServiceIntegrationProperties.getPassword()
                )
                .build();
        final ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath(this.addressServiceIntegrationProperties.getUrl());
        return apiClient;
    }

}
