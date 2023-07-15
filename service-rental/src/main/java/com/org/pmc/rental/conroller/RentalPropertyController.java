package com.org.pmc.rental.conroller;

import com.pmc.rental.contract.endpoint.RentalRegisterPropertyApi;
import com.pmc.rental.contract.model.Property;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
public class RentalPropertyController implements RentalRegisterPropertyApi {

    @Override
    public ResponseEntity<Property> registerProperty(Property property) {
        return null;
    }

    @Override
    public ResponseEntity<Property> updateProperty(Property property) {
        return null;
    }

    @Override
    public ResponseEntity<Property> fetchProperty(String s) {
        return null;
    }

    @Override
    public ResponseEntity<Property> deleteProperty(Property property) {
        return null;
    }
}
