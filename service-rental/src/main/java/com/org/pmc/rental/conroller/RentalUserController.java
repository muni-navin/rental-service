package com.org.pmc.rental.conroller;

import com.org.pmc.rental.service.UserService;
import com.pmc.rental.contract.endpoint.RentalRegisterUserApi;
import com.pmc.rental.contract.model.LoginRequest;
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
        user = userService.saveOrUpdateUser(user);
        log.info("User Registered: " + user.getEmail());
        return ResponseEntity.created(URI.create("user")).body(user);
    }

    @Override
    public ResponseEntity<User> update(@RequestBody @Valid User user) {
        user = userService.saveOrUpdateUser(user);
        return ResponseEntity.created(URI.create("user")).body(user);
    }

    @Override
    public ResponseEntity<User> fetch(Long userId) {
        var user = userService.fetchUser(userId);
        return ResponseEntity.created(URI.create("user")).body(user);
    }

    @Override
    public ResponseEntity<String> delete(Long userId) {
        var status = userService.deleteUser(userId);
        return ResponseEntity.created(URI.create("status")).body(status);
    }

    @Override
    public ResponseEntity<Boolean> validate(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.created(URI.create("flag")).body(userService.validateUserCredentials(loginRequest.getUsername(), loginRequest.getPassword()));
    }
}
