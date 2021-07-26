package com.codegym.validate_phone.model.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PhoneNumber{

    @NotEmpty(message = "Phone number not empty")
    @Size(min=10, max=11, message = "Length from 10 to 11")
    @Pattern(regexp = "^0.*$", message = "Phone number start with 0")
    @Pattern(regexp = "^[0-9]+$", message = "Phone number only include number")
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
