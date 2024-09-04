package com.phone.application.services;

import com.phone.application.dto.PhoneRequestDto;
import com.phone.application.dto.UpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UpdatePhoneService {
    ResponseEntity<HttpStatus>update(UpdateRequestDto request);
}
