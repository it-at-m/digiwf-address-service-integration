package io.muenchendigital.digiwf.address.service.integration.api.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "eventType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SearchAdressenBundesweitDto.class, name = "searchAdressenBundesweit"),
})
public abstract class AbstractRequestDto {

    private String eventType;

}
