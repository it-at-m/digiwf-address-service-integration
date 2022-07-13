package io.muenchendigital.digiwf.address.service.integration.model.response;

import io.muenchendigital.digiwf.address.service.integration.gen.model.AdresseDistanz;
import lombok.Data;

import java.util.List;

@Data
public class AddressDistancesModel {

    List<AdresseDistanz> adresseDistances;

}
