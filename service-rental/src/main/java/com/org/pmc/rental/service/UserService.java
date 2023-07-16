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
    private static final String SUCCESS = "Success";

    public User saveOrUpdateUser(User user) {
        var userEntity = userRepository.save(userMapper.toEntity(user));
        return userMapper.toVo(userEntity);
    }

    public User fetchUser(Long userId) {
        return userMapper.toVo(userRepository.findById(userId).get());
    }

    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return SUCCESS;
    }
}
