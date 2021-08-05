package com.codegym.model.entity.contract;

import com.codegym.model.entity.service.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name= "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name= "attach_service_id", referencedColumnName = "id")
    private AttachService attachService;

}
