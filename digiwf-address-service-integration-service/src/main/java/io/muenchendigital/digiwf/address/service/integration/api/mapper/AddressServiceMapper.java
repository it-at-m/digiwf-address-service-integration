package io.muenchendigital.digiwf.address.service.integration.api.mapper;

import io.muenchendigital.digiwf.address.service.integration.api.configuration.MapstructConfiguration;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.CheckAdresseMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.ListAdressenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.ListAenderungenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.ListStrassenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenBundesweitDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenGeoMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.SearchAdressenMuenchenDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.request.StrassenIdDto;
import io.muenchendigital.digiwf.address.service.integration.api.dto.response.AddressDistancesDto;
import io.muenchendigital.digiwf.address.service.integration.model.request.CheckAdresseMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.ListAdressenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.ListAenderungenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.ListStrassenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.SearchAdressenBundesweitModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.SearchAdressenGeoMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.SearchAdressenMuenchenModel;
import io.muenchendigital.digiwf.address.service.integration.model.request.StrassenIdModel;
import io.muenchendigital.digiwf.address.service.integration.model.response.AddressDistancesModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface AddressServiceMapper {

    SearchAdressenBundesweitModel dto2Model(final SearchAdressenBundesweitDto searchAdressenBundesweitDto);

    CheckAdresseMuenchenModel dto2Model(final CheckAdresseMuenchenDto checkAdresseMuenchenDto);

    ListAdressenMuenchenModel dto2Model(final ListAdressenMuenchenDto listAdressenMuenchenDto);

    ListAenderungenMuenchenModel dto2Model(final ListAenderungenMuenchenDto listAenderungenMuenchenDto);

    SearchAdressenMuenchenModel dto2Model(final SearchAdressenMuenchenDto searchAdressenMuenchenDto);

    SearchAdressenGeoMuenchenModel dto2Model(final SearchAdressenGeoMuenchenDto searchAdressenGeoMuenchenDto);

    StrassenIdModel dto2Model(final StrassenIdDto strassenIdDto);

    ListStrassenModel dto2Model(final ListStrassenDto listStrassenDto);

    AddressDistancesDto model2Dto(final AddressDistancesModel addressDistancesModel);

}
