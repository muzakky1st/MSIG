package com.phone.application.implement;

import com.parent.service.errorhandler.ErrorHandler;
import com.parent.service.model.MasterPhoneModel;
import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.dto.UpdateRequestDto;
import com.phone.application.services.UpdatePhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdatePhoneImpl implements UpdatePhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<HttpStatus> update(UpdateRequestDto request) {
        log.info("Start method : update");
        var dataPhone = masterPhoneRepository.findByPhoneNumberAndIsStatus(request.getPhoneNumber(), Boolean.FALSE);
        if (!dataPhone.isEmpty()) {
            throw new ErrorHandler("Data Sudah Ada", HttpStatus.IM_USED);
        }
        var updateData = MasterPhoneModel.builder()
                .id(request.getId())
                .phoneOwner(request.getPhoneOwner())
                .phoneNumber(request.getPhoneNumber())
                .phoneType(request.getPhoneType())
                .provider(request.getProvider())
                .isStatus(request.getIsStatus())
                .isDeleted(Boolean.FALSE)
                .build();
        masterPhoneRepository.save(updateData);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
