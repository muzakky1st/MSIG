package com.phone.application.services;

import com.phone.application.dto.PhoneResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchingPhoneService {
    ResponseEntity<List<PhoneResponseDto>>search(String request);
}
