package com.parent.service.repository;

import com.parent.service.model.MasterPhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterPhoneRepository extends JpaRepository<MasterPhoneModel, Long>, JpaSpecificationExecutor<MasterPhoneModel> {
    List<MasterPhoneModel> findByPhoneNumberAndIsStatus(String phoneNumber, Boolean isStatus);

}
