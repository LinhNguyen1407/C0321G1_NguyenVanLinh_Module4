package com.codegym.dto.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttachService {

    private Long id;
    private String name;
    private Long cost;
    private Long unit;
    private String status;
}
