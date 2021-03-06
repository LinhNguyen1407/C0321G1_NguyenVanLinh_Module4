package com.codegym.model.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userName;
    private String encrytedPassword;

    @OneToOne(mappedBy = "user")
    private Employee employee;
}
