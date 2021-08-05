package com.codegym.model.entity.service;

import com.codegym.model.entity.contract.ContractDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long cost;
    private Long unit;
    private String status;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;

}
