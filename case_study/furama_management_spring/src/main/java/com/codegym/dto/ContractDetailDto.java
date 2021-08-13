package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto {

    private Long id;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Quantity must be greater than 0")
    private Long quantity;

    private Contract contract;
    private AttachService attachService;
}
