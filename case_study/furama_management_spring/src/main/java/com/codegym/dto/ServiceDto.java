package com.codegym.dto;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {

    private Long id;

    @NotEmpty(message = "Data must be not emmpty")
    @Pattern(regexp = "DV-\\d{4}",message = "Customer code must have format KH-XXXX")
    private String code;

    @NotEmpty(message = "Data must be not emmpty")
    private String name;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long area;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long numFloors;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long maxPeople;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long cost;

    @NotEmpty(message = "Data must be not emmpty")
    private String standardRoom;

    @NotEmpty(message = "Data must be not emmpty")
    private String descOthers;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long poorArea;

    private RentType rentType;
    private ServiceType serviceType;
}
