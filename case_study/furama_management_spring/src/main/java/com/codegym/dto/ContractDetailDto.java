package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto {

    private Long id;
    private Long quantity;
    private Contract contract;
    private AttachService attachService;
}
