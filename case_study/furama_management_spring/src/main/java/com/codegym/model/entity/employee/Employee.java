package com.codegym.model.entity.employee;

import com.codegym.model.entity.contract.Contract;
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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthday;
    private String idCard;
    private Long salary;
    private String phone;
    private String email;
    private String address;
    private int flagDel;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

}
