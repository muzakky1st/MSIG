package com.phone.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRequestDto {
    private Long id;
    private String phoneNumber;
    private String phoneOwner;
    private String phoneType;
    private String provider;
    private Boolean isStatus;
}
