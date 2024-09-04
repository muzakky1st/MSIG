package com.parent.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "MASTER_PHONE")
public class MasterPhoneModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 827421830556130L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PHONE_OWNER")
    private String phoneOwner;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PROVIDER")
    private String provider;

    @Column(name = "PHONE_TYPE")
    private String phoneType;

    @Column(name = "IS_STATUS")
    private Boolean isStatus;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
}
