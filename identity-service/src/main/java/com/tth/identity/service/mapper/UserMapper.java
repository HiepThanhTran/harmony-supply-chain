package com.tth.identity.service.mapper;

import com.tth.identity.service.dto.request.user.RegisterRequest;
import com.tth.identity.service.dto.request.user.UpdateRequest;
import com.tth.identity.service.dto.response.user.UserResponse;
import com.tth.identity.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "file", ignore = true)
    @Mapping(target = "avatar", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    @Mapping(target = "shipper", ignore = true)
    User toUser(RegisterRequest registerRequest);

    @Mapping(target = "customerFirstName", source = "user.customer.firstName")
    @Mapping(target = "customerMiddleName", source = "user.customer.middleName")
    @Mapping(target = "customerLastName", source = "user.customer.lastName")
    @Mapping(target = "customerAddress", source = "user.customer.address")
    @Mapping(target = "customerPhone", source = "user.customer.phone")
    @Mapping(target = "customerGender", source = "user.customer.gender")
    @Mapping(target = "customerDateOfBirth", source = "user.customer.dateOfBirth")
    @Mapping(target = "shipperName", source = "user.shipper.name")
    @Mapping(target = "shipperContactInfo", source = "user.shipper.contactInfo")
    @Mapping(target = "supplieName", source = "user.supplier.name")
    @Mapping(target = "supplieAddress", source = "user.supplier.address")
    @Mapping(target = "suppliePhone", source = "user.supplier.phone")
    @Mapping(target = "supplieContactInfo", source = "user.supplier.contactInfo")
    UserResponse toUserResponse(User user);

    @Mapping(target = "avatar", ignore = true)
    @Mapping(target = "email")
    @Mapping(target = "username")
    void updateUser(@MappingTarget User user, UpdateRequest updateRequest);
}
