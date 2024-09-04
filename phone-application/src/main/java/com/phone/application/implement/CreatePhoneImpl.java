package com.phone.application.implement;

import com.parent.service.errorhandler.ErrorHandler;
import com.parent.service.model.MasterPhoneModel;
import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.dto.PhoneRequestDto;
import com.phone.application.services.CreatePhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreatePhoneImpl implements CreatePhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<HttpStatus> create(PhoneRequestDto request) {
        log.info("Start method : create");
        var checkDataExists = masterPhoneRepository.findByPhoneNumberAndIsStatus(request.getPhoneNumber(), Boolean.FALSE);
        validateExistsPhoneNumber(checkDataExists);
        MasterPhoneModel createData = MasterPhoneModel.builder()
                .phoneNumber(request.getPhoneNumber())
                .phoneType(request.getPhoneType())
                .phoneOwner(request.getPhoneOwner())
                .provider(request.getProvider())
                .isStatus(request.getIsStatus())
                .isDeleted(Boolean.FALSE)
                .build();
        masterPhoneRepository.save(createData);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    private void validateExistsPhoneNumber(List<MasterPhoneModel> listExistsPhoneNumber){
        log.info("Start method : validateExistsPhoneNumber");
        if (!listExistsPhoneNumber.isEmpty()){
            throw new ErrorHandler("Data sudah digunakan", HttpStatus.IM_USED);
        }
    }
}
