package com.codegym.dto;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {

    private Long id;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "DV-\\d{4}", message = "Customer code must have format KH-XXXX")
    private String code;

    @NotEmpty(message = "Data must be not empty")
    private String name;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Area must be greater than 0")
    private Long area;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Number of floors must be greater than 0")
    private Long numFloors;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Maximum people must be greater than 0")
    private Long maxPeople;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Cost must be greater than 0")
    private Long cost;

    @NotEmpty(message = "Data must be not empty")
    private String standardRoom;

    @NotEmpty(message = "Data must be not empty")
    private String descOthers;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Poor area must be greater than 0")
    private Long poorArea;

    private RentType rentType;
    private ServiceType serviceType;
}
