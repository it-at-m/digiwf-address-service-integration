package io.muenchendigital.digiwf.address.service.integration.api.mapper;

import io.muenchendigital.digiwf.address.service.integration.api.configuration.MapstructConfiguration;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.CheckAdresseMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenBundesweitDto;
import io.muenchendigital.digiwf.address.service.integration.model.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.SearchAdressenBundesweitModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface AddressServiceMapper {

    SearchAdressenBundesweitModel dto2Model(final SearchAdressenBundesweitDto searchAdressenBundesweitDto);

    CheckAdresseMuenchenModel dto2Model(final CheckAdresseMuenchenDto checkAdresseMuenchenDto);

}
