package com.thucnh.minischoolsystem.dtos;

import lombok.Data;

@Data
public class StudentCardDTO {
    private Integer id;
    private String num;

    public StudentCardDTO( String num) {
        this.num = num;
    }
}
