package com.phone.application.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface DeletePhoneService {
    ResponseEntity<HttpStatus>delete(Long id);
}
