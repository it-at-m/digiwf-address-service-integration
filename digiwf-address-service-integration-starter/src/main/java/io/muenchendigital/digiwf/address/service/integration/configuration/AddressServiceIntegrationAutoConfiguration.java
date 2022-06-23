package io.muenchendigital.digiwf.address.service.integration.configuration;

import io.muenchendigital.digiwf.address.service.integration.properties.AddressServiceIntegrationProperties;
import io.muenchendigital.digiwf.address.service.integration.service.PropertiesService;
import io.muenchendigital.digiwf.address.service.integration.gen.ApiClient;
import io.muenchendigital.digiwf.address.service.integration.gen.api.PersonApi;
import io.muenchendigital.digiwf.address.service.integration.gen.api.PersonErweitertApi;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;


@Configuration
@RequiredArgsConstructor
@ComponentScan(
        basePackages = "io.muenchendigital.digiwf.okewo.integration",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {
                                /**
                                 * Exclude to avoid multiple instantiation of beans with same name.
                                 * This class is instantiated in {@link AddressServiceIntegrationAutoConfiguration}
                                 * to give the bean another name.
                                 */
                                ApiClient.class,
                                PersonApi.class,
                                PersonErweitertApi.class
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
    public ApiClient okEwoApiClient(final RestTemplateBuilder restTemplateBuilder) {
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

    /**
     * Create the bean manually to use the correct configured {@link ApiClient}.
     *
     * @param restTemplateBuilder to create a {@link RestTemplate}.
     * @return a bean of type {@link PersonApi} named by method name.
     */
    @Bean
    public PersonApi okEwoPersonApi(final RestTemplateBuilder restTemplateBuilder) {
        final ApiClient apiClient = this.okEwoApiClient(restTemplateBuilder);
        return new PersonApi(apiClient);
    }

    /**
     * Create the bean manually to use the correct configured {@link ApiClient}.
     *
     * @param restTemplateBuilder to create a {@link RestTemplate}.
     * @return a bean of type {@link PersonErweitertApi} named by method name.
     */
    @Bean
    public PersonErweitertApi okEwoPersonErweitertApi(final RestTemplateBuilder restTemplateBuilder) {
        final ApiClient apiClient = this.okEwoApiClient(restTemplateBuilder);
        return new PersonErweitertApi(apiClient);
    }

    /**
     * @return a bean of type {@link PropertiesService} named by method name.
     */
    @Bean
    public PropertiesService propertiesService() {
        return new PropertiesService(this.addressServiceIntegrationProperties.getBenutzerId());
    }

}
