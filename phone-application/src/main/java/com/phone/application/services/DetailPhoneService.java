package com.phone.application.services;

import com.phone.application.dto.PhoneResponseDto;
import org.springframework.http.ResponseEntity;

public interface DetailPhoneService {
    ResponseEntity<PhoneResponseDto>detail(Long id);
}
