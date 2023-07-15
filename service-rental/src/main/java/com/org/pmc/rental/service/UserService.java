package com.org.pmc.rental.service;

import com.org.pmc.rental.mapper.UserMapper;
import com.org.pmc.rental.repository.UserRepository;
import com.pmc.rental.contract.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User saveUser(User user) {
        var userEntity = userRepository.save(userMapper.toEntity(user));
        return userMapper.toVo(userEntity);
    }
}
