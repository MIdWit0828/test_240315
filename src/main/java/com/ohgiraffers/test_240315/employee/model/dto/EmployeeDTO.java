package com.ohgiraffers.test_240315.employee.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private int empId;
    private String empName;
    private String empNo;
    private String email;
    private int phone;
    private String deptCode;
    private String deptTitle;
    private String jobCode;
    private String jobName;
    private String salLevel;
    private int salary;
    private double bonus;
    private Integer managerId;
    private Date hireDate;
    private Date entDate;
    private String entYn;

    public EmployeeDTO() {
    }
}
