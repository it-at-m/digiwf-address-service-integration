package io.muenchendigital.digiwf.address.service.integration.api.mapper;

import io.muenchendigital.digiwf.address.service.integration.api.configuration.MapstructConfiguration;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.CheckAdresseMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.ListAdressenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.ListAenderungenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenBundesweitDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.model.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.ListAdressenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.ListAenderungenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.SearchAdressenBundesweitModel;
import io.muenchendigital.digiwf.address.service.integration.model.SearchAdressenMuenchenModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface AddressServiceMapper {

    SearchAdressenBundesweitModel dto2Model(final SearchAdressenBundesweitDto searchAdressenBundesweitDto);

    CheckAdresseMuenchenModel dto2Model(final CheckAdresseMuenchenDto checkAdresseMuenchenDto);

    ListAdressenMuenchenModel dto2Model(final ListAdressenMuenchenDto listAdressenMuenchenDto);

    ListAenderungenMuenchenModel dto2Model(final ListAenderungenMuenchenDto listAenderungenMuenchenDto);

    SearchAdressenMuenchenModel dto2Model(final SearchAdressenMuenchenDto searchAdressenMuenchenDto);

}
