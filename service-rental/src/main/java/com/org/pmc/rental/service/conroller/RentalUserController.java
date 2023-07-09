package com.org.pmc.rental.service.conroller;

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

    @Override
    public ResponseEntity<User> register(@RequestBody @Valid User user) {
        return ResponseEntity.created(URI.create("test")).body(new User());
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
