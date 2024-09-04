package com.phone.application.implement;

import com.parent.service.model.MasterPhoneModel;
import com.parent.service.repository.MasterPhoneRepository;
import com.phone.application.dto.PhoneResponseDto;
import com.phone.application.services.SearchingPhoneService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchPhoneImp implements SearchingPhoneService {
    private final MasterPhoneRepository masterPhoneRepository;

    @Override
    public ResponseEntity<List<PhoneResponseDto>> search(String request) {
        log.info("Start method : search");
        var result = masterPhoneRepository.findAll(specification(request));
        List<PhoneResponseDto> response = new ArrayList<>();
        result.forEach(x -> {
            PhoneResponseDto tmp = new PhoneResponseDto();
            tmp.setId(x.getId());
            tmp.setPhoneOwner(x.getPhoneOwner());
            tmp.setPhoneType(x.getPhoneType());
            tmp.setProvider(x.getProvider());
            tmp.setIsStatus(x.getIsStatus());
            tmp.setIsDeleted(x.getIsDeleted());
            response.add(tmp);
        });
        return ResponseEntity.ok(response);
    }

    private Specification<MasterPhoneModel> specification(String keySearch) {
        return (Root<MasterPhoneModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (keySearch == null || keySearch.trim().isEmpty()) {
                return cb.conjunction();
            }
            String patternIn = "%" + keySearch.toLowerCase() + "%";
            Predicate criteriaPhoneNumber = cb.like(cb.lower(root.get("phoneNumber")), patternIn);
            Predicate criteriaPhoneOwner = cb.like(cb.lower(root.get("phoneOwner")), patternIn);
            Predicate criteriaProvider = cb.like(cb.lower(root.get("provider")), patternIn);
            Predicate criteriaPhoneType = cb.like(cb.lower(root.get("phoneType")), patternIn);
            return cb.or(criteriaPhoneNumber, criteriaPhoneOwner, criteriaProvider, criteriaPhoneType);
        };
    }
}
