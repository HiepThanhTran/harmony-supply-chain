package com.tth.identity.service.mapper;

import com.tth.identity.service.dto.request.user.RegisterRequest;
import com.tth.identity.service.dto.request.user.UpdateRequest;
import com.tth.identity.service.dto.response.shipper.ShipperResponse;
import com.tth.identity.service.entity.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipperMapper {

    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "name", source = "shipperName")
    @Mapping(target = "contactInfo", source = "shipperContactInfo")
    Shipper toShipper(RegisterRequest registerRequest);

    ShipperResponse toShipperResponse(Shipper shipper);

    List<ShipperResponse> toShipperResponse(List<Shipper> shippers);

    @Mapping(target = "name", source = "shipperName")
    @Mapping(target = "contactInfo", source = "shipperContactInfo")
    void updateShipper(@MappingTarget Shipper shipper, UpdateRequest updateRequest);
}
