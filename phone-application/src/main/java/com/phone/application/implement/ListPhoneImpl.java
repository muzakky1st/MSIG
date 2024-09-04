package com.phone.application.implement;

import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.dto.PhoneResponseDto;
import com.phone.application.services.ListPhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListPhoneImpl implements ListPhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<List<PhoneResponseDto>> list() {
        log.info("Start method : list");
        var findAllPhoneData = masterPhoneRepository.findAll()
                .stream().toList();
        List<PhoneResponseDto> response = new ArrayList<>();
        findAllPhoneData.forEach(listPhone -> {
            PhoneResponseDto tmp = new PhoneResponseDto();
            tmp.setId(listPhone.getId());
            tmp.setPhoneType(listPhone.getPhoneType());
            tmp.setPhoneOwner(listPhone.getPhoneOwner());
            tmp.setProvider(listPhone.getProvider());
            tmp.setIsStatus(listPhone.getIsStatus());
            tmp.setIsDeleted(listPhone.getIsDeleted());
            response.add(tmp);
        });
        return ResponseEntity.ok(response);
    }
}
