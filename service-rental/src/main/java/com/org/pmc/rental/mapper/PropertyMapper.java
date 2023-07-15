package com.org.pmc.rental.mapper;

import com.org.pmc.rental.entity.PropertyEntity;

import com.pmc.rental.contract.model.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper {

    PropertyEntity toEntity(Property property);

    Property toVo(PropertyEntity propertyEntity);
}
