package com.org.pmc.rental.conroller;

import com.org.pmc.rental.entity.UserEntity;
import com.org.pmc.rental.repository.UserRepository;
import com.org.pmc.rental.service.UserService;
import com.pmc.rental.contract.endpoint.RentalRegisterUserApi;
import com.pmc.rental.contract.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
public class RentalUserController implements RentalRegisterUserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> register(@RequestBody @Valid User user) {
        user = userService.saveUser(user);
        return ResponseEntity.created(URI.create("user")).body(user);
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> fetch(String s) {
        return null;
    }

    @Override
    public ResponseEntity<User> delete(User user) {
        return null;
    }
}
