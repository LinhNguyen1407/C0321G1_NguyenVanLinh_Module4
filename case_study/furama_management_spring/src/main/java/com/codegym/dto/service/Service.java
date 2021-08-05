package com.codegym.dto.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    private Long id;
    private String code;
    private String name;
    private Long area;
    private Long numFloors;
    private Long maxPeople;
    private Long cost;
    private String standardRoom;
    private String descOthers;
    private Long poorArea;
    private RentType rentType;
    private ServiceType serviceType;
}
