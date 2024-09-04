package com.phone.application.services;

import com.phone.application.dto.PhoneRequestDto;
import com.phone.application.dto.PhoneResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CreatePhoneService {
    ResponseEntity<HttpStatus>create(PhoneRequestDto request);
}
