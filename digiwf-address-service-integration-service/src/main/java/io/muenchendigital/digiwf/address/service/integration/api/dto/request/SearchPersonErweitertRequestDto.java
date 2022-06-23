package io.muenchendigital.digiwf.address.service.integration.api.dto.request;

import io.muenchendigital.digiwf.address.service.integration.gen.model.SuchePersonerweitertAnfrage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SearchPersonErweitertRequestDto extends AbstractRequestDto {

    private SuchePersonerweitertAnfrage searchPersonErweitert;

}
