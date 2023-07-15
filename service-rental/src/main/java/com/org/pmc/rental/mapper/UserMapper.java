package com.org.pmc.rental.mapper;

import com.org.pmc.rental.entity.UserEntity;
import com.pmc.rental.contract.model.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring", uses = {PropertyMapper.class})
public interface UserMapper {

    UserEntity toEntity(User user);

    User toVo(UserEntity userEntity);
}
