package com.phone.application.controller;

import com.phone.application.dto.PhoneRequestDto;
import com.phone.application.dto.PhoneResponseDto;
import com.phone.application.dto.UpdateRequestDto;
import com.phone.application.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneApplication")
@RequiredArgsConstructor
public class PhoneController {
    private final CreatePhoneService createPhoneService;
    private final DetailPhoneService detailPhoneService;
    private final UpdatePhoneService updatePhoneService;
    private final DeletePhoneService deletePhoneService;
    private final SearchingPhoneService searchingPhoneService;
    private final ListPhoneService listPhoneService;

    @PostMapping("/create")
    ResponseEntity<HttpStatus> create(@RequestBody PhoneRequestDto request) {
        return createPhoneService.create(request);
    }

    @GetMapping("/detail")
    ResponseEntity<PhoneResponseDto> detail(Long id) {
        return detailPhoneService.detail(id);
    }

    @DeleteMapping("/delete")
    ResponseEntity<HttpStatus> delete(Long id) {
        return deletePhoneService.delete(id);
    }

    @PutMapping("/update")
    ResponseEntity<HttpStatus> update(@RequestBody UpdateRequestDto request) {
        return updatePhoneService.update(request);
    }

    @GetMapping("/list")
    ResponseEntity<List<PhoneResponseDto>> list() {
        return listPhoneService.list();
    }

    @GetMapping("/search")
    ResponseEntity<List<PhoneResponseDto>> search(String request) {
        return searchingPhoneService.search(request);
    }
}
