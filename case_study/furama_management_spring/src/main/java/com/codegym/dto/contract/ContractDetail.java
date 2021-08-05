package com.codegym.dto.contract;

import com.codegym.dto.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {

    private Long id;
    private Long quantity;
    private Contract contract;
    private AttachService attachService;
}
