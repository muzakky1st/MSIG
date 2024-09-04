package com.phone.application.implement;

import com.parent.service.errorhandler.ErrorHandler;
import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.dto.PhoneResponseDto;
import com.phone.application.services.DetailPhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DetailPhoneImpl implements DetailPhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<PhoneResponseDto> detail(Long id) {
        log.info("Start method : detail");
        var detailPhone = masterPhoneRepository.findById(id)
                .orElseThrow(() -> new ErrorHandler("Data tidak ditemukan", HttpStatus.NOT_FOUND));
        var result = PhoneResponseDto.builder()
                .id(detailPhone.getId())
                .phoneOwner(detailPhone.getPhoneOwner())
                .phoneType(detailPhone.getPhoneType())
                .provider(detailPhone.getProvider())
                .isStatus(detailPhone.getIsStatus())
                .isDeleted(detailPhone.getIsDeleted())
                .build();
        return ResponseEntity.ok(result);
    }
}
