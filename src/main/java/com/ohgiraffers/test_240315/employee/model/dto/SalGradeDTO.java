package com.ohgiraffers.test_240315.employee.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class SalGradeDTO {
    private String salLevel;
    private int minSal;
    private int maxSal;

    public SalGradeDTO() {
    }
}
