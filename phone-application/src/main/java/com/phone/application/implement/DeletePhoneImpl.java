package com.phone.application.implement;

import com.parent.service.errorhandler.ErrorHandler;
import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.services.DeletePhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeletePhoneImpl implements DeletePhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {
        log.info("Start method : delete");
        var dataPhone = masterPhoneRepository.findById(id)
                .orElseThrow(() -> new ErrorHandler("Data tidak ditemukan", HttpStatus.NOT_FOUND));
        masterPhoneRepository.delete(dataPhone);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
