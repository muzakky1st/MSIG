package com.phone.application.services;

import com.phone.application.dto.PhoneResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListPhoneService {
    ResponseEntity<List<PhoneResponseDto>> list();

}
